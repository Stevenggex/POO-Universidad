import java.util.Scanner;

public class Empleado {
    private String nombre;
    private double horasTrabjadas;
    private double pagoXhoras;

    public void ingreso(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        this.nombre = sc.nextLine();

        System.out.println("Ingrese sus horas trabajadas: ");
        this.horasTrabjadas = sc.nextDouble();

        System.out.println("Ingrese su pago x horas: ");
        this.pagoXhoras = sc.nextDouble();
    }

    public double sueldoBase(){
        return horasTrabjadas * pagoXhoras;
    }

    public double calcularBono() {
        double sueldo = sueldoBase();
        if (sueldo >= 1000) {
            return sueldo * 0.20;
        } else {
            return 0.0;
        }
    }

    public double sueldoFinal() {
        return sueldoBase() + calcularBono();
    }

    public void mostrar(){
        System.out.println("------ Reporte Empleado ----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Sueldo base: " + sueldoBase());
        System.out.println("Bono: " + calcularBono());
        System.out.println("Sueldo Final: " + sueldoFinal());

    }

    public static void main(String[] args){
        Empleado emp1 = new Empleado();

        emp1.ingreso();
        emp1.mostrar();
    }
}
