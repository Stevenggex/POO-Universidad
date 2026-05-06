public class Moto extends Vehiculo{
    private boolean cascoextra;

    public Moto(String placa, String marca, int diasAlquiler, String nombre, boolean cascoextra){
        super(placa, marca, diasAlquiler, nombre);
        this.cascoextra = cascoextra;
    }

    public boolean isCascoextra() {
        return cascoextra;
    }

    public void setCascoextra(boolean cascoextra) {
        this.cascoextra = cascoextra;
    }

    public double calcularRecargoCasco(){
        if (isCascoextra()){
            return 10;
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
        double recargo = calcularRecargoCasco();
        double iva = subtotal * 0.15;
        double total = subtotal + iva + recargo;

        System.out.println("\n-- Factura --");
        System.out.println("Vehiculo SeleccionadO: Moto");
        System.out.println("Nombre cliente: " + getNombre());
        System.out.println("Placa: " + getPlaca());
        System.out.println("Marca Vehiculo: " + getMarca());
        System.out.println("Tarifa por Dia: " + getTarifaDiaria() );
        System.out.println("Dias alquiler: " + getDiasAlquiler());
        System.out.println("Incluye casco extra: " + isCascoextra());
        System.out.println("---------------------------------------------");
        System.out.println("Recargo Casco extra: " + calcularRecargoCasco());
        System.out.println("Subtotal: " + subtotal);
        System.out.println("IVA (15%): " + iva);
        System.out.println("Total: " + total);
        System.out.println("---------------------------------------------\n");
    }
}
