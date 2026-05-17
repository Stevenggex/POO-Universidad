import java.util.Scanner;

public class Actividad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese un número entero: ");
            String entrada = scanner.nextLine();

            // Intentar convertir la entrada de texto a número entero
            int numero = Integer.parseInt(entrada);

            // Realizar la división
            double resultado = 100.0 / numero;

            // Nota: En Java, dividir un double entre 0 da "Infinity". 
            // Para forzar el ArithmeticException de enteros de forma exacta como pide la guía:
            if (numero == 0) {
                throw new ArithmeticException("No se puede dividir por cero");
            }

            System.out.println("Resultado: " + resultado);

        } catch (NumberFormatException e) {
            // Captura si el usuario ingresa texto en lugar de un número
            System.out.println("Debe ingresar un número válido.");

        } catch (ArithmeticException e) {
            // Captura la división por cero
            System.out.println("No se puede dividir por cero.");

        } finally {
            // Bloque que se ejecuta siempre para finalizar el flujo o liberar recursos
            System.out.println("Programa finalizado correctamente.");
            scanner.close();
        }
    }
}