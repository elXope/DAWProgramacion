import java.util.Scanner;

public class Ejemplo27 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduix un número enter positiu: ");
        int n = lector.nextInt();
        lector.close();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }
}
