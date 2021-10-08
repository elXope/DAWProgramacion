public class Porta {

    byte tipo; // 0 AND, 1 OR, 3 NOT

    Porta(int tipo){
        this.tipo = (byte)tipo;
    }

    public void inicialitzar(int tipo){
        this.tipo = (byte)tipo;
    }

    public boolean ixida(boolean a, boolean b){
        // triar 0, 1 o 2 per a fer AND, OR o NOT
        switch (this.tipo){
            case 0:
                return a && b;

            case 1:
                return a || b;

            case 2:
                return !a;

            case 3: 
                return a ^ b;

            default:
                System.out.println("Hi ha un error en el metode tria de Porta");
                return false;  
        }
    }
}
