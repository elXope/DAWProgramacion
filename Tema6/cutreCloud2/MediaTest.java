package Tema6.cutreCloud2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaTest {

    @Test
    void getID() {
        Usuario usuario1 = new Usuario("joaquin@gmail.com", "xd");
        Usuario usuario2 = new Usuario("sabrina@gmail.com", "xdd");
        Usuario usuario3 = new Usuario("amaia@gmail.com", "xdddd");

        Media media1 = new Media("NFT Willyrex", new Contenido(), MediaType.IMAGEN, "joaquin@gmail.com");
        Media media2 = new Media("Dibujito", new Contenido(), MediaType.AUDIO, "sabrina@gmail.com");
        Media media3 = new Media("canta", new Contenido(), MediaType.VIDEO, "amaiolis@gmail.com");
        Media media4 = new Media("canta", new Contenido(), MediaType.VIDEO, "amaia@gmail.com");

        assertEquals(0, media1.getID());
        assertEquals(1, media2.getID());
        assertEquals(2, media3.getID());
        assertEquals(-1,media4.getID());
    }

    @Test
    void getNombre() {
        Usuario usuario4 = new Usuario("pepe@gmail.com", "xd");
        Usuario usuario5 = new Usuario("mari@gmail.com", "xdd");
        Usuario usuario6 = new Usuario("fina@gmail.com", "xdddd");

        Contenido cont = new Contenido();

        Media media5 = new Media("Esparta", cont, MediaType.IMAGEN, "mari@gmail.com");
        Media media6 = new Media("Danae", new Contenido(), MediaType.AUDIO, "pepe@gmail.com");
        Media media7 = new Media("crosta", new Contenido(), MediaType.VIDEO, "finolis@gmail.com");
        Media media8 = new Media("crosta", new Contenido(), MediaType.VIDEO, "fina@gmail.com");

        assertEquals("Esparta", media5.getNombre());
        assertEquals("Danae", media6.getNombre());
        assertEquals("crosta", media7.getNombre());
        assertEquals("Nombre repetido: crosta", media8.getNombre());
    }

    @Test
    void getTipo() {
        Media media9 = new Media("imagen", new Contenido(), MediaType.IMAGEN, "mari@gmail.com");
        Media media10 = new Media("audio", new Contenido(), MediaType.AUDIO, "pepe@gmail.com");
        Media media11 = new Media("video", new Contenido(), MediaType.VIDEO, "finolis@gmail.com");

        assertEquals(MediaType.IMAGEN, media9.getTipo());
        assertEquals(MediaType.AUDIO, media10.getTipo());
        assertEquals(MediaType.VIDEO, media11.getTipo());
    }

    @Test
    void eliminarMedia() {
        Media media12 = new Media("imagen", new Contenido(), MediaType.IMAGEN, "mari@gmail.com");
        Media media13 = new Media("audio", new Contenido(), MediaType.AUDIO, "pepe@gmail.com");
        Media media14 = new Media("video", new Contenido(), MediaType.VIDEO, "finolis@gmail.com");
    }

    @Test
    void eliminarTipoMedia() {
    }
}