import java.io.*;

public class Mezcla {
    public static void main(String[] args) throws IOException {
        FileReader f1 = new FileReader(args[0]);
        FileReader f2 = new FileReader(args[1]);
        FileWriter f3 = new FileWriter(args[2]);

        BufferedReader lectorf1 = new BufferedReader(f1);
        BufferedReader lectorf2 = new BufferedReader(f2);

        String linef1;
        String linef2;

        linef1 = lectorf1.readLine();
        linef2 = lectorf2.readLine();
        while (linef1 != null || linef2 != null) {
            if (linef1 != null) {
                f3.write(linef1 + System.lineSeparator());
                linef1 = lectorf1.readLine();
            }
            if (linef2 != null) {
                f3.write(linef2 + System.lineSeparator());
                linef2 = lectorf2.readLine();
            }
        }
        lectorf1.close();
        lectorf2.close();
        f1.close();
        f2.close();
        f3.close();
    }
}
