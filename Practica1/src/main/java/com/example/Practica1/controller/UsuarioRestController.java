package com.example.Practica1.controller;

import com.example.Practica1.config.PasswordEncoder;
import com.example.Practica1.model.Usuario;
import com.example.Practica1.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@Valid @RequestBody Usuario usuario){
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya esta en uso.");
        }

        String claveEncriptada = Base64.getEncoder().encodeToString(usuario.getPassword().getBytes());
        usuario.setPassword(claveEncriptada);

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado correctamente.");
    }

    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioDb = usuarioRepository.findByUsername(usuario.getUsername());

        if (usuarioDb.isPresent()){

            String passwordEncriptada = Base64.getEncoder().encodeToString(usuario.getPassword().getBytes());

            if (usuarioDb.get().getPassword().equals(passwordEncriptada)) {
                return ResponseEntity.ok("Login exitoso");
            } else {
                return ResponseEntity.status(401).body("Contraseña incorrecta");
            }
        }
        return ResponseEntity.status(401).body("Usuario no encontrado");
    }
}
