import java.io.File;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        File img = new File("./Ficheros/penyagolosa.bmp");
        TransformaImagen imgTrans = new TransformaImagen(img);
        imgTrans.transformaNegativo();
    }
}
