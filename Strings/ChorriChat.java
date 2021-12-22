package Strings;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ChorriChat {
    final String chorri = "Chorri: ";
    final String usuario = "Usuario: ";
    final String intro = "Bienvenido/a al ChorriChat. Habla con Chorri, te está esperando.";
    final String[] saludosUsuario = {
        "hola",
        "buenos dias",
        "buenas"
    };
    final String saludo = "Hola, soy Chorri,tu asistente";
    final String noSaludo = "Eres una persona maleducada";
    final String[] conversacion = {
        "Mmm, es un tema interesante",
        "No he entendido lo que dices",
        "Nooo hablooo tu idioma"
    };
    final String[] despedidasUsuario = {
        "chao",
        "ta luego",
        "adios",
        "bye"
    };
    final String despedida = "Ha sido un placer, bebé";
    String respuestaUsuario = "";
    Scanner lector = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        ChorriChat chorri = new ChorriChat();
        chorri.chat();
    }

    public void chat() throws InterruptedException {
        inicializar();
        if (!esperarSaludo()) {
            this.lector.close();
            return;
        }
        conversacion();
        this.lector.close();
    }

    private boolean esperarSaludo() throws InterruptedException {
        while(true) {
            leerRespuesta();
            if (comprobarDespedida()) {
                despedir();
                return false;
            }
            if (comprobarSaludo()) {
                saludar();
                return true;
            }
            reprender();
        }
    }

    private void conversacion() throws InterruptedException {
        while(true) {
            leerRespuesta();
            if (comprobarDespedida()) {
                despedir();
                break;
            }
            if (comprobarSaludo()) {
                saludar();
                continue;
            }
            conversar();
        }
    }

    private void leerRespuesta() {
        System.out.print(this.usuario);
        this.respuestaUsuario = this.lector.nextLine();
    }

    private boolean comprobarDespedida() {
        for (String despedidaUsuario : this.despedidasUsuario) {
            if (despedidaUsuario.equalsIgnoreCase(this.respuestaUsuario)) {
                return true;
            }
        }
        return false;
    }

    private boolean comprobarSaludo() throws InterruptedException {
        for (String saludoUsuario : this.saludosUsuario) {
            if (saludoUsuario.equalsIgnoreCase(this.respuestaUsuario)) {
                return true;
            }
        }
        if (buenasNoches()) {
            beretinOsborne();
            return true;
        }
        return false;
    }

    private void saludar() {
        System.out.println(this.chorri + this.saludo);
    }

    private void despedir() {
        System.out.println(this.chorri + this.despedida);
    }

    private void reprender() {
        System.out.println(this.chorri + this.noSaludo);
    }

    private void conversar() {
        int indRespuesta = (int)(Math.random()*(this.conversacion.length));
        System.out.println(this.chorri + this.conversacion[indRespuesta]);
    }

    private void inicializar() {
        System.out.println(this.intro);
    }

    private boolean buenasNoches() {
        if (this.respuestaUsuario.equalsIgnoreCase("buenas noches")) return true;
        return false;
    }

    private void beretinOsborne() throws InterruptedException {
        final String[] BUENAS_NOCHES = {
            "Buenas noches señora",
            "buenas noCHES SEÑORA",
            "hasta la vista",
            "gracias por sus sonrisas",
            "gracias por sus caricias",
            "hasta la vista",
            "para mí no hay fronteras",
            "y mi sitio es cualquiera",
            "hastaaaa la vista",
            "buenas noches señooraaaa",
            "recuerdos a su señor",
            "                             ,/*******************/,                            ",
            "                       /*******,,,,,,,,,,,,,,,,,,,*******/                      ",
            "                  .*****,,,,,,..                 ..,,,,,,****/                  ",
            "               *****,,,,.                              ..,,,,****,              ",
            "            .****,,,............ ....... ....... ............,,,,***            ",
            "          ****,,,,.............................................,,,,***,         ",
            "        ,***,,,,.................................................,,,,***.       ",
            "       ***,,,,.....................................................,,,,***      ",
            "     ,**,,,,,.......................................................,,,,***.    ",
            "    ***,,,,,.........................................................,,,,,**,   ",
            "   ****,,,,,,,,,..,(#*..,,,,,,,,.,,,,,,,.,,,,,,,.,,,,,,.,../#/,..,,,,,,,,,,**.  ",
            "   ***,,,,,,.&%%%%%%%%%%%%*,,,,,,,,,,,,,,,,,,,,,,,,,,,#%%%%%#%%%%%%&.,,,,,,***  ",
            "  /**,,,,,,&%#.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.%%%.,,,,,**/ ",
            "  **,,,,,&&.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.%%,,,,*** ",
            " ,**,,,,&.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.%,,,,**.",
            " ***,,,,,,,,,,,,,,,,,..,**.*..,,,,,,,,,,,,,,,,,,,,,,,,,...,,....,,,,,,,,,,,,,**.",
            " ,**,,,,,,,,,,,,(%%%%#######%%%.,,,,,,,,,,,,,,,,,,.%%%%#######%%%%,,,,,,,,,,,**.",
            "  **,,,,,,,,,,,,,,,,,,,#########,,,,,,,,,,,,,,,,.,,,,,,,,,#######%.,,,,,,,,,*** ",
            "  ***,,,,,,,,,,,,,,,,,,,.%###%.,,,,,,,,,,,,,,,,,,,,,,,,,,,,#####(,,,,,,,,,,,*** ",
            "   ***,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,***  ",
            "   ,***,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,**.  ",
            "    ****,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,&%.,,,,,,,,,,,,,,,,,***.   ",
            "     .**,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.%%%.,,,,,,,,,,,,,,,,,**     ",
            "       ***,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.,%####%,,,,,,,,,,,,,,,,**/      ",
            "        .***,,,,,,,,,,,,,,,,,,,,,,,,..../#%#########%.,,,,,,,,,,,,,,,***        ",
            "          .***,,,,,,,,,,,,,,%&&%%%%%%%%%#%%(,..,,,,,,,,,,,,,,,,,,,,***.         ",
            "             ****,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,**/            ",
            "               .****,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,****               ",
            "                   *****,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,****/                  ",
            "                       ********,,,,,,,,,,,,,,,,,,,*******,                      ",
            "                             ./******************/*                             "
        };
        for (int i = 0; i < BUENAS_NOCHES.length; i ++) {
            System.out.println(this.chorri + BUENAS_NOCHES[i]);
            if (i < 11) TimeUnit.SECONDS.sleep(3);
            else TimeUnit.MILLISECONDS.sleep(300);
        }
    }
}