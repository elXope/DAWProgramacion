package Tema6.formas;

import java.awt.*;

public class Rectangulo extends Forma {

    private double ladoMenor;
    private double ladoMayor;

    public Rectangulo(String color, Point coord, String nombre, double ladoMenor, double ladoMayor) {
        super(color, coord, nombre);
        this.ladoMenor = ladoMenor;
        this.ladoMayor = ladoMayor;
    }

    public double getLadoMenor() {
        return ladoMenor;
    }

    public double getLadoMayor() {
        return ladoMayor;
    }

    public void setLadoMenor(double ladoMenor) {
        this.ladoMenor = ladoMenor;
    }

    public void setLadoMayor(double ladoMayor) {
        this.ladoMayor = ladoMayor;
    }

    public void escala(double factor) {
        ladoMenor *= factor;
        ladoMayor *= factor;
    }

    @Override
    public String imprimir() {
        return "Forma: Rectangulo" +
                "\n" + super.imprimir() +
                "\nLado mayor: " +  this.ladoMayor +
                "\nLado menor: " + this.ladoMenor;
    }

    public double area() {
        return ladoMenor*ladoMayor;
    }

    public double perimetro() {
        return 2*ladoMayor + 2*ladoMenor;
    }
}
