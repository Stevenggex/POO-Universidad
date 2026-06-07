package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class MiApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EPN Fitness System - MVC Architecture");

        // 1. Instanciamos la Vista (Crea el cascarón visual)
        FitnessView vista = new FitnessView();

        // 2. Instanciamos el Controlador y le pasamos la vista para que la maneje
        FitnessController controlador = new FitnessController(vista);

        // 3. Montamos la escena pasándole el nodo raíz de la vista
        Scene scene = new Scene(vista, 740, 520);

        // Cargar los estilos de BootstrapFX
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        vista.btnProcesar.getStyleClass().setAll("btn", "btn-info");
        vista.btnLimpiar.getStyleClass().setAll("btn", "btn-default");
        vista.btnBorrarHistorial.getStyleClass().setAll("btn", "btn-danger");

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}