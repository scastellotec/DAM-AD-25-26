import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mi_base_de_datos";
        String user = "root";
        String pass = "";

        try(Connection con = DriverManager.getConnection(url, user, pass)){

            // Construyo la sentencia SQL en base a lo que me da el usuario
            String nombreUsuario = "usuario1@ejemplo.com";
            // Ejemplos SQL inyection
            String passUsuario = "12345' OR '1'='1";

            String sqlQuery = "SELECT * FROM usuarios WHERE email ='"+nombreUsuario+"' and contrasena = '"+passUsuario+"' ";
            System.out.println("Estamos ejecutando esta sentencia: ");
            System.out.println(sqlQuery);

            // Ejecuto y recojo resultado
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);

            // Si hay resultado signfica que he acertado
            if(rs.next()){
                System.out.println("Tenemos match");
            }else{
                System.out.println("Usuario y/o contraseña incorrectos");
            }

            st.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}