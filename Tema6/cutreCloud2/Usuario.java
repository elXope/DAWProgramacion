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
}
