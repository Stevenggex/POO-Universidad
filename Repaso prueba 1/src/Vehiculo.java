public abstract class Vehiculo {
    private String placa;
    private String nombre;
    private String marca;
    private final double tarifaDiaria;
    private int diasAlquiler;

    public Vehiculo(String placa, String marca, int diasAlquiler, String nombre){
        this.placa = placa;
        this.nombre = nombre;
        this.marca = marca;
        this.tarifaDiaria = 19.2;
        this.diasAlquiler = diasAlquiler;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa.isEmpty()){
            System.out.println("Plca no puede estar vacia.");
            return;
        }
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty()){
            System.out.println("Error: Nombre no puede estar vacio.");
            return;
        }
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca.isEmpty()){
            System.out.println("La marca no debe estar vacia.");
            return;
        }
        this.marca = marca;
    }

    public double getTarifaDiaria() {
        return tarifaDiaria;
    }


    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        if (diasAlquiler <= 0){
            System.out.println("Error: Los dias de alquiler deben ser mayores a 0.");
            return;
        }
        this.diasAlquiler = diasAlquiler;
    }

    public abstract double calcularAlquiler();

    public abstract void mostrarDetalle();

}
