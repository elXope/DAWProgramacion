package Control03;

public class TecladoTest {
    public static void main(String[] args) {
        Teclado test = new Teclado("amarillo", 10, "inalambrico", "en", "compacto");
        Teclado test2 = new Teclado();
        System.out.println(Teclado.getnTeclados());
        Teclado test3 = new Teclado();
        System.out.println(Teclado.getnTeclados());
    }
}
