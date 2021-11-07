import java.util.Arrays;
import java.util.Random;

public class AlgoritmeEvo {
    Circuit[] poblacio;
    boolean[][] objectiu = {{false, false, false, true, false, true, true, true},{false,true,true,false,true,false,false,true}};
    int maxIter = 1000;
    int aproxImmigracio = 20;
    Random rand = new Random();
    double probEnllas = 1e-3;
    double probPorta = 1e-5;

    public void busca(){
        fitness();
        display();
        recombinacio();
        mutacio();
        for (int i = 0; i < this.maxIter; i++) {
            fitness();
            recombinacio();
            mutacio();
            //immigracio(this.nImmigracio);
        }
        fitness();
        display();
        //poblacio[0].displayOutput();
    }

     private void fitness(){
        boolean[][] output;
        boolean[][] ixides = new boolean[this.objectiu.length][2];
        int matchPorta = 0;
        int totalPortes = 0;
        int matchOutput = 0;
        int outputComplet = 0;
        double provFitness = 0;
        int i = 0;
        int j = 0;
        int l = 0;
        for (int k = 0; k < this.poblacio.length; k++){
            output = this.poblacio[k].output();
            this.poblacio[k].fitness = 0;
            for (boolean[] obj : this.objectiu){
                j = 0;
                for (; j < this.poblacio[k].portes.length; j++){ //igual no és output[0].length
                    i = 0;
                    for (boolean o : obj){
                        if (o == output[i][j]) matchPorta++;
                        ixides[l][j] = output[i][j];
                        i++;
                    }
                    if (matchPorta == output.length) {
                        matchOutput++;
                        for (int i = 0; i < )
                        if (this.objectiu[])
                        if (l < this.objectiu.length) l++;
                        else ixidesExactes
                    }
                    totalPortes += matchPorta;  
                    matchPorta = 0;               
                } 
                provFitness += matchOutput*2 - (i*j - totalPortes)/(i*j);
                matchOutput = 0;
                totalPortes = 0;
            }
            this.poblacio[k].fitness = provFitness/objectiu.length;
            provFitness = 0;
        }
        Arrays.sort(this.poblacio);
    }

    private void recombinacio(){
        int notaDeTall = (this.poblacio.length-this.aproxImmigracio)/2;
        int nPortes;
        Circuit p1;
        Circuit p2;
        for (int i = notaDeTall; i < this.poblacio.length-this.aproxImmigracio; i++) {
            p1 = this.poblacio[this.rand.nextInt(notaDeTall)];
            p2 = this.poblacio[this.rand.nextInt(notaDeTall)];
            nPortes = (p1.portes.length + p2.portes.length)/2;
            if (p1.connect.length > p2.connect.length) this.poblacio[i] = plena(nPortes,p1,p2);
            else this.poblacio[i] = plena(nPortes,p2,p1);
        }
    }

    private Circuit plena (int nPortes, Circuit primer, Circuit segon){
        Circuit fill = new Circuit();
        fill.portes = new Porta[nPortes];
        fill.connect = new int[nPortes][2];
        fill.nInputs = primer.nInputs;
        int i = 0;
        for(; i < primer.portes.length/2; i++){
            fill.connect[i][0] = primer.connect[i][0];
            fill.connect[i][1] = primer.connect[i][1];
            fill.portes[i] = new Porta(primer.portes[i].tipo);
        }
        int j = 0;
        for(; i < nPortes; i++){
            fill.connect[i][0] = segon.connect[segon.connect.length/2 + j][0];
            fill.connect[i][1] = segon.connect[segon.connect.length/2 + j][1];
            fill.portes[i] = new Porta(segon.portes[segon.connect.length/2 + j].tipo);
            j++;
        }
        return fill;
    }

    private void mutacio(){
        for(int i = 0; i < this.poblacio.length; i++){
            for (int j = 0; j < this.poblacio[i].connect.length; j++) {
                if(this.rand.nextDouble() < this.probEnllas) this.poblacio[i].connect[j][0] = this.rand.nextInt(j + this.poblacio[0].nInputs);
                if(this.rand.nextDouble() < this.probEnllas) this.poblacio[i].connect[j][1] = this.rand.nextInt(j + this.poblacio[0].nInputs);
                if(this.rand.nextDouble() < this.probPorta) this.poblacio[i].portes[j].tipo = (byte)this.rand.nextInt(3);
            }
        }
    }

    public Circuit[] crearPoblacio(int nIndividus, int nInputs, int maxPortes){
        Circuit[] poblacio = new Circuit[nIndividus];
        for (int i = 0; i < nIndividus; i++) {
            poblacio[i] = new Circuit();
            poblacio[i].circuitAleatori(this.rand.nextInt(maxPortes - 1)+1, nInputs);
        }
        return poblacio;
    }

    public void poblacioAleatoria(int nIndividus, int nInputs, int maxPortes){
        this.poblacio = crearPoblacio(nIndividus, nInputs, maxPortes);
    }

    public void display(){
        int i = 0;
        for (Circuit individu : this.poblacio) {
            System.out.println("Fitness individu " + i + ": " + individu.fitness);
            i++;
        }
    }
}
