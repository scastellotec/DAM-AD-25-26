import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Datos de conexión de la base de datos
        String url = "jdbc:mysql://localhost:3306/accesodatos";
        String usuraio = "root";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(url, usuraio, password);
            System.out.println("Conectados con la base de datos");
            con.close();

        } catch (SQLException e) {
            System.out.println("Error en la conexion: " + e.getMessage());
            System.out.println("Código de error: " + e.getErrorCode());
            System.out.println("Estado SQL: " + e.getSQLState());
        }

    }
}