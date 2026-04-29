class EstudianteRegular extends Estudiante {
    private int numMaterias;

    public EstudianteRegular(String codigo, String nombre, double promedio, double valorMatricula, int numMaterias) {
        super(codigo, nombre, promedio, valorMatricula);
        this.numMaterias = numMaterias;
    }

    @Override
    public double calcularPagoFinal() {
        return getValorMatricula() + (numMaterias * 10);
    }
}

class RegularConRecargo extends EstudianteRegular {
    private double recargoPendiente;

    public RegularConRecargo(String codigo, String nombre, double promedio, double valorMatricula, int numMaterias, double recargo) {
        super(codigo, nombre, promedio, valorMatricula, numMaterias);
        this.recargoPendiente = recargo;
    }

    @Override
    public double calcularPagoFinal() {
        return super.calcularPagoFinal() + recargoPendiente;
    }
}
