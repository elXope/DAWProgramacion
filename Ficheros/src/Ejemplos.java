import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplos {

    public static void main (String[] args) throws IOException {
        String text = "Contenido para el fichero.";
        FileOutputStream f_out = new FileOutputStream("./Ficheros/f4.txt", true);
        for (int i = 0; i < text.length(); i++) {
            f_out.write(text.charAt(i));
        }
        f_out.close();
    }
}

