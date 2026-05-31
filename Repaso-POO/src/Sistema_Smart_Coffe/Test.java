package Sistema_Smart_Coffe;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Cafeteria miCafeteria = new Cafeteria("Smart Coffee EPN");
        int opc = 0;
        int opn = 0;

        do {
            System.out.println("-- SAMART COFFE --");
            System.out.println("1. Registro clientes");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Gestion pedidos clientes");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opcion: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("== REGISTRO CLIENTES ==");

                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.println("Correo: ");
                    String correo = sc.nextLine();

                    System.out.println("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Codigo Cliente: ");
                    String cod = sc.nextLine();

                    System.out.println("Tipo Membresia: ");
                    String membresia = sc.nextLine();

                    Cliente cl1 = new Cliente(nombre, correo, edad, cod, membresia);
                    miCafeteria.registrarCliente(cl1);
                    break;

                case 2:
                    System.out.println("\n-- CLIENTES REGISTRADOS --");

                    miCafeteria.mostrarClientes();
                    break;
                case 3:
                    do {
                        System.out.println("\n== GESTION PEDIDOS ==");
                        System.out.println("1. Registrar pedido");
                        System.out.println("2. Actualizar Pedido");
                        System.out.println("3. Eliminar pedido");
                        System.out.println("4. Mostrar Promedio Consumo");
                        System.out.println("5. Mostrar Mejor cliente");
                        System.out.println("6. BUscar cliente por correo");
                        System.out.println("7. Mostrar pedidos registrados");
                        System.out.println("8. Salir");
                        System.out.println("Seleccione una opcion: ");
                        opn = sc.nextInt();
                        sc.nextLine();

                        switch (opn){
                            case 1:
                                System.out.println("-- REGISTRAR PEDIDO --");

                                System.out.println("Ingrese su correo: ");
                                String correo_cl = sc.nextLine();

                                System.out.println("Ingrese su consumo: ");
                                int consumo = sc.nextInt();

                                miCafeteria.registrarPedido(correo_cl, consumo);
                                break;

                            case 2:
                                System.out.println("-- ACTUALIZAR PEDIDO --");

                                System.out.println("Correo: ");
                                String correo_clien = sc.nextLine();

                                System.out.println("Nuevo consumo: ");
                                int nuevo_consumo = sc.nextInt();

                                miCafeteria.actualizarPedido(correo_clien, nuevo_consumo);
                                break;

                            case 3:
                                System.out.println("-- ELIMINAR PEDIDO --");

                                System.out.println("Correo: ");
                                String correo_cliente = sc.nextLine();

                                miCafeteria.eliminarPedido(correo_cliente);
                                break;

                            case 4:
                                System.out.println("-- MOSTRAR PROMEDIO CONSUMO --");

                                 miCafeteria.promedioConsumo();
                                 break;

                            case 5:
                                System.out.println("\n-- MEJOR CLIENTE --");

                                miCafeteria.mejorCliente();
                                break;

                            case 6:
                                System.out.println("\n-- BUSCAR CLIENTE POR CORREO --");

                                System.out.println("Correo: ");
                                String correo_Cl = sc.nextLine();

                                miCafeteria.buscaPorCorreo(correo_Cl);
                                break;

                            case 7:
                                System.out.println("\n-- PEDIDOS REGISTRADOS --");

                                miCafeteria.mostrarPedidos();
                                break;

                            case 8:
                                System.out.println("Saliendo de gestion de pedidos... ");
                                break;

                            default:
                                System.out.println("Error: opcion invalida");
                                break;
                        }
                    } while (opn != 8);

                case 4:
                    System.out.println("Saliendo del sistema ...");
                    break;

                default:
                    System.out.println("Error: opcion invalida");
                    break;
            }
        } while (opc != 4);
    }
}
