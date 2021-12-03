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

    public static int[][] eliminarFila(int[][] mat, int fila){
        int[][] output = new int[mat.length - 1][mat[0].length];
        int j = 0;
        for (int i = 0; i < output.length; i++){
            if (i == fila) j++;
            output[i] = Arrays.copyOf(mat[j], mat[j].length);
            j++;
        }
        return output;
    }

    public static int[] eliminarDuplicados(int[] arreglo){
        int[] copia = Arrays.copyOf(arreglo, arreglo.length);
        Arrays.sort(copia);

        for (int i = 0; i < copia.length - 1; i++){
            if(copia[i] == copia[i+1]){
                copia = eliminar(copia,i--);
            }
        }
        return copia;
    }

    public static int[] duplicados(int[] arreglo){
        int[] copia = Arrays.copyOf(arreglo, arreglo.length);
        Arrays.sort(copia);

        for (int i = 0; i < copia.length - 1; i++){
            if(copia[i] != copia[i+1]){
                copia = eliminar(copia,i--);
            }
        }
        return eliminarDuplicados(copia);
    }

    public static int[] comunes(int[] a1, int[] a2) {
        a1 = eliminarDuplicados(a1);
        a2 = eliminarDuplicados(a2);
        int length = a1.length > a2.length ? a1.length : a2.length;
        int[] output = new int[length];
        int indOut = 0;
        for (int i = 0; i < a1.length; i++){
            for (int j = 0; j < a2.length; j++){
                if (a1[i] == a2[j]){
                    output[indOut++] = a1[i];
                }
            }
        }
        return Arrays.copyOf(output,indOut);
    }

    public static int[][] sumaIgual(int[] arreglo, int num){
        int stop = arreglo.length;
        int indOut = 0;
        int [][] output = new int[arreglo.length][2];
        int[] copia = Arrays.copyOf(arreglo,arreglo.length);
        Arrays.sort(copia);
        for(int i = 0; i < stop; i++){
            for(int j = i+1; j < stop; j++){
                if (copia[i] + copia[j] == num){
                    stop = j;
                    output[indOut][0] = copia[i];
                    output[indOut][1] = copia[j];
                    indOut++;
                } else if(copia[i] + copia[j] > num){
                    stop = j;
                }
            }
        }
        return Arrays.copyOf(output,indOut);
    }

    public static boolean iguales(int[] a1, int[] a2){
        for (int i = 0; i < a1.length; i++){
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static int[] paresImpares(int[] arreglo){
        int[] output = new int[2]; //output[0] = pares, output[1] = impares
        for (int i = 0; i < arreglo.length; i++){
            if (arreglo[i] % 2 == 0) output[0]++;
            else output[1]++;
        }
        return output;
    }

    public static void moverCeros(int[] arreglo){
        int ultimaPos = arreglo.length - 1;
        for(int i = 0; i < ultimaPos; i++){
            if (arreglo[i] == 0) {
                ultimaPos--;
                for (int j = i; j < ultimaPos; j++){
                    arreglo[j] = arreglo[j + 1];
                }
                arreglo[ultimaPos] = 0;
                i--;
            }
        }
    }

    public static void rellenaMatriz(int[][] mat, int min, int max){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                mat[i][j] = (int)(Math.random()*(max + 1 - min) + min);
            }
        }
    }

    public static void printTablero(int[][] mat, boolean muestraBarcos){
        char fila = 'A';
        for (int i = 0; i < mat.length + 1; i++){
            if (i == 0) System.out.print("  ");
            else System.out.print(fila++ + " ");
            for (int j = 0; j < mat[0].length; j++){
                if (i == 0) System.out.print((j + 1) + " ");
                else {
                    switch (mat[i - 1][j]){
                        case 1:
                            if (muestraBarcos) {
                                System.out.print("+ ");
                                break;
                            }
                        case 0:
                            System.out.print("· ");
                            break;
                        case 2:
                            System.out.print("0 ");
                            break;
                        case 3:
                            System.out.print("X ");
                            break;
                    }
                }
            }

            System.out.println();
        }
    }

    public static void hundirLaFlota(){
        int[][] tablero = new int[8][8];
        meterBarcos(tablero);
        int barcosDescubiertos = 0;
        int[] siguienteEntrada = new int[2];
        Scanner lector = new Scanner(System.in);

        while(barcosDescubiertos < 10){
            printTablero(tablero, false);
            pedirEntrada(siguienteEntrada, lector);

            if (tablero[siguienteEntrada[0]][siguienteEntrada[1]] == 1){
                tablero[siguienteEntrada[0]][siguienteEntrada[1]] = 3;
                barcosDescubiertos++;
            } else if (tablero[siguienteEntrada[0]][siguienteEntrada[1]] == 0){
                tablero[siguienteEntrada[0]][siguienteEntrada[1]] = 2;
            }
        }
        lector.close();
    }

    public static void meterBarcos(int[][] tablero){
        int barcos = 0;
        int fila, columna;
        while (barcos < 10) {
            fila = randomRange(0, 7);
            columna = randomRange(0, 7);
            if (tablero[fila][columna] == 0){
                tablero[fila][columna] = 1;
                barcos++;
            }
        }
    }

    public static void pedirEntrada(int[] siguienteEntrada, Scanner lector){
        System.out.print("Introduce fila (letra): ");
        String fila = lector.next();
        siguienteEntrada[0] = fila.charAt(0)%'A';
        System.out.print("Introduce columna (numero): ");
        siguienteEntrada[1] = lector.nextInt() - 1;
    }

    public static int randomRange(int min, int max){
        return (int)(Math.random()*(max + 1 - min) + min);
    }

    public static void histograma(int[][] mat, int nBins){
        int cont;
        for (int k = 0; k < nBins; k++){
            cont = 0;
            for (int i = 0; i < mat.length; i++){
                for (int j = 0; j < mat[0].length; j++){
                    if (mat[i][j] == k) cont++;
                }
            }
            System.out.println(k + ": " + cont);
        }
    }

    public static void printMatriz(int[][] mat){
        for (int[] is : mat) {
            System.out.println(Arrays.toString(is));
        }
    }
}
