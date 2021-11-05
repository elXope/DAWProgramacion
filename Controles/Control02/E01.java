package Control02;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class E01 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        System.out.println("Hola, " + lector.next());
        lector.close();
    }
}
