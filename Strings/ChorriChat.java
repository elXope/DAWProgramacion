package Strings;

import java.util.Scanner;

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
    final String despedida = "Ha sido un placer";
    String respuestaUsuario = "";
    Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        ChorriChat chorri = new ChorriChat();
        chorri.chat();
    }

    public void chat() {
        inicializar();
        esperarSaludo();
        conversacion();
    }

    private void saludar() {
        System.out.println(this.chorri + this.saludo);
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

    private void leerRespuesta() {
        System.out.print(this.usuario);
        this.respuestaUsuario = this.lector.nextLine();
        comprobarDespedida();
    }

    private void comprobarDespedida() {
        for (String despedidaUsuario : this.despedidasUsuario) {
            if (despedidaUsuario.equalsIgnoreCase(this.respuestaUsuario)) {
                System.out.println(this.chorri + this.despedida);
                this.lector.close();
                System.exit(0);
            }
        }
    }

    private boolean comprobarSaludo() {
        for (String saludoUsuario : this.saludosUsuario) {
            if (saludoUsuario.equalsIgnoreCase(this.respuestaUsuario)) {
                saludar();
                return true;
            }
        }
        return false;
    }

    private void esperarSaludo() {
        while(true) {
            leerRespuesta();
            if (comprobarSaludo()) break;
            reprender();
        }
    }

    private void conversacion() {
        while(true) {
            leerRespuesta();
            if (comprobarSaludo()) continue;
            conversar();
        }
    }
}