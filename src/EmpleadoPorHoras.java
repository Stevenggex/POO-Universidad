public class EmpleadoPorHoras extends Empleado {
    private double pagoHora;
    public EmpleadoPorHoras(String nombre, int horasTrabajadas, double pagoHora){
        super(nombre, horasTrabajadas);
        this.pagoHora = pagoHora;
    }

    public double calcularSalario(){
       return pagoHora * getHorasTRabajadas();
    }

    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Salario: " + calcularSalario());
    }
}
