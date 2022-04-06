import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Locale;

public class Ejercicio2 {
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
        DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault());

        if (actualFile.getParent() != null) {
            System.out.println(0 + ".-" + actualFile.getParent() + " <Parent>");
        }

        String flags;
        for (int i = 0; i < actualFile.list().length; i ++) {
            if (!actualFile.listFiles()[i].isHidden()) {
                flags = getFlags(actualFile.listFiles()[i]);
                System.out.println((i+1) + ".-\t" + flags + "\t" + actualFile.listFiles()[i].getTotalSpace() + "\t " + formatter.format(actualFile.listFiles()[i].lastModified()) + "\t" + actualFile.listFiles()[i].getName());
            }
        }
    }

    private static String getFlags(File file) {
        String flags;
        if(file.isDirectory()){
            flags = "d";
        }else{
            flags = "-";
        }

        if(file.canRead()){
            flags += "r";
        }else{
            flags += "-";
        }

        if(file.canWrite()){
            flags += "w";
        }else{
            flags += "-";
        }

        if(file.canExecute()){
            flags += "x";
        }else{
            flags += "-";
        }
        return flags;
    }
}
