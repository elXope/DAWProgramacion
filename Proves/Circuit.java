import java.util.ArrayList;

public class Circuit {
    Porta[] llistaPortes; //vector amb totes les portes
    byte nPortes; //número de portes
    byte[][] indexConnect; // el índex de la porta en la llista de outputs (si tenim 3 inputs la primera porta serà el ind 3)
    byte nInputs = 3; //numero de inputs. Per ara use tres sempre.
    boolean[][] solucio; //serà la matriu on se guardaran les solucions del circuit, és a dir, la solucio de la taula de la veritat per a les portes en les que el output no està connectat a res.
    int[] indexIxides; //índex de les ixides de un sistema

    // CONSTRUCTOR se necessiten les portes i com estan connectades. Hauré de fer un constructor per a circuits aleatoris o una classe que me cree els inputs aleatòriament.
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
        this.solucio = new boolean[this.nInputs][input.length]; //Inicialitzem la solució. Per ara guardarà tots els outputs de totes les portes.
        
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

            for (int i = this.indexConnect.length - 1; i >= 0; i--){
                output = solucioFrac(this.indexConnect[i], output);
            }

            for (byte i = 0; i < this.solucio.length; i++){
                this.solucio[i][contEstats] = output[i+3][1];
            }
            contEstats++;
        }

        // Per a imprimir les ixides per pantalla
        for(int i = 0; i < solucio.length; i++){
            for(int j = 0; j < solucio[0].length; j++){
                System.out.print(solucio[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    // Increible funció recursiva per a trobar els outputs de totes les portes
    private boolean[][] solucioFrac(byte[] conexio, boolean[][] output){   //1r arg: una fila de indexConnect. 2n arg: el output.
        if (!output[conexio[0]][0]){   //si NO té solució entra en el if. HI HA UN NOT!!
            if(!output[conexio[1]][0]){
                output = solucioFrac(this.indexConnect[conexio[1]-3], output);
                if(!output[conexio[2]][0]){
                    output = solucioFrac(this.indexConnect[conexio[2]-3], output);
                }
            }
            output[conexio[0]][1] = this.llistaPortes[conexio[0]-3].ixida(output[conexio[1]][1], output[conexio[2]][1]);
            return output;
        } else{
            return output;
        }
    }

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
}