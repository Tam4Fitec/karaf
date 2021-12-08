package com.leguide.backoffice.karaf.services.email.impl;

import com.leguide.backoffice.karaf.services.email.EmailService;
import com.leguide.backoffice.karaf.services.email.models.Email;
import com.leguide.backoffice.karaf.services.email.models.EmailAttachment;
import com.leguide.backoffice.karaf.services.email.models.EmailRecipient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * Email Service implementation
 *
 * @author Manuel Darcemont
 */
public class EmailServiceImpl implements EmailService {

    private static final String CONTENTTYPE_TEXT = "text/plain";

    private static final String CONTENTTYPE_EMAIL = "text/html; charset=UTF-8";

    private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);


    public EmailServiceImpl() {

    }

    /**
     * Sends a simple email.
     *
     * @param email Email to send
     * @throws MessagingException
     */
    public void sendEmail(Email email) throws MessagingException {
        sendEmailWithContentType(email, CONTENTTYPE_TEXT);
    }

    /**
     * Sends a html email
     *
     * @param email Email to send
     * @throws MessagingException
     */
    public void sendEmailHtml(Email email) throws MessagingException {
        sendEmailWithContentType(email, CONTENTTYPE_EMAIL);
    }

    /**
     * Sends email with contentType specified
     *
     * @param email       email
     * @param contentType contentType
     * @throws MessagingException
     */
    private void sendEmailWithContentType(Email email, String contentType) throws MessagingException {
        ClassLoader tcl = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(javax.mail.Session.class.getClassLoader());
            Session session = Session.getInstance(buildProperties(email));
            Message message = buildMessage(email, session);
            message.setContent(addTextContent(email.getBody(), contentType), contentType);
            Transport.send(message);
        } finally {
            Thread.currentThread().setContextClassLoader(tcl);
        }
    }

    /**
     * Send a simple email with attachment.
     *
     * @param email      Email to send.
     * @param attachment Attachment to send
     * @throws MessagingException
     */
    public void sendEmailWithAttachment(Email email, EmailAttachment attachment) throws MessagingException {
        sendEmailWithAttachmentAndContentType(email, attachment, CONTENTTYPE_TEXT);
    }

    /**
     * Send a HTML email with attachment.
     *
     * @param email      Email to send.
     * @param attachment Attachment to send
     * @throws MessagingException
     */
    public void sendEmailHtmlWithAttachment(Email email, EmailAttachment attachment) throws MessagingException {
        sendEmailWithAttachmentAndContentType(email, attachment, CONTENTTYPE_EMAIL);
    }

    /**
     * Send an email with attachment and contentType specified
     *
     * @param email      Email to send.
     * @param attachment Attachment to send
     * @throws MessagingException
     */
    private void sendEmailWithAttachmentAndContentType(Email email, EmailAttachment attachment, String contentType) throws MessagingException {
        ClassLoader tcl = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(javax.mail.Session.class.getClassLoader());
            Session session = Session.getInstance(buildProperties(email));
            Message message = buildMessage(email, session);
            message.setContent(addAttachment(addTextContent(email.getBody(), contentType), attachment), contentType);
            Transport.send(message);
        } finally {
            Thread.currentThread().setContextClassLoader(tcl);
        }
    }

    /**
     * Builds the server properties
     *
     * @param mail Mail definition
     * @return properties
     */
    private Properties buildProperties(Email mail) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", mail.getHost());
        if (mail.getPort() != null)
            properties.put("mail.smtp.port", Integer.toString(mail.getPort()));
        return properties;
    }

    /**
     * Builds the message
     *
     * @param email   Mail definition
     * @param session Javax mail session
     * @return Message to send
     * @throws MessagingException
     */
    private MimeMessage buildMessage(Email email, Session session) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email.getSender()));
        for (EmailRecipient emailRecipient : email.getRecipients()) {
            message.setRecipients(emailRecipient.getRecipientType(), InternetAddress.parse(emailRecipient.getAddress()));
        }
        message.setSubject(email.getSubject(), "UTF-8");
        return message;
    }

    /**
     * Adds the text content
     *
     * @param textContent Text content
     * @return Multipart
     * @throws MessagingException
     */
    private Multipart addTextContent(String textContent, String contentType) throws MessagingException {
        Multipart multipart = new MimeMultipart();
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(textContent, contentType);
        multipart.addBodyPart(messageBodyPart);
        return multipart;
    }

    /**
     * Adds the attachment
     *
     * @param multipart  multipart
     * @param attachment attachment
     * @return Multipart
     * @throws MessagingException
     */
    private Multipart addAttachment(Multipart multipart, EmailAttachment attachment) throws MessagingException {
        MimeBodyPart messageBodyPart = new MimeBodyPart();
       	messageBodyPart.setDataHandler(new DataHandler(attachment.getFile(), attachment.getContentType()));
        messageBodyPart.setFileName(attachment.getFileName());
        multipart.addBodyPart(messageBodyPart);
        return multipart;
    }
}
