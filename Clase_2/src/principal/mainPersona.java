package principal;

import modelo.Persona;

public class mainPersona {
    public static void main(String[] args){
        Persona p = new Persona();
        p.setNombre("Ana");
        System.out.println(p.getNombre());
    }
}
