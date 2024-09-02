package com.example.Banco.Converter;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalTimeZoneConverter {

    public static LocalDateTime convertirAHoraLocal(LocalDateTime localDateTimeUtc){
        ZoneId utcZoneId = ZoneId.of("UTC");
        ZoneId medellinZoneId = ZoneId.of("America/Bogota");
        return localDateTimeUtc.atZone(utcZoneId)
                .withZoneSameInstant(medellinZoneId)
                .toLocalDateTime();
    }
}
