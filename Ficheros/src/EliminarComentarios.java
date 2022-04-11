import java.io.*;

public class EliminarComentarios {
    public static void main(String[] args) throws IOException {
        File script = new File("./Ficheros/src/CribaErastotenes.java");
        FileReader inputFile = new FileReader(script);
        BufferedReader lector = new BufferedReader(inputFile);
        FileWriter escritor = new FileWriter("./Ficheros/src/CribaErastotenesNocom.java");
        String linia;
        String marcador = "_*_borrar_*_";
        boolean noComment = true;

        while ((linia = lector.readLine()) != null) {
            for (int i = 0; i < linia.length() - 1; i++) {
                if (noComment && linia.charAt(i) == '/') {
                    if (linia.charAt(i + 1) == '/') {
                        linia = linia.substring(0, i);
                        int cont = 0;
                        for (int j = 0; j < linia.length(); j++) {
                            if (linia.charAt(j) == ' ') {
                                cont++;
                            }
                        }
                        if (linia.length() == cont) {
                            linia = marcador;
                        }
                        break;
                    } else if (linia.charAt(i + 1) == '*') {
                        noComment = false;
                    }
                } else if (!noComment && linia.charAt(i) == '*' && linia.charAt(i + 1) == '/') {
                    linia = marcador;
                    noComment = true;
                    break;
                }
            }
            if (noComment && !linia.equals(marcador)) {
                escritor.write(linia + System.lineSeparator());
            }
        }
        escritor.close();
        lector.close();
        inputFile.close();
    }
}
