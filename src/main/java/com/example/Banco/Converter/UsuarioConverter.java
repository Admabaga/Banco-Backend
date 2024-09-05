package com.example.Banco.Converter;

import com.example.Banco.Dto.UsuarioDTO;
import com.example.Banco.Entidades.Usuario;

public class UsuarioConverter {

    public  static Usuario dtoAEntidad(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setPassword(usuarioDTO.getPassword());
        return usuario;
    }

    public static  UsuarioDTO entidadADto(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setCedula(usuario.getCedula());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setApellido(usuario.getApellido());
        usuarioDTO.setCorreo(usuario.getCorreo());
        usuarioDTO.setPassword(usuario.getPassword());
        return usuarioDTO;
    }
}
