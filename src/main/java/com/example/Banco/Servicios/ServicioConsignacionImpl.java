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
public class ServicioConsignacionImpl implements ServicioConsignacion {
    RepositorioCuenta repositorioCuenta;
    RepositorioMovimiento repositorioMovimiento;

    public ServicioConsignacionImpl(RepositorioCuenta repositorioCuenta, RepositorioMovimiento repositorioMovimiento) {
        this.repositorioCuenta = repositorioCuenta;
        this.repositorioMovimiento = repositorioMovimiento;
    }

    @Override
    public ServiciosDTO consignacion(ServiciosDTO serviciosDTO, Long cuentaId) {
        if (serviciosDTO.getValor()==null || String.valueOf(serviciosDTO.getValor()).isEmpty()){
            throw new RuntimeException("Ingresa un valor para recargar.");
        }
        Optional<Cuenta> cuentaOptional = repositorioCuenta.findById(cuentaId);
        Cuenta cuenta = cuentaOptional.get();
        Movimiento movimiento= new Movimiento();
        cuenta.setSaldo(cuenta.consignacion(serviciosDTO.getValor()));
        movimiento.setTipoMovimiento("Consignacion");
        movimiento.setCuenta(cuenta);
        movimiento.setFecha(LocalTimeZoneConverter.convertirAHoraLocal(LocalDateTime.now()));
        movimiento.setValor("+ "+ConversorDatos.numeros(serviciosDTO.getValor()));
        serviciosDTO.setSaldo(cuenta.getSaldo());
        repositorioCuenta.save(cuenta);
        repositorioMovimiento.save(movimiento);
        return serviciosDTO;
    }
}
