import java.util.Scanner;

public class Ejemplo19 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        final short eurosh, hores;
        float pagoBrut, souNet, impostos;

        System.out.println("Introduix els euros/hora:");
        eurosh = llig.nextByte();
        System.out.println("Introduix les hores:");
        hores = llig.nextByte();

        if (hores > 35) {
            pagoBrut = 35*eurosh + (float)1.5*eurosh*(hores - 35);  
        } else {
            pagoBrut = 35*eurosh;
        }
        
        if (pagoBrut > 900) {
            impostos = 400*(float).25 + (pagoBrut - 900)*(float).45;
        } else if (pagoBrut > 500) {
            impostos = pagoBrut;
        }

    }
}
