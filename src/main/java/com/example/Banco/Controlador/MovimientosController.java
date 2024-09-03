package com.example.Banco.Controlador;

import com.example.Banco.Dto.MovimientoDTO;
import com.example.Banco.Servicios.ServicioMovimiento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovimientosController {
    ServicioMovimiento servicioMovimiento;

    public MovimientosController(ServicioMovimiento servicioMovimiento) {
        this.servicioMovimiento = servicioMovimiento;
    }
    @GetMapping(value = "/movimientos/{cuentaId}")
    public ResponseEntity<List<MovimientoDTO>> traerMovimientos(@PathVariable Long cuentaId){
        List<MovimientoDTO> movimientoDTOS = servicioMovimiento.movimientos(cuentaId);
        return ResponseEntity.ok(movimientoDTOS);
    }

}
