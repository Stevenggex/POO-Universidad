public class Docente extends PersonaAcademica{
    private int horaClase;
    private double valorHora;

    public Docente(String codigo, String nombre, int edad, int horaClase, double valorHora){
        super(codigo, nombre, edad);
        this.horaClase = horaClase;
        this.valorHora = valorHora;
    }


    public void setHoraClase(int horaClase) {
        if (horaClase < 1 || horaClase > 40){
            System.out.println("Horas de clases invalidas.");
            return;
        }
        this.horaClase = horaClase;
    }


    public void setValorHora(double valorHora) {
        if (valorHora < 0){
            System.out.println("Valor invalido.");
            return;
        }
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPago(){
        return horaClase * valorHora;
    }

    @Override
    public void describirRol(){
        System.out.println("Soy Docente.");
    }
}

class DocenteInvestigador extends Docente{
    private int publicaciones;

    public DocenteInvestigador(String codigo, String nombre, int edad, int horaClase, double valorHora, int publicaciones){
        super(codigo, nombre, edad, horaClase, valorHora);
        this.publicaciones = publicaciones;
    }

    @Override
    public double calcularPago(){
        double bono = publicaciones * 20;
        return super.calcularPago() + bono;
    }

    public double calcularPago(double bonoExtra){
        return calcularPago() + bonoExtra;
    }

    @Override
    public void describirRol(){
        System.out.println("Soy Docente Invetigador.");
    }
}
