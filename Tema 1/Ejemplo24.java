import java.util.Scanner;

public class Ejemplo24 {
    public static void main(String[] args) {
        boolean wasTen = false;
        float sum = 0;
        short i = 0;
        Scanner llig = new Scanner(System.in);

        System.out.println("Introduix les notes una a una (per a parar el programa escriure '-1'): ");
        float grade = llig.nextFloat();

        while (grade != -1){
            sum = sum + grade;
            i++;
            if (grade == 10){
                wasTen = true;
            }
            grade = llig.nextFloat();
        }

        System.out.println("Average: " + (sum/i));

        if (wasTen){
            System.out.println("There was a ten.");
        }else{
            System.out.println("There was not a ten.");
        }
    }
}
