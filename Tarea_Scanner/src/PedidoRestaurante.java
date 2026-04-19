import java.util.Scanner;

public class PedidoRestaurante {
    private String cliente;
    private String plato;
    private double precio;
    private int cantidad;

    public void ingreso(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su nombre: ");
        this.cliente = sc.nextLine();

        System.out.println("Ingrese el plato comprado: ");
        this.plato = sc.nextLine();

        System.out.println("Ingrese el precio del plato: ");
        this.precio = sc.nextDouble();

        System.out.println("Ingrese la cantidad de platos comprados: ");
        this.cantidad = sc.nextInt();
    }

    public double calcularSubtotal(){
        return precio * cantidad;
    }

    public double descuento(){
        double desc = calcularSubtotal();

        if (desc >= 25){
            return desc * 0.10;
        } else {
            return 0.0;
        }
    }

    public double totalFinal(){
        return descuento() + calcularSubtotal();
    }

    public void mostrar(){
        System.out.println("------- Cuenta del Pedido ------");
        System.out.println("Cliente: " + cliente);
        System.out.println("Plato: " + plato);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Subtotal: " + calcularSubtotal());
        System.out.println("Descuento: " + descuento());
        System.out.println("Total final: " + totalFinal());
    }

    public static void main(String[] args){
        PedidoRestaurante p1 = new PedidoRestaurante();

        p1.ingreso();
        p1.mostrar();
    }
}
