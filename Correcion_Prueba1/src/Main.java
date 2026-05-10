import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dron miDron = null;

        System.out.println("=========== SISTEMA DE DRONES ===========");
        System.out.println("Seleccione el tipo de dron:");
        System.out.println("1. Dron Liviano");
        System.out.println("2. Dron de Carga");
        System.out.println("3. Dron de Emergencia");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                miDron = new DronLiviano();
                break;
            case 2:
                miDron = new DronCarga();
                break;
            case 3:
                miDron = new DronEmergencia();
                break;
            default:
                System.out.println("Opción no válida. Usando Dron Liviano por defecto.");
                miDron = new DronLiviano();
                break;
        }

        System.out.println("\n--- Ingrese los nuevos datos ---");
        System.out.print("Código: ");
        miDron.setCodigo(sc.nextLine());

        System.out.print("Modelo: ");
        miDron.setMarca(sc.nextLine());

        System.out.print("Distancia (km): ");
        miDron.setDistanciaKM(sc.nextDouble());

        System.out.print("Peso paquete (kg): ");
        miDron.setPesoPaquete(sc.nextDouble());

        System.out.print("Horas de vuelo: ");
        miDron.setHorasVuelo(sc.nextDouble());

        if (miDron instanceof DronEmergencia) {
            System.out.print("Nivel de Prioridad (1-3): ");
            ((DronEmergencia) miDron).setNivelPrioridad(sc.nextInt());
        }

        System.out.println("\nValidando datos...");
        if (miDron.validarDatos()) {
            System.out.println("ESTADO: DATOS CORRECTOS");
            miDron.mostrarInformacion();
        } else {
            System.out.println("ESTADO: DATOS NO VÁLIDOS PARA ESTE TIPO DE DRON");
            miDron.mostrarInformacion();
        }
    }
}