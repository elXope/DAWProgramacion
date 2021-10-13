public class provetes {
    public static void main(String[] args) {
        /*Circuit circo = new Circuit(5);
        circo.taulaVeritat();
        circo.display();

        for(int i = 0; i < circo.indexConnect.length; i++){
            System.out.println(circo.indexConnect[i][1] + " " + circo.indexConnect[i][2]);
        }
        for(int i = 0; i < circo.llistaPortes.length; i++){
            System.out.println(circo.llistaPortes[i].tipo);
        }*/

        //CIRCUIT FULL ADDER
        Porta[] llista = new Porta[13];
        llista[0] = new Porta(0);
        llista[1] = new Porta(2);
        llista[2] = new Porta(1);
        llista[3] = new Porta(0);
        llista[4] = new Porta(0);
        llista[5] = new Porta(0);
        llista[6] = new Porta(0);
        llista[7] = new Porta(0);
        llista[8] = new Porta(2);
        llista[9] = new Porta(1);
        llista[10] = new Porta(0);
        llista[11] = new Porta(1);
        llista[12] = new Porta(1);

        byte[][] plantilla = new byte[13][3];
        plantilla[0][0] = 3; // xor
        plantilla[0][1] = 1;
        plantilla[0][2] = 2;
        plantilla[1][0] = 4;
        plantilla[1][1] = 3;
        plantilla[1][2] = 3;
        plantilla[2][0] = 5;
        plantilla[2][1] = 1;
        plantilla[2][2] = 2;
        plantilla[3][0] = 6;
        plantilla[3][1] = 4;
        plantilla[3][2] = 5; // fin xor
        plantilla[4][0] = 7;
        plantilla[4][1] = 1;
        plantilla[4][2] = 2;
        plantilla[5][0] = 8;
        plantilla[5][1] = 0;
        plantilla[5][2] = 1;
        plantilla[6][0] = 9;
        plantilla[6][1] = 0;
        plantilla[6][2] = 2;
        plantilla[7][0] = 10; // xor
        plantilla[7][1] = 0;
        plantilla[7][2] = 6;
        plantilla[8][0] = 11;
        plantilla[8][1] = 10;
        plantilla[8][2] = 10;
        plantilla[9][0] = 12;
        plantilla[9][1] = 6;
        plantilla[9][2] = 0;
        plantilla[10][0] = 13;
        plantilla[10][1] = 11;
        plantilla[10][2] = 12; // fin xor
        plantilla[11][0] = 14;
        plantilla[11][1] = 7;
        plantilla[11][2] = 8;
        plantilla[12][0] = 15;
        plantilla[12][1] = 14;
        plantilla[12][2] = 9;
        


        Circuit cirkuit1 = new Circuit(llista, plantilla);
        cirkuit1.taulaVeritat();
        Circuit cirkuit2 = new Circuit(20);
        cirkuit2.aleatori();
        cirkuit2.taulaVeritat();

        EvoCircuit circo2 = new EvoCircuit(cirkuit1.solucio, 1000, 101);
        /*circo2.displayCircuit(5);
        System.out.println(circo2.fitness(circo2.poblacio[5]));*/
        Circuit pepe = circo2.procrear(cirkuit2, cirkuit1);
        pepe.taulaVeritat();
        cirkuit1.displayPublic();
        cirkuit2.displayPublic();
        pepe.displayPublic();
    }
}
