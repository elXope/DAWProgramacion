import java.util.Arrays;
import java.util.Random;

class Circuit implements Comparable<Circuit> {
    Porta[] portes;
    int[][] connect;
    int nInputs;
    double fitness;

    Circuit(){};

    Circuit(Porta[] portes, int[][] connect, int nInputs){
        this.portes = portes;
        this.connect = connect;
        this.nInputs = nInputs;
    }

    public boolean[][] output(){
        boolean[][] output = new boolean[(int)Math.pow(2,this.nInputs)][this.portes.length];
        boolean[][] estatInputs = BinComb8.binComb8(this.nInputs);//new boolean [this.nInputs][(int)Math.pow(2,this.nInputs)];
        boolean[] outputProv = new boolean[this.nInputs + this.portes.length];
        int j = 0;
        for (boolean[] input : estatInputs) {
            for (int i = 0; i < input.length; i++) {
                outputProv[i] = input[i];
            }
            for (int i = this.nInputs; i < outputProv.length; i++) {
                //System.out.println(i-this.nInputs);
                outputProv[i] = this.portes[i - this.nInputs].output(outputProv[this.connect[i-this.nInputs][0]],outputProv[this.connect[i-this.nInputs][1]]);
            }
            output[j] = Arrays.copyOfRange(outputProv, this.nInputs, outputProv.length);
            j++;
        }
        return output;
    }

    public void displayOutput() {
        boolean[][] output = output();
        for (boolean[] bs : output) {
            for (boolean bs2 : bs) {
                if(bs2) {System.out.print("1 ");}
                else {System.out.print("0 ");}
            }
            System.out.println("\n");
        }
    }

    public void displayPortes(){
        for (Porta porta : this.portes) {
            porta.display();
        }
    }

    public void circuitAleatori(int nPortes, int nInputs){
        this.portes = new Porta[nPortes];
        this.connect = new int[nPortes][2];
        this.nInputs = nInputs;
        Random rand = new Random();
        
        for (int i = 0; i < nPortes; i++) {
            this.portes[i] = new Porta(rand.nextInt(nInputs));
            this.connect[i][0] = rand.nextInt(i+nInputs);
            this.connect[i][1] = rand.nextInt(i+nInputs);
        }
    }
    
    public int compareTo(Circuit o){
        if (o.fitness > this.fitness) return 1;
        else if (o.fitness < this.fitness) return -1;
        else return 0;
    }
}