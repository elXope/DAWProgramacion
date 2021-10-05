public class provetes {
    public static void main(String[] args) {
        Porta[] llista = new Porta[3];
        llista[0] = new Porta(1);
        llista[1] = new Porta(0);
        llista[2] = new Porta(0);
        Circuit circo = new Circuit(llista);
        System.out.println(circo.nPortes);
        System.out.println(circo.llistaPortes[0].ixida(false, true));
    }
    //prova
}
