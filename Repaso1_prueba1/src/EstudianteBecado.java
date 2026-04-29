class EstudianteBecado extends Estudiante {
    private int porcentajeBeca;

    public EstudianteBecado(String codigo, String nombre, double promedio, double valorMatricula, int porcentajeBeca) {
        super(codigo, nombre, promedio, valorMatricula);
        this.porcentajeBeca = porcentajeBeca;
    }

    @Override
    public double calcularPagoFinal() {
        double descuento = getValorMatricula() * (porcentajeBeca / 100.0);
        return getValorMatricula() - descuento;
    }
}


class BecadoExcelencia extends EstudianteBecado {
    private double bonoExcelencia;

    public BecadoExcelencia(String codigo, String nombre, double promedio, double valorMatricula, int porcentajeBeca, double bono) {
        super(codigo, nombre, promedio, valorMatricula, porcentajeBeca);
        this.bonoExcelencia = bono;
    }

    @Override
    public double calcularPagoFinal() {
        double pagoBase = super.calcularPagoFinal();
        double resultado = pagoBase - bonoExcelencia;
        return Math.max(resultado, 0);
    }
}
