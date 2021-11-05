package AceptaElReto;

import java.util.Scanner;

public class P116HolaMundo {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        byte max = lector.nextByte();
        for(byte i = 0; i < max; i++) System.out.println("Hola mundo.");
    }
}
