import java.util.Scanner;
// import java.lang.String;

public class Ejemplo47bis {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        System.out.println("Introduix una frase: ");
        String frase = llig.nextLine();
        llig.close();
        String[] frases = frase.split(" ");
        byte maxChars = 0;

        for (String linia : frases){
            if (linia.length() > maxChars){
                maxChars = (byte)linia.length();
            }
        }

        int cont = 0;

        for (byte i = 0; i < frases.length + 2; i++){
            for(byte j = 0; j < maxChars + 2; j++){
                if(i == 0 || i == frases.length + 1 || j == 0 || j == maxChars + 1){
                    System.out.print("* ");
                } else if (cont < frases[i-1].length()){
                    System.out.print(frases[i-1].charAt(cont) + " ");
                    cont++;
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
            cont = 0;
        }
    }
}
