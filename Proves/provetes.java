public class provetes {
    public static void main(String[] args) {
        Porta[] llista = new Porta[3];
        llista[0] = new Porta(1);
        llista[1] = new Porta(1);
        llista[2] = new Porta(1);
        //Circuit circo = new Circuit(llista);
        //System.out.println(circo.nPortes);
        //System.out.println(circo.llistaPortes[0].ixida(false, true));


        byte[][] plantilla = new byte[3][3];
        plantilla[0][0] = 3;
        plantilla[0][1] = 0;
        plantilla[0][2] = 1;
        plantilla[1][0] = 4;
        plantilla[1][1] = 1;
        plantilla[1][2] = 2;
        plantilla[2][0] = 5;
        plantilla[2][1] = 3;
        plantilla[2][2] = 4;

        Circuit circo = new Circuit(llista, plantilla);
        circo.taulaVeritat();


    }
}
