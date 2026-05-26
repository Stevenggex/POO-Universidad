package app;

import modelo.*;
import servicio.EmpleadoServicio;
import util.Validador;
import java.util.Scanner;

public class Main {
    private static EmpleadoServicio servicio = new EmpleadoServicio();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            try {
                System.out.println("\n===== CLÍNICA SALUD TOTAL =====");
                System.out.println("1. Registrar médico");
                System.out.println("2. Registrar administrativo");
                System.out.println("3. Mostrar empleados");
                System.out.println("4. Buscar por cédula");
                System.out.println("5. Reemplazar información");
                System.out.println("6. Eliminar registro");
                System.out.println("7. Calcular pagos");
                System.out.println("8. Mostrar estadísticas");
                System.out.println("9. Salir");
                System.out.print("Seleccione opción: ");

                opcion = Integer.parseInt(sc.nextLine()); // Conversión obligatoria con try-catch

                switch (opcion) {
                    case 1: registrarMedico(); break;
                    case 2: registrarAdmin(); break;
                    case 3: servicio.mostrarTodosLosEmpleados(); break;
                    case 4: buscarPorCedula(); break;
                    case 5: reemplazarInformacion(); break;
                    case 6: eliminarRegistro(); break;
                    case 7: servicio.mostrarTodosLosEmpleados(); break; // Imprime listado con cálculos individuales
                    case 8: servicio.mostrarEstadisticas(); break;
                    case 9: System.out.println("Fin del sistema."); break;
                    default: System.out.println("Error: opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: opción inválida. Ingrese solo números enteros.");
                opcion = 0;
            }
        } while (opcion != 9);
    }

    private static void registrarMedico() {
        String cedula = pedirTexto("Cédula: ");
        String nombre = pedirTexto("Nombre: ");
        int edad = pedirEdad();
        String telf = pedirTelefono();
        String correo = pedirCorreo();
        String espec = pedirTexto("Especialidad: ");
        int pac = pedirEntero("Pacientes atendidos: ");
        double val = pedirDouble("Valor consulta: ");

        Medico m = new Medico(cedula, nombre, edad, telf, correo, espec, pac, val);
        servicio.registrarEmpleado(m);
    }

    private static void registrarAdmin() {
        String cedula = pedirTexto("Cédula: ");
        String nombre = pedirTexto("Nombre: ");
        int edad = pedirEdad();
        String telf = pedirTelefono();
        String correo = pedirCorreo();
        String depto = pedirTexto("Departamento: ");
        int horas = pedirEntero("Horas trabajadas: ");
        double valH = pedirDouble("Valor por hora: ");

        Administrativo a = new Administrativo(cedula, nombre, edad, telf, correo, depto, horas, valH);
        servicio.registrarEmpleado(a);
    }

    private static void buscarPorCedula() {
        System.out.print("Cédula a buscar: ");
        String c = sc.nextLine();
        Empleado e = servicio.buscarPorCedula(c);
        if (e != null) e.mostrarInformacion();
        else System.out.println("Registro no encontrado.");
    }

    private static void eliminarRegistro() {
        System.out.print("Cédula a eliminar: ");
        String c = sc.nextLine();
        if (servicio.eliminarEmpleado(c)) System.out.println("Eliminado correctamente.");
        else System.out.println("Cédula no encontrada.");
    }

    private static void reemplazarInformacion() {
        System.out.print("Cédula del empleado a reemplazar: ");
        String c = sc.nextLine();
        Empleado viejo = servicio.buscarPorCedula(c);
        if (viejo == null) {
            System.out.println("Registro no encontrado.");
            return;
        }
        System.out.println("Reemplazando datos de " + viejo.getNombre());
        if (viejo instanceof Medico) {
            String nom = pedirTexto("Nuevo Nombre: ");
            int ed = pedirEdad();
            String tel = pedirTelefono();
            String corr = pedirCorreo();
            String esp = pedirTexto("Nueva Especialidad: ");
            int pac = pedirEntero("Pacientes atendidos: ");
            double v = pedirDouble("Valor consulta: ");
            servicio.reemplazarEmpleado(c, new Medico(c, nom, ed, tel, corr, esp, pac, v));
        } else {
            String nom = pedirTexto("Nuevo Nombre: ");
            int ed = pedirEdad();
            String tel = pedirTelefono();
            String corr = pedirCorreo();
            String dep = pedirTexto("Nuevo Departamento: ");
            int hr = pedirEntero("Horas trabajadas: ");
            double vH = pedirDouble("Valor hora: ");
            servicio.reemplazarEmpleado(c, new Administrativo(c, nom, ed, tel, corr, dep, hr, vH));
        }
    }

    private static String pedirTexto(String msg) {
        String t;
        do {
            System.out.print(msg);
            t = sc.nextLine();
            if (Validador.esTextoVacio(t)) System.out.println("[Error] Campo obligatorio vacío.");
        } while (Validador.esTextoVacio(t));
        return t;
    }

    private static int pedirEdad() {
        while (true) {
            try {
                System.out.print("Edad: ");
                int ed = Integer.parseInt(sc.nextLine());
                if (Validador.validarEdad(ed)) return ed;
                System.out.println("[Error] Rango inválido (No se acepta abc, -1, 0, 150).");
            } catch (NumberFormatException e) {
                System.out.println("[Excepción] Entrada no numérica.");
            }
        }
    }

    private static String pedirTelefono() {
        String t;
        do {
            System.out.print("Teléfono: ");
            t = sc.nextLine();
            if (!Validador.validarTelefono(t)) System.out.println("[Error] Solo números.");
        } while (!Validador.validarTelefono(t));
        return t;
    }

    private static String pedirCorreo() {
        String c;
        do {
            System.out.print("Correo: ");
            c = sc.nextLine();
            if (!Validador.validarCorreo(c)) System.out.println("[Error] Debe contener '@'.");
        } while (!Validador.validarCorreo(c));
        return c;
    }

    private static int pedirEntero(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int val = Integer.parseInt(sc.nextLine());
                if (Validador.validarMayorCero(val)) return val;
                System.out.println("[Error] Debe ser mayor a cero.");
            } catch (NumberFormatException e) {
                System.out.println("[Excepción] Entrada inválida.");
            }
        }
    }

    private static double pedirDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                double val = Double.parseDouble(sc.nextLine());
                if (Validador.validarMayorCero(val)) return val;
                System.out.println("[Error] Debe ser mayor a cero.");
            } catch (NumberFormatException e) {
                System.out.println("[Excepción] Entrada inválida.");
            }
        }
    }
}
