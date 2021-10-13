import java.util.Scanner;

public class Ejemplo21 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce un año: ");
        int any = lector.nextInt();
        lector.close();

        if (any % 4 == 0){
            if (any < 400){
                System.out.println("El " + any + " es bisiesto.");
            } else {
                if(any % 100 == 0 && any % 400 != 0){
                    System.out.println("El " + any + " no es bisiesto.");
                } else {
                    System.out.println("El " + any + " es bisiesto.");
                }
            }
        } else {
            System.out.println("El " + any + " no es bisiesto.");

        }
    }
}
