public class EvoCircuit {
    boolean[][] objectiu;
    int[] fitnessLlista;
    byte nEstats = 8; //hauré d canviar-ho pa quan vullga n entrades
    int maxPortes;
    int nCircuits;

    EvoCircuit(boolean[][] objectiu, int nCircuits, int maxPortes){
        this.objectiu = new boolean[objectiu.length][this.nEstats];
        this.objectiu = objectiu;
        this.nCircuits = nCircuits;
        this.maxPortes = maxPortes;
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
                    finalCont = finalCont + 2;
                }else{
                    finalCont = finalCont + matchCont/8;
                }
            }
        }
        /*int extraPortes = 0;
        if(circuit.solucio.length > this.objectiu.length){
            extraPortes = circuit.solucio.length - this.objectiu.length;
        }*/
        return finalCont/(this.objectiu.length * circuit.solucio.length)- circuit.nPortes*0.001;
    }
}
