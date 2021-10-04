import java.util.Scanner;

public class Ejemplo26 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        System.out.println("Introduix un número: ");
        int num = llig.nextInt();
        llig.close();
        for (byte i = 1; i <= 10; i++){
            System.out.println(num + " * " + i + " = " + (num*i));
        }
    }
}