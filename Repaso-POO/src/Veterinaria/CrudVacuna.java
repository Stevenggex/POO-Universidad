package Veterinaria;

public interface CrudVacuna {
    void registrarMascota(Mascota mascota);

    void registrarVacuna(String codigoMascota, String nombreVacuna);

    void actualizarVacuna(String codigoMascota, String nuevaVacuna);

    void eliminarVacuna(String codigoMascota);

    void mostrarVacunas();
}
