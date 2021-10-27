public class Mates {
    public static void main(String[] args) {
        double a = 10.5, b = 5.25;
        System.out.println(suma(a, b));
        System.out.println(resta(a, b));
        System.out.println(multiplicacion(a, b));
        System.out.println(division(a, b));
    }

    public static double suma(double d1, double d2){
        return d1 + d2;
    } 

    public static double resta(double d1, double d2){
        return d1 - d2;
    }

    public static double multiplicacion(double d1, double d2){
        return d1 * d2;
    }

    public static double division(double d1, double d2){
        return d1 / d2;
    }
}
