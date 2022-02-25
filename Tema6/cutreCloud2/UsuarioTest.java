package Tema6.cutreCloud2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void getID() {
        Usuario usuario5 = new Usuario("gerard@gmail.com", "xd");
        Usuario usuario6 = new Usuario("laura@gmail.com", "xdd");
        Usuario usuarioMal3 = new Usuario("gerard@gmail.com", "xddd");
        Usuario usuario7 = new Usuario("fabiana@gmail.com", "xdddd");

        assertEquals(0, usuario5.getID());
        assertEquals(1, usuario6.getID());
        assertEquals(2, usuario7.getID());
        assertEquals(-1, usuarioMal3.getID());
    }

    @Test
    void getListaUsuarios() {
        Usuario usuario1 = new Usuario("pepe@gmail.com", "xd");
        Usuario usuario2 = new Usuario("mari@gmail.com", "xdd");
        Usuario usuarioMal = new Usuario("gerard@gmail.com", "xddd");
        Usuario usuario3 = new Usuario("fina@gmail.com", "xdddd");
        ArrayList<Usuario> listaUsers = Usuario.getListaUsuarios();

        assertEquals(6,listaUsers.size());

        assertSame(usuario1, listaUsers.get(3));
        assertSame(usuario2, listaUsers.get(4));
        assertSame(usuario3, listaUsers.get(5));
    }

    @Test
    void getEmail() {
        Usuario usuario4 = new Usuario("pepon@gmail.com", "xd");
        Usuario usuarioMal2 = new Usuario("pepon@gmail.com", "xddd");

        assertEquals("pepon@gmail.com", usuario4.getEmail());
        assertEquals("Email no valido: pepon@gmail.com", usuarioMal2.getEmail());
    }
}