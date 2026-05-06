public class Auto extends Vehiculo{
    private boolean tieneGPS;

    public Auto(String placa, String marca, int diasAlquiler, String nombre, boolean tieneGPS){
        super(placa, marca, diasAlquiler, nombre);
        this.tieneGPS = tieneGPS;
    }

    public boolean isTieneGPS() {
        return tieneGPS;
    }

    public void setTieneGPS(boolean tieneGPS) {
        this.tieneGPS = tieneGPS;
    }

    public double calcularRecargoGPS() {
        if (isTieneGPS()) {
            return getDiasAlquiler() * 5.0;
        } else {
            System.out.println("No tiene GPS.");
            return 0.0;
        }
    }

    @Override
    public double calcularAlquiler(){
        return getTarifaDiaria() * getDiasAlquiler();
    }

    @Override
    public void mostrarDetalle(){
        double subtotal = calcularAlquiler();
        double recargo = calcularRecargoGPS();
        double iva = subtotal * 0.15;
        double total = subtotal + iva + recargo;

        System.out.println("\n-- Factura --");
        System.out.println("Vehiculo SeleccionadO: Auto");
        System.out.println("Nombre cliente: " + getNombre());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Marca Vehiculo: " + getMarca());
        System.out.println("Tarifa por Dia: " + getTarifaDiaria() );
        System.out.println("Dias alquiler: " + getDiasAlquiler());
        System.out.println("Tiene GPs: " + isTieneGPS());
        System.out.println("---------------------------------------------");
        System.out.println("Recargo GPS: " + calcularRecargoGPS());
        System.out.println("Subtotal: " + subtotal);
        System.out.println("IVA (15%): " + iva);
        System.out.println("Total: " + total);
        System.out.println("---------------------------------------------\n");
    }
}
