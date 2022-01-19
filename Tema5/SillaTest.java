package Tema5;
import Tema5.Silla;
import java.util.Random;

public class SillaTest {
    public static void main(String[] args) {
        Random rand = new Random();

        String[] material = {
                "cuero",
                "sintetico",
                "esparto",
                "cañamo"
        };

        String[] color = {
                "marron",
                "roja",
                "azul",
                "amarilla"
        };

        Silla[] test = new Silla[100];
        for (int i = 0; i < test.length; i++) {
            test[i] = new Silla(material[rand.nextInt(4)], color[rand.nextInt(4)], rand.nextInt(6) + 1, rand.nextInt(11), rand.nextBoolean(), rand.nextInt(101), rand.nextInt(101));
            System.out.println(test[i]);
        }
    }
}
