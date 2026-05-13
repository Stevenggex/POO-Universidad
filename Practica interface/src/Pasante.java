public class Pasante extends Empleado{
    public Pasante(String nombre, double sueldo) {
        super(nombre, sueldo);
    }

    @Override
    public double calcularPago(){
        return sueldo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\n--- PAGOS PASANTE---");
        System.out.println("Bono: 0");
        System.out.println("Pago: " + sueldo);
    }
}
