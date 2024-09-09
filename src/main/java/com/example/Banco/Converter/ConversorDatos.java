package com.example.Banco.Converter;

import java.text.DecimalFormat;

public class ConversorDatos {
    public static String numeros(Double numero){
        DecimalFormat formato = new DecimalFormat("###,###,##0.0");
        return formato.format(numero);
    }

}
