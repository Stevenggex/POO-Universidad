public class PersonaAcademica {
    private String codigo;
    private String nombre;
    private int edad;

    public PersonaAcademica(String codigo, String nombre, int edad){
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void setCodigo(String codigo) {
        if (codigo.isEmpty()){
            System.out.println("Codigo no puede estar vacio.");
            return;
        }
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty()){
            System.out.println("Nombre no puede estar vacio.");
            return;
        }
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad < 18 ) {
            System.out.println("Edad no valida.");
            return;
        }
        this.edad = edad;
    }

    public void mostrar(){
        System.out.println("-- Datos --");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }


    public void describirRol(){
        System.out.println("Soy estudiante");
    }

    public double calcularPago(){
        return 0.0;
    }

}
