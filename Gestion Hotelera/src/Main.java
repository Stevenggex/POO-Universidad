import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Habitacion[] listaHabitaciones = new Habitacion[10];
        int contador = 0;
        int opcionMenu;

        do {
            System.out.println("\n--- RESERVAS HOTEL QUITO ---");
            System.out.println("1. Habitación Simple");
            System.out.println("2. Suite");
            System.out.println("3. Habitación Familiar");
            System.out.println("4. Mostrar todas las reservas");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcionMenu = sc.nextInt();

            if (opcionMenu >= 1 && opcionMenu <= 3) {
                if (contador < listaHabitaciones.length) {

                    System.out.print("Nombre del huésped: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();

                    System.out.print("Código: ");
                    String cod = sc.next();

                    System.out.print("Noches: ");
                    int noches = sc.nextInt();

                    System.out.println("Servicio Extra: 1.Lavandería 2.Parqueadero 3.Room Service 0.Ninguno");
                    int opServ = sc.nextInt();

                    if (opcionMenu == 1) {
                        HabitacionSimple hs = new HabitacionSimple(cod, noches, 0.0, nombre);
                        hs.setCostoServicioBasico(hs.calcularServicioExtra(opServ));

                        System.out.println("Tarifa base actual: $" + hs.getTarifaBase());
                        hs.setDisponible(false);
                        System.out.println("Disponible tras reserva: " + hs.isDisponible());

                        System.out.println("calcularPago(" + noches + "): $" + hs.calcularPago(noches));
                        System.out.println("calcularPago(" + noches + ", 0.05 desc): $" + hs.calcularPago(noches, 0.05));

                        listaHabitaciones[contador] = hs;
                    }
                    else if (opcionMenu == 2) {
                        Suite st = new Suite(cod, noches, 0.0, nombre);
                        st.setServicioPremium(st.calcularServicioExtra(opServ));

                        System.out.println("Tarifa base actual: $" + st.getTarifaBase());
                        st.setDisponible(false);
                        System.out.println("Disponible tras reserva: " + st.isDisponible());
                        System.out.println("calcularPago(" + noches + "): $" + st.calcularPago(noches));
                        System.out.println("calcularPago(" + noches + ", 0.05 desc): $" + st.calcularPago(noches, 0.05));

                        listaHabitaciones[contador] = st;
                    }
                    else if (opcionMenu == 3) {
                        System.out.print("Personas: ");
                        int pers = sc.nextInt();
                        HabitacionFamiliar hf = new HabitacionFamiliar(cod, noches, pers, nombre);
                        hf.setDescuentoFamiliar(hf.calcularServicioExtra(opServ));

                        System.out.println("Tarifa base actual: $" + hf.getTarifaBase());
                        hf.setDisponible(false);
                        System.out.println("Disponible tras reserva: " + hf.isDisponible());
                        System.out.println("calcularPago(" + noches + "): $" + hf.calcularPago(noches));
                        System.out.println("calcularPago(" + noches + ", 0.05 desc): $" + hf.calcularPago(noches, 0.05));

                        listaHabitaciones[contador] = hf;
                    }
                    contador++;
                    System.out.println("Registro completado.");
                } else {
                    System.out.println("Error: Habitaciones llenas.");
                }
            }
            else if (opcionMenu == 4) {
                for (int i = 0; i < contador; i++) {
                    listaHabitaciones[i].mostrarDetalle();
                }
            }
        } while (opcionMenu != 0);

        sc.close();
    }
}