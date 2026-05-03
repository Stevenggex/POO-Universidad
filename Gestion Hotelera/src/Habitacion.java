public abstract class Habitacion {
    private String codigo;
    private String tipoHabitacion;
    private double tarifaBase;
    private int numeroNoches;
    private boolean disponible;
    private String nombre;

    public Habitacion(String codigo, String tipoHabitacion, double tarifaBase, int numeroNoches, String nombre){
        this.codigo = codigo;
        this.tipoHabitacion = tipoHabitacion;
        this.setTarifaBase(tarifaBase);
        this.numeroNoches = numeroNoches;
        this.disponible = true;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty()){
            System.out.println("Nombre no puede estar vacio.");
            return;
        }
        this.nombre = nombre;
    }

    public String getCodigo(){return codigo;}

    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isEmpty()){
            System.out.println("Error: El codigo no puede estar vacio.");
            return;
        }
        this.codigo = codigo;
    }

    public String getTipoHabitacion(){return tipoHabitacion;}

    public void setTipoHabitacion(String tipoHabitacion){
        if (tipoHabitacion.isEmpty()){
            System.out.println("El tipo de habitacion no puede estar vacio.");
            return;
        }
        this.tipoHabitacion = tipoHabitacion;
    }

    public double getTarifaBase() {return tarifaBase;}

    public void setTarifaBase(double tarifaBase) {
        if (tarifaBase <= 0){
            System.out.println("Error: Valor de tarifa invalido.");
            return;
        }
        this.tarifaBase = tarifaBase;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getNumeroNoches(){return numeroNoches;}

    public void setNumeroNoches(int numeroNoches){
        if (numeroNoches <= 0 ){
            System.out.println("Error: El numero de noches ingresado es invalido.");
            return;
        }
        this.numeroNoches = numeroNoches;
    }

    public boolean verificarDisponibilidad(){
        if (this.disponible) {
            System.out.println("La habitación está libre para reservar.");
            return true;
        } else {
            System.out.println("Lo sentimos, la habitación ya está ocupada.");
            return false;
        }
    }

    public double calcularServicioExtra(int opcion){
        switch (opcion) {
            case 1:
                System.out.println("Servicio: Lavandería");
                return 5.0;
            case 2:
                System.out.println("Servicio: Parqueadero");
                return 10.0;
            case 3:
                System.out.println("Servicio: Room Service");
                return 15.0;
            default:
                System.out.println("Sin servicios adicionales.");
                return 0.0;
        }
    }

    public double calcularPago(int noches) {
        return getTarifaBase() * noches;
    }

    public double calcularPago(int noches, double descuento) {
        double subtotal = getTarifaBase() * noches;
        return subtotal - (subtotal * descuento);
    }

    public abstract double calcularHospedaje();

    public abstract void mostrarDetalle();
}
