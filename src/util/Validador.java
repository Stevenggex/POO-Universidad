package util;

public class Validador {
    public static boolean esTextoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean validarEdad(int edad) {
        return edad > 0 && edad < 150;
    }

    public static boolean validarCorreo(String correo) {
        return correo != null && correo.contains("@");
    }

    public static boolean validarTelefono(String telefono) {
        return telefono != null && telefono.matches("\\d+");
    }

    public static boolean validarMayorCero(double valor) {
        return valor > 0;
    }
}