package com.example.Banco.Servicios;

import com.example.Banco.Converter.UsuarioConverter;
import com.example.Banco.Dto.UsuarioDTO;
import com.example.Banco.Entidades.Usuario;
import com.example.Banco.Repositorios.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario{
    RepositorioUsuario repositorioUsuario;

    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioConverter.dtoAEntidad(usuarioDTO);
        repositorioUsuario.save(usuario);
        return UsuarioConverter.entidadADto(usuario);
    }
}
