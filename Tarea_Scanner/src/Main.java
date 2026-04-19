public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto();

        System.out.println("=== REGISTRO INICIAL DEL PRODUCTO ===");
        producto.ingresarDatos();

        System.out.println("\n=== REPORTE INICIAL ===");
        producto.mostrarReporte();

        System.out.println("\n=== ACTUALIZACIÓN DE DATOS ===");
        producto.actualizarDatos();

        System.out.println("\n=== REPORTE DESPUÉS DE ACTUALIZACIÓN ===");
        producto.mostrarReporte();

        System.out.println("\n=== PRUEBA DE VALOR INVÁLIDO (stock -3) ===");
        producto.setStockDisponible(-3);
        producto.mostrarReporte();
    }
}