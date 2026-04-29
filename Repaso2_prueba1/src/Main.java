import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa tu codigo: ");
        String cod = sc.nextLine();

        System.out.println("Ingresa tu nombre: ");
        String nom = sc.nextLine();

        System.out.println("Ingresa tu edad: ");
        int year = sc.nextInt();

        System.out.println("Ingrese sus horas de clase: ");
        int horascl = sc.nextInt();

        System.out.println("Ingrese su valor x hora: ");
        double valorxhora = sc.nextDouble();

        System.out.println("Ingrese la cantidad de publicaciones: ");
        int pub = sc.nextInt();

        PersonaAcademica p1 = new DocenteInvestigador(cod, nom, year, horascl, valorxhora, pub);

        p1.mostrar();
        p1.describirRol();

        System.out.println("Pago final: " + p1.calcularPago());

        double pagoConBono = ((DocenteInvestigador) p1).calcularPago(50);
        System.out.println("Pago con bono extra: " + pagoConBono);

    }
}