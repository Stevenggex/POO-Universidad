package com.example.javafx;

public class Socio {
    private String nombre;
    private int anioNacimiento;
    private double peso;
    private double estatura;
    private String objetivo;
    private String diasEntreno;

    public Socio(String nombre, int anioNacimiento, double peso, double estatura, String objetivo, String diasEntreno) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.peso = peso;
        this.estatura = estatura;
        this.objetivo = objetivo;
        this.diasEntreno = diasEntreno;
    }

    public int calcularEdad() {
        return 2026 - this.anioNacimiento;
    }

    public double calcularIMC() {
        return this.peso / Math.pow(this.estatura, 2);
    }

    public String obtenerEstadoIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) return "Bajo peso";
        if (imc < 25) return "Normal";
        if (imc < 30) return "Sobrepeso";
        return "Obesidad";
    }

    public String getNombre() { return nombre; }
    public String getObjetivo() { return objetivo; }
    public String getDiasEntreno() { return diasEntreno; }
}
