import java.util.Scanner;

public class Ejemplo19 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        final short eurosh, hores;
        float pagoBrut, souNet, impostos;

        System.out.println("Introduix els euros/hora:");
        eurosh = llig.nextShort();
        System.out.println("Introduix les hores:");
        hores = llig.nextShort();
        llig.close();

        if (hores > 35) {
            pagoBrut = 35*eurosh + (float)1.5*eurosh*(hores - 35);  
        } else {
            pagoBrut = 35*eurosh;
        }
        
        if (pagoBrut > 900) {
            impostos = 400*(float).25 + (pagoBrut - 900)*(float).45;
        } else if (pagoBrut > 500) {
            impostos = (pagoBrut - 500)*(float).25;
        } else {
            impostos = 0;
        }

        souNet = pagoBrut - impostos;
        System.out.println("Sou net: " + souNet + "euros\nSou brut: " + pagoBrut + "euros\nImpostos: " + impostos + "euros");

    }
}
