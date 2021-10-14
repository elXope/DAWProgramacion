import java.util.Random;
import java.util.Arrays;

public class EvoCircuit {
    boolean[][] objectiu;
    double[] fitnessLlista;
    byte nEstats = 8; //hauré d canviar-ho pa quan vullga n entrades
    int maxPortes;
    int nCircuits;
    Circuit[] poblacio;
    Random rand = new Random();
    double mutaNPorta = 0.001; // valors provisionals
    double mutaTipoPorta = 0.001;
    double mutaEnllas; //sé k seskriu enllaç

    EvoCircuit(boolean[][] objectiu, int nCircuits, int maxPortes){
        this.objectiu = new boolean[objectiu.length][this.nEstats];
        this.objectiu = objectiu;
        this.nCircuits = nCircuits;
        this.maxPortes = maxPortes;
        this.fitnessLlista = new double[nCircuits];
        crearPoblacio();
    }

    private void crearPoblacio(){
        this.poblacio = new Circuit[this.nCircuits];
        for(int i = 0; i < this.nCircuits; i++){
            this.poblacio[i] = new Circuit(rand.nextInt(this.maxPortes) + 1);
            this.poblacio[i].aleatori();
            this.poblacio[i].taulaVeritat(); //igual se pot llevar perquè al fer la fitness calcula la TV
        }
    }

    public void optimitzaCircuit(){
        int[] indexCircuits = new int[this.nCircuits];
        for (int i = 0; i < this.nCircuits; i++) {
            this.fitnessLlista[i] = fitness(this.poblacio[i]);
            indexCircuits[i] = i;
        }
        indexCircuits = ordenaPerFitness(indexCircuits);
    }

    private int[] ordenaPerFitness(int[] indexCircuits){ //Ho he de mirar molt
        int[] indexProvisional = new int[this.nCircuits];
        indexProvisional[0] = indexCircuits[0];
        for(int i = 1; i < this.nCircuits; i++){
            if(this.fitnessLlista[indexCircuits[i]] <= this.fitnessLlista[indexProvisional[i-1]]){
                indexProvisional[i] = indexCircuits[i];
            } else {

            }
            for(int j = i - 1; j >= 0; j--){
                if(indexCircuits[j+1] <= indexCircuits[j]){
                    indexProvisional[j+1] = indexCircuits[j+1];
                    break;
                } else {
                    //indexProvisional[]
                }
            }
        }
        return indexCircuits;
    }

    public Circuit procrear(Circuit circuit1, Circuit circuit2){
        int nPortesFill;
        Circuit fill;
        // El número de portes del fill estarà entre el dels progenitors
        if(circuit1.nPortes > circuit2.nPortes){
            nPortesFill = rand.nextInt(circuit1.nPortes - circuit2.nPortes) + circuit2.nPortes;
            nPortesFill = mutacioNPortes(nPortesFill);
            fill = new Circuit(nPortesFill);
            recombinacio(fill, circuit1, circuit2);

        } else if(circuit2.nPortes > circuit1.nInputs){
            nPortesFill = rand.nextInt(circuit2.nPortes - circuit1.nPortes) + circuit1.nPortes;
            nPortesFill = mutacioNPortes(nPortesFill);
            fill = new Circuit(nPortesFill);
            recombinacio(fill, circuit2, circuit1);

        } else {
            nPortesFill = circuit1.nPortes;
            nPortesFill = mutacioNPortes(nPortesFill);
            fill = new Circuit(nPortesFill);
            recombinacio(fill, circuit2, circuit1);

        }
        fill.indIx();
        return fill;
    }

    private int mutacioNPortes(int nPortesFill){
        while(rand.nextDouble() < this.mutaNPorta){
            if(rand.nextDouble() < 0.5){
                nPortesFill++;
            } else {
                nPortesFill--;
            }
        }
        return nPortesFill;
    }

    private void recombinacio (Circuit fill, Circuit circuitMajor, Circuit circuitMenor){
        int i = 0;
        while(i < fill.nPortes){       // Hauré de mirar si en lloc de dixar un numero aleatori entre les dos portes mos quedem en un nPortes o un altre
            while(i < circuitMenor.nPortes){
                if(rand.nextDouble() < 0.5){
                    fill.llistaPortes[i] = circuitMenor.llistaPortes[i];
                    fill.indexConnect[i] = circuitMenor.indexConnect[i];
                } else {
                    fill.llistaPortes[i] = circuitMajor.llistaPortes[i];
                    fill.indexConnect[i] = circuitMajor.indexConnect[i];
                }
                if(rand.nextDouble() < this.mutaTipoPorta){
                    fill.llistaPortes[i].tipo = (byte)rand.nextInt(3);
                    if(fill.llistaPortes[i].tipo == 2){
                        fill.indexConnect[i][1] = fill.indexConnect[i][2];
                    }
                }
                if(rand.nextDouble() < this.mutaEnllas){
                    if(fill.llistaPortes[i].tipo == 2){
                        fill.indexConnect[i][1] = (byte)rand.nextInt(i);
                        fill.indexConnect[i][2] = fill.indexConnect[i][1];
                    } else {
                        if(rand.nextDouble() < 0.5){
                            fill.indexConnect[i][1] = (byte)rand.nextInt(i);
                        } else {
                            fill.indexConnect[i][2] = (byte)rand.nextInt(i);
                        }
                    }
                }
                i++;
            }
            fill.llistaPortes[i] = circuitMajor.llistaPortes[i];
            fill.indexConnect[i] = circuitMajor.indexConnect[i];
            if(rand.nextDouble() < this.mutaTipoPorta){
                fill.llistaPortes[i].tipo = (byte)rand.nextInt(3);
                if(fill.llistaPortes[i].tipo == 2){
                    fill.indexConnect[i][1] = fill.indexConnect[i][2];
                }
            }
            if(rand.nextDouble() < this.mutaEnllas){
                if(fill.llistaPortes[i].tipo == 2){
                    fill.indexConnect[i][1] = (byte)rand.nextInt(i);
                    fill.indexConnect[i][2] = fill.indexConnect[i][1];
                } else {
                    if(rand.nextDouble() < 0.5){
                        fill.indexConnect[i][1] = (byte)rand.nextInt(i);
                    } else {
                        fill.indexConnect[i][2] = (byte)rand.nextInt(i);
                    }
                }
            }
            i++;
        }
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

    public void displayTot(){
        System.out.println("Població: " + this.poblacio.length + "\n\n");
        for(int i = 0; i < this.poblacio.length; i++){
            displayCircuit(i);
        }
    }

    public void displayCircuit(int index){
        System.out.println("Circuit " + index + ":");
        System.out.println("Nº portes: " + this.poblacio[index].nPortes);
        System.out.println("Nº outputs: " + this.poblacio[index].indexIxides.length);
        System.out.println("Outputs:");
        this.poblacio[index].display();
        System.out.println("\nLlista portes: ");
        for(int j = 0; j < this.poblacio[index].nPortes; j++){
            System.out.println("Porta " + this.poblacio[index].indexConnect[j][0] + ":");
            if(this.poblacio[index].llistaPortes[j].tipo == 0){
                System.out.println("  Tipo: AND");
            }else if(this.poblacio[index].llistaPortes[j].tipo == 1){
                System.out.println("  Tipo: OR");
            }else if(this.poblacio[index].llistaPortes[j].tipo == 2){
                System.out.println("  Tipo: NOT");
            }else{
                System.out.println("xddd");
            }
            System.out.println("  Inputs: " + this.poblacio[index].indexConnect[j][1] + " " + this.poblacio[index].indexConnect[j][2] + "\n");
        }

    }
}
