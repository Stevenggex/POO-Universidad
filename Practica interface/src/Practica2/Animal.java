package Practica2;

public abstract class Animal {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract String comer();

    public abstract String sonido();

    public abstract void info();
}
