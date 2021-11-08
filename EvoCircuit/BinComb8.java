package EvoCircuit;

public class BinComb8 {
    public static boolean[][] binComb8(int nBits){
        boolean[][] output = new boolean[(int)Math.pow(2,nBits)][nBits];
        boolean[] cadena = {false, false, false};
        for (int i = 0; i < output.length - 1; i++) {
            for (int j = nBits - 1; j > 0; j--){
                if (output[i][j] == false){
                    cadena[j] = true;
                    break;
                } else {
                    cadena[j] = false;
                    cadena[j - 1] = true;
                }
            }
            output[i + 1] = cadena.clone();
        }
        return output;
    }

    public static void display(int nBits){
        boolean[][] output = binComb8(nBits);
        for (boolean[] bs : output) {
            for (boolean bs2 : bs) {
                if (bs2) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println("\n");
        }
    }
}
