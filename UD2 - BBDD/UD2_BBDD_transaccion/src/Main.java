import java.sql.*;


public class Main {
    public static void main(String[] args) {

        // Conectarme a la BBDD
        String url = "jdbc:mysql://localhost:3306/banco";
        String user = "root";
        String pass = "";

        try(Connection con = DriverManager.getConnection(url, user, pass)){
            try {
                // Iniciar una transaccion
                con.setAutoCommit(false);

                int idOrigen = 3;
                int idDestino = 135;
                int dinero = 1000;

                // Primero comprobar que tiene suficiente dinero y la cuenta existe
                String sqlQuery = "SELECT saldo FROM cuenta WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(sqlQuery);
                ps.setInt(1, idOrigen);

                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    int saldoOrigen = rs.getInt("saldo");
                    System.out.println("El cliente origen tiene saldo: "+saldoOrigen);
                    if(saldoOrigen < dinero)
                        throw new SQLException("saldo insuficiente");
                }else{
                    throw new SQLException("cuenta origen inexistente");
                }

                // Quitar dinero de una cuenta
                sqlQuery = "UPDATE cuenta SET saldo = saldo - 1000 WHERE id = 3";
                Statement st = con.createStatement();
                int filasAfectadas = st.executeUpdate(sqlQuery);
                System.out.println("Se ha ejecutado un UPDATE que afecto a : " + filasAfectadas + " filas");

                // Comprobar cuenta destino existe
                sqlQuery = "SELECT saldo FROM cuenta WHERE id = ?";
                ps = con.prepareStatement(sqlQuery);
                ps.setInt(1, idDestino);
                rs = ps.executeQuery();
                if(!rs.next())
                    throw new SQLException("cuenta destino inexistente");


                // Poner dinero en otra cuenta
                sqlQuery = "UPDATE cuenta SET saldo = saldo + 1000 WHERE id = 5";
                st = con.createStatement();
                filasAfectadas = st.executeUpdate(sqlQuery);
                System.out.println("Se ha ejecutado un UPDATE que afecto a : " + filasAfectadas + " filas");

                // Registrar el movimiento
                sqlQuery = "INSERT INTO registro_transferencia (id_origen, id_destino, cantidad, fecha) VALUES (3,5,1000, now())";
                st = con.createStatement();
                filasAfectadas = st.executeUpdate(sqlQuery);
                System.out.println("Se ha ejecutado un INSERT que afecto a : " + filasAfectadas + " filas");

                // Commiteo los cambios
                con.commit();

            } catch (SQLException e) {
                System.out.println("Ha habido un error: "+e.getMessage());
                // Ha habido un error deshago los cambios
                con.rollback();
                System.out.println("Hacemos un rollback");
            } finally {
                // Dejarlo como estaba
                con.setAutoCommit(true);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




        // Si everything va bien commit
        // Si algo va mal rollback

        // Volver a dejar autocommit true
        // Cerrar conexino y liberar recursos
    }
}