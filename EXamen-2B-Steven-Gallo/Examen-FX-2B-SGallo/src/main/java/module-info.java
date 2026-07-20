module org.example.examenfx2bsgallo {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.security.crypto;
    requires java.sql;


    opens org.example.examenfx2bsgallo to javafx.fxml;
    exports org.example.examenfx2bsgallo;
}