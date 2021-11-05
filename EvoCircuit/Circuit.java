package EvoCircuit;

import java.util.ArrayList;

public class Circuit {
    Porta[] portes;
    int[][] connect;
    int nInputs;

    Circuit(Porta[] portes, int[][] connect, int nInputs){
        this.portes = portes;
        this.connect = connect;
        this.nInputs = nInputs;
    }

    public boolean[][] output(){
        int[] indOutput = indexOutput();
        return trobaOutput(indOutput);
    }

    private int[] indexOutput(){
        ArrayList<Integer> indexProv = new ArrayList<>();
        for (int i = 0; i < this.connect.length - 1; i++) {
            label1:
            for (int j = i; j < this.connect.length - 1; j++) {
                if (i + 3 == this.connect[j+1][0] || i + 3 == this.connect[j+1][1]){
                    i++;
                    break label1;
                }
            }
            indexProv.add(i);
        }
        int[] indOutput = new int[indexProv.size()];
        for (int i = 0; i < indexProv.size(); i++) {
            indOutput[i] = indexProv.get(i).intValue();
        }
        return indOutput;
    }

    private boolean[][] trobaOutput(int[] indOutput){
        boolean[][] output = new boolean[this.portes.length + this.nInputs][(int)Math.pow(2,this.nInputs)];
        boolean[] teOutput = new boolean[this.portes.length + this.nInputs];
        for (int i = 0; i < this.nInputs; i++) {
            teOutput[i] = true;
        }
        boolean[][] estatInputs = new boolean [this.nInputs][(int)Math.pow(2,this.nInputs)];
        
        for (int i : indOutput) {
            output = recursiva(output, teOutput, i);
        }
    }

    private boolean[][] recursiva(boolean[][] output, boolean[] teOutput, int index){
        if(!teOutput[index]){
            if(!teOutput[this.connect[index][0]]){
                output = recursiva(output, teOutput, this.connect[index][0]);
                teOutput[this.connect[index][0]] = true;
            }
            if(!teOutput[this.connect[index][1]]){
                output = recursiva(output, teOutput, this.connect[index][1]);
                teOutput[this.connect[index][1]] = true;
            }
            output[index][]
        }
    }
}
