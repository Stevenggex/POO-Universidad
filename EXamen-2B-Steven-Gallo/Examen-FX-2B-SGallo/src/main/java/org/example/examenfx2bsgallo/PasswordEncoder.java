package org.example.examenfx2bsgallo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //Encriptar la ocntraseña
    private String encriptar(String passwordPLana){
        String contraseñaEncriptada = encoder.encode(passwordPLana);
        return contraseñaEncriptada;
    }

    // comparar la clave del Login con la BD
    private boolean verifcar(String passwordPlana, String passwordEncriptada) {
        return encoder.matches(passwordPlana, passwordEncriptada);
    }
}
