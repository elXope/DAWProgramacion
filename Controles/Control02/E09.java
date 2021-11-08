package Control02;

import java.util.Scanner;

public class E09 { 
    public static void main(String[] args) {
        int c1, c2, nl;
        int nf = 60;
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese nota certamen 1: ");
        c1 = lector.nextInt();
        System.out.print("Ingrese nota certamen 2: ");
        c2 = lector.nextInt();
        System.out.print("Ingrese nota laboratorio: ");
        nl = lector.nextInt();
        lector.close();
        System.out.println("Necesita nota " + notaC3(c1, c2, nl, nf) + " en el certamen 3.");
    }

    private static double notaC3(int c1, int c2, int nl, int nf){
        return 3*(nf - nl*0.3)/0.7 - c1 - c2;
    }
}
