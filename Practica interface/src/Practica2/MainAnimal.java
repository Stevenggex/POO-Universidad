package Practica2;

public class MainAnimal {
    public static void main(String[] args){
        Leon l1 = new Leon("Alex", 12);
        l1.info();

        Pinguino p1 = new Pinguino("Oliver", 12);
        p1.info();

        Aguila a1 = new Aguila("Juan", 5);
        a1.info();

        Pato pato1 = new Pato("Lucas", 5);
        pato1.info();
    }
}
