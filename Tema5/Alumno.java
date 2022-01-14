package Tema5;

public class Alumno {

    private static int totalAlumnos = 0;

    private int id;
    private String nombre;
    private String grupo;

    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.grupo = "No asignado";
        totalAlumnos++;
    }

    public Alumno(int id, String nombre, String grupo) {
        this.id = id;
        this.nombre = nombre;
        this.grupo = grupo;
        totalAlumnos++;
    }

    public void preguntarDuda() {
        System.out.println(this.nombre + " levanta la mano");
    }

    public static void imprimirInforme() {
        System.out.println("Total de alumnos: " + totalAlumnos);
    }

    public static void imprimirInformeAlumnos(Alumno[] alumnos) {
        System.out.println("Nombre\tGrupo");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.nombre + "\t" + alumno.grupo);
        }
    }
}
