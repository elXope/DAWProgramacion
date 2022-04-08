import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EscribePrimos {
    public static void main(String[] args) throws IOException {
        CribaErastotenes criba = new CribaErastotenes(500);
        int[] vectorPrimos_1 = criba.vectorPrimos();
        int[] vectorPrimos = new int[vectorPrimos_1.length + 1];
        vectorPrimos[0] = 1;
        System.arraycopy(vectorPrimos_1, 0, vectorPrimos, 1, vectorPrimos_1.length);
        String in = Arrays.toString(vectorPrimos);

        FileWriter outputStream = new FileWriter("./Ficheros/primos.dat");
        outputStream.write(in);
        outputStream.close();
    }
}
