import java.util.Scanner;

public class Ejemplo25 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        System.out.println("Introduix un número: ");
        long factorial = llig.nextLong();
        llig.close();

        for (long i = factorial - 1; i > 0; i--){
            factorial = factorial*i;
        }

        System.out.println("Factorial: " + factorial);
    }
}

