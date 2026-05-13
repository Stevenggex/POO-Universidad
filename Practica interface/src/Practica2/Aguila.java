package Practica2;

public class Aguila extends Animal implements Volar {
    public Aguila(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void info() {
        System.out.println("\n--- INFORMACION ANIMAL AGUILA---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " +  edad);
        System.out.println("Sonido: " + sonido());
        System.out.println("Comida: " + comer());
        System.out.println("Vuelo: " + volador());
    }

    @Override
    public String sonido() {
        return "Chillido";
    }

    @Override
    public String volador() {
        return "Vuela de 4-5 horas.";
    }

    @Override
    public String comer() {
        return "Mamíferos pequeños y medianos, peces, aves y reptiles";
    }
}
