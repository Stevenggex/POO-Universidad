import java.util.Scanner;

public class Producto {

    public String codigo;
    public String nombreComercial;
    public String categoria;

    private double precioUnitario;
    private int stockDisponible;
    private int stockMinimo;

    public Producto() {
    }

    public void setPrecioUnitario(double precio) {
        if (precio > 0) {
            this.precioUnitario = precio;
            System.out.println("✓ Precio actualizado correctamente a $" + precio);
        } else {
            System.out.println("✗ Error: El precio no puede ser menor o igual a cero.");
        }
    }

    public void setStockDisponible(int stock) {
        if (stock >= 0) {
            this.stockDisponible = stock;
            System.out.println("✓ Stock disponible actualizado correctamente a " + stock);
        } else {
            System.out.println("✗ Error: El stock disponible no puede ser negativo.");
        }
    }

    public void setStockMinimo(int minimo) {
        if (minimo >= 0) {
            this.stockMinimo = minimo;
            System.out.println("✓ Stock mínimo actualizado correctamente a " + minimo);
        } else {
            System.out.println("✗ Error: El stock mínimo no puede ser negativo.");
        }
    }

    public double getPrecioUnitario() { return precioUnitario; }
    public int getStockDisponible() { return stockDisponible; }
    public int getStockMinimo() { return stockMinimo; }

    public double calcularValorTotalInventario() {
        return precioUnitario * stockDisponible;
    }

    public String obtenerEstadoStock() {
        if (stockDisponible == 0) {
            return "Producto agotado";
        } else if (stockDisponible < stockMinimo) {
            return "Requiere reposición";
        } else {
            return "Stock suficiente";
        }
    }

    public void mostrarReporte() {
        System.out.println("\n" + "=".repeat(55));
        System.out.println("               REPORTE DE PRODUCTO");
        System.out.println("=".repeat(55));
        System.out.println("Código              : " + codigo);
        System.out.println("Nombre              : " + nombreComercial);
        System.out.println("Categoría           : " + categoria);
        System.out.println("Precio Unitario     : $" + String.format("%.2f", precioUnitario));
        System.out.println("Stock Disponible    : " + stockDisponible + " unidades");
        System.out.println("Stock Mínimo        : " + stockMinimo + " unidades");
        System.out.println("Valor Total Inventario : $" + String.format("%.2f", calcularValorTotalInventario()));
        System.out.println("Estado del Stock    : " + obtenerEstadoStock());
        System.out.println("=".repeat(55));
    }

    public void ingresarDatos() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el código del producto: ");
        this.codigo = sc.nextLine();

        System.out.print("Ingrese el nombre comercial: ");
        this.nombreComercial = sc.nextLine();

        System.out.print("Ingrese la categoría: ");
        this.categoria = sc.nextLine();

        System.out.print("Ingrese el precio unitario: ");
        double precio = sc.nextDouble();
        setPrecioUnitario(precio);

        System.out.print("Ingrese el stock disponible: ");
        int stock = sc.nextInt();
        setStockDisponible(stock);

        System.out.print("Ingrese el stock mínimo: ");
        int minimo = sc.nextInt();
        setStockMinimo(minimo);

        sc.nextLine();
    }

    public void actualizarDatos() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Actualizando datos del producto ---");

        System.out.print("Nuevo precio unitario: ");
        double nuevoPrecio = sc.nextDouble();
        setPrecioUnitario(nuevoPrecio);

        System.out.print("Nuevo stock disponible: ");
        int nuevoStock = sc.nextInt();
        setStockDisponible(nuevoStock);

        sc.nextLine();
    }
}