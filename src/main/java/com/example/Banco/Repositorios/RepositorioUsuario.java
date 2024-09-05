package com.example.Banco.Repositorios;

import com.example.Banco.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u.correo FROM Usuario u")
    List<String> userEmails();

    @Query("SELECT u.cedula FROM Usuario u")
    List<Integer> userIdentification();



}
