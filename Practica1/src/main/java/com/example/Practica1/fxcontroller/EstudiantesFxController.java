package com.example.Practica1.fxcontroller;

import com.example.Practica1.model.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class EstudiantesFxController {

    @FXML private TextField txtNombre, txtApellido, txtCarrera, txtEdad;
    @FXML private Button btnRegistrar, btnSalir;
    @FXML private TableView<Estudiante> tblEstudiantes;
    @FXML private TableColumn<Estudiante, Long> colId;
    @FXML private TableColumn<Estudiante, String> colNombre;
    @FXML private TableColumn<Estudiante, String> colApellido;
    @FXML private TableColumn<Estudiante, String> colCarrera;
    @FXML private TableColumn<Estudiante, Integer> colEdad;

    private ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCarrera.setCellValueFactory(new PropertyValueFactory<>("carrera"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        listarEstudiantes();

        tblEstudiantes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtNombre.setText(newSelection.getNombre());
                txtApellido.setText(newSelection.getApellido());
                txtCarrera.setText(newSelection.getCarrera());
                txtEdad.setText(String.valueOf(newSelection.getEdad()));
            }
        });
    }

    // === MÉTODO PARA LISTAR LOS ESTUDIANTES (GET) ===
    public void listarEstudiantes() {
        listaEstudiantes.clear();
        try {
            URL url = new URL("http://localhost:8080/api/estudiantes");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int code = con.getResponseCode();
            if (code == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String json = response.toString().trim();

                if (json.startsWith("[") && json.endsWith("]")) {
                    json = json.substring(1, json.length() - 1);
                }

                if (!json.isEmpty()) {
                    // Separación mejorada de los objetos JSON
                    String[] objetos = json.split("\\},\\s*\\{");
                    for (String obj : objetos) {
                        // Asegurar el formato correcto de llaves de cada registro aislado
                        if (!obj.startsWith("{")) obj = "{" + obj;
                        if (!obj.endsWith("}")) obj = obj + "}";

                        Long id = Long.parseLong(extraerValor(obj, "id"));
                        String nombre = extraerValor(obj, "nombre");
                        String apellido = extraerValor(obj, "apellido");
                        String carrera = extraerValor(obj, "carrera");
                        Integer edad = Integer.parseInt(extraerValor(obj, "edad"));

                        Estudiante est = new Estudiante(id, nombre, apellido, carrera, edad);
                        listaEstudiantes.add(est);
                    }
                }
                tblEstudiantes.setItems(listaEstudiantes);
            } else {
                mostrarAlerta("Error", "Error al obtener estudiantes del servidor.", Alert.AlertType.ERROR);
            }
            con.disconnect();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo conectar con el backend.", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    // === MÉTODO PARA REGISTRAR (POST) ===
    @FXML
    void onRegistrarAction(ActionEvent event){ // Cambié el nombre para evitar conflictos FXML
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String carrera = txtCarrera.getText().trim();
        String edad = txtEdad.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || carrera.isEmpty() || edad.isEmpty()) {
            mostrarAlerta("Error", "Llena todos los campos", Alert.AlertType.WARNING);
            return;
        }

        String jsonBody = String.format(
                "{\"nombre\":\"%s\", \"apellido\":\"%s\", \"carrera\":\"%s\", \"edad\":%s}",
                nombre, apellido, carrera, edad
        );

        try {
            URL url = new URL("http://localhost:8080/api/estudiantes");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                os.write(jsonBody.getBytes("utf-8"));
            }

            int resCode = con.getResponseCode();
            if (resCode == 200 || resCode == 201) {
                mostrarAlerta("Éxito", "Estudiante agregado correctamente.", Alert.AlertType.INFORMATION);
                limpiarCampos();
                listarEstudiantes(); // Recarga la tabla con el nuevo elemento
            } else {
                mostrarAlerta("Error", "Servidor respondió con código: " + resCode, Alert.AlertType.ERROR);
            }
            con.disconnect();
        } catch (Exception e) {
            mostrarAlerta("Error", "Error en la conexión al registrar.", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtCarrera.clear();
        txtEdad.clear();
    }

    // Auxiliar corregido para extraer valores de JSON plano con precisión
    private String extraerValor(String json, String llave) {
        String claveBuscada = "\"" + llave + "\":";
        int inicio = json.indexOf(claveBuscada);
        if (inicio == -1) return "";

        inicio += claveBuscada.length();

        // Si el valor empieza con comillas es un String
        if (json.substring(inicio).trim().startsWith("\"")) {
            inicio = json.indexOf("\"", inicio) + 1;
            int fin = json.indexOf("\"", inicio);
            return json.substring(inicio, fin).trim();
        } else {
            // Si es un número (como id o edad) leemos hasta la siguiente coma o cierre de llave
            int finComa = json.indexOf(",", inicio);
            int finLlave = json.indexOf("}", inicio);
            int fin = (finComa != -1 && finComa < finLlave) ? finComa : finLlave;
            return json.substring(inicio, fin).trim();
        }
    }

    public void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alerta = new Alert(tipo);
        alerta.setContentText(mensaje);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.showAndWait();
    }
}