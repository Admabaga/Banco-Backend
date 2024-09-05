package com.example.Banco.Converter;

import com.example.Banco.Dto.MovimientoDTO;
import com.example.Banco.Entidades.Movimiento;

public class MovimientoConverter {

    public static MovimientoDTO entidadADto(Movimiento movimiento){
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        movimientoDTO.setId(movimiento.getId());
        movimientoDTO.setTipoMovimiento(movimiento.getTipoMovimiento());
        movimientoDTO.setValor(movimiento.getValor());
        movimientoDTO.setFecha(movimiento.getFecha());
        return movimientoDTO;
    }
}
