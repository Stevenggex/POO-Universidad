package org.example.examenfx2bsgallo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField txtUser, txtPassword;
    @FXML private ComboBox<String> cmbRol;
    @FXML private Button btnRegistro;

    @FXML
    void btnRegistro(ActionEvent event){
        String username = txtUser.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Error", "Llena todos loc campos", Alert.AlertType.ERROR);
        }

        if (cmbRol.equals("Administrador") && equals("Empleado") && equals("Usuario")) {
            return;
        }

        Registro registro = PasswordEncoder.encriptar(username.getBytes());
    }

    public void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setContentText(mensaje);
        alerta.setTitle(titulo);
        alerta.setAlertType(tipo);
        alerta.showAndWait();
    }
}
