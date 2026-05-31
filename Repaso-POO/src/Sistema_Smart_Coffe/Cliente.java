package Sistema_Smart_Coffe;

import java.util.Objects;

public class Cliente extends Persona{
    private String codigoCliente;
    private String tipoMembresia;

    public Cliente(String nombre, String correo, int edad, String codigoCliente, String tipoMembresia) {
        super(nombre, correo, edad);
        setCodigoCliente(codigoCliente);
        setTipoMembresia(tipoMembresia);
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setCodigoCliente(String codigoCliente) {
        if (codigoCliente == null || codigoCliente.trim().isEmpty()){
            throw new IllegalArgumentException("Error: Codigo no puede estar vacio.");
        }
        this.codigoCliente = codigoCliente;
    }

    public void setTipoMembresia(String tipoMembresia) {
        if (tipoMembresia == null || tipoMembresia.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El tipo de membresía no puede estar vacío.");
        }

        if (!tipoMembresia.equalsIgnoreCase("Gold") &&
        !tipoMembresia.equalsIgnoreCase("Silver") &&
        !tipoMembresia.equalsIgnoreCase("Premium")) {
            throw new IllegalArgumentException("Error: Memebresia seleccionada invalida");
        }
        this.tipoMembresia = tipoMembresia;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente client = (Cliente) obj;
        return Objects.equals(this.codigoCliente, client.codigoCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoCliente);
    }

    @Override
    public String toString(){
        return "Cliente [Código: " + codigoCliente + " - Membresía: " + tipoMembresia + " - " + super.toString() + "]";
    }
}
