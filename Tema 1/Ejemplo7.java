import java.util.Scanner;
public class Ejemplo7 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);
        boolean incorrecte = true;
        float preu = 0;
        float preuRebaixat = 0;
        // No sé perquè no me dixa usar-los sense inicialitzar-los.

        while(incorrecte){
            System.out.println("Introduix el preu inicial: ");
            preu = llig.nextFloat();

            System.out.println("Introduix el preu rebaixat: ");
            preuRebaixat = llig.nextFloat();

            if(preu < preuRebaixat){
                System.out.println("El preu rebaixat no pot ser major que el original.");
            }else{
                incorrecte = false;
            }
        }
        llig.close();
        final float rebaixa = (preu - preuRebaixat)/preu * 100;
        System.out.println("La rebaixa és del " + rebaixa + "%.");
    }
}
