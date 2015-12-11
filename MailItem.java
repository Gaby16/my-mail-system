
/**
 * Esta clase representa un mensaje de email.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    // almacena desde quien, para quien y el contenido del mensaje.
    private String from, to, message;
    private String subject;

    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String from, String to, String subject, String message)
    {
        // initialise instance variables
        this.from = from;
        this.to = to;
        this.message = message;
        // asunto del mensaje
        this.subject = subject;
    }

    /**
     * Primer metodo getter
     */
    public String getFrom()
    {
        // put your code here
        return from;
    }
      
    /**
    * Primer metodo getter
    */
    public String getTo()
    {
        // put your code here
        return to;
    }  
    
    /**
    * Primer metodo getter
    */
    public String getMessage()
    {
        // put your code here
        return message;
    }
    /**
    * Primer metodo getter
    */
    public String getSubject()
    {
        // put your code here
        return subject;
    }
    
    /**
    * Metodo print que devuelve los valores de from to y message
    */
    public void print()
    {
         System.out.println("De: " + from);
         System.out.println("A: " + to);
         System.out.println("Este es el asunto del mensaje: " + subject);
         System.out.println("Este es el mensaje: " + message);
    }
    
}
