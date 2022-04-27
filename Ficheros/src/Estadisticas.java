import java.io.*;

public class Estadisticas {
    public static void main(String[] args) throws IOException {
        File fichero = new File("./Ficheros/f3.txt");

        System.out.println("El fichero tiene " + cuentaLetras(fichero) + " letras.");
        System.out.println("El fichero tiene " + cuentaPalabras(fichero) + " palabras.");
        System.out.println("El fichero tiene " + cuentaLineas(fichero) + " lineas.");
        System.out.println("El fichero tiene un " + calculaPorcVocales(fichero) + "% de vocales.");
        System.out.println("El fichero tiene un " + calculaPorcConsonantes(fichero) + "% de consonantes.");
        System.out.println("El fichero tiene un " + calculaPorcEspacios(fichero) + "% de espacios.");
        System.out.println("El fichero tiene un " + calculaPorcTabuladores(fichero) + "% de tabuladores.");

        calculaTot(fichero);
    }

    public static int cuentaLetras(File f) throws IOException {
        FileReader fileReader = new FileReader(f);
        int nLetras = 0;
        int input;
        while ((input = fileReader.read()) != -1) {
            if (Character.isLetter((char)input)) {
                nLetras++;
            }
        }
        fileReader.close();
        return nLetras;
    }

    private static int cuentaPalabras(File f) throws IOException {
        FileReader fileReader = new FileReader(f);
        BufferedReader lector = new BufferedReader(fileReader);
        String linea;
        int nParaules = 0;
        while ((linea = lector.readLine()) != null) {
            for (String paraula : linea.split(" ")) {
                if (!paraula.equals("")) {
                    nParaules++;
                }
            }
        }
        fileReader.close();
        lector.close();
        return nParaules;
    }

    public static int cuentaLineas(File f) throws IOException {
        FileReader fileReader = new FileReader(f);
        BufferedReader lector = new BufferedReader(fileReader);
        int nLineas = 0;

        while (lector.readLine() != null) {
            nLineas++;
        }

        fileReader.close();
        lector.close();
        return nLineas;
    }

    public static double calculaPorcVocales(File f) throws IOException {
        FileReader fileReader = new FileReader(f);
        int nVocales = 0;
        int nCaracteres = 0;
        int input;
        while ((input = fileReader.read()) != -1) {
            nCaracteres++;
            if (isVowel((char)input)) {
                nVocales++;
            }
        }
        fileReader.close();
        return ((double)nVocales/(double)nCaracteres)*100;
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiouáÁàÀéÉèÈíÍìÌïÏóÓòÒúÚüÜ".indexOf(c) != -1;
    }

    public static double calculaPorcConsonantes(File f) throws IOException {
        FileReader fileReader = new FileReader(f);
        int nConsonantes = 0;
        int nCaracteres = 0;
        int input;
        while ((input = fileReader.read()) != -1) {
            nCaracteres++;
            if (Character.isLetter((char)input) && !isVowel((char)input)) {
                nConsonantes++;
            }
        }
        fileReader.close();
        return ((double)nConsonantes/(double)nCaracteres)*100;
    }

    public static double calculaPorcEspacios(File f) throws IOException {
        FileReader fileReader = new FileReader(f);
        int nEspacios = 0;
        int nCaracteres = 0;
        int input;
        while ((input = fileReader.read()) != -1) {
            nCaracteres++;
            if ((char)input == ' ') {
                nEspacios++;
            }
        }
        fileReader.close();
        return ((double)nEspacios/(double)nCaracteres)*100;
    }

    // En el metode de tabuladors hi ha trampa perque conte com un tabulador 4 espais seguits pero cada espai conta
    // com a caracter.
    public static double calculaPorcTabuladores(File f) throws IOException {
        FileReader fileReader = new FileReader(f);
        int nTab = 0;
        int nEspais = 0;
        int nCaracteres = 0;
        int input;
        while ((input = fileReader.read()) != -1) {
            nCaracteres++;
            if ((char)input == '\t') {
                nTab++;
            }
        }
        fileReader.close();
        return ((double)nTab/(double)nCaracteres)*100;
    }

    public static void calculaTot(File f) throws IOException {
        FileReader fileReader = new FileReader(f);
        BufferedReader lector = new BufferedReader(fileReader);
        String linia;
        String[] paraules;
        int nLinies = 0;
        int nEspais = 0;
        int nCaracters = 0;
        int nLetras = 0;
        int nVocales = 0;
        int nTabs = 0;
        int nPalabras = 0;

        while ((linia = lector.readLine()) != null) {
            nLinies++;
            nCaracters += linia.length() + 1;
            for (int i = 0; i < linia.length(); i++) {
                if (linia.charAt(i) == ' ') {
                    nEspais++;
                } else if (Character.isLetter(linia.charAt(i))) {
                    nLetras++;
                    if (isVowel(linia.charAt(i))) {
                        nVocales++;
                    }
                } else if (linia.charAt(i) == '\t') {
                    nTabs++;
                }
            }
            for (String palabra : linia.split(" ")) {
                if (!palabra.equals("")) {
                    nPalabras++;
                }
            }
        }
        nCaracters--; // La ultima linia no te caracter de salt de linia
        System.out.println("El texto tiene:\n" +
                nLetras + " letras\n" +
                nPalabras + " palabras\n" +
                nLinies + " linias\n" +
                ((double)nVocales/(double)nCaracters)*100 + "% de vocales\n" +
                ((double)(nLetras - nVocales)/(double)nCaracters)*100 + "% de consonantes\n" +
                ((double)nEspais/(double)nCaracters)*100 + "% de espacios\n" +
                ((double)nTabs/(double)nCaracters)*100 + "% de tabuladores\n");
    }
}