// --- Clases necesarias para la PARTE D (Jerarquía de Objetos) ---
class Animal {
    public void hacerSonido() {
        System.out.println("El animal hace un sonido.");
    }
}

class Perro extends Animal {
    public void ladrar() {
        System.out.println("El perro ladra: ¡Guau!");
    }
}

// --- Clase Principal de la Actividad 3 ---
public class Actividad3 {
    public static void main(String[] args) {

        // ==========================================================
        // PARTE A: Conversión Implícita (Widening)
        // ==========================================================
        System.out.println("--- PARTE A: Widening ---");
        byte miByte = 10;
        short miShort = miByte;  // byte -> short automático
        int miInt = miShort;     // short -> int automático
        long miLong = miInt;     // int -> long automático
        float miFloat = miLong;   // long -> float automático
        double miDouble = miFloat; // float -> double automático

        System.out.println("Valores en cadena automática (Double final): " + miDouble);

        // ==========================================================
        // PARTE B: Casting Explícito (Narrowing)
        // ==========================================================
        System.out.println("\n--- PARTE B: Narrowing ---");
        double originalDouble = 45.89;

        float desdeDoubleFloat = (float) originalDouble;
        int desdeDoubleInt = (int) originalDouble; // Se pierde la parte decimal (.89) por truncamiento
        short desdeDoubleShort = (short) originalDouble;
        byte desdeDoubleByte = (byte) originalDouble;

        System.out.println("Original Double: " + originalDouble);
        System.out.println("A Float: " + desdeDoubleFloat);
        System.out.println("A Int (Pérdida de decimales por truncamiento): " + desdeDoubleInt);
        System.out.println("A Short: " + desdeDoubleShort);
        System.out.println("A Byte: " + desdeDoubleByte);

        // ==========================================================
        // PARTE C: Conversión con Strings
        // ==========================================================
        System.out.println("\n--- PARTE C: Strings ---");
        // De String a Primitivos
        int sToInt = Integer.parseInt("2024");
        double sToDouble = Double.parseDouble("98.6");
        boolean sToBool = Boolean.parseBoolean("false");

        // De primitivos de vuelta a String mediante 3 métodos diferentes
        // Método 1: String.valueOf()
        String metodo1 = String.valueOf(sToInt);
        // Método 2: Wrapper.toString()
        String metodo2 = Double.toString(sToDouble);
        // Método 3: Concatenación vacía (automática)
        String metodo3 = "" + sToBool;

        System.out.println("Método 1 (String.valueOf): " + metodo1);
        System.out.println("Método 2 (Double.toString): " + metodo2);
        System.out.println("Método 3 (Concatenación): " + metodo3);

        // ==========================================================
        // PARTE D: Casting de Objetos (Reference Casting)
        // ==========================================================
        System.out.println("\n--- PARTE D: Reference Casting ---");
        Animal miAnimal = new Perro(); // Upcasting (Automático: un Perro ES un Animal)

        // Verificar el tipo de manera segura antes de aplicar Downcasting (Casteo explícito)
        if (miAnimal instanceof Perro) {
            Perro miPerroReal = (Perro) miAnimal; // Corregido el espacio en blanco
            System.out.print("Casteo exitoso. Acción del perro: ");
            miPerroReal.ladrar();
        } else {
            System.out.println("La conversión no es posible.");
        }
    }
}