package Tema6.club;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Store details of club memberships.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Club
{
    // Define any necessary fields here ...
    private ArrayList<Membership> listaMiembros = new ArrayList<>();
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...

    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        this.listaMiembros.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return this.listaMiembros.size();
    }

    /**
     * Determinar el numero de miembros que se han unido en el mes indicado
     * @param month El mes que nos interesa
     * @return El numero de miembros que se han unido este mes
     */
    public int joinedInMonth(int month) {
        final int[] output = {0};
        if (month <= 0 || month > 12) {
            System.out.println("Mes no valido.");
        } else {
            this.listaMiembros.forEach(miembro -> {if (miembro.getMonth() == month) output[0]++;});
        }
        return output[0];
    }

    public int purge(int month) {
        Iterator<Membership> it = this.listaMiembros.iterator();
        int output = 0;
        while (it.hasNext()) {
            Membership miembro = it.next();
            if (miembro.getMonth() == month) {
                it.remove();
                output++;
            }
        }
        return output;
    }
}