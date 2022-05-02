
import java.io.*;
import java.util.ArrayList;

public class PersistenciaCliente {

    private static final String NombreFichero = "clientes.dat";

    public static void write(ArrayList<Cliente> clientes) {
        FileWriter ficheroEscritura;
        BufferedWriter escritor;

        try {
            ficheroEscritura = new FileWriter(NombreFichero);
            escritor = new BufferedWriter(ficheroEscritura);

            for (Cliente cliente : clientes) {
                escritor.write(cliente.getId() + "," + cliente.getNif() + "," + cliente.getNombre() + "," + cliente.getApellidos() + "," + cliente.getEmail() + "\n");
            }

            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cliente> read() {
        ArrayList<Cliente> resultado = new ArrayList<>();
        FileReader fileReader;
        BufferedReader lector;

        try {
            fileReader = new FileReader("clientes.dat");
            lector = new BufferedReader(fileReader);
            String linia;
            String[] campos;

            while ((linia = lector.readLine()) != null) {
                campos = linia.split(",");
                resultado.add(new Cliente(campos[1], campos[2], campos[3], campos[0], campos[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultado;
    }
}
