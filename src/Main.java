public class Main {
    static public void main(String[] args){
        EmpleadoPorHoras e1 = new EmpleadoPorHoras("Steven Gallo", 35, 5);
        e1.mostrar();
        System.out.println("----------------------\n");
        System.out.println("Cambio de horas con set:");
        e1.setHorasTRabajadas(45);
        e1.mostrar();
    }
}

