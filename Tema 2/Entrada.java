import java.util.Scanner;

public class Entrada {
    public static int getInteger(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduix un número enter: ");
        while (!lector.hasNextInt()){
            lector.nextLine();
            System.out.println("Això no és un enter. Introduix un número enter: ");
        }
        int enter = lector.nextInt();
        lector.close();
        return enter;
    }

    public static double getDouble(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduix un double: ");
        while (!lector.hasNextDouble()){
            lector.nextLine();
            System.out.println("Això no és un double. Introduix un double: ");
        }
        double d = lector.nextDouble();
        lector.close();
        return d;
    }

    public static int getInteger2(){
        Scanner lector = new Scanner(System.in);
        int enter = 0;
        System.out.println("Introduix un número enter: ");
        if (!lector.hasNextInt()){
            System.out.println("Això no és un enter.");
            lector.close();
            enter = getInteger();
        }else{
            enter = lector.nextInt();
            lector.close();
        }
        return enter;
    }

}
