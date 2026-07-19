package com.example.Practica1.fxcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button; // <-- ¡Agregado que faltaba!
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.OutputStream;
import java.net.HttpURLConnection; // <-- Usamos HTTP para localhost
import java.net.URL;

public class LoginFxController {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Button btnIngresar;

    @FXML
    void btnIngresar(ActionEvent event){
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Error", "No pueden estar estos campos vacíos", Alert.AlertType.WARNING);
            return; // <-- Súper importante para detener la ejecución aquí
        }

        // 2. Armar el JSON idéntico al de Postman
        String jsonBody = String.format("{\"username\":\"%s\", \"password\":\"%s\"}", username, password);

        // Para que se pueda conectar y enviar peticiones Json
        try {
            URL url = new URL("http://localhost:8080/api/usuarios/Login");
            // CORREGIDO: Cambiado HttpsURLConnection por HttpURLConnection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json"); // CORREGIDO: cambiado guion por barra "/"
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()){
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = con.getResponseCode();
            if (code == 200) {
                mostrarAlerta("Éxito", "Login exitoso", Alert.AlertType.INFORMATION);
                cambiarPantalla(event, "/view/Estudiantes.fxml");
            } else {
                mostrarAlerta("Error", "Credenciales Incorrectas", Alert.AlertType.ERROR);
            }
            con.disconnect();
        } catch (Exception e) {
            mostrarAlerta("Error", "Error en la conexión. ¿Está encendido Spring Boot?", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public void cambiarPantalla(ActionEvent event, String fxmlPath){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de Estudiantes");
            stage.show();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo cargar la ventana de Estudiantes", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    public void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
