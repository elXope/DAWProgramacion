package Tema6.formas;

import java.awt.Point;

public class Forma {

    private String color;
    private Point coord;
    private String nombre;

    public Forma(String color, Point coord, String nombre) {
        this.color = color;
        this.coord = coord;
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCoord(Point coord) {
        this.coord.setLocation(coord);
    }

    public void moveCoord(int x, int y) {
        this.coord.move(x, y);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public Point getCoord() {
        return coord;
    }

    public String getNombre() {
        return nombre;
    }

    public String imprimir() {
        return "Color: " + this.color +
                "\nCentro: " + this.coord.x + ", " + this.coord.y +
                "\nNombre: " + this.nombre;
    }
}
