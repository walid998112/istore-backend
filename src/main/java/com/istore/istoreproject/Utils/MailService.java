package com.istore.istoreproject.Utils;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
    public void sendEmail(String to, String subject, String body)
            throws AddressException, MessagingException {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.user", "walidouahrani69@gmail.com");
        properties.put("mail.smtp.password", "aotegdkwlqackqon");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("walidouahrani69@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);

        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", "walidouahrani69@gmail.com", "aotegdkwlqackqon");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
