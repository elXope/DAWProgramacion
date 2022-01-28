package Tema5;

public class ClockProva {
    public static void main(String[] args) {
        ClockDisplay reloj = new ClockDisplay();
        System.out.println(reloj.getTime());
        for (int i = 0; i < 60; i++) {
            reloj.timeTick();
            System.out.println(reloj.getTime());
        }
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                reloj.timeTick();
            }
            System.out.println(reloj.getTime());
        }
    }
}
