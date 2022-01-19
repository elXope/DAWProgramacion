package Tema5;

import java.awt.Point;

public class Silla {
    /*
    No ejecutable.
    Atributos: color, num patas, respaldo o no, nivel de comodidad (0 - 10), material, coordenadas en la habitacion.
    Todos los atributos tienen que ser privados, pero se tienen que poder modificar y acceder a su valor.
    En la classe test creamos 100 sillas con distintas posiciones y materiales.
     */
    private boolean respaldo;
    private byte nPatas;
    private byte comodidad;
    private String material;
    private String color;
    private Point cord;

    public Silla() {}

    public Silla(String material, String color, int nPatas, int comodidad, boolean respaldo, int x, int y) {
        this.material = material;
        this.color = color;
        this.nPatas = (byte)nPatas;
        this.comodidad = (byte)comodidad;
        this.respaldo = respaldo;
        this.cord = new Point(x, y);
    }

    public Silla(String material, String color, int nPatas, int comodidad, boolean respaldo, Point cord) {
        this.material = material;
        this.color = color;
        this.nPatas = (byte)nPatas;
        this.comodidad = (byte)comodidad;
        this.respaldo = respaldo;
        this.cord = new Point(cord.x, cord.y);
    }

    public Silla(String material, String color, byte nPatas, byte comodidad, boolean respaldo, int x, int y) {
        this.material = material;
        this.color = color;
        this.nPatas = nPatas;
        this.comodidad = comodidad;
        this.respaldo = respaldo;
        this.cord = new Point(x, y);
    }

    public Silla(String material, String color, byte nPatas, byte comodidad, boolean respaldo, Point cord) {
        this.material = material;
        this.color = color;
        this.nPatas = nPatas;
        this.comodidad = comodidad;
        this.respaldo = respaldo;
        this.cord = new Point(cord.x, cord.y);
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNPatas(byte nPatas) {
        this.nPatas = nPatas;
    }

    public void setComodidad(byte comodidad) {
        this.comodidad = comodidad;
    }

    public void setRespaldo(boolean respaldo) {
        this.respaldo = respaldo;
    }

    public void setCord(int x, int y) {
        this.cord = new Point(x, y);
    }

    public String getMaterial() {
        return this.material;
    }

    public String getColor() {
        return this.color;
    }

    public int getNPatas() {
        return (int)this.nPatas;
    }

    public int getComodidad() {
        return (int)this.comodidad;
    }

    public boolean getRespaldo() {
        return this.respaldo;
    }

    public Point getCord() {
        return this.cord;
    }

    @Override
    public String toString() {
        return "==============================================" +
                "\nMaterial:\t" + this.material +
                "\nColor:\t" + this.color +
                "\nNum. Patas:\t" + this.nPatas +
                "\nComodidad:\t" + this.comodidad +
                "\nRespaldo:\t" + this.respaldo +
                "\nCordenadas:\t" + this.cord.toString();
    }
}
