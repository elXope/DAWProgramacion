import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PersistenciaClienteTest {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();

        Cliente c1 = new Cliente("11111111A", "Aaron", "Aa", "01", "aa@aa.aa");
        Cliente c2 = new Cliente("22222222B", "Barrabas", "Bb", "02", "bb@bb.bb");
        Cliente c3 = new Cliente("33333333C", "Concha", "Cc", "03", "cc@cc.cc");

        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);

//        PersistenciaCliente.write(clientes);
//
//        ArrayList<Cliente> clientesRecuperado = PersistenciaCliente.read();
//        for (int i = 0; i < clientesRecuperado.size(); i++) {
//            System.out.println(clientesRecuperado.get(i));
//            System.out.println(clientes.get(i));
//            System.out.println("==============");
//        }

//        try {
//            PersistenciaCliente.writeXML(clientes);
//            ArrayList<Cliente> clientesRecuperado = PersistenciaCliente.readXML();
//            for (int i = 0; i < clientesRecuperado.size(); i++) {
//                System.out.println(clientesRecuperado.get(i));
//                System.out.println(clientes.get(i));
//                System.out.println("==============");
//            }
//        } catch (ParserConfigurationException | TransformerException | IOException | SAXException e) {
//            e.printStackTrace();
//        }

//        try {
//            PersistenciaCliente.writeJSON(clientes);
//            ArrayList<Cliente> clientesRecuperado = PersistenciaCliente.readJSON();
//            for (int i = 0; i < clientesRecuperado.size(); i++) {
//                System.out.println(clientesRecuperado.get(i));
//                System.out.println(clientes.get(i));
//                System.out.println("==============");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            PersistenciaCliente.writeSeri(clientes);
            ArrayList<Cliente> clientesRecuperado = PersistenciaCliente.readSeri();
            for (int i = 0; i < clientesRecuperado.size(); i++) {
                System.out.println(clientesRecuperado.get(i));
                System.out.println(clientes.get(i));
                System.out.println("==============");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
