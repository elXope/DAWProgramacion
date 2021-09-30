import java.util.Scanner;

public class Ejemplo14 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        boolean seguir = true;
        byte nota;

        while(seguir){
            System.out.println("Introduix la nota de l'examen (0 - 10): ");
            nota = llig.nextByte();

            if(nota < 0 || nota > 10){
                System.out.println("Nota no vàlida. La nota ha d'anar de 0 a 10.");
            }else if(nota < 3){
                System.out.println("Molt deficient.");
                seguir = false;
            }else if(nota < 5){
                System.out.println("Insuficient.");
                seguir = false;
            }else if(nota < 6){
                System.out.println("Suficient.");
                seguir = false;
            }else if(nota < 7){
                System.out.println("Bé.");
                seguir = false;
            }else if(nota < 9){
                System.out.println("Notable.");
                seguir = false;
            }else{
                System.out.println("Excel·lent.");
                seguir = false;
            }
        }
        

    }
}
