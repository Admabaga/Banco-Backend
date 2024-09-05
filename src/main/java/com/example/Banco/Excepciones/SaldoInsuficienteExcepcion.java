package com.example.Banco.Excepciones;

public class SaldoInsuficienteExcepcion extends RuntimeException{
    public SaldoInsuficienteExcepcion() {
    }

    public SaldoInsuficienteExcepcion(String message) {
        super(message);
    }
}
