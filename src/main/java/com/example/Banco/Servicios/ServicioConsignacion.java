package com.example.Banco.Servicios;

import com.example.Banco.Dto.ServiciosDTO;

public interface ServicioConsignacion {
    ServiciosDTO consignacion(ServiciosDTO serviciosDTO, Long cuentaId);
}
