package Tema6.cutreCloud;

import java.util.ArrayList;

public class Media {
    private static ArrayList<Media> listaMedia = new ArrayList<>();
    private static int generadorID = 0;

    private final String ID;
    private String nombre;
    private String contenido;
    private String tipo;
    private String usuarioID;

    private Media() {
        this.ID = "";
    }

    private Media(String nombre, String contenido, String tipo, String usuarioID) {
        this.ID = generadorID++ + "";
        this.nombre = nombre;
        this.contenido = contenido;
        this.tipo = tipo;
        this.usuarioID = usuarioID;
    }

    public void setUsuarioID(String usuarioID) {
        this.usuarioID = compruebaUsuarioID(usuarioID);
    }

    public static Media creaMedia(String nombre, String contenido, String tipo, String usuarioId) {
        Media nuevo;
        if (compruebaNombre(nombre)) {
            nuevo = new Media(nombre, contenido, tipo,usuarioId);
            listaMedia.add(nuevo);
        } else {
            nuevo = new Media();
        }
        return nuevo;
    }

    private static boolean compruebaNombre(String nombre) {
        for (Media media : listaMedia) {
            if (media.nombre.equals(nombre)) {
                return false;
            }
        }
        return true;
    }

    private static String compruebaUsuarioID(String usuarioId) {
        for (Usuario usuario : Usuario.getListaUsuario()) {
            if (usuario.getID().equals(usuarioId)) {
                return usuarioId;
            }
        }
        return "no definido";
    }
}