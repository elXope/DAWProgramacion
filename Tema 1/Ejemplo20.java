import java.util.Scanner;

public class Ejemplo20 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        double precioInicial;

        System.out.println("Introduix el preu: ");
        precioInicial = lector.nextDouble();
        lector.close();

        if (precioInicial < 0 ){
            System.out.println("No introduixca preus negatius.");
        } else if (precioInicial < 6){
            System.out.println(precioInicial);
        } else if (precioInicial < 60){
            System.out.println(precioInicial - precioInicial * 0.05);
        } else {
            System.out.println(precioInicial - precioInicial * 0.1);
        }
    }
}
