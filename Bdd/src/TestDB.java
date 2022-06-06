import java.sql.*;

/**
 * TestDB
 */
public class TestDB {

    public static void main(String[] args) {
//        String consulta = "insert into Cliente values (null, 'Yoan', 'Eredia Molins', 'uwu.uwu@gmail.com', '56473465T')";
//        String connectionUrl = "jdbc:mysql://192.168.204.139:3306/clientes";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
//        try (Connection conn = DriverManager.getConnection(connectionUrl, "phpmyadmin", "phpmyadmin")) {
//            PreparedStatement ps = conn.prepareStatement(consulta);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        String consulta = "select * from Cliente";
        String connectionUrl = "jdbc:mysql://192.168.204.139:3306/clientes";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "phpmyadmin", "phpmyadmin");
             PreparedStatement ps = conn.prepareStatement(consulta);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getString(3) +" "+ rs.getString(4) +" "+ rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
