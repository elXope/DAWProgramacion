package Control02;

import java.util.Arrays;
import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese numero: ");
        String strNumero = lector.nextLine();
        lector.close();

        if (strNumero.length() != 3) {
            System.out.println("Tiene que ser un entero de tres dígitos");
            return;
        }

        char[] charNumero = new char[3];
        byte i = 2;
        for (char digito : strNumero.toCharArray()) {
            charNumero[i] = digito;
            i--;
        }
        
        for (char car : charNumero) {
            System.out.print(car);
        }
        System.out.println("");
    }
}