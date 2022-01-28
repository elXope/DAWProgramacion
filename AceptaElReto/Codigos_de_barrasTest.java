package AceptaElReto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Codigos_de_barrasTest {

    @Test
    void rellena() {
        String cad = "22";
        String exp8 = "00000022";
        assertEquals(exp8, Codigos_de_barras.rellena(cad, 8));
        cad = "22222222";
        assertEquals(cad, Codigos_de_barras.rellena(cad, 8));
        cad = "2" + cad;
        String exp13 = "0000222222222";
        assertEquals(exp13, Codigos_de_barras.rellena(cad, 13));

    }
}