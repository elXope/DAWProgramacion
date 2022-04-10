import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContarPalabra {
    public static void main(String[] args) throws IOException {
        FileReader input = new FileReader("./Ficheros/fsplit.txt");
        BufferedReader lector = new BufferedReader(input);

        String linia;
        String[] liniaPartida;
        String objectiu = "ff";
        int cont = 0;
        while ((linia = lector.readLine()) != null) {
            liniaPartida = linia.split(" ");
            for (int i = 0; i < liniaPartida.length; i++) {
                for (int j = 0; j < liniaPartida[i].length(); j++) {
                    if(!Character.isLetter(liniaPartida[i].charAt(j)) && !Character.isDigit(liniaPartida[i].charAt(j))) {
                        liniaPartida[i] = liniaPartida[i].replace("" + liniaPartida[i].charAt(j), "");
                    }
                }
                if (liniaPartida[i].equalsIgnoreCase(objectiu)) {
                    cont++;
                }
            }
        }
        System.out.println("La palabra aparece " + cont + " veces.");
    }

    static void imprimirArrayString(String[] strings) {
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
