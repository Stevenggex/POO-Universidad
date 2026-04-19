import java.util.Scanner;

public class Calificacion {
    private String nombreEstudiante;
    private double nota1;
    private double nota2;
    private double nota3;

    public void ingresarDatos(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del estudiante: ");
        this.nombreEstudiante = sc.nextLine();

        System.out.println("Ingrese nota 1 del estudiante " + nombreEstudiante + " : ");
        this.nota1 = sc.nextDouble();

        System.out.println("Ingrese nota 2 del estudiante " + nombreEstudiante + " : ");
        this.nota2 = sc.nextDouble();

        System.out.println("Ingrese nota 3 del estudiante " + nombreEstudiante + " : ");
        this.nota3 = sc.nextDouble();
    }

    public double calcularPromedio(){
        return (nota1 + nota2 + nota3) / 3.0;
    }

    public String estado(){
        double prom = calcularPromedio();

        if (prom >= 7){
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    public void mostrarDatos(){
        double promedio = calcularPromedio();

        System.out.println("---- Reporte Academico -----");
        System.out.println("Nombre: " +  nombreEstudiante);
        System.out.println("Promedio Final: " + promedio);
        System.out.println("Estado: " + estado());
    }

    public static void main(String[] args){
        Calificacion c1 = new Calificacion();

        c1.ingresarDatos();
        c1.mostrarDatos();
    }
}
