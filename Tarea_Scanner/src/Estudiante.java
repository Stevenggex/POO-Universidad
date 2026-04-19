import java.util.Scanner;

public class Estudiante {
    private String nombre;
    private String carrera;
    private int edad;

    public void registarDatos(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del estudiante: ");
        this.nombre = sc.nextLine();

        System.out.println("Ingrese la carrera del estudiante " + nombre + " : ");
        this.carrera = sc.nextLine();

        System.out.println("Ingrese la edad del estudiante " + nombre + " : ");
        this.edad = sc.nextInt();

    }

    public void mostrarDatos(){
        System.out.println("----- DATOS DEL ESTUDIANTE -----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Carrera: " + carrera);
        System.out.println("Edad: " + edad);
    }

    public static void main(String[] args){
        Estudiante estudiante1 = new Estudiante();
        estudiante1.registarDatos();
        estudiante1.mostrarDatos();
    }
}
