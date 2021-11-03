public class Primos {
    public static void primos(){
        for (int i = 3; i <= 100; i++) {
            if(Primo.esPrimo(i)){
                System.out.print(i + " ");
            }
        }
    }
}
