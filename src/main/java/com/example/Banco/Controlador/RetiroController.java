package com.example.Banco.Controlador;

import com.example.Banco.Dto.ServiciosDTO;
import com.example.Banco.Servicios.ServicioRetiro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetiroController {
    ServicioRetiro servicioRetiro;

    public RetiroController(ServicioRetiro servicioRetiro) {
        this.servicioRetiro = servicioRetiro;
    }
    @PostMapping("/retiros/{cuentaId}")
    public ResponseEntity<?> retirar(@RequestBody ServiciosDTO serviciosDTO, @PathVariable Long cuentaId) {
        ServiciosDTO resultado = servicioRetiro.retirar(serviciosDTO, cuentaId);
        return ResponseEntity.ok(resultado);
    }
}
