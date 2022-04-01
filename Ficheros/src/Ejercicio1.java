import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) {
        File actualFile = File.listRoots()[0];
        int opcion = 0;

        imprimirDirectorio(actualFile);

        while(true) {
            opcion = pideOpcion(-2);
            if (opcion == -2) {
                continue;
            }
            if (opcion != -1) {
                if (opcion < -1 || opcion > actualFile.list().length) {
                    System.out.println("Introduce un numero valido.");
                } else {
                    imprimirDirectorio(actualFile);
                    actualFile = nuevoDirectorio(opcion - 1);
                }
            }
            else {
                break;
            }
        }
    }

    private static int pideOpcion(int def) {
        System.out.println("Introduce el identificador del directorio al que navegar (-1 para salir):  ");
        try {
            return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        } catch (NumberFormatException e) {
            System.out.println("Introduce un entero.");
            return def;
        } catch (IOException e) {
            System.out.println("Introduce un parametro valido.");
            return def;
        }
    }

    private static void imprimirDirectorio(File actualFile) {
        System.out.println("Directorio: " + actualFile.getName());
    }

    private static File nuevoDirectorio(int opcion) {
        return File.listRoots()[0];
    }
}
