import java.util.Scanner;
// import java.lang.String;

public class Ejemplo27 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        System.out.println("Introduix una frase: ");
        String frase = llig.nextLine();
        System.out.println("Introduix l'alçada del cartell: ");
        int files = llig.nextInt();
        System.out.println("Introduix l'amplada del cartell: ");
        int columnes = llig.nextInt();
        llig.close();

        int cont = 0;

        for (byte i = 0; i < files; i++){
            for(byte j = 0; j < columnes; j++){
                if(i == 0 || i == files-1 || j == 0 || j == columnes-1){
                    System.out.print("* ");
                } else if (cont < frase.length()){
                    System.out.print(frase.charAt(cont) + " ");
                    cont++;
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }
    }
}
