package Canchas_Deportivas;

public class Cliente {
    private String nombre;
    private String cedula;
    private int edad;
    private String telefono;

    // Constructor completo
    public Cliente(String nombre, String cedula, int edad, String telefono) {
        setNombre(nombre);
        setCedula(cedula);
        setEdad(edad);
        setTelefono(telefono);
    }

    // Getters y Setters con validaciones completas (Ejercicio 1)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        // Rellenado: La cédula debe tener exactamente 10 dígitos numéricos
        if (cedula == null || !cedula.matches("\\d{10}")) {
            throw new IllegalArgumentException("Cédula inválida: debe tener 10 dígitos.");
        }
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        // Rellenado: Edad entre 15 y 60 años
        if (edad < 15 || edad > 60) {
            throw new IllegalArgumentException("Edad debe estar entre 15 y 60 años.");
        }
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        // Rellenado: El teléfono debe contener solo números
        if (telefono == null || !telefono.matches("\\d+")) {
            throw new IllegalArgumentException("Teléfono solo puede contener números.");
        }
        this.telefono = telefono;
    }

    // Ejercicio 2 — equals() y hashCode() basados estrictamente en la cédula
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente)) return false;
        Cliente otro = (Cliente) obj;
        return this.cedula.equals(otro.cedula); // Igualdad por cédula
    }

    @Override
    public int hashCode() {
        return cedula.hashCode(); // Mismo criterio que equals
    }

    @Override
    public String toString() {
        return "Cliente{cedula='" + cedula +
                "', nombre='" + nombre +
                "', edad=" + edad +
                ", telefono='" + telefono + "'}";
    }
}