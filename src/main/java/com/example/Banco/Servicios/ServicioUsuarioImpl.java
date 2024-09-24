package com.example.Banco.Servicios;

import com.example.Banco.Converter.ConversorDatos;
import com.example.Banco.Converter.UsuarioConverter;
import com.example.Banco.Dto.LoginDTO;
import com.example.Banco.Dto.UsuarioDTO;
import com.example.Banco.Entidades.Cuenta;
import com.example.Banco.Entidades.Usuario;
import com.example.Banco.Excepciones.CedulaExistenteExcepcion;
import com.example.Banco.Excepciones.CorreoExistenteExcepcion;
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

    @Override
    public LoginDTO inicioSesion(LoginDTO loginDTO) {
        if (loginDTO.getUsuario()==null || String.valueOf(loginDTO.getUsuario()).isEmpty()){
            throw new RuntimeException("Ingresa un usuario.");
        }
        if (loginDTO.getPassword()==null || String.valueOf(loginDTO.getPassword()).isEmpty()){
            throw new RuntimeException("Ingresa una contraseña.");
        }
        List<Usuario> usuarios = repositorioUsuario.findAll();
        for (Usuario usuario : usuarios) {
            if (usuario.getCorreo().equalsIgnoreCase(loginDTO.getUsuario()) && usuario.getPassword().equalsIgnoreCase(loginDTO.getPassword())) {
                Cuenta cuenta = usuario.getCuenta();
                loginDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
                loginDTO.setEstado(cuenta.getEstaActiva());
                loginDTO.setSaldo(ConversorDatos.numeros(cuenta.getSaldo()));
                loginDTO.setLoggIn(true);
                loginDTO.setIdCuenta(cuenta.getId());
                return loginDTO;
            }
        }
        throw new RuntimeException("Usuario y/o contraseña incorrectos.");
    }

    public void validaciones(Usuario usuario){
        List<String> correos = repositorioUsuario.userEmails();
        List<Integer> cedulas = repositorioUsuario.userIdentification();
        validacionUsuario(usuario);
        if (correos.contains(usuario.getCorreo())) {
            throw new CorreoExistenteExcepcion(String.format("El correo %s ya ha sido registrado", usuario.getCorreo()));
        }
        if (cedulas.contains(usuario.getCedula())) {
            throw new CedulaExistenteExcepcion(String.format("La cedula %s ya ha sido registrada", usuario.getCedula()));
        }

    }

    public Cuenta crearCuenta(Cuenta cuenta){
        if (repositorioUsuario.userEmails().size() > 0){
            Integer valorMaximo = repositorioCuenta.traerValorMaximo();
            Integer cuentaNueva = valorMaximo + 1;
            cuenta.setNumeroCuenta(cuentaNueva);
        }else {
            cuenta.setNumeroCuenta(2000000000);
        }
        cuenta.setSaldo(200000.0);
        cuenta.setEstaActiva(true);
        return cuenta;
    }

    public void validacionUsuario(Usuario usuario){
        if (usuario.getCedula()== null || String.valueOf(usuario.getCedula())== "" ) {
            throw new RuntimeException("El campo cedula debe estar diligenciado.");
        }
        if (usuario.getNombre()== null || usuario.getNombre()== "" ) {
            throw new RuntimeException("El campo nombre debe estar diligenciado.");
        }
        if (usuario.getApellido()== null || usuario.getApellido()== "" ) {
            throw new RuntimeException("El campo apellido debe estar diligenciado.");
        }
        if (usuario.getCorreo()== null || usuario.getCorreo()== "" ) {
            throw new RuntimeException("El campo correo debe estar diligenciado.");
        }
        if (usuario.getPassword()== null || usuario.getPassword()== "" ) {
            throw new RuntimeException("El campo contraseña debe estar diligenciado.");
        }
    }

}
