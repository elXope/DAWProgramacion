import java.io.Serializable;

public class Contacto implements Serializable {
    String nombre;
    String apellidos;
    String email;
    String telefono;

    public Contacto(String nombre, String apellidos, String email, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nApellidos: " + apellidos
                + "\nEmail: " + email
                + "\nTelefono: " + telefono
                + "\n============================";
    }
}
