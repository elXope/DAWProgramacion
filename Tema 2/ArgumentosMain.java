public class ArgumentosMain {
    public static void main(String[] args) {
        String separador = "======================================";
        System.out.println(separador);
        System.out.println("Argumentos: " + args.length);
        System.out.println(separador);

        for (String string : args) {
            System.out.println(string);
        }

        System.out.println(separador);
    }
}