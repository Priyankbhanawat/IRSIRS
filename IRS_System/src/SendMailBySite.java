/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Priyank_Bhanawat
 */
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMailBySite {
    String user;//change accordingly
    String password;
    String to;
    String subject,detail;
    SendMailBySite(String str1, String str2, String str3, String str4, String str5) {
        user = str1;
        password = str2;
        to = str3;
        subject = str4;
        detail = str5;
    }

    public void sendMail() {

    String host="mail.google.com";


   //Get the session object
    Properties props = new Properties();
    props.put("mail.smtp.user", user);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "465");
    props.put("mail.smtp.starttls.enable","true");
    props.put("mail.smtp.debug", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
    
   
    Session session = Session.getDefaultInstance(props,
    new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(user,password);
      }
    });

   //Compose the message
    try {
     MimeMessage message = new MimeMessage(session);
     message.setFrom(new InternetAddress(user));
     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
     
     message.setSubject(subject);
     
     message.setText(detail);
     
    //send the message
     Transport.send(message);

     System.out.println("message sent successfully...");
 
     } catch (MessagingException e) {e.printStackTrace();}
 }
}
