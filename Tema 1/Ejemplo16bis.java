import java.util.Scanner;

public class Ejemplo16bis {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        final double num1, num2;
        final String operacio;

        System.out.println("Introduix la operació que vols fer (+,-,*,/): ");
        operacio = llig.next();
        System.out.println("Introduix el primer número: ");
        num1 = llig.nextDouble();
        System.out.println("Introduix el segon número: ");
        num2 = llig.nextDouble();
        llig.close();

        if(operacio.contains("+")){
            System.out.println(num1 + num2);
        }else if(operacio.contains("-")){
            System.out.println(num1 - num2);
        }else if(operacio.contains("*")){
            System.out.println(num1 * num2);
        }else if(operacio.contains("/")){
            System.out.println(num1 / num2);
        }else{
            System.out.println("La operació no és vàlida.");
        }
    }
}
