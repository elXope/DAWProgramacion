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

    public BufferedImage transformaNegativo() throws IOException {
        BufferedImage neg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                neg.setRGB(i, j, 255 - image.getRGB(i, j));
            }
        }

        File output = new File("./Ficheros/penyagolosa_n2.bmp");
        ImageIO.write(neg, "bmp", output);
        return neg;
    }

    public BufferedImage transformaOscuro() throws IOException {
        BufferedImage osc = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                osc.setRGB(i, j, image.getRGB(i, j)/2);
            }
        }

        File output = new File("./Ficheros/penyagolosa_o2.bmp");
        ImageIO.write(osc,"bmp", output);
        return osc;
    }


    public void transformaBlancoNegro() throws IOException {
    }

    public static int compararImagen(BufferedImage img1, BufferedImage img2, String nom) throws IOException {
        BufferedImage comp = new BufferedImage(img1.getWidth(), img1.getHeight(), BufferedImage.TYPE_INT_RGB);
        int score = 0;
        for (int i = 0; i < img1.getWidth(); i++) {
            for (int j = 0; j < img1.getHeight(); j++) {
                comp.setRGB(i, j, Math.abs(img1.getRGB(i, j) - img2.getRGB(i, j)));
                score = score + Math.abs(img1.getRGB(i, j) - img2.getRGB(i, j));
            }
        }
        File output = new File("./Ficheros/" + nom + ".bmp");
        ImageIO.write(comp,"bmp", output);

        return score/(img1.getHeight()*img1.getWidth());
    }
}
