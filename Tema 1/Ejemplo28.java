import java.util.Scanner;

public class Ejemplo28 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Por favor ingrese un número a evaluar");
        int a = lector.nextInt();
        lector.close();

        int cont = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                cont++;
            }
        }

        if (cont == 2) {
            System.out.println(a + " es un número primo");
        } else {
            System.out.println(a + " no es un número primo");
        }
    }
}
