package principal;

import modelo.Estudiante;

public class mainEstudiante {
    public static void main(String[] args){
        Estudiante e = new Estudiante();
        e.setNombre("Ana");
        System.out.println("El nombre del estudiante es: " + e.getNombre());
    }
}
