import java.sql.*;

/**
 * TestDB
 */
public class TestDB {

    public static void main(String[] args) {
        String consulta = "insert into Clientes values (null, '56473465J', 'Juan', 'Heredia Molinos', 'lol.lol@gmail.com')";
        String connectionUrl = "jdbc:mysql://192.168.204.160:3306/clientes";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(connectionUrl, "phpmyadmin", "phpmyadmin")) {
            PreparedStatement ps = conn.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


//        try (Connection conn = DriverManager.getConnection(connectionUrl, "phpmyadmin", "phpmyadmin");
//             PreparedStatement ps = conn.prepareStatement(consulta);
//             ResultSet rs = ps.executeQuery()) {
//
//            while (rs.next()) {
//                int total = rs.getInt("total");
//                System.out.println("Total: " + total);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}