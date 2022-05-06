
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.Type;
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

    public static void writeXML(ArrayList<Cliente> clientes) throws ParserConfigurationException, TransformerException, FileNotFoundException {
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = doc.createElement("clientes");
        doc.appendChild(root);

        for (Cliente cliente : clientes) {
            Element cli = doc.createElement("cliente");

            Element nif = doc.createElement("nif");
            nif.appendChild(doc.createTextNode(cliente.getNif()));
            cli.appendChild(nif);

            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(cliente.getNombre()));
            cli.appendChild(nombre);

            Element apellidos = doc.createElement("apellidos");
            apellidos.appendChild(doc.createTextNode(cliente.getApellidos()));
            cli.appendChild(apellidos);

            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(cliente.getId()));
            cli.appendChild(id);

            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode(cliente.getEmail()));
            cli.appendChild(email);

            root.appendChild(cli);
        }

        Transformer trans = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream("./Clientes.xml"));

        trans.transform(source, result);
    }

    public static ArrayList<Cliente> readXML() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("./Clientes.xml");
        Element root = doc.getDocumentElement();
        NodeList hijos = root.getChildNodes();

        for (int i = 0; i < hijos.getLength(); i++) {
            NodeList hojas = hijos.item(i).getChildNodes();
            clientes.add(new Cliente(hojas.item(0).getTextContent(),
                    hojas.item(1).getTextContent(),
                    hojas.item(2).getTextContent(),
                    hojas.item(3).getTextContent(),
                    hojas.item(4).getTextContent()));
        }

        return clientes;
    }

    public static void writeJSON(ArrayList<Cliente> clientes) throws IOException {
        Gson gson = new Gson();
        FileWriter destino = new FileWriter("./ClientesJSON.json");
        BufferedWriter escritor = new BufferedWriter(destino);

        escritor.write("[");
        for (int i = 0; i < clientes.size() - 1; i++) {
            escritor.write(gson.toJson(clientes.get(i)) + ",");
        }
        escritor.write(gson.toJson(clientes.get(clientes.size() - 1)) + "]");

        escritor.close();
        destino.close();
    }

    public static ArrayList<Cliente> readJSON() throws IOException {
        Type tipoListaClientes = new TypeToken<ArrayList<Cliente>>(){}.getType();
        Gson gson = new Gson();
        FileReader fileReader = new FileReader("./ClientesJSON.json");
        BufferedReader lector = new BufferedReader(fileReader);
        String elJson = lector.readLine();

        return gson.fromJson(elJson, tipoListaClientes);
    }

    public static void writeSeri(ArrayList<Cliente> clientes) throws IOException {
        ObjectOutputStream f = new ObjectOutputStream(new FileOutputStream("./ClientesSeri.obj"));
        for (Cliente cliente : clientes) {
            f.writeObject(cliente);
        }
        f.close();
    }

    public static ArrayList<Cliente> readSeri() throws IOException, ClassNotFoundException {
        ObjectInputStream f = new ObjectInputStream(new FileInputStream("./ClientesSeri.obj"));
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            while(true) {
                clientes.add((Cliente) f.readObject());
            }
        } catch (EOFException eof) {
            f.close();
        }
        return clientes;
    }
}
