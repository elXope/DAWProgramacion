import java.io.*;

public class Agenda {
    private static String pathDatos = "./ControlAgenda/contactos/agenda.dat";
    private static String pathContactos = "./ControlAgenda/contactos/agendaObjetos.dat";

    public static void guardarDatos(String nombre, String apellidos, String email, String telefono) throws IOException {
        File datos = new File(pathDatos);
        datos.createNewFile();
        BufferedWriter escritor = new BufferedWriter(new FileWriter(datos, true));

        escritor.write(nombre + "\t" + apellidos + "\t" + email + "\t" + telefono + "\n");

        escritor.close();
    }

    public static void leerDatos() throws IOException {
        BufferedReader lector = new BufferedReader(new FileReader(pathDatos));

        System.out.println("Contactos:");
        String linia;
        while ((linia = lector.readLine()) != null) {
            System.out.println(
                    "Nombre: " + linia.split("\t")[0]
                    + "\nApellidos: " + linia.split("\t")[1]
                    + "\nEmail: " + linia.split("\t")[2]
                    + "\nTelefono: " + linia.split("\t")[3]
                    + "\n============================"
            );
        }

        System.out.println("*** Fin de la agenda ***\n============================");
        lector.close();
    }

    public static void guardarObjeto(String nombre, String apellidos, String email, String telefono) throws IOException {
        File objetos = new File(pathContactos);
        objetos.createNewFile();

        ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(pathContactos,true));
        escritor.writeObject(new Contacto(nombre, apellidos, email, telefono));

        escritor.close();
    }

    public static void leerObjetos() throws IOException, ClassNotFoundException {
        ObjectInputStream lector = new ObjectInputStream(new FileInputStream(pathContactos));

        System.out.println("Contactos: ");
        try {
            while(true) {
                System.out.println((Contacto)lector.readObject());
            }
        } catch (EOFException eof) {
            System.out.println("*** Fin de la agenda ***\n============================");
            lector.close();
        }
    }
}
