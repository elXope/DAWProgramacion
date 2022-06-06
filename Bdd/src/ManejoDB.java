import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class ManejoDB {
    public static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        String next = "";
        int indexM;
        while(true) {
            imprimirMenu();
            next = lector.nextLine().strip();
            if (next.equals("0")){
                break;
            } else {
                seleccionMenu(next);
            }
        }
    }

    public static void imprimirMenu() {
        System.out.println(
                "***Menu***\n" +
                        "0:\tSalir\n" +
                        "1:\tInsertar filas\n" +
                        "2:\tVer datos\n" +
                        "3:\tBuscar dato"
        );
    }

    private static void seleccionMenu(String next) {
        switch (next) {
            case("1"):
                insertaFila();
                break;
            case("2"):
                verFilas();
                break;
            case("3"):
                System.out.println("La il·lusio de tot un poble industrial i llaurador");
                break;
            default:
                System.out.println("El valor introducido no es valildo. Por favor introduzca un numero del 0 al 3.");
        }
    }

    private static void insertaFila() {
        String connectionUrl = "jdbc:mysql://192.168.204.139:3306/clientes";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String consulta;
        while(true) {
            if (!(consulta = formarInsert()).equals("")) {
                try (Connection conn = DriverManager.getConnection(connectionUrl, "phpmyadmin", "phpmyadmin")) {
                    PreparedStatement ps = conn.prepareStatement(consulta);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println("Se ha actualizado la Base de Datos.");
            } else {
                break;
            }
        }

    }

    private static String formarInsert() {
        String[] nombresVariables = {"nombre", "apellidos", "email", "nif"};
        String[] longitudesVariables = {"100", "100", "100", "9"};
        String[] respuestas = new String[4];
        for(int i = 0; i < nombresVariables.length; i++) {
            if ((respuestas[i] = pedirCampo(nombresVariables[i], longitudesVariables[i])).equals("-1")) {
                return "";
            }
        }
        return "insert into Cliente values (null, '"+respuestas[0]+"', '"+respuestas[1]+"', '"+respuestas[2]+"', '"+respuestas[3]+"')";
    }

    private static String pedirCampo(String nombresVariable, String longitudesVariable) {
        System.out.println("Introduzca "+nombresVariable+". Max "+longitudesVariable+" caracteres. Para salir escriba '-1'.");
        return lector.nextLine().strip();
    }


    private static void verFilas() {
        String consulta = "select * from Cliente";
        String connectionUrl = "jdbc:mysql://192.168.204.139:3306/clientes";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

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
