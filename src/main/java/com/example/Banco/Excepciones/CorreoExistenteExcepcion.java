package com.example.Banco.Excepciones;

public class CorreoExistenteExcepcion extends RuntimeException{
    public CorreoExistenteExcepcion() {
    }

    public CorreoExistenteExcepcion(String message) {
        super(message);
    }
}
