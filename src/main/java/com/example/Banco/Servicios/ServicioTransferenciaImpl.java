package com.example.Banco.Servicios;

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
        Optional<Cuenta> cuentaOptional = repositorioCuenta.findById(cuentaId);
        Cuenta cuentaReceptora = repositorioCuenta.cuentaReceptora(serviciosDTO.getCuentaReceptora());
        Cuenta cuentaEmisora = cuentaOptional.get();
        Movimiento movimientoEmisora = new Movimiento();
        Movimiento movimientoCuentaReceptora = new Movimiento();
        cuentaEmisora.setSaldo(cuentaEmisora.retiro(serviciosDTO.getValor()));
        cuentaReceptora.setSaldo(cuentaReceptora.consignacion(serviciosDTO.getValor()));
        movimientoEmisora.setValor(String.format("- "+serviciosDTO.getValor()));
        movimientoEmisora.setCuenta(cuentaEmisora);
        movimientoEmisora.setFecha(LocalDateTime.now());
        movimientoEmisora.setTipoMovimiento("Transferencia");
        movimientoCuentaReceptora.setValor(String.format("+ "+serviciosDTO.getValor()));
        movimientoCuentaReceptora.setTipoMovimiento("Transferencia");
        movimientoCuentaReceptora.setCuenta(cuentaReceptora);
        movimientoCuentaReceptora.setFecha(LocalDateTime.now());
        serviciosDTO.setSaldo(cuentaEmisora.getSaldo());
        repositorioCuenta.save(cuentaEmisora);
        repositorioCuenta.save(cuentaReceptora);
        repositorioMovimiento.save(movimientoEmisora);
        repositorioMovimiento.save(movimientoCuentaReceptora);
        return serviciosDTO;
    }
}
