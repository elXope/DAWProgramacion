package EvoCircuit;

public class Proves {
    public static void main(String[] args) {
        Porta[] llista = new Porta[13];
        llista[0] = new Porta(0);
        llista[1] = new Porta(2);
        llista[2] = new Porta(1);
        llista[3] = new Porta(0);
        llista[4] = new Porta(0);
        llista[5] = new Porta(0);
        llista[6] = new Porta(0);
        llista[7] = new Porta(0);
        llista[8] = new Porta(2);
        llista[9] = new Porta(1);
        llista[10] = new Porta(0);
        llista[11] = new Porta(1);
        llista[12] = new Porta(1);

        int[][] connect = {
            {1, 2},
            {3, 3},
            {1, 2},
            {4, 5},
            {1, 2},
            {0, 1},
            {0, 2},
            {0, 6},
            {10, 10},
            {6, 0},
            {11, 12},
            {7, 8},
            {14, 9}
        };

        Circuit circuit = new Circuit(llista, connect, 3);
    }
}
