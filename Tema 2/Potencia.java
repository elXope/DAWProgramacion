public class Potencia {
    public static double potencia(double base, int exponent){
        if (exponent == 0){
            return 1;
        }else if (exponent > 0){
            return base * potencia(base, exponent - 1);
        }else {
            return 1 / (base * potencia(base, -exponent - 1));
        }
    }
}
