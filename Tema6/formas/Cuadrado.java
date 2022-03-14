package Tema6.formas;

import java.awt.*;

public class Cuadrado extends Rectangulo {

    private double lado;

    public Cuadrado(String color, Point coord, String nombre, double lado) {
        super(color, coord, nombre, lado, lado);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
        this.setLadoMayor(lado);
        this.setLadoMenor(lado);
    }
}
