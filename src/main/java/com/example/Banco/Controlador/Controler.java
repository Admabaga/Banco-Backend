package com.example.Banco.Controlador;

import com.example.Banco.Dto.LoginDTO;
import com.example.Banco.Dto.UsuarioDTO;
import com.example.Banco.Servicios.ServicioUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Controler {
    ServicioUsuario servicioUsuario;

    public Controler(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
            UsuarioDTO resultado = servicioUsuario.registrarUsuario(usuarioDTO);
            return ResponseEntity.ok(resultado);
    }
    @PostMapping("/usuarios/log")
    public ResponseEntity<?> iniciarSesion(@RequestBody LoginDTO loginDTO) {
        Boolean resultado = servicioUsuario.inicioSesion(loginDTO);
        return ResponseEntity.ok(resultado);
    }
}

