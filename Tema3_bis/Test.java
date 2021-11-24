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
        int[] prova = {0, 1, 1, 66, 66, 3, 4, 5, 5, 66, 8, 3, 0};
        int[] dup = Arreglo.duplicados(prova);
        System.out.println(Arrays.toString(dup));
    }
}
