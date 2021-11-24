import java.util.Arrays;

public class Arreglo {
    public static int[] eliminar(int[] arreglo, int index) {
        int[] copiaDavant = Arrays.copyOf(arreglo, index);
        int[] copiaDarrere = Arrays.copyOfRange(arreglo, index + 1, arreglo.length);
        int[] output = new int[arreglo.length - 1];
        int i = 0;
        for (; i < copiaDavant.length; i++){
            output[i] = copiaDavant[i];
        }
        for (; i < copiaDarrere.length; i++){
            output[i] = copiaDarrere[i - copiaDavant.length];
        }
        return output;
    }
    
}