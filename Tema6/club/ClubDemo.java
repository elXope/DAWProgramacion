package Tema6.club;

/**
 * Provide a demonstration of the Club and Membership
 * classes.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClubDemo
{
    // instance variables - replace the example below with your own
    private Club club;

    /**
     * Constructor for objects of class ClubDemo
     */
    public ClubDemo()
    {
        club = new Club();
    }

    /**
     * Add some members to the club, and then
     * show how many there are.
     * Further example calls could be added if more functionality
     * is added to the Club class.
     */
    public void demo()
    {
        try {
            club.join(new Membership("David", 13, 2004));
            club.join(new Membership("Michael", 1, 2004));
            System.out.println("The club has " +
                    club.numberOfMembers() +
                    " members.");
        }
        catch (IllegalArgumentException excepcion) {
            System.out.println("Se ha encontrado un error de >:( ARGUMENTOS ILEGALES >:(\n" + excepcion.getMessage());
        }
    }

    public static void main(String[] args) {
        ClubDemo test = new ClubDemo();
        test.demo();
    }
}