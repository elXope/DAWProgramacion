package Tema5.networok;

import java.util.ArrayList;

public class PublicacionTexto {

    private final String autor;
    private String mensaje;
    private final int MAXCARACTERES;
    private int likes;
    private ArrayList<String> comentarios;

    public PublicacionTexto(String autor, String mensaje) {
        this.autor = autor;
        this.MAXCARACTERES = 200;
        this.nuevoMensaje(mensaje);
        this.likes = 0;
        this.comentarios = new ArrayList<>();
    }

    private void nuevoMensaje(String mensaje) {
        if (mensaje.length() > this.MAXCARACTERES) {
            System.out.println("El mensaje supera el numero permitido de caracteres.");
        } else {
            this.mensaje = mensaje;
        }
    }

    public void gustado() {
        this.likes++;
    }

    private void nuevoComentario(String comentario) {
        this.comentarios.add(comentario);
    }
}
