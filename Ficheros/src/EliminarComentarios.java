import java.io.*;

public class EliminarComentarios {
    public static void main(String[] args) throws IOException {
        File script = new File("./Ficheros/src/CribaErastotenes.java");
        FileReader inputFile = new FileReader(script);
        BufferedReader lector = new BufferedReader(inputFile);
        FileWriter escritor = new FileWriter("./Ficheros/src/CribaErastotenesNocom.java");
        String linia;
        boolean noComment = true;

        while ((linia = lector.readLine()) != null) {
            for (int i = 0; i < linia.length() - 1; i++) {
                if (noComment && linia.charAt(i) == '/') {
                    if (linia.charAt(i + 1) == '/') {
                        linia = linia.substring(0, i);
                        break;
                    } else if (linia.charAt(i + 1) == '*') {
                        noComment = false;
                    }
                } else if (!noComment && linia.charAt(i) == '*' && linia.charAt(i + 1) == '/') {
                    linia = "";
                    noComment = true;
                    break;
                }
            }
            if (noComment) {
                escritor.write(linia + System.lineSeparator());
            }
        }
        escritor.close();
        lector.close();
        inputFile.close();
    }
}
