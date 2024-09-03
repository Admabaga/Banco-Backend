package com.example.Banco.Excepciones;

public class CedulaExistenteExcepcion extends RuntimeException{
    public CedulaExistenteExcepcion() {
    }

    public CedulaExistenteExcepcion(String message) {
        super(message);
    }
}
