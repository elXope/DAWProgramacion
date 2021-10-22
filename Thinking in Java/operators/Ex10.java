package operators;
import static operators.Print.print;

public class Ex10 {
    public static void main(String[] args) {
        final int uno = 0xAA;
        final int dos = 0x55;
        print(Integer.toBinaryString(uno & dos));
        print(Integer.toBinaryString(uno | dos));
        print(Integer.toBinaryString(uno ^ dos));
    }
}