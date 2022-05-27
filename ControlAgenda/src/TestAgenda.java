import java.io.IOException;

public class TestAgenda {
    public static void main(String[] args) {
        try {
            Agenda.guardarDatos("Pepe", "Viyuela", "ee@oo.com", "664664");
            Agenda.guardarDatos("Pepardo", "Viyuelon", "ee@oo.con", "664665");
            Agenda.leerDatos();
            Agenda.guardarObjeto("Pepe", "Viyuela", "ee@oo.com", "664664");
            Agenda.guardarObjeto("Pepardo", "Viyuelon", "ee@oo.con", "664665");
            Agenda.leerObjetos();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
