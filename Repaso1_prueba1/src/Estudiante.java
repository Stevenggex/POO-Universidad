public class Estudiante {
    private String codigo;
    private String nombre;
    private double promedio;
    private double valorMatricula;

    
    public Estudiante(String codigo, String nombre, double promedio, double valorMatricula) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.promedio = promedio;
        this.valorMatricula = valorMatricula;
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty()) { System.out.println("Nombre no válido"); return; }
        this.nombre = nombre;
    }

    public void setPromedio(double promedio) {
        if (promedio < 0 || promedio > 10) { System.out.println("Promedio inválido"); return; }
        this.promedio = promedio;
    }

    public boolean validarPromedio() {
        return this.promedio >= 0 && this.promedio <= 10;
    }

    public double calcularPagoFinal() {
        return valorMatricula;
    }

    public double calcularPagoFinal(double descuentoExtra) {
        return calcularPagoFinal() - descuentoExtra;
    }

    public void mostrarDatos() {
        System.out.println("Código: " + codigo + " | Nombre: " + nombre + " | Promedio: " + promedio);
    }

    public double getValorMatricula() { return valorMatricula; }
}
