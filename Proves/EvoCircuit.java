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
        double matchCont;
        double finalCont = 0;
        for(int objFilInd = 0; objFilInd < this.objectiu.length; objFilInd++){
            for(int solFilInd = 0; solFilInd < circuit.solucio.length; solFilInd++){
                matchCont = 0;
                for(int col = 0; col < this.nEstats; col++){
                    if(this.objectiu[objFilInd][col] == circuit.solucio[solFilInd][col]){
                        matchCont++;
                    }
                }
                if(matchCont == 8){
                    finalCont = finalCont + 5;
                }else{
                    finalCont = finalCont + matchCont/8;
                }
            }
        }
        double match = finalCont/(this.objectiu.length * circuit.solucio.length);
        return match;
    }
}
