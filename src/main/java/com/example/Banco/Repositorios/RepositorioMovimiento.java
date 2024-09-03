package com.example.Banco.Repositorios;

import com.example.Banco.Entidades.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioMovimiento extends JpaRepository<Movimiento, Long> {
}