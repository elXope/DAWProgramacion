package Tema6.formas;

import java.awt.*;

public class FormasTest {
    public static void main(String[] args) {
        Forma[] arr = new Forma[4];
        arr[0] = new Rectangulo("Amarillo", new Point(3, 2), "Pepe", 10, 11);
        arr[1] = new Elipse("Rojo", new Point(4,4), "Riky", 10, 5);
        arr[2] = new Cuadrado("Azul", new Point(-1, 2), "Lara", 4);
        arr[3] = new Circulo("Beige", new Point(-5, -2), "Anna", 0.5);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].imprimir());
            System.out.println("=================");
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i].moveCoord(0, 0);
            arr[i].setColor("Granate");
            System.out.println(arr[i].imprimir());
            System.out.println("=================");
        }
    }
}
