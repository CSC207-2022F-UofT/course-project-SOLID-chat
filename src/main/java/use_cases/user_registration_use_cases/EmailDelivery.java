package use_cases.user_registration_use_cases;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailDelivery implements ISendVerificationCode {
    public void sendVerificationCode(String email, int code){
        /*TODO: When this is implemented, the verification code will be sent to the email specified by String email*/
        System.out.println("Verification code sent to " + email);

        //email address we will send the code to
        String to = email;

        //email address we are sending from
        String from = "solidchat02@gmail.com";

        //Get System properties
        Properties properties = System.getProperties();

        //Setting up the mail server
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("solidchat02@gmail.com", "gker cnno jcxv psou");
            }
        });

        session.setDebug(true);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(from);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Verification Code for registration");
            message.setText("The verification code for your account is " + code + ". If this was not you, you can safely " +
                    "ignore this email");
            Transport.send(message);
            System.out.println("success");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
