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

    @Test
    void eliminarUsuarioXEmail() {
        Usuario usuario1 = new Usuario("joaquin@gmail.com", "xd");
        Usuario usuario2 = new Usuario("sabrina@gmail.com", "xdd");
        Usuario usuario3 = new Usuario("amaia@gmail.com", "xdddd");

        Media media1 = new Media("NFT Willyrex", new Contenido(), MediaType.IMAGEN, "joaquin@gmail.com");
        Media media2 = new Media("Dibujito", new Contenido(), MediaType.AUDIO, "sabrina@gmail.com");
        Media media3 = new Media("canta", new Contenido(), MediaType.VIDEO, "amaia@gmail.com");
        Media media4 = new Media("NFT Willyrex 2", new Contenido(), MediaType.VIDEO, "joaquin@gmail.com");
        Media media5 = new Media("eee", new Contenido(), MediaType.VIDEO, "joaquin@gmail.com");
        Media media6 = new Media("aaaa", new Contenido(), MediaType.AUDIO, "amaia@gmail.com");

        assertSame(usuario1,Usuario.getListaUsuarios().get(0));
        assertSame(usuario2,Usuario.getListaUsuarios().get(1));
        assertSame(usuario3,Usuario.getListaUsuarios().get(2));
        assertSame(media1, Media.getListaMedia().get(0));
        assertSame(media2, Media.getListaMedia().get(1));
        assertSame(media3, Media.getListaMedia().get(2));
        assertSame(media4, Media.getListaMedia().get(3));
        assertSame(media5, Media.getListaMedia().get(4));
        assertSame(media6, Media.getListaMedia().get(5));
        Usuario.eliminarUsuarioXEmail("joaquin@gmail.com");
        assertEquals(2, Usuario.getListaUsuarios().size());
        assertSame(usuario2, Usuario.getListaUsuarios().get(0));
        assertSame(usuario3,Usuario.getListaUsuarios().get(1));
        assertEquals(3, Media.getListaMedia().size());
        assertSame(media2, Media.getListaMedia().get(0));
        assertSame(media3, Media.getListaMedia().get(1));
        assertSame(media6, Media.getListaMedia().get(2));
    }

    @Test
    void eliminarUsuarioXDominio() {
        Usuario usuario1 = new Usuario("joaquin@gmail.com", "xd");
        Usuario usuario2 = new Usuario("sabrina@hotmail.com", "xdd");
        Usuario usuario3 = new Usuario("amaia@gmail.es", "xdddd");
        Usuario usuario4 = new Usuario("sabrina@gmail.es", "xdd");
        Usuario usuario5 = new Usuario("ruben@gmail.es", "xdddd");

        Media media1 = new Media("NFT Willyrex", new Contenido(), MediaType.IMAGEN, "joaquin@gmail.com");
        Media media2 = new Media("Dibujito", new Contenido(), MediaType.AUDIO, "sabrina@hotmail.com");
        Media media3 = new Media("canta", new Contenido(), MediaType.VIDEO, "amaia@gmail.es");
        Media media4 = new Media("NFT Willyrex 2", new Contenido(), MediaType.VIDEO, "sabrina@gmail.es");
        Media media5 = new Media("eee", new Contenido(), MediaType.VIDEO, "ruben@gmail.es");
        Media media6 = new Media("aaaa", new Contenido(), MediaType.AUDIO, "amaia@gmail.es");

        assertSame(usuario1,Usuario.getListaUsuarios().get(0));
        assertSame(usuario2,Usuario.getListaUsuarios().get(1));
        assertSame(usuario3,Usuario.getListaUsuarios().get(2));
        assertSame(media1, Media.getListaMedia().get(0));
        assertSame(media2, Media.getListaMedia().get(1));
        assertSame(media3, Media.getListaMedia().get(2));
        assertSame(media4, Media.getListaMedia().get(3));
        assertSame(media5, Media.getListaMedia().get(4));
        assertSame(media6, Media.getListaMedia().get(5));

        Usuario.eliminarUsuarioXDominio("@gmail.es");
        assertEquals(2,Usuario.getListaUsuarios().size());
        assertEquals(2,Media.getListaMedia().size());
    }

    public static void main(String[] args) {
        Usuario pepe = new Usuario("pepe@gmail.com", "Bustamante007");
        Usuario matilde = new Usuario("matilde@gmail.com", "Bustamante007");
        Usuario fran = new Usuario("fran@gmail.com", "Bustamante007");
        pepe.writeXML();
        matilde.writeXML();
        fran.writeXML();

        Usuario.loadXML();
    }
}