package Control03;

public class TecladoTest {
    public static void main(String[] args) {
        Teclado test = new Teclado("amarillo", 10, "inalabrico", "en", "compacto");
        Teclado test0 = new Teclado("amarillo", 10, "inalabrico", "en", "compacto");
        Teclado test2 = new Teclado();
        System.out.println(Teclado.getnTeclados());
        Teclado test3 = new Teclado();
        System.out.println(Teclado.getnTeclados());
        Ordenador pedro = new Ordenador();
        Ordenador pasqual = new Ordenador("sobremesa", "rosa", test3);
    }
}
