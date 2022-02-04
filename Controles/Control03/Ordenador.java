package Control03;

import java.util.Scanner;

public class Ordenador {

    private String formato;
    private String color;
    private Teclado teclado;

    public Ordenador() {
        this.formato = "sobremesa";
        this.color = "gris";
        this.teclado = new Teclado();
    }

    public Ordenador(String formato, String color, Teclado teclado) {
        setFormato(formato);
        this.color = color;
        this.teclado = new Teclado();
    }

    public String getFormato() {
        return formato;
    }

    public String getColor() {
        return color;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    private void setFormato(String formato) {
        if (!(formato.equalsIgnoreCase("sobremesa") || formato.equalsIgnoreCase("portatil"))) {
            System.out.println("Tuviste la oportunidad de escoger entre las opciones de sobremesa o portatil pero ahora la has perdido para siempre.");
            this.formato = "no especificado";
        } else this.formato = formato;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }
}
