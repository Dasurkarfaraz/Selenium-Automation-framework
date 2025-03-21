/**
 * This package contains classes for sending emails with attachments using JavaMail API.
 */
package com.starquick.java_mail_API;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * EmailAttachmentsSender provides functionality to send emails with attachments using JavaMail API.
 * It allows sending emails with multiple attachments to multiple recipients.
 */
public class EmailAttachmentsSender {

    /**
     * Sends an email with attachments to the specified recipients.
     * 
     * @param host       the SMTP server host
     * @param port       the SMTP server port
     * @param userName   the email account username
     * @param password   the email account password
     * @param toAddress  an array of recipient email addresses
     * @param subject    the subject of the email
     * @param message    the body of the email
     * @param attachFiles optional file paths of attachments to include in the email
     * @throws AddressException if the address is invalid
     * @throws MessagingException if there is an error while sending the email
     */
    public static void sendEmailWithAttachments(String host, String port, final String userName, final String password,
            String[] toAddress, String subject, String message, String... attachFiles)
            throws AddressException, MessagingException {
        // Sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);

        // Creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(properties, auth);

        // Creates a new email message
        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));

        InternetAddress[] addressTo = new InternetAddress[toAddress.length];
        for (int i = 0; i < toAddress.length; i++)
            addressTo[i] = new InternetAddress(toAddress[i]);
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        msg.setSubject(subject);
        msg.setSentDate(new Date());

        // Creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");

        // Creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();

                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                multipart.addBodyPart(attachPart);
            }
        }

        // Sets the multi-part as email's content
        msg.setContent(multipart);

        // Sends the email
        Transport.send(msg);
    }
}
