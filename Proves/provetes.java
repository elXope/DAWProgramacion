public class provetes {
    public static void main(String[] args) {
        And i = new And(true, true);
        System.out.println(i.ixida);
        portes[] llista = new portes[2];
        llista[0] = new And();
        llista[1] = new And();
        circuit circo = new circuit(llista);
        circo.llistaPortes[0].inicialitzar(true, true);
        System.out.println(circo.llistaPortes[0].ixida);
    }
}
