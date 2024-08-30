package com.example.Banco.Controlador;

import com.example.Banco.Dto.UsuarioDTO;
import com.example.Banco.Servicios.ServicioUsuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Controler {
    ServicioUsuario servicioUsuario;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Controler(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

@PostMapping("/usuarios")
public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
    try {
        UsuarioDTO resultado = servicioUsuario.registrarUsuario(usuarioDTO);
        return ResponseEntity.ok(resultado);
    } catch (Exception e) {
        logger.error("Error al registrar usuario", e);
        return ResponseEntity.badRequest().body("Error al registrar el usuario");
    }
}

}
