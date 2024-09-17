package com.example.Banco.Controlador;

import com.example.Banco.Dto.LoginDTO;
import com.example.Banco.Dto.UsuarioDTO;
import com.example.Banco.Servicios.ServicioUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://banco-front.onrender.com", allowedHeaders = "*", maxAge = 3600)
public class UsuarioController {
    ServicioUsuario servicioUsuario;

    public UsuarioController(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
            UsuarioDTO resultado = servicioUsuario.registrarUsuario(usuarioDTO);
            return ResponseEntity.ok(resultado);
    }
    @PostMapping("/usuarios/log")
    public ResponseEntity<?> iniciarSesion(@RequestBody LoginDTO loginDTO) {
        LoginDTO resultado = servicioUsuario.inicioSesion(loginDTO);
        return ResponseEntity.ok(resultado);
    }
}

