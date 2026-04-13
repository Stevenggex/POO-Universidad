package modelo;

public class Cuenta {
    private double saldo;

    public void setSaldo(double saldo){
        if (saldo >= 0){
            this.saldo = saldo;
        } else {
            System.out.println("Error: saldo invalido");
        }
    }

}
