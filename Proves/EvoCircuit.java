public class EvoCircuit {
    boolean[][] objectiu;
    int[] fitnessLlista;
    byte nEstats = 8; //hauré d canviar-ho pa quan vullga n entrades

    EvoCircuit(boolean[][] objectiu){
        this.objectiu = new boolean[objectiu.length][this.nEstats];
        this.objectiu = objectiu;
    }

    public double fitness(Circuit circuit){
        circuit.taulaVeritat();
        double matchCont = 0;
        for(int objFilInd = 0; objFilInd < this.objectiu.length; objFilInd++){
            for(int solFilInd = 0; solFilInd < circuit.solucio.length; solFilInd++){
                for(int col = 0; col < this.nEstats; col++){
                    if(this.objectiu[objFilInd][col] == circuit.solucio[solFilInd][col]){
                        matchCont++;
                    }
                }
            }
        }
        double match = matchCont/(8*(double)circuit.solucio.length);
        System.out.println(matchCont);
        return match;
    }
}
