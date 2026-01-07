import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MainTryResourcesNoResults {
    public static void main(String[] args) {

        // Datos de conexión de la base de datos
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuraio = "root";
        String password = "";

        try(Connection con = DriverManager.getConnection(url, usuraio, password)) {
            System.out.println("Conectados con la base de datos");

            /** SELECT **/
            // Preparo la sentencia que quiero ejecutar
            Statement st = con.createStatement();

            // Ejecuto la setencia SQl y recojo el resultado
            String sqlQuery = "SELECT * FROM producto";
            ResultSet rs = st.executeQuery(sqlQuery);

            // Recorrer el resultado SQL
            // Primero compruebo que tengo resultados
            if(rs.next()){
                do {
                    // Se puede recoger por orden de columna
                    int id = rs.getInt(1);

                    // Tamibén se puede recoger por nombre de columna
                    String nombre = rs.getString("nombre");
                    double precio = rs.getDouble("precio");
                    String descripcion = rs.getString("descripcion");

                    System.out.println("id: "+id+"; nombre: "+nombre+"; precio: "+precio+"; descripcion: "+descripcion );
                }while(rs.next());
            }else{
                System.out.println("Tu consulta no ha devuelto resultados");
            }
            // Libero recursos de la consulta
            st.close();


            /** INSERT **/
            // Preparo la consulta
            st = con.createStatement();
            sqlQuery = "INSERT INTO producto (nombre, precio, descripcion) VALUES ('Kinder sorpresa', 1.60,'Tiene sorpresa dentro')";

            // Ejecuto y recojo numero filas afectas
            int filasAfectadas = st.executeUpdate(sqlQuery);

            System.out.println("Fila insertadas: "+filasAfectadas);

            /** UPDATE **/
            // Preparo la consulta
            st = con.createStatement();
            sqlQuery = "UPDATE producto SET precio = 2.60 WHERE id = 41 ";

            // Ejecuto y recojo numero filas afectas
            filasAfectadas = st.executeUpdate(sqlQuery);

            System.out.println("Fila actualizadas: "+filasAfectadas);

            /** DELETE **/
            // Preparo la consulta
            st = con.createStatement();
            sqlQuery = "DELETE FROM producto WHERE nombre = 'Kinder sorpresa'";

            // Ejecuto y recojo numero filas afectas
            filasAfectadas = st.executeUpdate(sqlQuery);

            System.out.println("Fila borradas: "+filasAfectadas);

        } catch (SQLException e) {
            System.out.println("Error en la conexion: " + e.getMessage());
            System.out.println("Código de error: " + e.getErrorCode());
            System.out.println("Estado SQL: " + e.getSQLState());
        }

    }
}