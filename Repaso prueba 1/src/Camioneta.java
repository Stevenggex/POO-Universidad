public class Camioneta extends Vehiculo{
    private double capacidadCarga;

    public Camioneta(String placa, String marca, int diasAlquiler, String nombre, double capacidadCarga){
        super(placa, marca, diasAlquiler, nombre);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        if (capacidadCarga <= 0){
            System.out.println("Error: parametro invalido.");
            return;
        }
        this.capacidadCarga = capacidadCarga;
    }

    public double calcularRecargoCapacidad(){
        if (getCapacidadCarga() >= 1000){
            return 0.15;
        } else {
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
        double recargo = calcularRecargoCapacidad();
        double iva = subtotal * 0.15;
        double total = subtotal + iva + recargo;

        System.out.println("\n-- Factura --");
        System.out.println("Vehiculo SeleccionadO: Camioneta");
        System.out.println("Nombre cliente: " + getNombre());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Marca Vehiculo: " + getMarca());
        System.out.println("Tarifa por Dia: " + getTarifaDiaria() );
        System.out.println("Dias alquiler: " + getDiasAlquiler());
        System.out.println("Capacidad de carga: " + getCapacidadCarga());
        System.out.println("---------------------------------------------");
        System.out.println("Recargo Capacidad Carga: " + calcularRecargoCapacidad());
        System.out.println("Subtotal: " + subtotal);
        System.out.println("IVA (15%): " + iva);
        System.out.println("Total: " + total);
        System.out.println("---------------------------------------------\n");
    }
}
