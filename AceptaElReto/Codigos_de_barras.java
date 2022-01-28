package AceptaElReto;

public class Codigos_de_barras {
    public static void main(String[] args) {
        comprueba(args[0]);
    }

    public static void comprueba(String cdb) {
        if (cdb.length() <= 8) cdb = rellena(cdb, 8);
        else if (cdb.length() <= 13) cdb = rellena(cdb, 13);
    }

    public static String rellena(String cdb, int max) {
        for (int i = cdb.length(); i < max; i++) {
            cdb = "0" + cdb;
        }
        return cdb;
    }

    //https://www.aceptaelreto.com/problem/statement.php?id=106&cat=4
}
