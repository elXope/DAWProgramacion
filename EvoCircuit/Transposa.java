package EvoCircuit;

public class Transposa {
    public static boolean[][] transposa(boolean[][] matriuO){
        boolean[][] matriuT = new boolean[matriuO[0].length][matriuO.length];
        for (int i = 0; i < matriuO.length; i++) {
            for (int j = 0; j < matriuO[0].length; j++) {
                matriuT[j][i] = matriuO[i][j];
            }
        }
        return matriuT;
    }
}
