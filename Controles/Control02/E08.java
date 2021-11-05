package Control02;

import java.util.Scanner;

public class E08 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        double num = lector.nextDouble();
        lector.close();
        System.out.println(Math.abs(num - (int)num));
    }
}
