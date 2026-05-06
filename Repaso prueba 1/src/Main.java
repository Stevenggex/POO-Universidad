import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Vehiculo[] listaespacios = new Vehiculo[10];
        int contador = 0;
        int opc;

        do {
            System.out.println("\n--- Alquiler de Vehiculos ---");
            System.out.println("1. Auto");
            System.out.println("2. Camioneta");
            System.out.println("3. Moto");
            System.out.println("4. Mostrar todas las reservas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opc = sc.nextInt();


            sc.nextLine();

            switch (opc) {
                case 1:
                    if (contador < listaespacios.length ) {
                        System.out.print("Nombre del cliente: ");
                        String nomAuto = sc.nextLine();
                        System.out.print("Placa: ");
                        String placaAuto = sc.nextLine();
                        System.out.print("Marca: ");
                        String marcAuto = sc.nextLine();
                        System.out.print("Dias de alquiler: ");
                        int diasAuto = sc.nextInt();
                        System.out.print("¿Su auto tiene GPS? (true/false): ");
                        boolean gps = sc.nextBoolean();

                        listaespacios[contador] = new Auto(placaAuto, marcAuto, diasAuto, nomAuto, gps);
                        System.out.println("Vehiculo registrado exitosamente en el espacio: " + (contador + 1) );
                        contador ++;
                    } else {
                        System.out.println("Error: El parqueadero está lleno (máximo 10 vehículos).");
                    }
                    break;
                case 2:
                    if (contador < listaespacios.length){
                        System.out.print("Nombre del cliente: ");
                        String nomCam = sc.nextLine();
                        System.out.print("Placa: ");
                        String placaCam = sc.nextLine();
                        System.out.print("Marca: ");
                        String marcCam = sc.nextLine();
                        System.out.print("Dias de alquiler: ");
                        int diasCam = sc.nextInt();
                        System.out.print("Capacidad de carga (ton): ");
                        double carga = sc.nextDouble();

                        listaespacios[contador] = new Camioneta(placaCam, marcCam, diasCam, nomCam, carga);
                        System.out.println("Camioneta regstrada exitosamente en el espacio: " + (contador + 1));
                        contador ++;
                    } else {
                        System.out.println("Error: El parqueadero esta lleno (maximo 10 vehiculos). ");
                    }
                    break;

                case 3:
                    if (contador < listaespacios.length){
                        System.out.print("Nombre del cliente: ");
                        String nomMoto = sc.nextLine();
                        System.out.print("Placa: ");
                        String placaMoto = sc.nextLine();
                        System.out.print("Marca: ");
                        String marcMoto = sc.nextLine();
                        System.out.print("Dias de alquiler: ");
                        int diasMoto = sc.nextInt();
                        System.out.print("Casco Extra (true/false): ");
                        boolean casco = sc.nextBoolean();

                        listaespacios[contador] = new Moto(placaMoto, marcMoto, diasMoto, nomMoto, casco);
                        System.out.println("Mota registrada exitosamente en el espacio: " + (contador + 1));
                        contador++;
                    } else {
                        System.out.println("Error: El parqueadero esta lleno (limite de 10 espacios).");
                    }
                    break;

                case 4:
                    for (int i = 0; i < contador; i++) {
                        listaespacios[i].mostrarDetalle();
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema de alquiler.");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opc != 0);

        sc.close();
    }
}