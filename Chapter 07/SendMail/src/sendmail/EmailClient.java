/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailClient {
public static void main(String[] args) { 
            String to="dhanssoft@gmail.com";//change accordingly
            String from="dhanssoft@gmail.com";//change accordingly
            String pwd="Bestdomains2016";//change accordingly
            
          //Get the session object
          Properties props = new Properties();
          props.put("mail.smtp.host", "smtp.gmail.com"); //Outgoing server (SMTP) - change it to your SMTP server
          props.put("mail.smtp.socketFactory.port", "465");
          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
          props.put("mail.smtp.auth", "true"); //Outgoing server requires authentication
          props.put("mail.smtp.port", "465"); //Outgoing port
          //props.put("mail.smtp.starttls.enable", "true");//TLS must be activated
          //props.put("mail.smtp.port", "587");
      
          Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(from,pwd);//change accordingly
          }});
          //compose message
          try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(from));//change accordingly
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    message.setSubject("Hello");
                    message.setText("Testing.......");
                     //send message
                    Transport.send(message);
                    System.out.println("message sent successfully");
          } catch (MessagingException e) { System.out.println(e);}
}
}
