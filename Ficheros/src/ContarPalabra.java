import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContarPalabra {
    public static void main(String[] args) throws IOException {
        FileReader input = new FileReader("./Ficheros/f2.txt");
        BufferedReader lector = new BufferedReader(input);

        String linia;
        int cont;
        while ((linia = lector.readLine()) != null) {
            cont = cuentaPalabras(linia);
        }
    }

    public static int cuentaPalabras(String linia) {
        boolean esPalabra = false;
        char car;

        for (int i = 0; i < linia.length(); i++) {
            if (linia.charAt(i) != " ") {

            }
        }
    }
}
