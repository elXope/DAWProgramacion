
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaCliente {

    private static final String NombreFichero = "clientes.dat";

    public void write(ArrayList<Cliente> clientes) {
        FileWriter ficheroEscritura;
        BufferedWriter escritor;

        try {
            ficheroEscritura = new FileWriter(NombreFichero);
            escritor = new BufferedWriter(ficheroEscritura);

            for (Cliente cliente : clientes) {
                escritor.write(cliente.getId() + "," + cliente.getNif() + "," + cliente.getNombre() + "," + cliente.getApellidos() + "," + cliente.getEmail());
            }

            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
