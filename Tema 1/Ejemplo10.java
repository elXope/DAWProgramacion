import java.util.Scanner;

public class Ejemplo10 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);

        System.out.println("Introduix un número: ");
        final float num = llig.nextFloat();
        llig.close();

        if(num < 0){
            System.out.println("El número introduït és negatiu.");
        }else{
            System.out.println("El número introduït és positiu.");
        }
    }
}
