package Practica1;
import java.util.Scanner;


public class Main {
     static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa tu edad: ");
        int ed = sc.nextInt();

        Persona p1 = new Persona(ed);
        p1.mostrar();
    }
}
