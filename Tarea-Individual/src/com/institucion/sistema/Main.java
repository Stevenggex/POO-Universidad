package com.institucion.sistema;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Persona> listaPersonas = new ArrayList<>();
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] academico) {
        int opcion = 0;

        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN ACADÉMICA ===");
            System.out.println("1. Registrar persona");
            System.out.println("2. Mostrar registros");
            System.out.println("3. Actualizar registro");
            System.out.println("4. Eliminar registro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1: registrarPersona(); break;
                case 2: mostrarRegistros(); break;
                case 3: actualizarRegistro(); break;
                case 4: eliminarRegistro(); break;
                case 5: System.out.println("Saliendo del sistema..."); break;
                default: System.out.println("Error: opción inválida. Intente nuevamente.");
            }
        } while (opcion != 33 && opcion != 5);
    }

    private static void registrarPersona() {
        System.out.println("\n--- Seleccione Tipo de Persona ---");
        System.out.println("1. Estudiante");
        System.out.println("2. Docente");
        System.out.print("Opción: ");
        int tipo = leerEntero();

        if (tipo != 1 && tipo != 2) {
            System.out.println("Error: opción inválida. Regresando al menú.");
            return;
        }

        String cedula = leerCadenaObligatoria("Ingrese cédula: ");

        if (buscarPersonaPorCedula(cedula) != null) {
            System.out.println("Error: Ya existe una persona registrada con esa cédula.");
            return;
        }

        String nombre = leerCadenaObligatoria("Ingrese nombre completo: ");
        System.out.print("Ingrese edad: ");
        int edad = leerEntero();

        if (tipo == 1) {
            String carrera = leerCadenaObligatoria("Ingrese carrera: ");
            listaPersonas.add(new Estudiante(cedula, nombre, edad, carrera));
        } else {
            String asignatura = leerCadenaObligatoria("Ingrese asignatura: ");
            listaPersonas.add(new Docente(cedula, nombre, edad, asignatura));
        }
        System.out.println("Registro agregado correctamente.");
    }

    private static void mostrarRegistros() {
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay registros almacenados.");
            return;
        }

        System.out.println("\n--- Lista de Personas Registradas ---");
        for (int i = 0; i < listaPersonas.size(); i++) {
            System.out.print("[" + i + "] ");
            listaPersonas.get(i).mostrarDatos();
        }

        contarPorTipo();
    }

    private static void actualizarRegistro() {
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay registros para actualizar.");
            return;
        }

        mostrarRegistros();
        System.out.print("\nIngrese el índice del registro a actualizar: ");
        int indice = leerEntero();

        if (indice < 0 || indice >= listaPersonas.size()) {
            System.out.println("Registro no encontrado.");
            return;
        }

        Persona p = listaPersonas.get(indice);
        System.out.println("Modificando los datos de: " + p.getNombreCompleto());

        String nuevoNombre = leerCadenaObligatoria("Nuevo nombre completo: ");
        System.out.print("Nueva edad: ");
        int nuevaEdad = leerEntero();

        p.setNombreCompleto(nuevoNombre);
        p.setEdad(nuevaEdad);

        if (p instanceof Estudiante) {
            String nuevaCarrera = leerCadenaObligatoria("Nueva carrera: ");
            ((Estudiante) p).setCarrera(nuevaCarrera);
        } else if (p instanceof Docente) {
            String nuevaAsignatura = leerCadenaObligatoria("Nueva asignatura: ");
            ((Docente) p).setAsignatura(nuevaAsignatura);
        }

        System.out.println("Registro actualizado correctamente.");
    }

    private static void eliminarRegistro() {
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay registros para eliminar.");
            return;
        }

        mostrarRegistros();
        System.out.print("\nIngrese el índice del registro a eliminar: ");
        int indice = leerEntero();

        if (indice < 0 || indice >= listaPersonas.size()) {
            System.out.println("Registro no encontrado."); // [cite: 36]
            return;
        }

        System.out.print("¿Está seguro que desea eliminar este registro? (S/N): ");
        String confirmacion = leer.nextLine().trim();

        if (confirmacion.equalsIgnoreCase("S")) {
            listaPersonas.remove(indice);
            System.out.println("Registro eliminado correctamente.");
        } else {
            System.out.println("Operación de eliminación cancelada.");
        }
    }

    private static int leerEntero() {
        while (true) {
            try {
                int valor = Integer.parseInt(leer.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar solo números.");
                System.out.print("Intente de nuevo: ");
            }
        }
    }

    private static String leerCadenaObligatoria(String mensajeEnConsola) {
        while (true) {
            System.out.print(mensajeEnConsola);
            String entrada = leer.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Campo obligatorio.");
            } else {
                return entrada;
            }
        }
    }

    private static Persona buscarPersonaPorCedula(String cedula) {
        for (Persona p : listaPersonas) {
            if (p.getCedula().equals(cedula)) {
                return p;
            }
        }
        return null;
    }

    private static void contarPorTipo() {
        int estudiantes = 0;
        int docentes = 0;
        for (Persona p : listaPersonas) {
            if (p instanceof Estudiante) estudiantes++;
            if (p instanceof Docente) docentes++;
        }
        System.out.println(">> Total en el sistema: [" + estudiantes + "] Estudiantes y [" + docentes + "] Docentes.");
    }
}
