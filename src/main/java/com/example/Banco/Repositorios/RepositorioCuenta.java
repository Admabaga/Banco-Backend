package com.example.Banco.Repositorios;

import com.example.Banco.Entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositorioCuenta extends JpaRepository<Cuenta, Long > {

    @Query("SELECT max(c.numeroCuenta) FROM Cuenta c ")
    Integer traerValorMaximo();

    @Query("SELECT c FROM Cuenta c WHERE c.numeroCuenta = :numeroCuenta")
    Cuenta cuentaReceptora(@Param("numeroCuenta") Integer id);

    @Query("SELECT c FROM Cuenta c WHERE c.id = :id")
    Cuenta cuentaLogeada(@Param("id") Integer id);

}
