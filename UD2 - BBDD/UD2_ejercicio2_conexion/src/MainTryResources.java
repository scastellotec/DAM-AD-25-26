import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainTryResources {
    public static void main(String[] args) {

        // Datos de conexión de la base de datos
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuraio = "root";
        String password = "";

        try(Connection con = DriverManager.getConnection(url, usuraio, password)) {
            System.out.println("Conectados con la base de datos");

            // Preparo la sentencia que quiero ejecutar
            String sqlQuery = "SELECT * FROM producto WHERE id = 1000";
            Statement st = con.createStatement();

            // Ejecuto la setencia SQl y recojo el resultado
            ResultSet rs = st.executeQuery(sqlQuery);

            // Recorrer el resultado SQL

            while(rs.next()){
                // Se puede recoger por orden de columna
                int id = rs.getInt(1);

                // Tamibén se puede recoger por nombre de columna
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String descripcion = rs.getString("descripcion");

                System.out.println("id: "+id+"; nombre: "+nombre+"; precio: "+precio+"; descripcion: "+descripcion );
            }



        } catch (SQLException e) {
            System.out.println("Error en la conexion: " + e.getMessage());
            System.out.println("Código de error: " + e.getErrorCode());
            System.out.println("Estado SQL: " + e.getSQLState());
        }

    }
}