import java.util.Scanner;

public class Ejemplo8y9 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);

        System.out.println("Introduix la teua edat: ");
        final byte edat = llig.nextByte();
        llig.close();

        if(edat >= 18){
            System.out.println("Tens la edat legal.");
        }else{
            System.out.println("No tens la edat legal.");
        }
    }
}
