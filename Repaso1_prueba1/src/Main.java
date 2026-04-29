import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nom = sc.nextLine();

        System.out.print("Código: ");
        String cod = sc.nextLine();

        System.out.print("Promedio (0-10): ");
        double prom = sc.nextDouble();

        System.out.print("Matrícula Base: ");
        double mat = sc.nextDouble();

        System.out.print("Porcentaje Beca (0-100): ");
        int beca = sc.nextInt();

        Estudiante est1 = new EstudianteBecado(cod, nom, prom, mat, beca);

        System.out.println("\n--- RESULTADOS ---");
        est1.mostrarDatos();
        System.out.println("Pago Final con Beca: $" + est1.calcularPagoFinal());

        System.out.println("Pago con descuento pronto pago: $" + est1.calcularPagoFinal(50.0));
    }
}