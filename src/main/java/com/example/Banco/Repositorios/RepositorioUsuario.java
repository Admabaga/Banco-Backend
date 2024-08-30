package com.example.Banco.Repositorios;

import com.example.Banco.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {
}
