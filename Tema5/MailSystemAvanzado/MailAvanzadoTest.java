package Tema5.MailSystemAvanzado;

public class MailAvanzadoTest {

        public static void main(String[] args) {
            MailServer testServer = new MailServer();
            MailClient javi = new MailClient(testServer, "Javi");
            MailClient laia = new MailClient(testServer, "Laia");
            javi.sendMailItem("Laia", "Me ha picado una avispa!!1!", "Buenos dias Laia,\nEsta mañana me ha picado una avispa, me duele mucho y no podre acabar el trabajo hoy.\nMira a ver si lo puedes hacer tu porfa.\nSin rencorees eeeeh jajjajj\nJavi.");
            laia.printNextMailItem();
            laia.sendMailItem("Javi;Clara;Miguel","Me cago en tus muertos", "Mira javi o haces el trabajo o mañana cuado te vea te dare una nyescla que te dejare la boca tuerta de por vida.\nSi ya me caias mal ahora peor.\nLaia.");
            javi.printNextMailItem();
        }
}
