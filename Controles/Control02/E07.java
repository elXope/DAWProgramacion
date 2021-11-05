package Control02;

import java.util.Scanner;

public class E07 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Hora actual: ");
        int t = lector.nextInt();

        System.out.print("Cantidad de horas: ");
        int h = lector.nextInt();
        lector.close();

        System.out.print("En " + h +" horas, el reloj marcara las ");

        if(h >= 12){
            h -= (h/12)*12;
        }
        if(t + h > 12){
            t = h - (12 - t);
        } else {
            t += h;
        }

        System.out.print(t + "\n");
    }
}