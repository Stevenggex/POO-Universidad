public class Gerente extends Empleado implements Bonificable{
    public Gerente(String nombre, double sueldo) {
        super(nombre, sueldo);
    }

    @Override
    public double calcularBono(){
        return sueldo * 0.15;
    }

    @Override
    public double calcularPago(){
        return sueldo + calcularBono();
    }

    @Override
    public void mostrarInfo() {
        System.out.println("--- PAGOS GERENTE ---");
        System.out.println("Bono: " + calcularBono());
        System.out.println("Pago: " + calcularPago());
    }
}
