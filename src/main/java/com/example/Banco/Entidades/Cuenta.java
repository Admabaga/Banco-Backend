package com.example.Banco.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue
    private Long id;
    private Boolean estaActiva;
    private Double saldo;
    private Integer numeroCuenta;

    public Cuenta() {
    }

    public Cuenta(Long id, Boolean estaActiva, Double saldo, Integer numeroCuenta) {
        this.id = id;
        this.estaActiva = estaActiva;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(Boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", estado=" + estaActiva +
                ", saldo=" + saldo +
                ", numeroCuento=" + numeroCuenta +
                '}';
    }
}
