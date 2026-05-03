public class HabitacionSimple extends Habitacion{
    private double costoServicioBasico;
    private boolean desayunoIncluido;

    public HabitacionSimple(String codigo, int numeroNoches, double costoServicioBasico, String nombre){
        super(codigo, "Habitacion Simple", 35.0, numeroNoches, nombre);
        this.costoServicioBasico = costoServicioBasico;
        this.desayunoIncluido = true;
    }

    public double getCostoServicioBasico() {
        return costoServicioBasico;
    }

    public void setCostoServicioBasico(double costoServicioBasico) {
        if (costoServicioBasico < 0){
            System.out.println("Error: El valor de costo de servicio basico es invalido.");
            return;
        }
        this.costoServicioBasico = costoServicioBasico;
    }

    public boolean isDesayunoIncluido() {
        return desayunoIncluido;
    }

    public void setDesayunoIncluido(boolean desayunoIncluido) {
        this.desayunoIncluido = desayunoIncluido;
    }

    @Override
    public double calcularHospedaje(){
        double subtotal = getTarifaBase() * getNumeroNoches();
        double descuento = 0;
        if (getNumeroNoches() > 5){
            descuento = subtotal * 0.10;
        }
        double valorDescuento = subtotal - descuento;
        double iva = valorDescuento * 0.15;
        return costoServicioBasico + valorDescuento + iva;
    }

    @Override
    public void mostrarDetalle(){
        double subtotal = getTarifaBase() * getNumeroNoches();
        double descuento = (getNumeroNoches() > 5) ? (subtotal * 0.10) : 0;
        double valorConDescuento = subtotal - descuento;
        double iva = valorConDescuento * 0.15;
        double total = valorConDescuento + iva + costoServicioBasico;

        System.out.println("\n========== FACTURA FINAL ==========");
        System.out.println("Huesped: " + getNombre());
        System.out.println("Tipo: " + getTipoHabitacion());
        System.out.println("Código: " + getCodigo());
        System.out.println("Tarifa por noche: $" + getTarifaBase());
        System.out.println("Número de noches: " + getNumeroNoches());
        System.out.println("-----------------------------------");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento (10%): -$" + descuento);
        System.out.println("IVA (15%): +$" + iva);
        System.out.println("Servicios Adicionales: +$" + costoServicioBasico);
        System.out.println("-----------------------------------");
        System.out.println("TOTAL A PAGAR: $" + total);
        System.out.println("Desayuno incluido: " + (desayunoIncluido ? "SÍ" : "NO"));
        System.out.println("===================================\n");
    }
}
