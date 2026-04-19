import java.util.Scanner;

public class Planilla {
    private String nombreCliente;
    private double costokW;
    private int consumoEnergia;

    public void ingresoDatos(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del cliente: ");
        this.nombreCliente = sc.nextLine();

        System.out.println("Ingrese su consumo de energia (En horas, por ej: 100): ");
        this.consumoEnergia = sc.nextInt();

        System.out.println("Ingrese su costo por kWh: ");
        this.costokW = sc.nextDouble();
    }

    public double calcularSubtotal(){
        return consumoEnergia * costokW;
    }

    public double calcularIva(){
        return calcularSubtotal() * 0.15;
    }

    public double totalPagar(){
        return calcularIva() + calcularSubtotal();
    }

    public void mostrarDatos(){
        System.out.println("---- Planilla de Luz -----");
        System.out.println("Nombre: " + nombreCliente);
        System.out.println("Subtotal: " + calcularSubtotal());
        System.out.println("Iva: " + calcularIva());
        System.out.println("Total a pagar: " + totalPagar());
        System.out.println("----------------------------------");
    }

    public static void main(String[] args){
        Planilla p1 = new Planilla();

        p1.ingresoDatos();
        p1.mostrarDatos();
    }
}
