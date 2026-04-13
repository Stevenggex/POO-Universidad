package modelo;

public class Tienda {
    private String nombre;
    private int stock;
    private double precio;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setStock(int stock){
        if (stock >= 0 && stock <= 100){
            this.stock = stock;
        } else {
            System.out.println("Error: el stock debe ser un numero 0 o mayor");
        }
    }

    public void setPrecio(double precio){
        if (precio >= 0){
            this.precio = precio;
        } else {
            System.out.println("Error: el precio debe ser mayor a 0");
        }
    }

    public String getNombre(){
        return nombre;
    }

    public int getStock(){
        return stock;
    }

    public double getPrecio(){
        return precio;
    }

    public double calcularTotal(){
        return precio * stock;
    }
}
