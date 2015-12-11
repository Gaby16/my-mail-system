
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    // instance variables - replace the example below with your own
    private MailServer server;
    private String user;
    private String lastEmail;
    private int countSend;
    private int countSpam;
    private int countRecive;
    private MailItem email;

    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer server, String user)
    {
        // initialise instance variables
        this.server = server;
        this.user = user;
        lastEmail = null;
        email = null;

    }

    /**
     *Metodo getNextMailItem devuelve el mensaje del correo.
     */
    public MailItem getNextMailItem()
    {

        String message = email.getMessage();

        if ((message.contains("regalo")) || (message.contains("promocion")))
        {
            email = null;
        }
        else
        {
            lastEmail = message;
        }
        return email;
    }

    /**
     *Metodo que imprime el mensaje del correo
     */
    public void printNextMailItem()
    {

        String message = email.getMessage();

        if (email == null) {
            System.out.println("No hay mensajes.");
        }
        else if (message.contains("trabajo")){
            email.print();
            lastEmail = email.getMessage();
            countRecive = countRecive + 1;
        }
        else if ((message.contains("regalo")) || (message.contains("promocion"))){
            System.out.println("Tu mensaje contenia un spam");
            countRecive = countRecive + 1;
            countSpam = countSpam + 1;
        }
        else {
            email.print();
            lastEmail = email.getMessage();
            countRecive = countRecive + 1;
        }
    }

    /**
     *Metodo sendMailItem envia mensaje.
     */
    public void sendMailItem(String to, String subject, String message){
        MailItem emailToSend = new MailItem(user, to, subject, message);
        server.post(emailToSend);
        countSend = countSend + 1;
    }

    /**
     * Metodo para saber cuantos correos tenemos para nosotros
     */
    public void howManyMailItems()
    {
        System.out.println("Tienes " + server.howManyMailItems(user) + " correos pendientes.");
    }

    /**
     * Metodo para contestar automaticamente al emisor del mensaje.
     */
    public void getNextMailItemAndAutorespond()
    {
        MailItem email = server.getNextMailItem(user);

        if (email != null)
        {
            String subject = "RE " + email.getSubject();
            // OTRA FORMA DE PONER SALTOS DE LINEA String nuevalinea = System.getProperty("line.separator");
            String message = "Estoy de vacaciones.\n" + email.getMessage();
            String from = email.getFrom();
            sendMailItem(from,subject, message);
        }
    }

    /**
     * Metodo para ver el ulitmo metodo recibido.
     */
    public void printLastEmail()
    {
        if (lastEmail != null)
        {
            System.out.println("El ultimo mensaje recibido es:" + lastEmail);
        }
        else
        {
            System.out.println("No tienes ningun mensaje");
        }
    }

    /**
     * Metodo para ver estadisticas
     */
    public void showStats()
    {
        float spamPor;
        if(countRecive != 0){
            spamPor = ((float)countSpam/countRecive) * (100);
        }
        else{
            spamPor = 0;
        }

        System.out.println("Emails recibidos: " + countRecive);
        System.out.println("Emails enviados: " + countSend);
        System.out.println("Emails recibidos con spam: " + spamPor + "%");
        System.out.println("Email mas largo");
    }

    /**
     * Metodo que muestra datos del ultimo spam recibido, sino ha recibido spam
     * nos informa de ello
     */
    //public void showInfoLastSpam()
    //{
        //if(email==spamPor){
            //System.out.println("De: " + from);
           // System.out.println("A: " + to);
           // System.out.println("Este es el asunto del mensaje: " + subject);
           // System.out.println("Este es el mensaje: " + message);
       // }
       // else{
        //    System.out.println("No tienes ningun spam");
        //}
    }

