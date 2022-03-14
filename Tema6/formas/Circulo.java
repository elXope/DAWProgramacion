package Tema6.formas;

import java.awt.*;

public class Circulo extends Elipse {

    private double radio;

    public Circulo(String color, Point coord, String nombre, double radio) {
        super(color, coord, nombre, radio, radio);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
        this.setrMayor(radio);
        this.setrMenor(radio);
    }
}
