import java.util.Scanner;

public class Ejemplo4 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		System.out.println("Introduix el costat (en metres) del quadrat per a calcular l'area: ");
		final float costat = tec.nextFloat();
		final float squareArea = costat*costat;
		System.out.println("El quadrat té una àrea de " + costat*costat + " metres quadrats.");

	}
}
