package Control03;

import java.util.Scanner;

public class Teclado {

    private String color;
    private int nTeclas;
    private String conectividad;
    private String idioma;
    private String formato;

    public Teclado(String color, int nTeclas, String conectividad, String idioma, String formato) {
        this.color = color;
        this.nTeclas = nTeclas;
        setConectividad(conectividad);
        setIdioma(idioma);
        setFormato(formato);
    }

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

    private void setConectividad(String conectividad) {
        Scanner lector = new Scanner(System.in);
        while (!conectividad.equalsIgnoreCase("inalambrico") || !conectividad.equalsIgnoreCase("cable")) {
            System.out.println("Introduce una de las dos opciones validas (inalambrico / cable):");
            conectividad = lector.nextLine();
            lector.nextLine();
        }
        lector.close();
        this.conectividad = conectividad;
    }

    private void setIdioma(String idioma) {
        Scanner lector = new Scanner(System.in);
        while(idioma.length() != 2) {
            System.out.println("Introduce un codigo de idioma valido (maximo 2 letras):");
            idioma = lector.nextLine();
            lector.nextLine();
        }
        lector.close();
        this.idioma = idioma;
    }

    private void setFormato(String formato) {
        Scanner lector = new Scanner(System.in);
        while (!formato.equalsIgnoreCase("inalambrico") || !formato.equalsIgnoreCase("cable")) {
            System.out.println("Introduce una de las dos opciones validas (compacto / extendido):");
            formato = lector.nextLine();
            lector.nextLine();
        }
        lector.close();
        this.formato = formato;
    }
}
