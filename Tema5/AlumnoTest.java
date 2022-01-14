package Tema5;

public class AlumnoTest {
    public static void main(String[] args) {
        Alumno a1, a2, a3, a4;

        a1 = new Alumno(1, "Pablo");
        a2 = new Alumno(2, "Maria", "1CFSJ");
        a3 = new Alumno(3, "Manuel", "1CFSK");
        a4 = new Alumno(4, "Alma");

        a1.preguntarDuda();
        a2.preguntarDuda();

        Alumno.imprimirInforme();

        Alumno[] alumnos = {a1, a2, a3, a4};
        Alumno.imprimirInformeAlumnos(alumnos);
    }
}
