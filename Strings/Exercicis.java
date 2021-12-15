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
    }

    public static int comparar(String cadena1, String cadena2) {
        return cadena1.compareTo(cadena2);
    }

    public static void resultadoComparacion(int diferencia) {
        if (diferencia > 0) System.out.println("La primera cadena es mayor que la segunda.");
        else if (diferencia < 0) System.out.println("La segunda cadena es mayor que la primera.");
        else System.out.println("Las dos cadenas son iguales.");
    }
}