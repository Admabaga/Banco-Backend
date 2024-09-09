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
public class ServicioRetiroImpl implements ServicioRetiro{
    RepositorioCuenta repositorioCuenta;
    RepositorioMovimiento repositorioMovimiento;

    public ServicioRetiroImpl(RepositorioCuenta repositorioCuenta, RepositorioMovimiento repositorioMovimiento) {
        this.repositorioCuenta = repositorioCuenta;
        this.repositorioMovimiento = repositorioMovimiento;
    }

    @Override
    public ServiciosDTO retirar(ServiciosDTO serviciosDTO, Long cuentaId) {
        if (serviciosDTO.getValor()==null || String.valueOf(serviciosDTO.getValor()).isEmpty()){
            throw new RuntimeException("Ingresa un valor para retirar.");
        }
        Optional<Cuenta> cuentaOptional = repositorioCuenta.findById(cuentaId);
        Cuenta cuenta = cuentaOptional.get();
        Movimiento movimiento = new Movimiento();
        cuenta.setSaldo(cuenta.retiro(serviciosDTO.getValor()));
        movimiento.setFecha(LocalTimeZoneConverter.convertirAHoraLocal(LocalDateTime.now()));
        movimiento.setValor("- "+ ConversorDatos.numeros(serviciosDTO.getValor()));
        movimiento.setTipoMovimiento("Retiro");
        movimiento.setCuenta(cuenta);
        serviciosDTO.setSaldo(cuenta.getSaldo());
        repositorioCuenta.save(cuenta);
        repositorioMovimiento.save(movimiento);
        return serviciosDTO;
    }
}
