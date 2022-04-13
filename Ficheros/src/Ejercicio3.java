import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        File img = new File("./Ficheros/penyagolosa.bmp");
        TransformaImagen imgTrans = new TransformaImagen(img);
//        imgTrans.transformaNegativo();
        File negFile = new File("./Ficheros/penyagolosa_n.bmp");
        BufferedImage neg = new BufferedImage(525, 393, BufferedImage.TYPE_INT_RGB);
        neg = ImageIO.read(negFile);

//        imgTrans.transformaOscuro();
        File oscFile = new File("./Ficheros/penyagolosa_o.bmp");
        BufferedImage osc = new BufferedImage(525, 393, BufferedImage.TYPE_INT_RGB);
        osc = ImageIO.read(oscFile);
//        imgTrans.transformaBlancoNegro();

        TransformaImagen2 imagen = new TransformaImagen2(img);
        imagen.copiaImagen("./Ficheros/penyagolosaCopia.bmp");
//        imagen.transformaNegativo();
//        imagen.transformaOscuro();
        System.out.println(TransformaImagen2.compararImagen(neg, imagen.transformaNegativo(), "compNeg"));
        System.out.println(TransformaImagen2.compararImagen(osc, imagen.transformaOscuro(), "compOsc"));

    }
}
