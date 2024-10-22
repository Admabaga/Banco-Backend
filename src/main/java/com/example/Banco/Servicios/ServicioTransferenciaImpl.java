package com.example.Banco.Servicios;

import com.example.Banco.Converter.ConversorDatos;
import com.example.Banco.Converter.LocalTimeZoneConverter;
import com.example.Banco.Dto.ServiciosDTO;
import com.example.Banco.Entidades.Cuenta;
import com.example.Banco.Entidades.Movimiento;
import com.example.Banco.Repositorios.RepositorioCuenta;
import com.example.Banco.Repositorios.RepositorioMovimiento;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ServicioTransferenciaImpl implements ServicioTransferencia{
    RepositorioMovimiento repositorioMovimiento;
    RepositorioCuenta repositorioCuenta;

    public ServicioTransferenciaImpl(RepositorioMovimiento repositorioMovimiento, RepositorioCuenta repositorioCuenta) {
        this.repositorioMovimiento = repositorioMovimiento;
        this.repositorioCuenta = repositorioCuenta;
    }

    @Override
    public ServiciosDTO transferir(ServiciosDTO serviciosDTO, Long cuentaId) {
        if (serviciosDTO.getValor()==null || String.valueOf(serviciosDTO.getValor()).isEmpty()){
            throw new RuntimeException("Ingresa un valor para transferir.");
        }
        if (serviciosDTO.getCuentaReceptora()==null || String.valueOf(serviciosDTO.getCuentaReceptora()).isEmpty()){
            throw new RuntimeException("Ingresa un numero de cuenta para transferir.");
        }
        Optional<Cuenta> cuentaOptional = repositorioCuenta.findById(cuentaId);
        Cuenta cuentaReceptora = repositorioCuenta.cuentaReceptora(serviciosDTO.getCuentaReceptora());
        Cuenta cuentaEmisora = cuentaOptional.get();
        if (cuentaReceptora==null){
            throw  new RuntimeException(String.format("El numero de cuenta %s no es valido.", serviciosDTO.getCuentaReceptora()));
        }
        if (cuentaReceptora.equals(cuentaEmisora)){
            throw new RuntimeException("No puedes trasnferirte dinero desde tu propia cuenta.");
        }
        Movimiento movimientoEmisora = new Movimiento();
        Movimiento movimientoCuentaReceptora = new Movimiento();
        cuentaEmisora.setSaldo(cuentaEmisora.retiro(serviciosDTO.getValor()));
        cuentaReceptora.setSaldo(cuentaReceptora.consignacion(serviciosDTO.getValor()));
        movimientoEmisora.setValor("- "+ ConversorDatos.numeros(serviciosDTO.getValor()));
        movimientoEmisora.setCuenta(cuentaEmisora);
        movimientoEmisora.setFecha(LocalTimeZoneConverter.convertirAHoraLocal(LocalDateTime.now()));
        movimientoEmisora.setTipoMovimiento("Transferencia");
        movimientoCuentaReceptora.setValor("+ "+ConversorDatos.numeros(serviciosDTO.getValor()));
        movimientoCuentaReceptora.setTipoMovimiento("Transferencia");
        movimientoCuentaReceptora.setCuenta(cuentaReceptora);
        movimientoCuentaReceptora.setFecha(LocalTimeZoneConverter.convertirAHoraLocal(LocalDateTime.now()));
        serviciosDTO.setSaldo(cuentaEmisora.getSaldo());
        repositorioCuenta.save(cuentaEmisora);
        repositorioCuenta.save(cuentaReceptora);
        repositorioMovimiento.save(movimientoEmisora);
        repositorioMovimiento.save(movimientoCuentaReceptora);
        return serviciosDTO;
    }

}
