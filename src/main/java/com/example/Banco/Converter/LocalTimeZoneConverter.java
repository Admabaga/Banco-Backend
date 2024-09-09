package com.example.Banco.Converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalTimeZoneConverter {

    public static String convertirAHoraLocal(LocalDateTime hora){
        hora = hora.truncatedTo(ChronoUnit.SECONDS);

        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaYHoraFormateada = hora.format(formatear);
        return  fechaYHoraFormateada;
    }
}
