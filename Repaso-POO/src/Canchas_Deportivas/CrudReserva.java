package Canchas_Deportivas;

public interface CrudReserva {
    void registrarReserva(String cedula, int horas);
    void actualizarReserva(String cedula, int nuevasHoras);
    void eliminarReserva(String cedula);
    int calcularTotalHoras();
    String clienteMayorReserva();
}
