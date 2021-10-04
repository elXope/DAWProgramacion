import java.util.Scanner;

public class Ejemplo25 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        System.out.println("Introduix un número: ");
        int num = llig.nextInt();
        llig.close();
        long factorial = num;

        for (int i = num - 1; i > 0; i--){
            factorial = factorial*i;
        }

        System.out.println("Factorial: " + factorial);
    }
}
