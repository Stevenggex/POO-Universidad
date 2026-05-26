package servicio;

import modelo.*;
import java.util.ArrayList;

public class EmpleadoServicio {
    private ArrayList<Empleado> listaEmpleados; // Polimorfismo Obligatorio

    public EmpleadoServicio() {
        this.listaEmpleados = new ArrayList<>();
    }

    public boolean registrarEmpleado(Empleado emp) {
        if (buscarPorCedula(emp.getCedula()) != null) {
            System.out.println("[ERROR] Código de bloqueo: La cédula ya está duplicada en el sistema.");
            return false;
        }
        listaEmpleados.add(emp);
        return true;
    }

    public void mostrarTodosLosEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No se registran empleados actualmente.");
            return;
        }
        for (Empleado emp : listaEmpleados) {
            System.out.println("=================================");
            emp.mostrarInformacion();
        }
    }

    public Empleado buscarPorCedula(String cedula) {
        for (Empleado emp : listaEmpleados) {
            if (emp.getCedula().equals(cedula)) {
                return emp;
            }
        }
        return null;
    }

    public boolean reemplazarEmpleado(String cedula, Empleado nuevoEmp) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i).getCedula().equals(cedula)) {
                listaEmpleados.set(i, nuevoEmp);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEmpleado(String cedula) {
        Empleado emp = buscarPorCedula(cedula);
        if (emp != null) {
            listaEmpleados.remove(emp);
            return true;
        }
        return false;
    }

    public void mostrarEstadisticas() {
        int medicos = 0, admins = 0;
        double pagosMedicos = 0, pagosAdmins = 0;
        Empleado masIngresos = null;

        for (Empleado emp : listaEmpleados) {
            double pago = emp.calcularPago();
            if (masIngresos == null || pago > masIngresos.calcularPago()) {
                masIngresos = emp;
            }
            if (emp instanceof Medico) {
                medicos++;
                pagosMedicos += pago;
            } else if (emp instanceof Administrativo) {
                admins++;
                pagosAdmins += pago;
            }
        }

        System.out.println("\n========= ESTADÍSTICAS OBLIGATORIAS =========");
        System.out.println("Total médicos: " + medicos);
        System.out.println("Total administrativos: " + admins);
        System.out.println("Total empleados: " + listaEmpleados.size());
        System.out.println("Pago total médicos: $" + pagosMedicos);
        System.out.println("Pago total administrativos: $" + pagosAdmins);
        if (masIngresos != null) {
            System.out.println("Empleado con mayor ingreso: " + masIngresos.getNombre() + " ($" + masIngresos.calcularPago() + ")");
        } else {
            System.out.println("Empleado con mayor ingreso: N/A");
        }
    }
}
