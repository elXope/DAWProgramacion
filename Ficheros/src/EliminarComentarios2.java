import java.io.*;

public class EliminarComentarios2 {
    public static void main(String[] args) throws IOException {
        File script = new File("./Ficheros/src/CribaErastotenes.java");
        FileReader inputFile = new FileReader(script);
        BufferedReader lector = new BufferedReader(inputFile);
        FileWriter escritor = new FileWriter("./Ficheros/src/CribaErastotenesNocom.java");



        escritor.close();
        lector.close();
        inputFile.close();
    }
}
