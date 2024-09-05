package com.example.Banco.Servicios;

import com.example.Banco.Dto.ServiciosDTO;

public interface ServicioRetiro {

    ServiciosDTO retirar(ServiciosDTO serviciosDTO, Long cuentaId);
}
