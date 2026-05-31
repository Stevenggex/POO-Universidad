package Canchas_Deportivas;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        ReservaCancha sistema = new ReservaCancha();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ DE RESERVAS DE CANCHAS =====");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Registrar Reserva");
            System.out.println("3. Actualizar Reserva");
            System.out.println("4. Eliminar Reserva");
            System.out.println("5. Calcular Total de Horas Reservadas");
            System.out.println("6. Mostrar Cliente con Mayor Reserva");
            System.out.println("7. Mostrar Todos los Clientes");
            System.out.println("8. Mostrar Todas las Reservas");
            System.out.println("9. Buscar Cliente por Cédula");
            System.out.println("10. Cargar Datos de Prueba (Mock)");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción (1-11): ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRAR CLIENTE ---");
                    try {
                        System.out.print("Ingrese Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese Cédula (10 dígitos): ");
                        String cedula = sc.nextLine();
                        System.out.print("Ingrese Edad (15 - 60): ");
                        int edad = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingrese Teléfono (solo números): ");
                        String telefono = sc.nextLine();

                        Cliente nuevo = new Cliente(nombre, cedula, edad, telefono);
                        sistema.registrarCliente(nuevo);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error de Validación: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Error: Entrada de datos no válida.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- REGISTRAR RESERVA ---");
                    System.out.print("Ingrese Cédula del cliente: ");
                    String cedulaReserva = sc.nextLine();
                    System.out.print("Ingrese cantidad de horas (1-5): ");
                    try {
                        int horas = Integer.parseInt(sc.nextLine());
                        sistema.registrarReserva(cedulaReserva, horas);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Las horas deben ser un número.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- ACTUALIZAR RESERVA ---");
                    System.out.print("Ingrese Cédula del cliente: ");
                    String cedulaAct = sc.nextLine();
                    System.out.print("Ingrese nuevas horas (1-5): ");
                    try {
                        int nuevasHoras = Integer.parseInt(sc.nextLine());
                        sistema.actualizarReserva(cedulaAct, nuevasHoras);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Las horas deben ser un número.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- ELIMINAR RESERVA ---");
                    System.out.print("Ingrese Cédula del cliente a eliminar: ");
                    String cedulaElim = sc.nextLine();
                    sistema.eliminarReserva(cedulaElim);
                    break;

                case 5:
                    System.out.println("\nTotal de horas asignadas en el complejo: " + sistema.calcularTotalHoras() + " horas.");
                    break;

                case 6:
                    System.out.println("\nEl cliente que más tiempo reservó es: " + sistema.clienteMayorReserva());
                    break;

                case 7:
                    sistema.mostrarClientes();
                    break;

                case 8:
                    sistema.mostrarReservas();
                    break;

                case 9:
                    System.out.print("\nIngrese la cédula a buscar: ");
                    String cedulaBuscar = sc.nextLine();
                    Cliente encontrado = sistema.buscarPorCedula(cedulaBuscar);
                    if (encontrado != null) {
                        System.out.println("Cliente encontrado: " + encontrado);
                    } else {
                        System.out.println("Cliente no registrado en el sistema.");
                    }
                    break;

                case 10:
                    try {
                        sistema.registrarCliente(new Cliente("Ana Gomez", "1712345678", 25, "0998765432"));
                        sistema.registrarCliente(new Cliente("Luis Perez", "1787654321", 40, "0991234567"));
                        sistema.registrarReserva("1712345678", 3);
                        sistema.registrarReserva("1787654321", 5);
                        System.out.println("\n[MOCK] Datos de prueba cargados correctamente.");
                    } catch (Exception e) {
                        System.out.println("Los datos ya estaban cargados.");
                    }
                    break;

                case 11:
                    System.out.println("\nSaliendo del sistema de reservas de canchas. ¡Buen día!");
                    break;

                default:
                    System.out.println("\nOpción no válida. Intente del 1 al 11.");
                    break;
            }
        } while (opcion != 11);

        sc.close();
    }
}
