import java.io.*;

public class ProcesadorCodigo {

    private boolean esComentario;

    public String eliminaComSimple(String linea) {
        String[] lineas = linea.split("//");
        return lineas[0];
    }

//    public String eliminaComBloque(String linea) {
//        String[] lineas;
//        if (!esComentario) {
//            lineas = linea.split("/*");
//            if (lineas.length > 2) {
//
//            }
//        }
//    }

}
