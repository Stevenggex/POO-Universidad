// 1. Definición de la excepción personalizada (Checked)
class EdadInvalidaException extends Exception {
    private final int edadIngresada;

    public EdadInvalidaException(int edadIngresada) {
        super("Edad inválida: " + edadIngresada + ". Debe estar entre 0 y 120 años.");
        this.edadIngresada = edadIngresada;
    }

    public int getEdadIngresada() {
        return edadIngresada;
    }
}

// 2. Clase Estudiante
class Estudiante {
    private String nombre;
    private int edad;
    private double promedio;

    public Estudiante(String nombre, int edad, double promedio) throws EdadInvalidaException {
        // Validar regla de negocio para la edad
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException(edad);
        }
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante{Nombre='" + nombre + "', Edad=" + edad + ", Promedio=" + promedio + "}";
    }
}

// 3. Clase Principal para ejecutar las pruebas
public class Actividad2 {
    public static void main(String[] args) {
        // Intentar registrar 3 estudiantes (uno fallará)
        try {
            System.out.println("Intentando registrar a Juan...");
            Estudiante e1 = new Estudiante("Juan", 20, 8.5);
            System.out.println("Registrado con éxito: " + e1);

            System.out.println("\nIntentando registrar a Carlos (Edad inválida)...");
            Estudiante e2 = new Estudiante("Carlos", -5, 9.0); // Esto lanzará la excepción
            System.out.println("Registrado con éxito: " + e2);

        } catch (EdadInvalidaException e) {
            System.err.println("Error capturado: " + e.getMessage());
        }

        try {
            System.out.println("\nIntentando registrar a Maria...");
            Estudiante e3 = new Estudiante("Maria", 22, 9.5);
            System.out.println("Registrado con éxito: " + e3);
        } catch (EdadInvalidaException e) {
            System.err.println("Error capturado: " + e.getMessage());
        }
    }
}
