public class Primo {
    public static boolean esPrimo(int num){
        for (int i = 2; i <= num/2; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}