package Tema6.cutreCloud;

import java.util.ArrayList;

public class Usuario {
    private static ArrayList<Usuario> listaUsuario = new ArrayList<>();
    private static int idGenerator = 0;

    private final String ID;
    private String email;
    private String password;

    public Usuario() {
        this.ID = "";
    }

    private Usuario(String email, String password) {
        this.ID = idGenerator++ + "";
        this.email = email;
        this.password = password;
    }

    public static Usuario creaUsuario(String email, String password) {
        Usuario nuevo;
        boolean repetido = false;
        for (Usuario usuario : listaUsuario) {
            if (email.equals(usuario.email)) {
                repetido = true;
                break;
            }
        }
        if (repetido) {
            nuevo = new Usuario();
            System.out.println("Direccion de email no valida.");
        } else {
            nuevo = new Usuario(email, password);
            listaUsuario.add(nuevo);
        }
        return nuevo;
    }

    public static ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public String getID() {
        return this.ID;
    }
}
