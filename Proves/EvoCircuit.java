import java.util.Random;

public class EvoCircuit {
    boolean[][] objectiu;
    int[] fitnessLlista;
    byte nEstats = 8; //hauré d canviar-ho pa quan vullga n entrades
    int maxPortes;
    int nCircuits;
    Circuit[] poblacio;
    Random rand = new Random();
    double mutaNPorta = 0.001; // valors provisionals
    double mutaTipoPorta;
    double mutaEnllas; //sé k seskriu enllaç

    EvoCircuit(boolean[][] objectiu, int nCircuits, int maxPortes){
        this.objectiu = new boolean[objectiu.length][this.nEstats];
        this.objectiu = objectiu;
        this.nCircuits = nCircuits;
        this.maxPortes = maxPortes;
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

    public Circuit recombinacio(Circuit circuit1, Circuit circuit2){
        int nPortesFill;
        // El número de portes del fill estarà entre el dels progenitors
        if(circuit1.nPortes > circuit2.nPortes){
            nPortesFill = rand.nextInt(circuit1.nPortes - circuit2.nPortes) + circuit2.nPortes;
            nPortesFill = mutacioNPortes(nPortesFill);

        } else if(circuit2.nPortes > circuit1.nInputs){
            nPortesFill = rand.nextInt(circuit2.nPortes - circuit1.nPortes) + circuit1.nPortes;
            nPortesFill = mutacioNPortes(nPortesFill);

        } else {
            nPortesFill = circuit1.nPortes;
            nPortesFill = mutacioNPortes(nPortesFill);

        }
        
        Circuit fill = new Circuit(nPortesFill);
        for(int i = 0; i < nPortesFill; i++){       // Hauré de mirar si en lloc de dixar un numero aleatori entre les dos portes mos quedem en un nPortes o un altre
            while(i < circuitMenor.nPortes){
                if(rand.nextDouble() < 0.5){
                    fill.llistaPortes[i] = circuitMenor.llistaPortes[i];
                    fill.indexConnect[j]
                }
            }
        }
        return circuit1;
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
