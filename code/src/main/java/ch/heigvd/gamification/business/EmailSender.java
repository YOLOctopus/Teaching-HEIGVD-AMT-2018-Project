package ch.heigvd.gamification.business;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Stateless
public class EmailSender {
    @Resource(name = "mail/myMailSession")
    Session mailSession;

    public void sendEmail(String subject, String address, String name, String content) throws MessagingException, UnsupportedEncodingException {
        Message message = new MimeMessage(mailSession);
        message.setSubject(subject);
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(address, name));
        message.setContent(content, "text/html; charset=utf-8");
        Transport.send(message);
    }
}
