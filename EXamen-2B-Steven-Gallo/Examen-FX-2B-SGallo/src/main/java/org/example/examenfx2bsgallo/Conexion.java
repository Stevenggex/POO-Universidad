package org.example.examenfx2bsgallo;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost/3306/sistemaclientes";
    private static final String user = "root";
    private static final String password = "root";

    public class Connection getConexion() throws SQLException{
        Connection con = DriverManager.getConnection(url,user,password);
    }

}
