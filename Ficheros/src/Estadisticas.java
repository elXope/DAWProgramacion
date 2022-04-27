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
            if ((char)input == ' ') {
                nEspais++;
                if (nEspais == 4) {
                    nTab++;
                    nEspais = 0;
                }
            } else if (nEspais != 0){
                nEspais = 0;
            }
        }
        fileReader.close();
        return ((double)nTab/(double)nCaracteres)*100;
    }
}