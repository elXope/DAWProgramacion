package Tema5.MailSystemAvanzado;

/**
 * A class to model a simple mail item. The item has sender and recipient
 * addresses and a message string.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MailItem
{
    // The sender of the item.
    private String from;
    // The intended recipient.
    private String to;
    // Asunto
    private String asunto;
    // The text of the message.
    private String message;

    /**
     * Create a mail item from sender to the given recipient,
     * containing the given message.
     * @param from The sender of this item.
     * @param to The intended recipient of this item.
     * @param message The text of the message to be sent.
     */
    public MailItem(String from, String to, String asunto, String message)
    {
        this.from = from;
        this.to = to;
        this.asunto = asunto;
        this.message = message;
    }

    /**
     * @return The sender of this message.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * @return The intended recipient of this message.
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return The asunto of this message.
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @return The text of the message.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Print this mail message to the text terminal.
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Asunto: " + this.asunto);
        System.out.println("Message: " + message);
    }
}