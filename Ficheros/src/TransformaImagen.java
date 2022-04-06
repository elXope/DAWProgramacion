import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TransformaImagen {
    File f = null;

    public TransformaImagen(File fEnt) {
        // Control de existencia del fichero y control de la extensión .bmp (sacar
        // mensajes de error)
        if (!fEnt.isFile()) {
            System.out.println("No es un archivo valido.");
        } else {
            String nom = fEnt.getName();
            if (!nom.substring(nom.length() - 4, nom.length()).equals(".bmp")) {
                System.out.println("No es un formato valido. Tiene que ser '.bmp'");
            } else {
                f = fEnt;
            }
        }
    }

    public void transformaNegativo() throws IOException {
        // Transformar a negativo y guardar como *_n.bmp
        FileInputStream imgIn = new FileInputStream(f);
        FileOutputStream imgOut = new FileOutputStream(f.getPath().substring(0, f.getPath().length() - 4) + "_n.bmp");
        for (int i = 0; i < 54; i++) {
            imgOut.write(imgIn.read());
        }
        while (true) {
            int out = imgIn.read();
            if (out == -1) {
                break;
            } else {
                imgOut.write(255 - out);
            }
        }
        imgIn.close();
        imgOut.close();
    }

    public void transformaOscuro() throws IOException {
        // Transformar a una imagen más oscura y guardar como *_o.bmp
        FileInputStream imgIn = new FileInputStream(f);
        FileOutputStream imgOut = new FileOutputStream(f.getPath().substring(0, f.getPath().length() - 4) + "_o.bmp");
        for (int i = 0; i < 54; i++) {
            imgOut.write(imgIn.read());
        }
        while (true) {
            int out = imgIn.read();
            if (out == -1) {
                break;
            } else {
                imgOut.write(out/2);
            }
        }
        imgIn.close();
        imgOut.close();
    }


    public void transformaBlancoNegro() throws IOException {
        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp
        FileInputStream imgIn = new FileInputStream(f);
        FileOutputStream imgOut = new FileOutputStream(f.getPath().substring(0, f.getPath().length() - 4) + "_bn.bmp");
        for (int i = 0; i < 54; i++) {
            imgOut.write(imgIn.read());
        }

        int r;
        int g;
        int b;
        while (true) {
            r = imgIn.read();
            if (r == -1) {
                break;
            } else {
                g = imgIn.read();
                b = imgIn.read();
                imgOut.write((r+g+b)/3);
                imgOut.write((r+g+b)/3);
                imgOut.write((r+g+b)/3);
            }
        }
        imgIn.close();
        imgOut.close();
    }
}
