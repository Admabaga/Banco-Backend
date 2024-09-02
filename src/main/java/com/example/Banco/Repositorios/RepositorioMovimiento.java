package com.example.Banco.Repositorios;

import com.example.Banco.Entidades.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMovimiento extends JpaRepository<Movimiento, Long> {
}
