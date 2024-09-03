package com.example.Banco.Servicios;

import com.example.Banco.Converter.MovimientoConverter;
import com.example.Banco.Dto.MovimientoDTO;
import com.example.Banco.Entidades.Movimiento;
import com.example.Banco.Repositorios.RepositorioMovimiento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioMovimientosImpl implements ServicioMovimiento{
    RepositorioMovimiento repositorioMovimiento;

    public ServicioMovimientosImpl(RepositorioMovimiento repositorioMovimiento) {
        this.repositorioMovimiento = repositorioMovimiento;
    }

    @Override
    public List<MovimientoDTO> movimientos(Long cuentaId) {
//        return movimientos.stream()
//                .map(MovimientoConverter::entidadADto)
//                .collect(Collectors.toList());
        return null;
    }
}
