package Sistema_Smart_Coffe;

import Veterinaria.Mascota;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cafeteria implements CrudPedido{
    private String nombreCafeteria;
    private Set<Cliente> listaClientes;
    private Map<String, Double> mapaPedidos;

    public Cafeteria(String nombreCafeteria) {
        this.nombreCafeteria = nombreCafeteria;
        this.listaClientes = new HashSet<>();
        this.mapaPedidos = new HashMap<>();
    }

    public Cliente buscaPorCorreo(String coreo){
        for (Cliente c: listaClientes){
            if (c.getCorreo().equals(coreo)){
                System.out.println("Cliente encontrado: " + c.getNombre());
                return c;
            }
        }
        return null;
    }

    public void registrarCliente(Cliente c){
        if (c == null) return;
        boolean agregado = listaClientes.add(c);
        if (!agregado){
            System.out.println("Error: El clinete que intenta ingresar ya existe.");
        } else {
            System.out.println("Cliente registrado exitosamente: " + c.getNombre());
        }
    }

    public Set<Cliente> getListaClientes(){
        return listaClientes;
    }

    public Map<String, Double> getMapaPedidos(){
        return mapaPedidos;
    }

    @Override
    public void registrarPedido(String correo, double consumo) {
        Cliente cliente = buscaPorCorreo(correo);
        if (cliente == null){
            System.out.println("Error: No se puede registrar el pedido. El cliente con correo: " + correo + " no existe.");
            return;
        }

        if (consumo <= 0){
            System.out.println("Error: El consumo debe ser mayor a 0.");
            return;
        }

        mapaPedidos.put(correo, consumo);
        System.out.println("Pedido registrado exitosamente para el cliente: " + cliente.getNombre());
    }

    @Override
    public void actualizarPedido(String correo, double nuevoConsumo) {
        if (!mapaPedidos.containsKey(correo)) {
            throw new IllegalArgumentException("Error: No se encontro ningun pedido registrado para el correo: " + correo);
        }

        if (nuevoConsumo <= 0) {
            throw new IllegalArgumentException("Error: El consumo debe ser mayor a 0.");
        }

        mapaPedidos.put(correo, nuevoConsumo);
        System.out.println("Pedido actualizado con exito.");
    }

    @Override
    public void eliminarPedido(String correo) {
        if (!mapaPedidos.containsKey(correo)){
            throw new IllegalArgumentException("Error: No se puede eliminar el pedio porque no existe.");
        }

        mapaPedidos.remove(correo);
        System.out.println("Pedido eliminado exitosamente.");
    }

    @Override
    public void promedioConsumo() {
        if (mapaPedidos.isEmpty()){
            System.out.println("No hay datos disponibles.");
            return;
        }

        double suma = 0;
        for (double consumo : mapaPedidos.values()){
            suma += consumo;
        }
        double promedio = suma/mapaPedidos.size();
        System.out.printf("El promedio general del consumo es: $%.2f\n", promedio);
    }

    @Override
    public void mejorCliente() {
        if (mapaPedidos.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }
        String correoMax = "";
        double consumoMax = 0.0;

        for (Map.Entry<String, Double> elemento : mapaPedidos.entrySet()){
            if (elemento.getValue() > consumoMax){
                consumoMax = elemento.getValue();
                correoMax = elemento.getKey();
            }
        }

        Cliente c = buscaPorCorreo(correoMax);
        if (c != null){
            System.out.println("El mejor cliente es: " + c.getNombre() + " (Correo: " + correoMax + ") con un consumo de: $" + consumoMax);
        } else {
            System.out.println("El mejor cliente (correo: " + correoMax + ") tiene un consumo de: $" + consumoMax);
        }
    }

    public void mostrarPedidos(){
        if (mapaPedidos.isEmpty()) {
            System.out.println("No se ha registrado ningún pedido en el sistema todavía.");
            return; // Se sale del método
        }

        // Recorremos el mapa usando entrySet() para obtener la clave (correo) y el valor (consumo)
        for (Map.Entry<String, Double> registro : mapaPedidos.entrySet()) {
            String correoCliente = registro.getKey();
            double consumo = registro.getValue();

            // Buscamos al cliente por correo para obtener su nombre real
            Cliente c = buscaPorCorreo(correoCliente);
            String nombreCliente = (c != null) ? c.getNombre() : "Cliente no encontrado en la lista";

            System.out.println("Cliente: " + nombreCliente + " | Correo: " + correoCliente + " | Consumo: $" + consumo);
        }

    }

    public void mostrarClientes(){
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados en la cafetería actualmente.");
            return; // Se sale del método
        }

        // Si tiene datos, recorremos el Set e imprimimos cada cliente
        for (Cliente c : listaClientes) {
            System.out.println(c); // Llama automáticamente al toString() de tu clase Cliente
        }
    }
}
