public class DronLiviano extends Dron{
    private double limiteHoras;

    public DronLiviano() {
        super("DL-000", "ModeloBase", 5.0, 2.0, 1.0, 3.0);
        this.limiteHoras = 2.0;
    }

    public DronLiviano(String codigo, String marca, double distanciaKM, double pesoPaquete,
                       double horasVuelo, double costoBase){
        super(codigo, marca, distanciaKM, pesoPaquete, horasVuelo, 3.0);
        this.limiteHoras = 2.0;
    }

    public double getLimiteHoras() {
        return limiteHoras;
    }

    @Override
    public boolean validarDatos(){
        if (getHorasVuelo() <= 2 && getPesoPaquete() <= 5){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double calcularCostoEntrga(){
        return getCostoBase() + (getDistanciaKM() * 0.80) + (getPesoPaquete() * 0.50);
    }

    @Override
    public void mostrarInformacion(){
        System.out.println("--- Dron Liviano ---");
        super.mostrarInformacion();
        System.out.println("Limite de peso: 5 kg");
        System.out.println("Costo Base: " + getCostoBase());
        System.out.println("Costo de entrega: " + calcularCostoEntrga());

        if (!validarDatos()){
            System.out.println("Estado: Entrga no permitida (Exece los limites).");
        } else {
            System.out.println("Estado: Entrga Aprobada.");
        }
    }
}
