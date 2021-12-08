package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import com.leguide.backoffice.karaf.bundle.business.service.ShopSiteService;
import com.leguide.backoffice.karaf.services.email.EmailService;
import com.leguide.backoffice.karaf.services.email.models.Email;
import com.leguide.backoffice.karaf.services.email.models.EmailRecipient;
import com.leguide.backoffice.karaf.webservices.wsclient.models.ContactForm;
import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.mail.Message;
import javax.mail.MessagingException;
import java.util.Arrays;

/**
 * Email management
 *
 * @author manuel
 */
public class SendEmailBean {

    private Logger logger = LoggerFactory.getLogger(SendEmailBean.class);

    @Value("${leguide.mail.server.host}")
    public String MAIL_SERVER_HOST;

    @Value("${mail.sender}")
    private String MAIL_SENDER;

    @Value("${mail.alertconsumption.sender}")
    private String MAIL_ALERTCONSUMPTION_SENDER;

    @Value("${mail.recipients}")
    private String MAIL_RECIPIENTS;

    private DemandDefinitionBean demandDefinitionBean;

    private TemplateMailBean templateMailBean;

    private LanguageBean languageBean;

    private EmailService emailService;

    private ShopSiteService shopSiteService;

    /**
     * Send a "contact" email
     */
    public void sendEmailContact(@Body ContactForm contactForm) throws MessagingException {
        String subject, recipients;
        String body = contactForm.getBody();

        if ((contactForm.getDemandType() == 8) || (contactForm.getDemandType() == 12)) {
            subject = demandDefinitionBean.getDemandDefinition(contactForm.getDemandType()).getLabelDemande();
            recipients = MAIL_RECIPIENTS;
        } else {
            String country = shopSiteService.findById(contactForm.getShopsiteId()).getCountry().toLowerCase();
            DemandDefinitionBean.CiaoDemandDefinition ciaoDemandDefinition = demandDefinitionBean.getCiaoDemandDefinition(country);
            subject = ciaoDemandDefinition.getLabelDemande();
            recipients = ciaoDemandDefinition.getEmail();
        }

        emailService.sendEmail(buildContactEmail(recipients, subject, body));
    }

    /**
     * Send a "alert consumption" email
     */
    public void sendEmailAlertConsumption(Exchange exchange) throws MessagingException {
        String recipients = exchange.getIn().getHeader("recipients", String.class);
        String language = exchange.getIn().getHeader("language", String.class);

        String subject = languageBean.getSubjectMailAlertConsumptionForLanguage(language);
        String body = getBodyAlertConsumption(exchange);
        emailService.sendEmailHtml(buildAlertConsumptionEmail(recipients, subject, body));
    }

    /**
     * Build "contact" email
     *
     * @return email
     */
    private Email buildContactEmail(String recipients, String subject, String body) {
        return new Email.Builder(
                MAIL_SERVER_HOST,
                MAIL_SENDER,
                Arrays.asList(new EmailRecipient(Message.RecipientType.TO, recipients)))
                .subject(subject).body(body).build();
    }

    /**
     * Build "alert consumption" email
     *
     * @return email
     */
    private Email buildAlertConsumptionEmail(String recipients, String subject, String body) {
        return new Email.Builder(
                MAIL_SERVER_HOST,
                MAIL_ALERTCONSUMPTION_SENDER,
                Arrays.asList(new EmailRecipient(Message.RecipientType.CC, recipients)))
                .subject(subject).body(body).build();
    }

    /**
     * Gets body for "alert consumption" email
     *
     * @param exchange exchange
     * @return body
     */
    private String getBodyAlertConsumption(Exchange exchange) {

        return templateMailBean.buildTemplateMailAlertConsumption(
                exchange.getIn().getHeader("language", String.class),
                exchange.getIn().getHeader("url", String.class),
                exchange.getIn().getHeader("maximumAmount", Double.class),
                exchange.getIn().getHeader("month", String.class),
                exchange.getIn().getHeader("currentUserEmail", String.class));
    }

    public void setDemandDefinitionBean(DemandDefinitionBean demandDefinitionBean) {
        this.demandDefinitionBean = demandDefinitionBean;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void setTemplateMailBean(TemplateMailBean templateMailBean) {
        this.templateMailBean = templateMailBean;
    }

    public void setLanguageBean(LanguageBean languageBean) {
        this.languageBean = languageBean;
    }

    public void setShopSiteService(ShopSiteService shopSiteService) {
        this.shopSiteService = shopSiteService;
    }
}