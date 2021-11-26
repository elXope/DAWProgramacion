package Tema3_bis;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // test eliminar
        /*int[] prova = {0, 1, 2, 3, 4};
        System.out.println(Arrays.toString(prova));
        prova = Arreglo.eliminar(prova, 2);
        System.out.println(Arrays.toString(prova));*/
        
        // test duplicados
        /* int[] prova = {0, 12, 1, 1, 66, 66, 3, 4, 5, 5, 66, 8, 3, 0, 12, 12, 15, 3};// repes: 0, 1, 3, 5, 66
        int[] dup = Arreglo.duplicados(prova);
        System.out.println(Arrays.toString(dup)); */

        // test comunes
        /* int[] prova1 = {0, 12, 1, 1, 66, 66, 3, 4, 5, 5, 66, 8, 3, 0, 12, 12, 15, 3};
        int[] prova2 = {3, 2, 4, 0, 11, 5, 8, 10, 12, 3};
        int[] output = Arreglo.comunes(prova1, prova2);
        System.out.println(Arrays.toString(output)); */
        
        // test sumaIgual
        /* int[] prova1 = {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        int[][] output = Arreglo.sumaIgual(prova1, 10);
        Arreglo.printMatriz(output); */

        // test iguales
        /* int[] prova1 = {0, 1, 2};
        int[] prova2 = {0, 2, 2};
        boolean output = Arreglo.iguales(prova1, prova2);
        System.out.println(output); */

        // test paresImpares
        /* int[] prova = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] out = Arreglo.paresImpares(prova);
        System.out.println(Arrays.toString(out)); */
        
        // test moverCeros
        /* int[] prova = {0, 1, 0, 0, 2, 0, 3, 0, 0, 0};
        Arreglo.moverCeros(prova);
        System.out.println(Arrays.toString(prova)); */

        // test rellenaMatriz
        int[][] mat = new int[10][10];
        Arreglo.rellenaMatriz(mat, 0, 3);
        Arreglo.printMatriz(mat);
    }
}
