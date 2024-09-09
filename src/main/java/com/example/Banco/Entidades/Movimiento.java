package com.example.Banco.Entidades;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento")
public class Movimiento {
    @Id
    @GeneratedValue
    private Long id;
    private String tipoMovimiento;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private String fecha;
    private String valor;

    @ManyToOne
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(Long id, String tipoMovimiento, String fecha, String valor, Cuenta cuenta) {
        this.id = id;
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = fecha;
        this.valor = valor;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "id=" + id +
                ", tipoMovimiento='" + tipoMovimiento + '\'' +
                ", fecha=" + fecha +
                ", valor='" + valor + '\'' +
                ", cuenta=" + cuenta +
                '}';
    }
}
