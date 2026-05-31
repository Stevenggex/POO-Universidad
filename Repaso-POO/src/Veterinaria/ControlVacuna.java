package Veterinaria;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ControlVacuna implements CrudVacuna{
    private Set<Mascota> listaMascotas;
    private Map<String, String> registroVacunas;

    public ControlVacuna() {
        this.listaMascotas = new HashSet<>();
        this.registroVacunas = new HashMap<>();
    }

    public Mascota buscarPorCodigo(String codigo) {
        for (Mascota m : listaMascotas) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void registrarMascota(Mascota mascota) {
        boolean agregado = listaMascotas.add(mascota);

        if (!agregado) {
            System.out.println("Error: No se pudo registrar. Ya existe una mascota con el código: " + mascota.getCodigo());
        } else {
            System.out.println("Mascota registrada con éxito: " + mascota.getNombre());
        }
    }

    @Override
    public void registrarVacuna(String codigoMascota, String nombreVacuna) {
        Mascota mascota = buscarPorCodigo(codigoMascota);

        if (mascota == null) {
            System.out.println("Error: No se puede registrar la vacuna. La mascota con código " + codigoMascota + " no existe.");
            return;
        }

        // Si existe, se agrega al HashMap (Clave: código, Valor: nombre de la vacuna)
        registroVacunas.put(codigoMascota, nombreVacuna);
        System.out.println("Vacuna '" + nombreVacuna + "' registrada con éxito para " + mascota.getNombre());
    }

    @Override
    public void actualizarVacuna(String codigoMascota, String nuevaVacuna) {
        if (!registroVacunas.containsKey(codigoMascota)) {
            System.out.println("Error: No se puede actualizar. No hay vacunas registradas para el código " + codigoMascota);
            return;
        }

        // .put() reemplaza el valor anterior si la clave ya existe
        registroVacunas.put(codigoMascota, nuevaVacuna);
        System.out.println("Vacuna actualizada con éxito al código " + codigoMascota);
    }

    @Override
    public void eliminarVacuna(String codigoMascota) {
        // Validación obligatoria: No eliminar vacuna inexistente
        if (!registroVacunas.containsKey(codigoMascota)) {
            System.out.println("Error: No se puede eliminar. No hay vacunas registradas para el código " + codigoMascota);
            return;
        }

        registroVacunas.remove(codigoMascota);
        System.out.println("Registro de vacuna eliminado con éxito para el código " + codigoMascota);
    }

    @Override
    public void mostrarVacunas() {
        if (registroVacunas.isEmpty()) {
            System.out.println("No hay datos disponibles.");
            return;
        }

        System.out.println("\n=======================================================");
        System.out.printf("%-10s | %-15s | %-20s\n", "CÓDIGO", "MASCOTA", "VACUNA REGISTRADA");
        System.out.println("=======================================================");

        for (String cod : registroVacunas.keySet()) {
            Mascota m = buscarPorCodigo(cod);
            String vacuna = registroVacunas.get(cod);

            if (m != null) {
                System.out.printf("%-10s | %-15s | %-20s\n",
                        cod, m.getNombre(), vacuna);
            }
        }
        System.out.println("=======================================================");
    }

    public void mostrarMascotas() {
        if (listaMascotas.isEmpty()) {
            System.out.println("No hay mascotas registradas en el sistema actualmente.");
            return;
        }
        System.out.println("\n=======================================================");
        System.out.printf("%-10s | %-15s | %-12s | %-5s\n", "CÓDIGO", "NOMBRE", "TIPO", "EDAD");
        System.out.println("=======================================================");
        for (Mascota m : listaMascotas) {
            System.out.printf("%-10s | %-15s | %-12s | %-5d\n",
                    m.getCodigo(), m.getNombre(), m.getTipo_animal(), m.getEdad());
        }
        System.out.println("=======================================================");
    }
}
