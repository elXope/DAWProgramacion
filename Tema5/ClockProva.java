package Tema5;

public class ClockProva {
    public static void main(String[] args) {
        ClockDisplay reloj = new ClockDisplay();
        System.out.println(reloj.getTime());
        reloj.timeTick();
        System.out.println(reloj.getTime());
        reloj.setTime(00, 59, 58);
        System.out.println(reloj.getTime());
        reloj.timeTick();
        System.out.println(reloj.getTime());
        reloj.timeTick();
        System.out.println(reloj.getTime());
    }
}
