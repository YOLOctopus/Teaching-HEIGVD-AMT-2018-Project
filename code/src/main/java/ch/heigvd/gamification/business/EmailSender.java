/**
 * @document EmailSender
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal EJB that sends an email
 */

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

    /**
     * Sends an email to the given address
     * @param subject Subject of the mail
     * @param address Mail address to send the mail to
     * @param name Name of the recipient
     * @param content Content of the mail
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public void sendEmail(String subject, String address, String name, String content) throws MessagingException, UnsupportedEncodingException {
        Message message = new MimeMessage(mailSession);
        message.setSubject(subject);
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(address, name));
        message.setContent(content, "text/html; charset=utf-8");
        Transport.send(message);
    }
}
