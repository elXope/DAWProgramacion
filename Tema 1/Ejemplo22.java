import java.util.Scanner;
import java.util.ArrayList;

public class Ejemplo22 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ArrayList<Double> positius = new ArrayList<Double>();
        double provisional;

        for(int i = 0; i < 10; i++){
            System.out.println("Introduix un numero (" + (i+1) + "/10): ");
            provisional = lector.nextDouble();
            
            if(provisional > 0){
                positius.add(provisional);
            }
        }
        lector.close();
        
        for (Double numPositiu : positius) {
            System.out.print(numPositiu + " ");
        }
        System.out.print("\n");
    }
}
