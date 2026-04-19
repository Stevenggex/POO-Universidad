import java.util.Scanner;

public class Tienda {
    private String nombreProducto;
    private double precioProducto;
    private int cantidad;

    public void ingresarDatos(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el nombre del producto: ");
        this.nombreProducto = sc.nextLine();

        System.out.println("Ingrese el precio del producto " + nombreProducto + " : ");
        this.precioProducto = sc.nextDouble();

        System.out.println("Ingrese la cantidad del producto " + nombreProducto + " : ");
        this.cantidad = sc.nextInt();
    }

    public void descuentoTotal(){

        double total = precioProducto * cantidad;

        if (total >= 1000){
            double descuento = total * 0.10;
            System.out.println("Se aplica descuento del 10%: $" + descuento);
            System.out.println("Total con descuento: $" + (total - descuento));
        } else {
            System.out.println("No aplica descuento.");
            System.out.println("Total a pagar: $" + total);
        }
    }

    public void mostrarFactura(){

        double total = precioProducto * cantidad;

        System.out.println("----- Factura ------");
        System.out.println("Nombre Producto: " + nombreProducto);
        System.out.println("Precio Producto: " + precioProducto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total: " + total);

        descuentoTotal();
    }

    public static void main(String[] args){
        Tienda p1 = new Tienda();
        p1.ingresarDatos();
        p1.mostrarFactura();
    }
}
