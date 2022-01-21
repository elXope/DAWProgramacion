package Tema5;

public class TMtest {
    public static void main(String[] args) {
//        TicketMachine tm1 = new TicketMachine();
//        tm1.setPrice(100);
//        tm1.showPrice();
//        tm1.prompt();
//        tm1.insertMoney(100);
//        tm1.printTicket();
//        System.out.println(tm1.getTotal());
//
//        TicketMachine tm2 = new TicketMachine(100);
//        tm2.showPrice();
//        tm2.prompt();
//        tm2.insertMoney(100);
//        tm2.printTicket();
//        System.out.println(tm2.getTotal());

        TicketMachine tm1 = new TicketMachine(100);
        for(byte i = 0; i < 10; i++) {
            tm1.insertMoney(100);
            tm1.printTicket();
        }
        System.out.println(tm1.getTotal());
        tm1.empty();
        System.out.println(tm1.getTotal());
    }
}
