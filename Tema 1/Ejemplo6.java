import java.util.Scanner;
import java.lang.Math;
public class Ejemplo6 {
    public static void main(String[] args) {        
        Scanner llig = new Scanner(System.in);

        System.out.println("Escriu el radi (m): ");
        final double radi = llig.nextFloat();
        llig.close();

        final double perimetre = 2*Math.PI*radi;
        final double area = Math.PI*Math.pow(radi, 2);

        System.out.println("El perímetre és de " + perimetre + "m i l'àrea de " + area + "m*m.");
    }
}
