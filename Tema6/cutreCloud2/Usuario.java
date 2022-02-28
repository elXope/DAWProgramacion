package Tema6.cutreCloud2;

import java.util.ArrayList;

public class Usuario {

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static int generadorID = 0;

    private final int ID;
    private String email;
    private String contrasenya;

    public Usuario(String email, String contrasenya) {
        if (emailValido(email)) {
            this.ID = generadorID++;
            this.email = email;
            this.contrasenya = contrasenya;
            listaUsuarios.add(this);
        } else {
            this.ID = -1;
            this.email = "Email no valido: " + email;
        }
    }

    public static ArrayList<Usuario> getListaUsuarios() {
        return new ArrayList<>(listaUsuarios);
    }

    public String getEmail() {
        return this.email;
    }

    public int getID(){
        return this.ID;
    }

    private static boolean emailValido(String email) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public static void eliminarUsuarioXEmail(String email) {
        listaUsuarios.removeIf(usuario -> usuario.email.equals(email));
        Media.actualizarMediaUsuario();
    }

    public static void eliminarUsuarioXDominio(String dominio) {
        listaUsuarios.removeIf(usuario -> usuario.email.split("@")[1].equals(dominio.split("@")[1]));
        Media.actualizarMediaUsuario();
    }
}

/**
 * Interfaz que se llama ParserXML: tiene que haber un metodo en las clases que se llame generateXML()
 * En la clase usuario tendremos que crear un metodo que se llame generateXML(), que tiene que devolver un string del xml para los objetos
 * de dicha clase. Para la clase Media lo mismo.
 */