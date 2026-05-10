public class DronEmergencia extends Dron {
    private double recargoUrgencia;
    private int nivelPrioridad;

    public DronEmergencia() {
        super("DE-000", "Emergente", 8.0, 3.0, 1.5, 8.0);
        this.recargoUrgencia = 10.0;
        this.nivelPrioridad = 1;
    }

    public DronEmergencia(String codigo, String modelo, double distanciakm, double pesoPaquete,
                          double horasVuelo, double costoBase, double recargoUrgencia, int nivelPrioridad) {
        super(codigo, modelo, distanciakm, pesoPaquete, horasVuelo, 8.0);
        this.recargoUrgencia = recargoUrgencia;
        this.nivelPrioridad = nivelPrioridad;
    }

    public double getRecargoUrgencia() {
        return recargoUrgencia;
    }

    public void setRecargoUrgencia(double recargoUrgencia) {
        if (recargoUrgencia >= 0) {
            this.recargoUrgencia = recargoUrgencia;
        }
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        if (nivelPrioridad >= 1 && nivelPrioridad <= 3) {
            this.nivelPrioridad = nivelPrioridad;
        }
    }

    @Override
    public boolean validarDatos() {
        return (getPesoPaquete() <= 10.0 && getHorasVuelo() <= 3.0 && nivelPrioridad >= 1 && nivelPrioridad <= 3);
    }

    @Override
    public double calcularCostoEntrga() {
        return getCostoBase() + (getDistanciaKM() * 1.50) + (getPesoPaquete() * 0.90) + recargoUrgencia;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("====== DRON EMERGENCIA ======");
        super.mostrarInformacion();
        System.out.println("Prioridad: " + nivelPrioridad);
        System.out.println("Recargo: $" + recargoUrgencia);
        System.out.println("Costo entrega: $" + String.format("%.2f", calcularCostoEntrga()));
    }
}
