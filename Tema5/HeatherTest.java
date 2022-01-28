package Tema5;

import static org.junit.jupiter.api.Assertions.*;

class HeatherTest {

    @org.junit.jupiter.api.Test
    void warmer() {
        Heather estufa = new Heather(10, 20);
        estufa.warmer();
        assertEquals(20.0, estufa.getTemperature());
        estufa.warmer();
        assertEquals(20.0, estufa.getTemperature());
    }

    @org.junit.jupiter.api.Test
    void cooler() {
        Heather estufa = new Heather(10, 20);
        estufa.cooler();
        assertEquals(10.0, estufa.getTemperature());
        estufa.cooler();
        assertEquals(10.0, estufa.getTemperature());
    }

    @org.junit.jupiter.api.Test
    void setIncrement() {
        Heather estufa = new Heather(10, 20);
        estufa.setIncrement(1);
        estufa.warmer();
        assertEquals(16.0, estufa.getTemperature());
        estufa.setIncrement(0);
        estufa.warmer();
        assertEquals(17.0, estufa.getTemperature());
        estufa.setIncrement(6);
        estufa.warmer();
        assertEquals(18.0, estufa.getTemperature());

    }

}