import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class TransformaImagen2 {
    File f = null;
    BufferedImage image;

    public TransformaImagen2(File fEnt) throws IOException {
        if (!fEnt.isFile()) {
            System.out.println("No es un archivo valido.");
        } else {
            String nom = fEnt.getName();
            if (!nom.substring(nom.length() - 4, nom.length()).equals(".bmp")) {
                System.out.println("No es un formato valido. Tiene que ser '.bmp'");
            } else {
                f = fEnt;
                image = new BufferedImage(525, 393, BufferedImage.TYPE_INT_RGB);
                image =  ImageIO.read(f);
            }
        }
    }

    public void copiaImagen(String path) throws IOException {
        File outputFile = new File(path);
        ImageIO.write(image, "bmp", outputFile);
    }

    public void transformaNegativo() throws IOException {
        BufferedImage neg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                neg.setRGB(i, j, 255 - image.getRGB(i, j));
            }
        }

        File output = new File("./Ficheros/penyagolosa_n2.bmp");
        ImageIO.write(neg, "bmp", output);
    }

    public void transformaOscuro() throws IOException {

    }


    public void transformaBlancoNegro() throws IOException {
    }
}
