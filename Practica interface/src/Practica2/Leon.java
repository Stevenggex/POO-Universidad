package Practica2;

public class Leon extends Animal{
    public Leon(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String sonido() {
        return "Rugido";
    }

    @Override
    public String comer() {
        return "Carne";
    }

    @Override
    public void info() {
        System.out.println("--- INFORMACION ANIMAL LEON---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " +  edad);
        System.out.println("Sonido: " + sonido());
        System.out.println("Comida: " + comer());
    }
}
