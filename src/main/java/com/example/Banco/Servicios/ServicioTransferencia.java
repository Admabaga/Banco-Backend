package com.example.Banco.Servicios;

import com.example.Banco.Dto.ServiciosDTO;

public interface ServicioTransferencia {

    ServiciosDTO transferir(ServiciosDTO serviciosDTO, Long cuentaId);
}
