import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // Conecto con la BBDD
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tienda", "root", "");

            // Preparo la consulta SQL que quiero ejecutar
            Statement st = con.createStatement();

            // La ejceuto y recojo el resultado
            ResultSet rs = st.executeQuery("SELECT id, nombre, precio, descripcion FROM producto");

            // Itero sobre todos los resultados recibidos
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String descripcion = rs.getString("descripcion");
                System.out.println("id: "+id+"; nombre: "+nombre+"; precio: "+precio+"; descripcion: "+descripcion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}