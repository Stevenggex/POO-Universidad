public class DronCarga extends Dron {
    private double costoPorkg;

    public DronCarga() {
        super("DC-000", "CargaMax", 10.0, 5.0, 2.0, 6.0);
        this.costoPorkg = 1.20;
    }

    public DronCarga(String codigo, String modelo, double distanciakm, double pesoPaquete,
                     double horasVuelo, double costoBase, double costoPorkg) {
        super(codigo, modelo, distanciakm, pesoPaquete, horasVuelo, 6.0);
        this.costoPorkg = costoPorkg;
    }

    public double getCostoPorkg() {
        return costoPorkg;
    }

    public void setCostoPorkg(double costoPorkg) {
        if (costoPorkg > 0) {
            this.costoPorkg = costoPorkg;
        }
    }

    @Override
    public boolean validarDatos() {
        return (getPesoPaquete() <= 30.0 && getHorasVuelo() <= 5.0);
    }

    @Override
    public double calcularCostoEntrga() {
        return getCostoBase() + (getDistanciaKM() * 1.20) + (getPesoPaquete() * costoPorkg);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("====== DRON DE CARGA ======");
        super.mostrarInformacion();
        System.out.println("Costo por kg: $" + costoPorkg);
        System.out.println("Costo entrega: $" + String.format("%.2f", calcularCostoEntrga()));
    }
}