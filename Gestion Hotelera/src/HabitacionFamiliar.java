public class HabitacionFamiliar extends Habitacion {
    private int capacidadPersonas;
    private double descuentoFamiliar;

    public HabitacionFamiliar(String codigo, int numeroNoches, int capacidadPersonas, String nombre) {
        super(codigo, "Habitación Familiar", 60.0, numeroNoches, nombre);
        this.setCapacidadPersonas(capacidadPersonas);
        this.descuentoFamiliar = 0.0;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        if (capacidadPersonas <= 0 || capacidadPersonas > 6) {
            System.out.println("Error: Capacidad no permitida (Máximo 6 personas).");
            this.capacidadPersonas = 1; // Valor por defecto seguro
            return;
        }
        this.capacidadPersonas = capacidadPersonas;
    }

    public double getDescuentoFamiliar() {
        return descuentoFamiliar;
    }

    public void setDescuentoFamiliar(double descuentoFamiliar) {
        this.descuentoFamiliar = descuentoFamiliar;
    }

    @Override
    public double calcularHospedaje() {
        double subtotal = getTarifaBase() * getNumeroNoches();
        double descuento = (getNumeroNoches() > 5) ? (subtotal * 0.10) : 0;
        double valorConDescuento = subtotal - descuento - descuentoFamiliar;
        double iva = valorConDescuento * 0.15;
        return valorConDescuento + iva;
    }

    @Override
    public void mostrarDetalle() {
        double subtotal = getTarifaBase() * getNumeroNoches();
        double descuento = (getNumeroNoches() > 5) ? (subtotal * 0.10) : 0;
        double valorConDescuento = subtotal - descuento - descuentoFamiliar;
        double iva = valorConDescuento * 0.15;
        double total = valorConDescuento + iva;

        System.out.println("\n========== FACTURA FINAL ==========");
        System.out.println("Huesped: " + getNombre());
        System.out.println("Tipo: " + getTipoHabitacion());
        System.out.println("Código: " + getCodigo());
        System.out.println("Capacidad: " + capacidadPersonas + " personas");
        System.out.println("Tarifa por noche: $" + getTarifaBase());
        System.out.println("Número de noches: " + getNumeroNoches());
        System.out.println("-----------------------------------");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento (10%): -$" + descuento);
        if (descuentoFamiliar > 0) System.out.println("Desc. Familiar: -$" + descuentoFamiliar);
        System.out.println("IVA (15%): +$" + iva);
        System.out.println("-----------------------------------");
        System.out.println("TOTAL A PAGAR: $" + total);
        System.out.println("===================================\n");
    }
}
