import java.util.ArrayList;
import java.util.Random;

public class Circuit {
    Porta[] llistaPortes; //vector amb totes les portes
    byte nPortes; //número de portes
    byte[][] indexConnect; // el índex de la porta en la llista de outputs (si tenim 3 inputs la primera porta serà el ind 3)
    byte nInputs = 3; //numero de inputs. Per ara use tres sempre.
    boolean[][] solucio; //serà la matriu on se guardaran les solucions del circuit, és a dir, la solucio de la taula de la veritat per a les portes en les que el output no està connectat a res.
    int[] indexIxides; //índex de les ixides de un sistema


    Circuit(int nPortes){
        this.nPortes = (byte)nPortes;
        this.llistaPortes = new Porta[nPortes];
        this.indexConnect = new byte[nPortes][3];
    }
    
    // CONSTRUCTOR se necessiten les portes i com estan connectades.
    Circuit(Porta[] llistaPortes, byte[][] indexConnect){
        this.llistaPortes = llistaPortes;
        this.nPortes = (byte)llistaPortes.length;
        this.indexConnect = indexConnect;
        indIx();
    }
    
    // Principal métode del circuit, dóna la solució
    public void taulaVeritat(){
        //INPUTS
        boolean[][] input = inputComb();
        int contEstats = 0; //per a vore en quin estat dels inputs està ja que mhe posat fancy i he fet el bucle sense index
        
        //OUTPUTS
        this.solucio = new boolean[this.indexIxides.length][input.length]; //Inicialitzem la solució. Per ara guardarà tots els outputs de totes les portes.
        int contSolucions = 0;

        boolean[][] output = new boolean[this.nInputs + this.nPortes][2]; //1a col: true si hi ha output. 2a el output. quan se crea per default posa un "false".
        output[0][0] = true; //els inputs sempre tenen "output"
        output[1][0] = true;
        output[2][0] = true;        
        
        /*
        Bucles on s'executa la part principal i més llarga del codi.
        Primer bucle: recorre tota la taula d'estats dels inputs.
        Segon bucle: per a cada estat se busca el output de totes les portes. La funció recursiva actua des d'una porta
            cap als inputs. En el plantejament del programa s'establix que qualsevol porta amb un output que no estiga connectat a res,
            se considerarà output del sistema.
        Tercer bucle: per a cada estat se guarden els outputs de totes les portes en la variable de circuit "solucio".
        */
        for(boolean[] estats : input){ 
            // assignem als estats dels inputs
            output[0][1] = estats[0];
            output[1][1] = estats[1];
            output[2][1] = estats[2];

            contSolucions = 0;
            for (int i : this.indexIxides){
                //System.out.println(this.indexConnect[i][0] +" "+ this.indexConnect[i][1] +" "+ this.indexConnect[i][2]);
                output = solucioFrac(this.indexConnect[i], output);
                this.solucio[contSolucions][contEstats] = output[i+3][1];
                contSolucions++;
            }

            contEstats++;
        }
    }

    // Increible funció recursiva per a trobar els outputs de totes les portes
    private boolean[][] solucioFrac(byte[] conexio, boolean[][] output){   //1r arg: una fila de indexConnect. 2n arg: el output.
        if (!output[conexio[0]][0]){   //si NO té solució entra en el if. HI HA UN NOT!!
            if(!output[conexio[1]][0]){
                output = solucioFrac(this.indexConnect[conexio[1]-3], output);
            }
            if(!output[conexio[2]][0]){
                output = solucioFrac(this.indexConnect[conexio[2]-3], output);
            }
            output[conexio[0]][1] = this.llistaPortes[conexio[0]-3].ixida(output[conexio[1]][1], output[conexio[2]][1]);
            return output;
        } else{
            return output;
        }
    }

    //Per a trobar els index de les ixides del sistema
    private void indIx(){
        ArrayList<Integer> indexProv = new ArrayList<Integer>();
        boolean noEsInd;
        for(int i = 0; i < this.indexConnect.length - 1; i++){
            noEsInd = false;
            for(int j = i+1; j < this.indexConnect.length; j++){
                if(this.indexConnect[i][0] == this.indexConnect[j][1] || this.indexConnect[i][0] == this.indexConnect[j][2]){
                    noEsInd = true;
                    break;
                }
            }
            if(!noEsInd){
                indexProv.add(i);
            }
        }
        indexProv.add(this.indexConnect.length - 1);
        this.indexIxides = new int[indexProv.size()];
        for(int i = 0; i < indexProv.size(); i++){
            this.indexIxides[i] = indexProv.get(i).intValue();
        }
    }

    public void display(){
        // Per a imprimir les ixides per pantalla
        for(boolean[] i : this.solucio){
            for(boolean j : i){
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }

    // Ara no té arguments però vull arribar a posar el nº d inputs com a argument de Circuit.
    private boolean[][] inputComb(){
        boolean[][] input = new boolean[8][3]; 
        input[0][0] = false;
        input[0][1] = false;
        input[0][2] = false;
        input[1][0] = false;
        input[1][1] = false;
        input[1][2] = true;
        input[2][0] = false;
        input[2][1] = true;
        input[2][2] = false;
        input[3][0] = false;
        input[3][1] = true;
        input[3][2] = true;
        input[4][0] = true;
        input[4][1] = false;
        input[4][2] = false;
        input[5][0] = true;
        input[5][1] = false;
        input[5][2] = true;
        input[6][0] = true;
        input[6][1] = true;
        input[6][2] = false;
        input[7][0] = true;
        input[7][1] = true;
        input[7][2] = true;
        return input;
    }

    public void aleatori(){
        Random rand = new Random();
        for (int i = 0; i < this.nPortes; i++){
            this.llistaPortes[i] = new Porta(rand.nextInt(3));
            this.indexConnect[i][0] = (byte)(i + 3);
            this.indexConnect[i][1] = (byte)rand.nextInt(i+3);
            if(this.llistaPortes[i].tipo == 2){
                this.indexConnect[i][2] = this.indexConnect[i][1];
            }else{
                this.indexConnect[i][2] = (byte)rand.nextInt(i+3);
            }
        }
        indIx();
    }
}