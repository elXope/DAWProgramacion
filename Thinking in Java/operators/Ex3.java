package operators;
import static operators.Print.print;

public class Ex3 {
    float f;

    public static void main(String[] args) {
        Ex3 uno = new Ex3();
        Ex3 dos = uno;
        uno.f = (float)1.5;
        dos.f = (float)0.4;
        print(uno.f + " " + dos.f);
    }
}
