package Control02;

import java.util.Scanner;

public class E06 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingrese cateto a: ");
        double a = lector.nextDouble();

        System.out.print("Ingrese cateto b: ");
        double b = lector.nextDouble();

        System.out.println("La hipotenusa es " + (Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))));
    }
}
