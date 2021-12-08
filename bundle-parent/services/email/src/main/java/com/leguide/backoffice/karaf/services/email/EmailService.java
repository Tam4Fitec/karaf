package com.leguide.backoffice.karaf.services.email;

import com.leguide.backoffice.karaf.services.email.models.Email;
import com.leguide.backoffice.karaf.services.email.models.EmailAttachment;

import javax.mail.MessagingException;

/**
 * Email Service Sending emails.
 *
 * @author Manuel Darcemont
 */
public interface EmailService {

    /**
     * Sends a simple email.
     *
     * @param email Email to send
     * @throws MessagingException
     */
    public void sendEmail(Email email) throws MessagingException;

    /**
     * Sends a html email
     *
     * @param email Email to send
     * @throws MessagingException
     */
    public void sendEmailHtml(Email email) throws MessagingException;

    /**
     * Send a simple email with attachment.
     *
     * @param email      Email to send.
     * @param attachment Attachment to send
     * @throws MessagingException
     */
    public void sendEmailWithAttachment(Email email, EmailAttachment attachment) throws MessagingException;

    /**
     * Send a HTML email with attachment.
     *
     * @param email      Email to send.
     * @param attachment Attachment to send
     * @throws MessagingException
     */
    public void sendEmailHtmlWithAttachment(Email email, EmailAttachment attachment) throws MessagingException;

}
