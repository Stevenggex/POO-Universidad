package Practica2;

public class Pinguino extends Animal{
    public Pinguino(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void info() {
        System.out.println("\n--- INFORMACION ANIMAL PINGUINO---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " +  edad);
        System.out.println("Sonido: " + sonido());
        System.out.println("Comida: " + comer());
    }

    @Override
    public String sonido() {
        return "Graznido ";
    }

    @Override
    public String comer() {
        return "Peces, calamares y crustáceos";
    }
}
