import java.util.Scanner;

public class Ejemplo16 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);

        System.out.println("Introduix quina operació vols fer.\nHa de ser de l'estil 'a + b' i pots usar un d'estos quatre operadors: +, -, * o /.\nNOMÉS NUMEROS ENTERS. Divisió entera.");
        String operacio = llig.nextLine();
        operacio = operacio.replace(" ","");
        String[] numsStr;

        if(operacio.contains("+")){
            //
            numsStr = operacio.split("\\+");
            System.out.println(Integer.parseInt(numsStr[0]) + Integer.parseInt(numsStr[1]));
        }else if(operacio.contains("-")){
            numsStr = operacio.split("-");
            System.out.println(Integer.parseInt(numsStr[0]) - Integer.parseInt(numsStr[1]));
        }else if(operacio.contains("*")){
            numsStr = operacio.split("\\*");
            System.out.println(Integer.parseInt(numsStr[0]) * Integer.parseInt(numsStr[1]));
        }else if(operacio.contains("/")){
            numsStr = operacio.split("\\/");
            System.out.println(Integer.parseInt(numsStr[0]) / Integer.parseInt(numsStr[1]));
        }else{
            System.out.println("Operació no vàlida.");
        }
        
    }
}
