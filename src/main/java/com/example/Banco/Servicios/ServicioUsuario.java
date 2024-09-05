package com.example.Banco.Servicios;

import com.example.Banco.Dto.LoginDTO;
import com.example.Banco.Dto.UsuarioDTO;
import com.example.Banco.Entidades.Usuario;

public interface ServicioUsuario {

    UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);
    LoginDTO inicioSesion(LoginDTO loginDTO);
}
