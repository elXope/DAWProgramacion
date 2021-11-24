package Tema3_bis;

import java.util.Arrays;
import java.util.Scanner;

public class Arreglo {
    public static int[] eliminar(int[] arreglo, int index) {
        /*System.out.println("L'array és " + Arrays.toString(arreglo) + ". Introduix l'índex de l'element a eliminar: ");
        Scanner lector = new Scanner(System.in);
        int index = lector.nextInt();
        while(index > arreglo.length - 1){
            System.out.println("L'índex màxim és " + (arreglo.length - 1) + ". Introduix un índex vàlid:");
            index = lector.nextInt();
        }*/
        int[] output = new int[arreglo.length - 1];
        int j = 0;
        for (int i = 0; i < output.length; i++) {
            if (i == index) j++;
            output[i] = arreglo[j];
            j++;
        }
        return output;
    }

    public static boolean[][] eliminarFilaBoolean(boolean[][] mat, int fila){
        boolean[][] output = new boolean[mat.length - 1][mat[0].length];
        int j = 0;
        for (int i = 0; i < output.length; i++){
            if (i == fila) j++;
            output[i] = Arrays.copyOf(mat[j], mat[j].length);
            j++;
        }
        return output;
    }

    public static int[] eliminarDuplicados(int[] arreglo) { //mhe kedat x aci
        for (int i = 0; i < arreglo.length; i++){
            for (int j = i + 1; j < arreglo.length; j++){
                if (arreglo[i] == arreglo[j]){
                    
                }
            }
        }
    }

    public static int[] duplicados(int[] arreglo){
        int[] duplicados = new int[arreglo.length/2];
        int contDup = 0;
        for (int i = 0; i < copiaArreglo.length; i++){
            for (int j = i + 1; j < copiaArreglo.length; j++){
                if (copiaArreglo[i] == copiaArreglo[j]){
                    duplicados[contDup] = copiaArreglo[i];
                    contDup++;;
                }
            }
        }
        return Arrays.copyOf(duplicados,contDup);
    }
}
