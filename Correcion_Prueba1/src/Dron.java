public abstract class Dron {
    private String codigo;
    private String marca;
    private double distanciaKM;
    private double pesoPaquete;
    private double horasVuelo;
    protected double costoBase;

    public Dron(){}

    public Dron(String codigo, String marca, double distanciaKM, double pesoPaquete,
                double horasVuelo, double costoBase){
        this.codigo = codigo;
        this.marca = marca;
        this.distanciaKM = distanciaKM;
        this.costoBase = costoBase;
        this.horasVuelo = horasVuelo;
        this.pesoPaquete = pesoPaquete;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo.isEmpty()){
            System.out.println("Error: El nombre no puede estar vacio.");
            return;
        }
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca.isEmpty()){
            System.out.println("Error: La marca no puede estar vacia.");
            return;
        }
        this.marca = marca;
    }

    public double getDistanciaKM() {
        return distanciaKM;
    }

    public void setDistanciaKM(double distanciaKM) {
        if (distanciaKM < 0){
            System.out.println("Error: Distancia ingresada invalida.");
            return;
        }
        this.distanciaKM = distanciaKM;
    }

    public double getPesoPaquete() {
        return pesoPaquete;
    }

    public void setPesoPaquete(double pesoPaquete) {
        if (pesoPaquete < 0){
            System.out.println("Error: Peso del paquete ingresado invalido.");
            return;
        }
        this.pesoPaquete = pesoPaquete;
    }

    public double getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(double horasVuelo) {
        if (horasVuelo < 0){
            System.out.println("Error: Horas de vuelo ingresadas son invalidos.");
            return;
        }
        this.horasVuelo = horasVuelo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public abstract double calcularCostoEntrga();

    public abstract boolean validarDatos();

    public void mostrarInformacion(){
        System.out.println("Codigo: " + getCodigo());
        System.out.println("Marca: " + getMarca());
        System.out.println("Distancia (km): " +  getDistanciaKM());
        System.out.println("Peso paquete (km): " + getPesoPaquete());
        System.out.println("Horas de vuelo: " + getHorasVuelo());
    }
}
