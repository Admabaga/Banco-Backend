package com.example.Banco.Dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovimientoDTO {
    private Long id;
    private String tipoMovimiento;
    private LocalDateTime fecha;
    private String valor;
}
