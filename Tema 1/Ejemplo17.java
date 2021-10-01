import java.util.Scanner;

public class Ejemplo17 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        System.out.println("Escriu el número del mes: ");
        final byte mes = llig.nextByte();
        llig.close();

        if (mes > 12 || mes < 1) {
            System.out.println("Número del mes no vàlid.");
        }else if (mes == 2) {
            System.out.println(28);
        }else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            System.out.println(30);
        }else {
            System.out.println(31);
        }
    }
}
