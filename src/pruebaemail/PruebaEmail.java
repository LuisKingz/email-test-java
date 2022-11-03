/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaemail;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author lfern
 */
public class PruebaEmail {

    /**
     * @param args the command line arguments
     */
    public static String Username = "mi correo";
    public static String PassWord = "mi contraseña";

    String Subject = "prueba de correo";
    String To = "correo remitente";
    String Mensaje = "cuerpo del correo";

    public void SendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Username, PassWord);
                    }
                });
        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setText(Mensaje);
            Transport.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
