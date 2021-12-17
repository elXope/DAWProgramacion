import java.util.Scanner;

public class Ejemplo16 {
    public static void main(String[] args) {
        Scanner llig = new Scanner(System.in);

        System.out.println("Introduix quina operació vols fer.\nHa de ser de l'estil 'a + b' i pots usar un d'estos quatre operadors: +, -, * o /.");
        String operacio = "";
        
        while (true) {
            operacio = llig.nextLine();

            operacio = operacio.replace(" ","");
            String[] numsStr;

            if(operacio.equalsIgnoreCase("fin")){
                break;
            }else if(operacio.contains("+")){
                numsStr = operacio.split("\\+");
                System.out.println(Double.parseDouble(numsStr[0]) + Double.parseDouble(numsStr[1]));
            }else if(operacio.contains("-")){
                numsStr = operacio.split("-");
                System.out.println(Double.parseDouble(numsStr[0]) - Double.parseDouble(numsStr[1]));
            }else if(operacio.contains("*")){
                numsStr = operacio.split("\\*");
                System.out.println(Double.parseDouble(numsStr[0]) * Double.parseDouble(numsStr[1]));
            }else if(operacio.contains("/")){
                numsStr = operacio.split("\\/");
                System.out.println(Double.parseDouble(numsStr[0]) / Double.parseDouble(numsStr[1]));
            }else{
                System.out.println("Operació no vàlida.");
            }
        }
        llig.close();
    }
}
