package EvoCircuit;

public class Porta {
    boolean input1;
    boolean input2;
    byte codi;
    String tipo;

    Porta(boolean input1){
        this.tipo = "not";
        this.codi = 0;
        this.input1 = input1;
    }

    Porta(byte codi, boolean input1, boolean input2){
        this.codi = codi;
        switch (codi) {
            case 1:
                this.tipo = "and";
                break;
            case 2:
                this.tipo = "or";
                break;
            default:
            System.out.println("1 -> and\n2 -> or");
                break;
        }
        this.input1 = input1;
        this.input2 = input2;
    }
}
