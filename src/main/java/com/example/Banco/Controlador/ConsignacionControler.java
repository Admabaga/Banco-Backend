package com.example.Banco.Controlador;

import com.example.Banco.Dto.ServiciosDTO;
import com.example.Banco.Servicios.ServicioConsignacion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsignacionControler {
    ServicioConsignacion servicioConsignacion;

    public ConsignacionControler(ServicioConsignacion servicioConsignacion) {
        this.servicioConsignacion = servicioConsignacion;
    }
    @PostMapping("/consignaciones/{cuentaId}")
    public ResponseEntity<?> consignar(@RequestBody ServiciosDTO serviciosDTO, @PathVariable Long cuentaId) {
        ServiciosDTO resultado = servicioConsignacion.consignacion(serviciosDTO, cuentaId);
        return ResponseEntity.ok(resultado);
    }
}
