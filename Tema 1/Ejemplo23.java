import java.util.Scanner;
import java.util.ArrayList;

public class Ejemplo23 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<Double> positius = new ArrayList<Double>();
        double provisional;

        do {
            System.out.println("Introduix un número: ");
            provisional = lector.nextDouble();
            if(provisional > 0){
                positius.add(provisional);
            }
        } while (provisional != 0);
        lector.close();

        System.out.println("Els números positius són: ");
        for(Double numPositiu : positius){
            System.out.print(numPositiu + " ");
        }
        System.out.print("\n");
    }
}
