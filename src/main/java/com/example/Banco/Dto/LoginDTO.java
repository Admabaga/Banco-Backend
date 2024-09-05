package com.example.Banco.Dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String usuario;
    private String password;
    private Boolean loggIn;
    private Double saldo;
    private Integer numeroCuenta;
    private Boolean estado;
}
