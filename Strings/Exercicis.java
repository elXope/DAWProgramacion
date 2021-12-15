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
        String cadena1 = "Buenos dias Juan Luis";
        String cadena2 = "os di";
        System.out.println(contiene(cadena1, cadena2));
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
}