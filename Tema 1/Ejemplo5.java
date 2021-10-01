import java.util.Scanner;

public class Ejemplo5 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);

        System.out.println("Este programa sumara, restara, multiplicara i dividira dos numeros introduits per l'usuari. Introduix un número: ");
        float x = llig.nextFloat();

        System.out.println("Introduix el segon numero: ");
        float y = llig.nextFloat();
        llig.close();
        
        System.out.println("La suma dona " + (x + y) + ", la resta " + (x - y) + ", la multiplicació " + (x * y) + " i la divisió " + (x/y) + ".");
    }    
}
