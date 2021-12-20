package Strings;

public class Exercicis {
    public static void main(String[] args) {
        // Ej1
        /* String cadena1 = Utilidades.leerCadena("Primera cadena: ");
         * String cadena2 = Utilidades.leerCadena("Segunda cadena: ");
         * int resultado = comparar(cadena1, cadena2);
         * resultadoComparacion(resultado);
         */

        // Ej2
        /* String cadena1 = Utilidades.leerCadena("Primera cadena: ");
        String cadena2 = Utilidades.leerCadena("Segunda cadena: ");
        int resultado = compararIgnoreCase(cadena1, cadena2);
        resultadoComparacion(resultado); */
        
        // Ej3
       /*  String cadena1 = "OOO0";
        String cadena2 = "s diaaaas";
        System.out.println(concat(cadena1, cadena2)); */

        // Ej4
        /* String cadena1 = "Buenos dias Juan Luis";
        String cadena2 = "os di";
        System.out.println(contiene(cadena1, cadena2)); */

        // Ej5
        /* String cadena1 = "La millor varietat de taronja és la clemenula.";
        String cadena2 = "nula.";
        System.out.println(ends(cadena1, cadena2)); */

        // Ej6
        /* String cadena = "Buenas noches señora, BUENAS NOCHES SEÑORA";
        System.out.println(reemplazar(cadena, ' ', 'a')); */

        // Ej7 & Ej8
        /* String cadena = "La cultura és la unió d'un marc de comprensió i un marc de pràctica ... marc";
        String subCadena = "marc";
        System.out.println(indexOf(cadena, subCadena));
        System.out.println(lastIndexOf(cadena, subCadena)); */

        // Ej9
        /* String cadena = "La filosofia esta para usarla, quien la saca para enseñarla es un pargela.";
        System.out.println(substring(cadena, 5, 25)); */

        // Ej10
        /* String cadena = "Amunt els pàries de la terra, amunt els qui pateixen fam! Els proletaris cridem guerra, tot el món és de guerra un clam.";
        System.out.println(longitud(cadena, 3)); */

        // Ej11
        /* String cadena = "Es el vecino el que quiere que sea el alcalde el vecino, y es el alcalde el que quiere que sea el vecino el alcalde del vecino.";
        System.out.println(longitud2(cadena, 3)); */

        // Ej12
        /* String cadena = "En la discoteca, se pone loco, todos los nenes quieren invitarme a porro";
        longitud3(cadena, 7); */

        // Ej13 i ej14
        /* String cadena = "2 y 2 son 4, 4 y 2 son 6, 6 y 2 son 8 y 8 16";
        System.out.println(digitos(cadena));
        System.out.println(digitos2(cadena)); */

        //Ej15
        /* String cadena1 = "Hola (Paco) k (contes (pringao) e)";
        String cadena2 = "Hola Paco) k (contes (pringao) e)";
        String cadena3 = "Hola (Paco) k (contes pringao) e)";
        String cadena4 = "Hola (Paco k (contes (pringao) e)";
        String cadena5 = "Hola (Paco) k (contes pringao) e)";
        System.out.println(parentesis(cadena1) + " " + parentesis(cadena2) + " " + parentesis(cadena3) + " " + parentesis(cadena4) + " " + parentesis(cadena5)); */

        //Ej16
        /* String cadena = "Es responsabilidad del empresario dotar a los trabajadores de los EPIs y asegurarse que obtienen la información y la formación adecuadas.";
        System.out.println(invertir(cadena)); */

        //Ej17
        /* String cadena = "Organització Terrorista de America del Nord";
        System.out.println(siglas(cadena)); */

        //Ej18
        String palabra1 = "amor";
        String palabra2 = "sabadu";
        System.out.println(alfabetica(palabra1) + " " + alfabetica(palabra2));
    }

    public static int comparar(String cadena1, String cadena2) {
        return cadena1.compareTo(cadena2);
    }

    public static void resultadoComparacion(int diferencia) {
        if (diferencia > 0) System.out.println("La primera cadena es mayor que la segunda.");
        else if (diferencia < 0) System.out.println("La segunda cadena es mayor que la primera.");
        else System.out.println("Las dos cadenas son iguales.");
    }

    public static int compararIgnoreCase(String cadena1, String cadena2) {
        return cadena1.compareToIgnoreCase(cadena2);
    }

    public static String concat(String cadena1, String cadena2) {
        return cadena1.concat(cadena2);
    }

    public static boolean contiene(String cadena1, String cadena2) {
        return cadena1.contains(cadena2);
    }

    public static boolean ends(String cadena1, String cadena2) {
        return cadena1.endsWith(cadena2);
    }

    public static String reemplazar(String cadena, char original, char nuevo) {
        return cadena.replace(original, nuevo);
    }

    public static int indexOf(String cadena, String subCadena) {
        return cadena.indexOf(subCadena);
    }

    public static int lastIndexOf(String cadena, String subCadena) {
        return cadena.lastIndexOf(subCadena);
    }

    public static String substring(String cadena, int inicio, int fin) {
        return cadena.substring(inicio, fin);
    }

    public static int numLetras(String palabra) {
        int lletresParaula = 0;
        for (int i = 0; i < palabra.length(); i++){
            if ((palabra.charAt(i) >= 65 && palabra.charAt(i) <= 90) || (palabra.charAt(i) >= 97 && palabra.charAt(i) <= 122) || (palabra.charAt(i) >= 192 && palabra.charAt(i) <= 255)) lletresParaula++;
        }
        return lletresParaula;
    }

    public static int longitud(String cadena, int nLetras) {
        String[] palabras = cadena.split(" ");
        int contador = 0;
        for (String palabra : palabras) {
            if (numLetras(palabra) == nLetras) contador++;
        }
        return contador;
    }

    public static boolean longitud2(String cadena, int nLetras) {
        String[] palabras = cadena.split(" ");
        for (String palabra : palabras) {
            if (numLetras(palabra) == nLetras) return true;
        }
        return false;
    }

    public static void longitud3(String cadena, int nLetras) {
        String[] palabras = cadena.split(" ");
        for (String palabra : palabras) {
            if (numLetras(palabra) >= nLetras) {
                System.out.println("Hay alguna palabra larga.");
                return;
            } 
        }
        System.out.println("Todas las cadenas son cortas.");
    }

    public static int digitos(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= 48 && cadena.charAt(i) <= 57) contador++;
        }
        return contador;
    }

    public static boolean esNumero (String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) >= '0' && palabra.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }

    public static int digitos2(String cadena) {
        int contador = 0;
        String[] palabras = cadena.split(" ");
        for (String palabra : palabras) {
            if (esNumero(palabra)) contador++;
        }
        return contador;
    }

    public static boolean parentesis (String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '(') contador++;
            else if (cadena.charAt(i) == ')') contador--;
        }
        return contador == 0;
    }

    public static String[] palabras(String cadena) {
        return cadena.split(" ");
    }

    public static String invertir(String cadena) {
        String[] palabras = palabras(cadena);
        String output = "";
        for (int i = palabras.length - 1; i >= 0; i--) {
            output+= " " + palabras[i];
        }
        return output;
    }

    public static String siglas(String cadena) {
        String[] palabras = palabras(cadena);
        String output = "";
        for (String palabra : palabras) {
            if (palabra.charAt(0) >= 'A' && palabra.charAt(0) <= 'Z') {
                output += palabra.charAt(0);
            }
        }
        return output;
    }

    public static boolean alfabetica(String cadena) {
        char letraMasGrande = 'a';
        for (int i = 0; i <= cadena.length(); i++){
            if (cadena.IgnoreCase)
        }

    }
}