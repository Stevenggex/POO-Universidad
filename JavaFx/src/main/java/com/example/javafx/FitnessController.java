package com.example.javafx;

import javafx.collections.ObservableList;

public class FitnessController {
    private FitnessView vista;

    public FitnessController(FitnessView vista) {
        this.vista = vista;
        inicializarEventos();
    }

    private void inicializarEventos() {
        // Evento para procesar el registro y el cálculo matemático
        vista.btnProcesar.setOnAction(e -> {
            String nombre = vista.txtNombre.getText().trim();
            String anioStr = vista.txtAnio.getText().trim();
            String pesoStr = vista.txtPeso.getText().trim();
            String estaturaStr = vista.txtEstatura.getText().trim();

            if (nombre.isEmpty() || anioStr.isEmpty() || pesoStr.isEmpty() || estaturaStr.isEmpty() || vista.cmbObjetivo.getValue() == null) {
                vista.lblResultadoEncuesta.setText("❌ Error: Faltan datos en el formulario.");
                vista.lblResultadoEncuesta.setStyle("-fx-text-fill: #ff2e63;");
                return;
            }

            // Uso obligatorio de try-catch para capturar excepciones numéricas
            try {
                int anio = Integer.parseInt(anioStr);
                double peso = Double.parseDouble(pesoStr);
                double estatura = Double.parseDouble(estaturaStr);

                if (estatura <= 0 || peso <= 0) {
                    vista.lblResultadoIMC.setText("❌ Valores numéricos inválidos.");
                    return;
                }

                // CREACIÓN DEL MODELO: Pasamos los datos puros a la clase Socio
                ObservableList<String> dias = vista.lstDias.getSelectionModel().getSelectedItems();
                String diasTexto = dias.isEmpty() ? "No definidos" : dias.toString();

                Socio socio = new Socio(nombre, anio, peso, estatura, vista.cmbObjetivo.getValue(), diasTexto);

                // Solicitamos los cálculos resueltos al Modelo
                int edad = socio.calcularEdad();
                double imc = socio.calcularIMC();
                String estado = socio.obtenerEstadoIMC();

                // Le enviamos las respuestas calculadas a las etiquetas de la Vista
                vista.lblResultadoEncuesta.setText("✅ Socio: " + socio.getNombre() + " (" + edad + " años)\n" +
                        "🎯 Objetivo: " + socio.getObjetivo() + "\n" +
                        "📅 Días: " + socio.getDiasEntreno());
                vista.lblResultadoEncuesta.setStyle("-fx-text-fill: #00adb5;");

                String imcFormateado = String.format("%.2f", imc);
                vista.lblResultadoIMC.setText("💪 IMC: " + imcFormateado + " | Estado: " + estado);
                vista.lblResultadoIMC.setStyle("-fx-text-fill: #00adb5; -fx-font-weight: bold;");

                // Alimentamos el ListView del Historial dinámicamente
                vista.lstHistorial.getItems().add(0, socio.getNombre() + " -> IMC: " + imcFormateado + " (" + estado + ")");

            } catch (NumberFormatException ex) {
                vista.lblResultadoEncuesta.setText("❌ Error: Ingrese números válidos.");
                vista.lblResultadoEncuesta.setStyle("-fx-text-fill: #ff2e63;");
            }
        });

        // Botón de Limpiar campos de la pantalla
        vista.btnLimpiar.setOnAction(e -> {
            vista.txtNombre.clear();
            vista.txtAnio.clear();
            vista.txtPeso.clear();
            vista.txtEstatura.clear();
            vista.cmbObjetivo.setValue(null);
            vista.lstDias.getSelectionModel().clearSelection();
            vista.lblResultadoEncuesta.setText("");
            vista.lblResultadoIMC.setText("IMC: -- | Estado: --");
            vista.lblResultadoIMC.setStyle("-fx-font-weight: bold; -fx-text-fill: #ff2e63;");
        });

        // Botón para vaciar el historial
        vista.btnBorrarHistorial.setOnAction(e -> vista.lstHistorial.getItems().clear());
    }
}
