import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) {
        File actualFile = File.listRoots()[0];
        int opcion = 0;

        while(true) {
            imprimirDirectorio(actualFile);
            opcion = pideOpcion();
            if (opcion != -1) {
                if (opcion < -1 || opcion > actualFile.list().length) {
                    System.out.println("Introduce un numero valido.");
                } else if (opcion == 0) {
                    actualFile = actualFile.getParentFile();
                } else if (actualFile.listFiles()[opcion - 1].isDirectory()){
                    actualFile = actualFile.listFiles()[opcion - 1];
                }
            }
            else {
                break;
            }
        }
    }

    private static int pideOpcion() {
        while (true) {
            System.out.println("Introduce el identificador del directorio al que navegar (-1 para salir):  ");
            try {
                return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un entero.");
            } catch (IOException e) {
                System.out.println("Introduce un parametro valido.");
            }
        }
    }

    private static void imprimirDirectorio(File actualFile) {
        System.out.println("======================================");
        System.out.println("Directorio: " + actualFile.getPath());

        if (actualFile.getParent() != null) {
            System.out.println(0 + ".-" + actualFile.getParent() + " <Parent>");
        }

        for (int i = 0; i < actualFile.list().length; i ++) {
            if (!actualFile.listFiles()[i].isHidden()) {
                if (actualFile.listFiles()[i].isFile()) {
                    System.out.println((i+1) + ".-" + actualFile.listFiles()[i].getName() + " " + actualFile.listFiles()[i].getTotalSpace());
                }
                else if (actualFile.listFiles()[i].isDirectory()) {
                    System.out.println((i+1) + ".-" + actualFile.listFiles()[i].getName() + " <Directorio>");
                }
            }
        }
    }

    private static File nuevoDirectorio(int opcion) {
        return File.listRoots()[0];
    }
}
