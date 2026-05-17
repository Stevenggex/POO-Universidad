import java.util.Scanner;

// 1. Excepción personalizada para monedas no válidas
class MonedaNoSoportadaException extends Exception {
    public MonedaNoSoportadaException(String mensaje) {
        super(mensaje);
    }
}

public class Actividad4 {

    // 2. Método conversor con tasas hardcodeadas
    public static double convertir(String monedaOrigen, String monedaDestino, double cantidad)
            throws MonedaNoSoportadaException {

        // Normalizamos a mayúsculas para evitar errores de tipeo
        String origen = monedaOrigen.toUpperCase();
        String destino = monedaDestino.toUpperCase();

        // Validar que las monedas sean únicamente USD o EUR
        if ((!origen.equals("USD") && !origen.equals("EUR")) ||
                (!destino.equals("USD") && !destino.equals("EUR"))) {
            throw new MonedaNoSoportadaException("Error: Una o ambas monedas ('" + origen + "' -> '" + destino + "') no están soportadas.");
        }

        if (origen.equals(destino)) {
            return cantidad; // Misma moneda
        }

        // Ejemplo de tasas fijas de conversión: 1 EUR = 1.08 USD
        if (origen.equals("EUR") && destino.equals("USD")) {
            return cantidad * 1.08;
        } else { // De USD a EUR
            return cantidad / 1.08;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese la moneda de origen (USD / EUR): ");
            String origen = scanner.nextLine();

            System.out.print("Ingrese la moneda de destino (USD / EUR): ");
            String destino = scanner.nextLine();

            System.out.print("Ingrese la cantidad a cambiar: ");
            String cantidadStr = scanner.nextLine();

            // Convertir de String a double controlando errores de formato
            double cantidad = Double.parseDouble(cantidadStr);

            // Intentar procesar la conversión monetaria
            double resultado = convertir(origen, destino, cantidad);

            // Imprimir el resultado con exactamente 2 decimales usando String.format
            System.out.println("\n--- Transacción Exitosa ---");
            System.out.println("Monto final: " + String.format("%.2f", resultado) + " " + destino.toUpperCase());

        } catch (NumberFormatException e) {
            System.err.println("Error: La cantidad ingresada no es un número decimal válido.");
        } catch (MonedaNoSoportadaException e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Proceso de conversión finalizado.");
        }
    }
}
