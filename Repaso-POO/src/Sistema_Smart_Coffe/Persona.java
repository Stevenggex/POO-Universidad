package Sistema_Smart_Coffe;

public class Persona {
    private String nombre;
    private String correo;
    private int edad;

    public Persona(String nombre, String correo, int edad) {
        setNombre(nombre);
        setCorreo(correo);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Error: Nombre no puede estar vacio.");
        }
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()){
            throw new IllegalArgumentException("Error: Correo no puede estar vacio.");
        }
        if (!correo.contains("@")){
            throw new IllegalArgumentException("Error: Correo invalido, el correo debe tener el '@'.");
        }
        this.correo = correo;
    }

    public void setEdad(int edad) {
        if (edad < 18 || edad > 60){
            throw new IllegalArgumentException("Error: Edad invalida.");
        }
        this.edad = edad;
    }

    @Override
    public String toString(){
        return "Cliente [Nombre: " + nombre + " - Correo: " + correo + " - Edad: " + edad + "]";
    }
}
