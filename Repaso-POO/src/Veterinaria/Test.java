package Veterinaria;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControlVacuna controlador = new ControlVacuna();
        int opc = 0;
        int opcn = 0;
        int op = 0;
        do {
            try {
                System.out.println("\n=== Veterinaria ESFOT ===");
                System.out.println("1. Gestion Mascotas");
                System.out.println("2. Gestion Vacunas Mascotas");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opcion: ");
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
                    case 1:
                        do {
                            System.out.println("\n=== GESTION MASCOTAS ===");
                            System.out.println("1. Registrar mascotas");
                            System.out.println("2. Mostrar registros de mascotas");
                            System.out.println("3. Salir");
                            System.out.println("Selecciona una opcion: ");
                            op = sc.nextInt();
                            sc.nextLine();

                            switch (op){
                                case 1:
                                    System.out.println("\n-- REGISTRAR MASCOTAS --");

                                    System.out.print("Nombre mascota: ");
                                    String nom = sc.nextLine();

                                    System.out.print("Tipo animal (Perro, Gato, Conejo, Otro): ");
                                    String tipo_animal = sc.nextLine();

                                    System.out.print("Edad mascota " + nom + ": ");
                                    int edad = sc.nextInt();
                                    sc.nextLine();

                                    System.out.print("Codigo mascota: ");
                                    String codigo = sc.nextLine();

                                    Mascota mas = new Mascota(codigo, tipo_animal, edad, nom);
                                    controlador.registrarMascota(mas);
                                    break;

                                case 2:
                                    System.out.println("\n--- Mostrar Mascotas ---");

                                    controlador.mostrarMascotas();
                                    break;
                                case 3:
                                    System.out.println("Saliendo del sistema de Gestion de Mascotas...");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;

                            }
                        }while (op != 3);
                        break;
                    case 2:
                        do {
                            System.out.println("--- GESTION VACUNAS ---");
                            System.out.println("1. Registrar vacuna mascota");
                            System.out.println("2. Actualizar vacuna");
                            System.out.println("3. Eliminar Vacuna");
                            System.out.println("4. Mostrar Vacunas");
                            System.out.println("5. Salir");
                            System.out.println("Seleccione una opcion: ");
                            opcn = sc.nextInt();
                            sc.nextLine();

                            switch (opcn){
                                case 1:
                                    System.out.println("\n--- Registrar vacuna mascota ---");

                                    System.out.println("Ingrese el codigo de la mascota: ");
                                    String codigoMascota = sc.nextLine();

                                    System.out.println("Ingrese el nombe de la vacuna: ");
                                    String nombreVacuna = sc.nextLine();

                                    controlador.registrarVacuna(codigoMascota,nombreVacuna);
                                    break;
                                case 2:
                                    System.out.println("\n--- Actualizar vacuna ---");

                                    System.out.println("Ingrese el codigo de la mascota: ");
                                    String codigMascota = sc.nextLine();

                                    System.out.println("Ingrese el nombe de la nueva vacuna: ");
                                    String nombrVacuna = sc.nextLine();

                                    controlador.actualizarVacuna(codigMascota, nombrVacuna);
                                    break;
                                case 3:
                                    System.out.println("\n--- Eliminar Vacuna ---");

                                    System.out.println("Ingrese el codigo de la mascota: ");
                                    String codiMascota = sc.nextLine();

                                    controlador.eliminarVacuna(codiMascota);
                                    break;
                                case 4:
                                    System.out.println("\n--- Mostrar Vacunas ---");

                                    controlador.mostrarVacunas();
                                    break;
                                case 5:
                                    System.out.println("Saliendo del sistema de Gestion de Vacunas...");
                                    break;
                                default:
                                    System.out.println("Opción no válida. Intente de nuevo.");
                                    break;
                            }
                        }while (opcn != 5);
                        break;

                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nERROR DE VALIDACIÓN: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\nERROR INDETERMINADO: Entrada inválida.");
                sc.nextLine();
            }

        } while (opc != 3);
        sc.close();
    }
}
