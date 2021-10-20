package Tema1;

public class Ex8 {
    static int i = 0;

    public static void main(String[] args) {
        Ex8.prova();
    }

    public void increment(){
        this.i++;
    }

    public static void prova(){
        Ex8 uno = new Ex8();
        Ex8 dos = new Ex8();
        Ex8 tres = new Ex8();
        System.out.println(Ex8.i);
        uno.increment();
        System.out.println(uno.i);
        dos.i++;
        System.out.println(dos.i);
        tres.increment();
        System.out.println(tres.i);
    }
}
