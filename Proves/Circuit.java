import java.util.Random;

public class Circuit {
    Porta[] llistaPortes;
    byte nPortes;
    byte[][] indexConnect; // Index, input 1, input 2
    boolean a;
    boolean b;
    boolean c;

    Circuit(Porta[] llistaPortes){
        this.llistaPortes = llistaPortes;
        this.nPortes = (byte)llistaPortes.length;
    }

    Circuit(int nPortes){
        this.nPortes = (byte)nPortes;
    }
    
    public void inicialitza(){
        this.indexConnect = new byte[this.nPortes][3];
        Random rand = new Random();

        for (byte i = 0; i < this.nPortes; i++){
            this.llistaPortes[i] = new Porta(rand.nextInt(3));
            this.indexConnect[0][i] = i;
            // POSE LES CONNEXIONS JA AMB LO ALTRE. FALTARIA COM DECIDIR SI A, B O C O TOTES LES ANTERIORS.
        }
    }
}
