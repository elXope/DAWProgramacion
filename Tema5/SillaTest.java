package Tema5;
import Tema5.Silla;

public class SillaTest {
    public static void main(String[] args) {
        Silla[] test = new Silla[100];
        for (int i = 0; i < test.length; i++) {
            test[i] = new Silla();
            System.out.println(test[i]);
        }
    }
}
