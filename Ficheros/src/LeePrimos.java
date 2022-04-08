import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeePrimos {
    public static void main(String[] args) throws IOException {
        FileReader primos = new FileReader("./Ficheros/primos.dat");
        int n = primos.read();
        while (n != -1) {
            System.out.print((char)n);
            n = primos.read();
        }
        primos.close();
    }
}
