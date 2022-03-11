package Tema6.cutreCloud2;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Objects;

public class Usuario {

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static int generadorID = 0;

    private final int ID;
    private String email;
    private String contrasenya;

    public Usuario(String email, String contrasenya) {
        if (emailValido(email)) {
            this.ID = generadorID++;
            this.email = email;
            this.contrasenya = contrasenya;
            listaUsuarios.add(this);
        } else {
            this.ID = -1;
            this.email = "Email no valido: " + email;
        }
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return new ArrayList<>(listaUsuarios);
    }

    public String getEmail() {
        return this.email;
    }

    public int getID(){
        return this.ID;
    }

    private static boolean emailValido(String email) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public static void eliminarUsuarioXEmail(String email) {
        listaUsuarios.removeIf(usuario -> usuario.email.equals(email));
        Media.actualizarMediaUsuario();
    }

    public static void eliminarUsuarioXDominio(String dominio) {
        listaUsuarios.removeIf(usuario -> usuario.email.split("@")[1].equals(dominio.split("@")[1]));
        Media.actualizarMediaUsuario();
    }

    public String generateXML() {
        return "<usuario>\n" +
                "\t<id>" + this.getID() + "</id>\n" +
                "\t<email>" + this.getEmail() + "</email>\n" +
                "\t<contrasenya>" + this.getEmail() + "</contrasenya>\n" +
                "</usuario>";
    }

    public void writeXML() {
        try {
            File fichero = new File("./Usuarios/" + this.getID() + ".xml");
            fichero.createNewFile();
            FileWriter escritor = new FileWriter("./Usuarios/" + this.getID() + ".xml");
            escritor.write(this.generateXML());
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadXML(){
        File folder = new File("./Usuarios/");

        listaUsuarios.clear();

        for (File xmlFile : folder.listFiles()) {
            getLoadSingleXML(xmlFile);
        }
    }

    private static Usuario getLoadSingleXML(File xmlFile) {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc;
        Usuario newUser = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            String email = doc.getElementsByTagName("email").item(0).getTextContent();
            String password = doc.getElementsByTagName("contrasenya").item(0).getTextContent();
            newUser = new Usuario(email, password);
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return newUser;
    }
}

/**
 * Interfaz que se llama ParserXML: tiene que haber un metodo en las clases que se llame generateXML()
 * En la clase usuario tendremos que crear un metodo que se llame generateXML(), que tiene que devolver un string del xml para los objetos
 * de dicha clase. Para la clase Media lo mismo.
 */