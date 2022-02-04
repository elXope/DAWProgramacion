package Tema5.MailSystemAvanzado;

import java.util.List;
/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    // Last mail recived
    private MailItem lastMailRecived;

    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }

    /**
     * Print the next mail item (if any) for this user to the text
     * terminal.
     */
    public void printNextMailItem()
    {
        this.lastMailRecived = server.getNextMailItem(user);
        if(this.lastMailRecived == null) {
            System.out.println("No new mail.");
        }
        else {
            this.lastMailRecived.print();
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to, String asunto, String message)
    {
        String[] destinatarios = to.split(";");
        for (String destinatario : destinatarios) {
            MailItem item = new MailItem(user, destinatario, asunto, message);
            server.post(item);
        }
    }

    public void forwardLastMailItem (String to) {
        String[] destinatarios = to.split(";");
        for (String destinatario : destinatarios) {
            MailItem item = new MailItem(user, destinatario, this.lastMailRecived.getAsunto(), this.lastMailRecived.getMessage());
            server.post(item);
        }
    }
}