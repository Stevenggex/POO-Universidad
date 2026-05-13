package Practica2;

public class Pato extends Animal implements Volar, Nadador{
    public Pato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String comer() {
        return "Plantas acuáticas, insectos, peces pequeños, gusanos, semillas ";
    }

    @Override
    public String sonido() {
        return "Graznido";
    }

    @Override
    public String nadar() {
        return "Nadan a una velocidad promedio de 2 a 3 millas por hora";
    }

    @Override
    public String volador() {
        return "8 horas";
    }

    @Override
    public void info() {
        System.out.println("\n--- INFORMACION ANIMAL PATO---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " +  edad);
        System.out.println("Sonido: " + sonido());
        System.out.println("Comida: " + comer());
        System.out.println("Vuelo: " + volador());
        System.out.println("Nado: " + nadar());
    }


}
