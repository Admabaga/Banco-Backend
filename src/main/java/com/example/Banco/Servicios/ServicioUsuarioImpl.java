package com.example.Banco.Servicios;

import com.example.Banco.Converter.UsuarioConverter;
import com.example.Banco.Dto.UsuarioDTO;
import com.example.Banco.Entidades.Cuenta;
import com.example.Banco.Entidades.Usuario;
import com.example.Banco.Repositorios.RepositorioCuenta;
import com.example.Banco.Repositorios.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario{
    RepositorioUsuario repositorioUsuario;
    RepositorioCuenta repositorioCuenta;

    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario, RepositorioCuenta repositorioCuenta) {
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioCuenta = repositorioCuenta;
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioConverter.dtoAEntidad(usuarioDTO);
        Cuenta cuenta = new Cuenta();
        validaciones(usuario);
        crearCuenta(cuenta);
        usuario.setCuenta(cuenta);
        repositorioCuenta.save(cuenta);
        repositorioUsuario.save(usuario);
        return UsuarioConverter.entidadADto(usuario);
    }

    public void validaciones(Usuario usuario){
        List<String> correos = repositorioUsuario.userEmails();
        List<Integer> cedulas = repositorioUsuario.userIdentification();
        if (correos.contains(usuario.getCorreo())) {
            throw new RuntimeException(String.format("El correo %s ya ha sido registrado", usuario.getCorreo()));
        }
        if (cedulas.contains(usuario.getCedula())) {
            throw new RuntimeException(String.format("La cedula %s ya ha sido registrada", usuario.getCedula()));
        }
    }

    public Cuenta crearCuenta(Cuenta cuenta){
        if (repositorioUsuario.userEmails().size() > 0){
            Integer valorMaximo = repositorioCuenta.traerValorMaximo();
            Integer cuentaNueva = valorMaximo + 1;
            cuenta.setNumeroCuenta(cuentaNueva);
        }else {
            cuenta.setNumeroCuenta(1000000000);
        }
        cuenta.setSaldo(0.0);
        cuenta.setEstaActiva(true);
        return cuenta;
    }

}
