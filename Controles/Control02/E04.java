package Control02;

import java.util.Scanner;

public class E04 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese longitud: ");
        double cm = lector.nextDouble();
        System.out.println(cm + " cm = " + cm/2.54 + " in");        
    }
}