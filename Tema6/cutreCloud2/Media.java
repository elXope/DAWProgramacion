package Tema6.cutreCloud2;

import java.util.ArrayList;

public class Media {

    private static ArrayList<Media> listaMedia = new ArrayList<>();
    private static int generadorID = 0;

    private final int ID;
    private String nombre;
    private Contenido contenido;
    private MediaType tipo;
    private String usuario;

    public Media(String nombre, Contenido contenido, MediaType tipo, String emailUsuario) {
        if (nombreValido(nombre)) {
            this.ID = generadorID++;
            this.nombre = nombre;
            this.contenido = contenido;
            this.tipo = tipo;
            if (usuarioEmailValido(emailUsuario)) {
                this.usuario = emailUsuario;
            } else {
                this.usuario = "Usuario no definido";
            }
            listaMedia.add(this);
        } else {
            this.ID = -1;
            this.nombre = "Nombre repetido: " + nombre;
        }
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public MediaType getTipo() {
        return this.tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public static ArrayList<Media> getListaMedia() {
        return new ArrayList<>(listaMedia);
    }

    private boolean nombreValido(String nombre) {
        for (Media media : listaMedia) {
            if (media.getNombre().equals(nombre)) {
                return false;
            }
        }
        return true;
    }

    private boolean usuarioEmailValido(String email) {
        for (Usuario usuario : Usuario.getListaUsuarios()) {
            if (usuario.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public static void eliminarMedia(String nombre) {
        for (int i = 0; i < listaMedia.size(); i++) {
            if (listaMedia.get(i).getNombre().equals(nombre)) {
                listaMedia.remove(i);
                break;
            }
        }
    }

    public static void eliminarTipoMedia(MediaType tipo) {
        int i = 0;
        while (i < listaMedia.size()) {
            if (listaMedia.get(i).getTipo() == tipo) {
                listaMedia.remove(i);
            } else {
                i++;
            }
        }
    }
}
