package com.example.Practica1.repository;

import com.example.Practica1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Esto buscará al usuario en la BD usando el campo 'username'
    Optional<Usuario> findByUsername(String username);
}
