import java.util.Scanner;

public class Control01 {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        byte numeroLados;
        double longitudLados;
        double perimetro = 0;

        System.out.println("Dime el número de lados del polígono: ");
        numeroLados = lector.nextByte();

        if ((numeroLados == 3) || (numeroLados == 4)) {
            System.out.println("Dime la longitud del lado del polígono: ");
            longitudLados = lector.nextDouble();

            for (byte i = 0; i < numeroLados; i++){
                perimetro = perimetro + longitudLados;
            }

            if (numeroLados == 3) {
                System.out.println("El perímetro del triángulo es " + perimetro);
            } else {
                System.out.println("El perímetro del cuadrado es " + perimetro);
            }
        }
        lector.close();
    }
}
