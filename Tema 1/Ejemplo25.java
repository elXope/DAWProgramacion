import java.util.Scanner;

public class Ejemplo25 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        System.out.println("Introduix un número enter: ");
        long factorial = llig.nextLong();
        llig.close();

        if (factorial < 0) return;
        for (long i = factorial - 1; i > 0; i--){
            factorial *= i;
        }

        System.out.println("Factorial: " + factorial);
    }
}

