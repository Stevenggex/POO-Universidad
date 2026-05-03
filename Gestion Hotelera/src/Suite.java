public class Suite extends Habitacion{
    private double servicioPremium;
    private boolean jacuzzi;

    public Suite(String codigo, int numeroNoches, double servicioPremium, String nombre){
        super(codigo, "Suite", 80.0, numeroNoches, nombre);
        this.servicioPremium = servicioPremium;
        this.jacuzzi = true;
    }

    public double getServicioPremium() {
        return servicioPremium;
    }

    public void setServicioPremium(double servicioPremium) {
        if (servicioPremium < 0 ) {
            System.out.println("Error: Valor ingresado para servicio Premium es invalido.");
            return;
        }
        this.servicioPremium = servicioPremium;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
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
        return servicioPremium + valorDescuento + iva;
    }

    @Override
    public void mostrarDetalle(){
        double subtotal = getTarifaBase() * getNumeroNoches();
        double descuento = (getNumeroNoches() > 5) ? (subtotal * 0.10) : 0;
        double valorConDescuento = subtotal - descuento;
        double iva = valorConDescuento * 0.15;
        double total = valorConDescuento + iva + servicioPremium;

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
        System.out.println("Servicios Adicionales: +$" + servicioPremium);
        System.out.println("-----------------------------------");
        System.out.println("TOTAL A PAGAR: $" + total);
        System.out.println("Jacuzzi incluido: " + (jacuzzi ? "SÍ" : "NO"));
        System.out.println("===================================\n");
    }
}
