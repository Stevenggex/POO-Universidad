package principal;

import modelo.Tienda;

public class mainTienda {
    public static void main(String[] args){
        Tienda t = new Tienda();

        t.setNombre("Laptop HP");
        System.out.println("Nombre: " + t.getNombre());

        t.setPrecio(900);
        System.out.println("Precio: " + t.getPrecio());

        t.setStock(5);
        System.out.println("Stock: " + t.getStock());

        System.out.println("Total: " + t.calcularTotal());
    }
}
