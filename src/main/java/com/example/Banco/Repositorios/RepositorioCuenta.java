package com.example.Banco.Repositorios;

import com.example.Banco.Entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositorioCuenta extends JpaRepository<Cuenta, Long > {

    @Query("SELECT max(c.numeroCuenta) FROM Cuenta c ")
    Integer traerValorMaximo();
}
