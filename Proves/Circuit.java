import java.util.Random;

public class Circuit {
    Porta[] llistaPortes;
    byte nPortes;
    byte[][] indexConnect; // input 1, input 2
    boolean a;
    boolean b;
    boolean c;
    byte nInputs = 3;
    boolean[][] solucio;

    Circuit(Porta[] llistaPortes){
        this.llistaPortes = llistaPortes;
        this.nPortes = (byte)llistaPortes.length;
    }

    Circuit(int nPortes){
        this.nPortes = (byte)nPortes;
    }

    Circuit(Porta[] llistaPortes, byte[][] indexConnect){
        this.llistaPortes = llistaPortes;
        this.nPortes = (byte)llistaPortes.length;
        this.indexConnect = indexConnect;
    }

    public void taulaVeritat(){
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
        
        boolean[][] output = new boolean[this.nInputs + this.nPortes][2]; //1a col: true si hi ha output. 2a el output.
        output[0][0] = true;
        output[1][0] = true;
        output[2][0] = true;        

        int contEstats = 0;
        this.solucio = new boolean[this.nInputs][input.length];
        for(boolean[] estats : input){ //canviar inputs OJOOOOOOOO CONCORDAR EN LO DE DALT
            output[0][1] = estats[0];
            output[1][1] = estats[1];
            output[2][1] = estats[2];

            for (int i = 1; i <= this.indexConnect.length; i++){
                output = solucioFrac(this.indexConnect[this.indexConnect.length-i], output);
            }
            for (int i = 0; i < this.solucio.length; i++){
                this.solucio[i][contEstats] = output[i+3][1];
            }
            /*for (int i = this.nPortes - 1; i >= 0; i--){

            }*/
            contEstats++;
        }
        for(int i = 0; i < solucio.length; i++){
            for(int j = 0; j < solucio[0].length; j++){
                System.out.print(solucio[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private boolean[][] solucioFrac(byte[] conexio, boolean[][] output){   //Una fila de indexConnect
        if (!output[conexio[0]][0]){   //si NO té solució, HI HA UN NOT
            if(!output[conexio[1]][0]){
                output = solucioFrac(this.indexConnect[conexio[1]-3], output);  //igual hem de fer que retorne output
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
    
    /*public void inicialitza(){
        this.indexConnect = new byte[this.nPortes][3];
        Random rand = new Random();

        for (byte i = 0; i < this.nPortes; i++){
            this.llistaPortes[i] = new Porta(rand.nextInt(3));
            this.indexConnect[0][i] = i;
            // POSE LES CONNEXIONS JA AMB LO ALTRE. FALTARIA COM DECIDIR SI A, B O C O TOTES LES ANTERIORS.
        }
    }*/
}
