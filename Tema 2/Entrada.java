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
        //lector.close();  No tanquem el lector perquè té una dependència el programa amb Sysin i se ralla (no ho acabe d'entendre)
        return enter;
    }

    public static double getDouble(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduix un double: ");
        while (!lector.hasNextDouble()){
            lector.nextLine();
            System.out.println("Això no és un double. Introduix un double: ");
        }
        double doble = lector.nextDouble();
        //lector.close();
        return doble;
    }

    public static int getInteger2(){
        Scanner lector = new Scanner(System.in);
        int enter = 0;
        System.out.println("Introduix un número enter: ");
        if (!lector.hasNextInt()){
            System.out.println("Això no és un enter.");
            enter = getInteger();
        }else{
            enter = lector.nextInt();
        }
        return enter;
    }

    public static double getDouble2(){
        Scanner lector = new Scanner(System.in);
        double doble = 0;
        System.out.println("Introduix un número double: ");
        if (!lector.hasNextDouble()){
            System.out.println("Això no és un double.");
            doble = getDouble();
        }else{
            doble = lector.nextDouble();
        }
        return doble;
    }

}
