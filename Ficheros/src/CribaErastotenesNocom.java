
public class CribaErastotenes {

    private int nMax; 
    private int dim;
    private boolean[] esPrimo;
    

    public CribaErastotenes(int nMax) {
        
        this.nMax = nMax;
        this.dim = nMax + 1;
        this.inicializaVectorBoolean();
    }


    public void setNMax(int nMax) {
        this.nMax = nMax;
        this.dim = nMax + 1;
        this.inicializaVectorBoolean();
    }

    private void inicializaVectorBoolean() {
        this.esPrimo = new boolean[this.dim];
        for (int i = 2; i < this.dim; i++) {
            this.esPrimo[i] = true;
        }
    }


    public int[] vectorPrimos() {
        
        this.ejecutaCribaErastotenes();
        return this.generaVectorPrimos(); 
    }

    private void ejecutaCribaErastotenes() {
        for (int i = 2; i <= Math.sqrt(this.nMax); i++) {
            if (this.esPrimo[i]) {
                for (int j = 2 * i; j < this.dim; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    private int[] generaVectorPrimos() {
        int[] vectorPrimos = new int[this.cuentaNPrimos()];
        int j = 0;
        for (int i = 0; i < this.dim; i++) {
            if (this.esPrimo[i]) {
                vectorPrimos[j++] = i;
            }
        }
        return vectorPrimos;
    }

    private int cuentaNPrimos() {
        int cuenta = 0;
        for (int i = 2; i < this.dim; i++) {
            if (this.esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

}
