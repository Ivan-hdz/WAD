package mx.ivan.wad.ProyectoFinal.Utils;


import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author honte_000
 */
public class EmailSender {

  
    @Getter
    @Setter
    private String from;
    @Getter
    @Setter
    private String to;
    @Getter
    @Setter
    private String fromPassword;
    @Getter
    @Setter
    private String mensaje;
    @Setter
    @Getter
    private String subject;
    
    public boolean send(){
        boolean success = false;

      final String user = from;
      final String pass = fromPassword;
      
      String host = "smtp.gmail.com";

      Properties properties = System.getProperties();

       Properties props = new Properties();
      props.put("mail.smtp.ssl.trust", host);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.port", 587);

      Session session = Session.getDefaultInstance(props, null);
      try{
         MimeMessage message = new MimeMessage(session);

         message.setFrom(new InternetAddress(from));

         message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));

         message.setSubject(subject);

         message.setContent(mensaje, "text/html" );
        
         // Send message
         Transport transport = session.getTransport("smtp");
         transport.connect("smtp.gmail.com", user, pass);
         transport.sendMessage(message, message.getAllRecipients());
         System.out.println("Sent message successfully....");
         success = true;
      }catch (javax.mail.MessagingException mex) {
          System.out.println(mex.getMessage());
          success = false;
      }catch(Exception e){
          success = false;
      }
      return success;
   }

   

  

}