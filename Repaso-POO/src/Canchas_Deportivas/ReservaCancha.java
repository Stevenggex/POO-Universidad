package Canchas_Deportivas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReservaCancha implements CrudReserva {
    private Set<Cliente> setClientes;
    private Map<String, Integer> mapaReservas;

    public ReservaCancha() {
        this.setClientes = new HashSet<>();
        this.mapaReservas = new HashMap<>();
    }

    public Cliente buscarPorCedula(String cedula) {
        for (Cliente c : setClientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public void registrarCliente(Cliente c) {
        // add() retorna false si ya existe un objeto con el mismo hashCode/equals
        boolean agregado = setClientes.add(c);
        if (!agregado) {
            System.out.println("Error: ya existe un cliente con esa cédula.");
        } else {
            System.out.println("Cliente registrado: " + c.getNombre());
        }
    }

    @Override
    public void registrarReserva(String cedula, int horas) {
        if (buscarPorCedula(cedula) == null) {
            System.out.println("Error: cliente inexistente.");
            return;
        }
        if (horas < 1 || horas > 5) {
            System.out.println("Error: las horas deben estar entre 1 y 5.");
            return;
        }
        mapaReservas.put(cedula, horas);
        System.out.println("Reserva registrada.");
    }

    @Override
    public void actualizarReserva(String cedula, int nuevasHoras) {
        if (!mapaReservas.containsKey(cedula)) {
            System.out.println("Reserva no encontrada.");
            return;
        }
        if (nuevasHoras < 1 || nuevasHoras > 5) {
            System.out.println("Error: las horas deben estar entre 1 y 5.");
            return;
        }
        mapaReservas.put(cedula, nuevasHoras);
        System.out.println("Reserva actualizada.");
    }

    @Override
    public void eliminarReserva(String cedula) {
        if (!mapaReservas.containsKey(cedula)) {
            System.out.println("Reserva no encontrada.");
            return;
        }
        mapaReservas.remove(cedula);
        System.out.println("Reserva eliminada.");
    }

    @Override
    public int calcularTotalHoras() {
        int total = 0;
        for (int horas : mapaReservas.values()) {
            total += horas;
        }
        return total;
    }

    @Override
    public String clienteMayorReserva() {
        if (mapaReservas.isEmpty()) {
            return "No hay datos disponibles.";
        }

        String cedulaMax = null;
        int max = 0;

        for (Map.Entry<String, Integer> e : mapaReservas.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                cedulaMax = e.getKey();
            }
        }

        Cliente c = buscarPorCedula(cedulaMax);
        return c != null ? c.getNombre() + " → " + max + " horas" : "Sin datos.";
    }

    public void mostrarClientes() {
        if (setClientes.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }
        System.out.println("\n--- LISTA DE CLIENTES ---");
        for (Cliente c : setClientes) {
            System.out.println(c);
        }
    }

    public void mostrarReservas() {
        if (mapaReservas.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }
        System.out.println("\n--- RESERVAS ACTUALES ---");
        for (Map.Entry<String, Integer> entry : mapaReservas.entrySet()) {
            Cliente c = buscarPorCedula(entry.getKey());
            String nombreCliente = (c != null) ? c.getNombre() : "Desconocido";
            System.out.println("Cédula: " + entry.getKey() + " (" + nombreCliente + ") - Horas: " + entry.getValue());
        }
    }
}
