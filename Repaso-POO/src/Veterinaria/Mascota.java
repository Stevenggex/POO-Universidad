package Veterinaria;

import java.util.Objects;

public class Mascota {
    private String codigo;
    private String tipo_animal;
    private int edad;
    private String nombre;

    public Mascota(String codigo, String tipo_animal, int edad, String nombre) {
        setCodigo(codigo);
        setTipo_animal(tipo_animal);
        setEdad(edad);
        setNombre(nombre);
    }

    public String getCodigo() {
        return codigo;
    }
    public String getTipo_animal() {
        return tipo_animal;
    }
    public int getEdad() {
        return edad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("Codigo no puede estar vacio.");
        }
        this.codigo = codigo;
    }

    public void setTipo_animal(String tipo_animal) {
        if (tipo_animal == null ||
                (!tipo_animal.equalsIgnoreCase("Perro") &&
                        !tipo_animal.equalsIgnoreCase("Gato") &&
                        !tipo_animal.equalsIgnoreCase("Conejo") &&
                        !tipo_animal.equalsIgnoreCase("Otro"))) {
            throw new IllegalArgumentException("Tipo de animal inválido. Solo se permite: Perro, Gato, Conejo u Otro.");
        }
        this.tipo_animal = tipo_animal;
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 20){
            throw new IllegalArgumentException("Edad ingresada no es valida.");
        }
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Nombre no puede estar vacio.");
        }
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object cod_animal){
        if (this == cod_animal) return true;
        if (cod_animal == null || getClass() != cod_animal.getClass()) return false;
        Mascota mascota = (Mascota) cod_animal;
        return Objects.equals(codigo, mascota.codigo);
    }

    @Override
    public int hashCode(){
        return Objects.hash(codigo);
    }

    @Override
    public String toString(){
        return "Mascota [Codigo =" + codigo + "- Nombre = " + nombre + "- Tipo = " + tipo_animal + "- Edad = " + edad + "]";
    }
}
