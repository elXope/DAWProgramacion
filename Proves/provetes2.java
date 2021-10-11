public class provetes2 {
    public static void main(String[] args) {
        boolean[][] objectiu = {
            {false, true, true, false, true, false, false, true},
            {false, false, false, true, false, true, true, true}
        };

        EvoCircuit circo = new EvoCircuit(objectiu);
        /*for (int i = 0; i < circo.objectiu.length; i++) {
            for (int j = 0; j < circo.objectiu[0].length; j++) {
                System.out.print(circo.objectiu[i][j] + " ");
            }
            System.out.println("\n");
        }*/

        Circuit prova = new Circuit(100);
        prova.taulaVeritat();
        System.out.println(prova.solucio.length + " " + circo.fitness(prova));
    }
}
