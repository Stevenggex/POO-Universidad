package com.example.javafx;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FitnessView extends VBox {

    // Componentes de la interfaz expuestos para el controlador
    public TextField txtNombre, txtAnio, txtPeso, txtEstatura;
    public ComboBox<String> cmbObjetivo;
    public ListView<String> lstDias, lstHistorial;
    public Label lblResultadoEncuesta, lblResultadoIMC;
    public Button btnProcesar, btnLimpiar, btnBorrarHistorial;

    public FitnessView() {
        // Configuración del contenedor principal (Vista)
        this.setPadding(new Insets(20));
        this.setStyle("-fx-background-color: #222831;");
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);

        // Título de la App
        Label lblTituloApp = new Label("🏋️ SYSTEM CONTROL FITNESS & IMC");
        lblTituloApp.setStyle("-fx-font-family: 'Arial'; -fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");

        // --- COLUMNA IZQUIERDA: REGISTRO ---
        Label lblTituloEncuesta = new Label("📝 REGISTRO DE SOCIO");
        lblTituloEncuesta.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #00adb5;");

        txtNombre = new TextField(); txtNombre.setPromptText("Ej: Steven Gallo");
        txtAnio = new TextField(); txtAnio.setPromptText("Ej: 2005");

        cmbObjetivo = new ComboBox<>(FXCollections.observableArrayList("Ganar Masa Muscular", "Perder Grasa", "Mejorar Resistencia"));
        cmbObjetivo.setPromptText("-- Seleccione --"); cmbObjetivo.setMaxWidth(Double.MAX_VALUE);

        lstDias = new ListView<>(FXCollections.observableArrayList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"));
        lstDias.setPrefHeight(85); lstDias.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        lblResultadoEncuesta = new Label(); lblResultadoEncuesta.setWrapText(true);
        lblResultadoEncuesta.setStyle("-fx-text-fill: #eeeeee; -fx-font-size: 11px;");

        VBox panelIzquierdo = new VBox(10, lblTituloEncuesta, crearEtiqueta("Nombre completo:"), txtNombre, crearEtiqueta("Año de nacimiento:"), txtAnio, crearEtiqueta("Objetivo Fitness:"), cmbObjetivo, crearEtiqueta("Días de entreno (Ctrl+Click):"), lstDias, lblResultadoEncuesta);
        panelIzquierdo.setPadding(new Insets(15)); panelIzquierdo.setPrefWidth(340);
        panelIzquierdo.setStyle("-fx-background-color: #393e46; -fx-background-radius: 8; -fx-border-color: #4f5b66; -fx-border-radius: 8;");

        // --- COLUMNA DERECHA: BIOMETRÍA ---
        Label lblTituloCalc = new Label("📊 EVALUACIÓN BIOMÉTRICA");
        lblTituloCalc.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #00adb5;");

        txtPeso = new TextField(); txtPeso.setPromptText("Peso en kg");
        txtEstatura = new TextField(); txtEstatura.setPromptText("Estatura en metros");

        lblResultadoIMC = new Label("IMC: -- | Estado: --");
        lblResultadoIMC.setStyle("-fx-font-weight: bold; -fx-text-fill: #ff2e63; -fx-font-size: 13px;");

        lstHistorial = new ListView<>(); lstHistorial.setPrefHeight(120);

        VBox panelDerecho = new VBox(10, lblTituloCalc, crearEtiqueta("Peso actual (kg):"), txtPeso, crearEtiqueta("Estatura actual (m):"), txtEstatura, lblResultadoIMC, crearEtiqueta("Historial de Evaluaciones:"), lstHistorial);
        panelDerecho.setPadding(new Insets(15)); panelDerecho.setPrefWidth(340);
        panelDerecho.setStyle("-fx-background-color: #393e46; -fx-background-radius: 8; -fx-border-color: #4f5b66; -fx-border-radius: 8;");

        // Contenedor de las dos columnas
        HBox columnasContenedor = new HBox(20, panelIzquierdo, panelDerecho);
        columnasContenedor.setAlignment(Pos.CENTER);

        // --- PANEL INFERIOR: BOTONES ---
        btnProcesar = new Button("🚀 Procesar Datos");
        btnLimpiar = new Button("🧹 Limpiar Campos");
        btnBorrarHistorial = new Button("🗑️ Borrar Historial");

        HBox panelBotones = new HBox(15, btnProcesar, btnLimpiar, btnBorrarHistorial);
        panelBotones.setAlignment(Pos.CENTER); panelBotones.setPadding(new Insets(15, 0, 0, 0));

        // Unir todo dentro del contenedor de la vista
        this.getChildren().addAll(lblTituloApp, columnasContenedor, panelBotones);
    }

    private Label crearEtiqueta(String texto) {
        Label lbl = new Label(texto);
        lbl.setStyle("-fx-text-fill: #eeeeee; -fx-font-weight: 500; -fx-font-size: 11px;");
        return lbl;
    }
}
