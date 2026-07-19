package com.example.Practica1.config;

import java.util.Base64;

public class PasswordEncoder {

    //Encriptacion de la clave pasando de texto plano -> a encriptacion
    public static String encode(String password){
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    //Desencriptacion para comparar
    public static boolean matches(String rawPassword,String encodedPassword){
        String decoded = new String(Base64.getDecoder().decode(encodedPassword));
        return rawPassword.equals(decoded);
    }
}
