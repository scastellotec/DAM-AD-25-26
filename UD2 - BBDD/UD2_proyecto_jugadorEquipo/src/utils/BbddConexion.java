package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BbddConexion {

    private static final String URL = "jdbc:mysql://localhost:3306/liga";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private BbddConexion() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

