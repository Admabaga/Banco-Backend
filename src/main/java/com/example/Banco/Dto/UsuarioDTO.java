package com.example.Banco.Dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String nombre;
    private String apellido;
    private Long cedula;
    private String correo;
    private String password;
}
