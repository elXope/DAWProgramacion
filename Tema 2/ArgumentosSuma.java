public class ArgumentosSuma {
    public static void main(String[] args) {
        double resultat = 0;
        for (String string : args) {
            resultat += Double.parseDouble(string);
        }
        System.out.println(resultat);
    }
}
