package com.example.Banco.Controlador;

import com.example.Banco.Dto.ServiciosDTO;
import com.example.Banco.Servicios.ServicioTransferencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferenciaController {
    ServicioTransferencia servicioTransferencia;

    public TransferenciaController(ServicioTransferencia servicioTransferencia) {
        this.servicioTransferencia = servicioTransferencia;
    }

    @PostMapping("/transferencias/{cuentaId}")
    public ResponseEntity<?> transferir(@RequestBody ServiciosDTO serviciosDTO, @PathVariable Long cuentaId) {
        ServiciosDTO resultado = servicioTransferencia.transferir(serviciosDTO, cuentaId);
        return ResponseEntity.ok(resultado);
    }
}
