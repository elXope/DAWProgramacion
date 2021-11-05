package Control02;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class E02 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese el radio: ");
        double radi = lector.nextDouble();
        lector.close();

        double perimetre = round(2*Math.PI*radi, 1);
        double area = round(Math.PI*radi*radi, 1);

        System.out.println("Perimetro: " + perimetre);
        System.out.println("Área: " + area);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
