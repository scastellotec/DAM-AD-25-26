import java.sql.*;


public class Main {
    public static void main(String[] args) {
        // Establezco conexion con la BBDD
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/accesodatos", "root", "");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        // Realizo las operacinoes necesarias: En este caso una consulta
        String sentenciaSql = "SELECT id, nombre, calorias, valor_nutricional FROM alimentos WHERE calorias > ?";
        PreparedStatement sentencia = null;
        ResultSet resultado = null;

        try {
            sentencia = conexion.prepareStatement(sentenciaSql);
            sentencia.setInt(1, 100);

            resultado = sentencia.executeQuery();
            while (resultado.next()) {
                System.out.println("id: " + resultado.getInt(1));
                System.out.println("nombre: " + resultado.getString(2));
                System.out.println("calorias: " + resultado.getInt(3));
                System.out.println("valor_nutricional: " + resultado.getString(4));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            if (sentencia != null)
                try {
                    sentencia.close();
                    resultado.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
        }


        // Cierro la conexion
        try {
            conexion.close();
            conexion = null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}