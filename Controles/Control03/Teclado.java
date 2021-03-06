package Control03;

import java.util.Scanner;

public class Teclado {

    // Atributos
    private final String color;
    private final int nTeclas;
    private String conectividad;
    private String idioma;
    private String formato;
    private static int nTeclados = 0;

    // Constructores
    public Teclado() {
        this.color = "gris";
        this.nTeclas = 22;
        this.conectividad = "cable";
        this.idioma = "en";
        this.formato = "extendido";
        tecladoNuevo();
    }

    public Teclado(String color, int nTeclas, String conectividad, String idioma, String formato) {
        this.color = color;
        this.nTeclas = nTeclas;
        Scanner lector = new Scanner(System.in);
        setConectividad(conectividad, lector);
        setIdioma(idioma, lector);
        setFormato(formato, lector);
        lector.close();
        tecladoNuevo();
    }

    // Getters
    public String getColor() {
        return color;
    }

    public int getnTeclas() {
        return nTeclas;
    }

    public String getConectividad() {
        return conectividad;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getFormato() {
        return formato;
    }

    // Setters
    private void setConectividad(String conectividad, Scanner lector) {
        while (!(conectividad.equalsIgnoreCase("inalambrico") || conectividad.equalsIgnoreCase("cable"))) {
            System.out.println("Introduce una de las dos opciones de conectividad validas (inalambrico / cable):");
            conectividad = lector.nextLine();
        }
        this.conectividad = conectividad;
    }

    private void setIdioma(String idioma, Scanner lector) {
        while(idioma.length() != 2) {
            System.out.println("Introduce un codigo de idioma valido (maximo 2 letras):");
            idioma = lector.nextLine();
        }
        this.idioma = idioma;
    }

    private void setFormato(String formato, Scanner lector) {
        while (!(formato.equalsIgnoreCase("compacto") || formato.equalsIgnoreCase("extendido"))) {
            System.out.println("Introduce una de las dos opciones de formato validas (compacto / extendido):");
            formato = lector.nextLine();
        }
        this.formato = formato;
    }

    // Static
    public static int getnTeclados() {
        return nTeclados;
    }

    private static void tecladoNuevo() {
        nTeclados++;
    }
}
