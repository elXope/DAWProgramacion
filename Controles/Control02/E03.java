package Control02;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class E03 {
    public static void main(String[] args) {
        String[] ordre = {"Primera", "Segunda", "Tercera", "Cuarta"};
        double mitjana = 0;
        Scanner lector = new Scanner(System.in);

        for (String posicio : ordre) {
            System.out.print(posicio + " nota: ");
            mitjana += lector.nextDouble();
        }

        mitjana = round(mitjana/4, 2);

        System.out.println("El promedio es: " + mitjana);        
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}