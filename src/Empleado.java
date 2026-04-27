public abstract class Empleado {
    private String nombre;
    private int horasTRabajadas;

    public Empleado(String nombre, int horasTRabajadas){
        this.nombre = nombre;
        this.horasTRabajadas = horasTRabajadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasTRabajadas(){
        return horasTRabajadas;
    }

    public void setHorasTRabajadas(int horasTRabajadas) {
        this.horasTRabajadas = horasTRabajadas;
    }


    public void mostrar(){
        System.out.println("Empleado: " + getNombre());
        System.out.println("Horas: " + getHorasTRabajadas());
    }
}
