package com.example.Banco.Servicios;

import com.example.Banco.Dto.MovimientoDTO;

import java.util.List;

public interface ServicioMovimiento {
    List<MovimientoDTO> movimientos(Long cuentaId);
}
