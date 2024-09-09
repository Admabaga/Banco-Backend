package com.example.Banco.Dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String usuario;
    private String password;
    private Boolean loggIn;
    private String saldo;
    private Integer numeroCuenta;
    private Boolean estado;
    private Long idCuenta;
}
