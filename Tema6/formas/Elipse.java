package Tema6.formas;

import java.awt.*;

public class Elipse extends Forma {

    private double rMayor;
    private double rMenor;

    public Elipse(String color, Point coord, String nombre, double rMayor, double rMenor) {
        super(color, coord, nombre);
        this.rMayor = rMayor;
        this.rMenor = rMenor;
    }

    public double getrMayor() {
        return rMayor;
    }

    public double getrMenor() {
        return rMenor;
    }

    public void setrMayor(double rMayor) {
        this.rMayor = rMayor;
    }

    public void setrMenor(double rMenor) {
        this.rMenor = rMenor;
    }

    @Override
    public String imprimir() {
        return "Forma: Elipse" +
                "\n" + super.imprimir() +
                "\nRadio mayor: " + this.rMayor +
                "\nRadio menor: " + this.rMenor;
    }

    public double area() {
        return Math.PI*rMenor*rMayor;
    }
}
