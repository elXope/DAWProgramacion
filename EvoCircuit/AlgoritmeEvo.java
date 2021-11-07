public class AlgoritmeEvo {
    Circuit[] poblacio;
    boolean[][] objectiu = {{false, false, false, true, false, true, true, true},{false,true,true,false,true,false,false,true}};
    int maxIter = 0;

    public void busca(){
        for (int i = 0; i < this.maxIter; i++) {
            fitness();
            //recombinacio();
            //mutacio();
            //immigracio(this.nImmigracio);
        }
        fitness();
        //poblacio[0].displayOutput();
    }

    public void fitness(){
        boolean[][] output;
        int matchPorta = 0;
        int totalPortes = 0;
        int matchOutput = 0;
        double provFitness = 0;
        int i = 0;
        int j = 0;
        for (Circuit individu : this.poblacio){
            output = individu.output();
            individu.fitness = 0;
            for (boolean[] obj : objectiu){
                j = 0;
                matchOutput = 0;
                for (; j < output[0].length; j++){ //igual no és output[0].length
                    i = 0;
                    matchPorta = 0;
                    for (boolean o : obj){
                        if (o == output[i][j]) matchPorta++;
                        i++;
                    }
                    if (matchPorta == output.length) matchOutput++;
                    totalPortes += matchPorta;                 
                }
                provFitness += totalPortes/(i*j) + matchOutput*2;
            }
            individu.fitness = provFitness/objectiu.length;
        }
    }
}
