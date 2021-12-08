package com.leguide.backoffice.karaf.webservices.wsclient.service;

import com.leguide.backoffice.karaf.business.models.pojo.integration.Source;
import com.leguide.backoffice.karaf.webservices.wsclient.models.Consumption;
import com.leguide.backoffice.karaf.webservices.wsclient.models.ContactForm;
import com.leguide.backoffice.karaf.webservices.wsclient.models.Subscription;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Client service
 */
@WebService
public class ClientService {

    /**
     * Returns shopsite consumption
     *
     * @param shopsiteId shopsite Id
     * @return shopsite consumption
     */
    @GET
    @Path("/shopsite/{shopsiteId}/consumption")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consumption> getConsumption(@PathParam("shopsiteId") Long shopsiteId) {
        return null;
    }

    /**
     * Updates maximum consumption
     *
     * @param shopsiteId shopsite Id
     */
    @PUT
    @Path("/shopsite/{shopsiteId}/consumption/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateConsumption(@PathParam("shopsiteId") Long shopsiteId, @QueryParam("currentUserEmail") String currentUserEmail, Consumption consumption) {
        return null;
    }

    /**
     * Find last invoices
     *
     * @param clientId client Id
     */
    @GET
    @Path("/client/{clientId}/invoices")
    @Produces(MediaType.APPLICATION_JSON)
    public String findLastInvoices(@PathParam("clientId") String clientId) {
        return null;
    }

    /**
     * get Balance
     *
     * @param clientId client Id
     */
    @GET
    @Path("/balance/client/{clientId}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Double getBalance(@PathParam("clientId") String clientId) {
        // TODO renvoie json et 0 si null
        return null;
    }

    /**
     * Gets shopsite feeds
     *
     * @param shopsiteId shopsiteId
     */
    @GET
    @Path("/shopsite/{shopsiteId}/feeds")
    @Produces(MediaType.APPLICATION_JSON)
    public String getShopsiteFeeds(@PathParam("shopsiteId") Long shopsiteId) {
        return null;
    }

    /**
     * Add new feed
     * (create a case in CRM)
     *
     * @param shopsiteId shopsiteId
     * @param source     source
     */
    @PUT
    @Path("/shopsite/{shopsiteId}/feeds")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewFeed(@PathParam("shopsiteId") String shopsiteId, Source source) {
        return null;
    }

    /**
     * Finds current shopsite purchase
     *
     * @param shopsiteId shopsiteId
     */
    @GET
    @Path("/shopsite/{shopsiteId}/purchase")
    @Produces(MediaType.APPLICATION_JSON)
    public String findCurrentShopsitePurchase(@PathParam("shopsiteId") Long shopsiteId) {
        return null;
    }

    /**
     * Create case contact
     *
     * @param contactForm formulaire
     */
    @POST
    @Path("/contact/")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createCaseContact(ContactForm contactForm) {
        return null;
    }

    /**
     * Get subscription statistics
     *
     * @param shopsiteId shopsite Id
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/shopsite/{shopsiteId}/statistics/subscription")
    public String getSubscriptionStatsClicks(@PathParam("shopsiteId") Long shopsiteId, @QueryParam("contactEmail") String contactEmail) {
        return null;
    }

    /**
     * Get subscription purchase
     *
     * @param shopsiteId shopsite Id
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/shopsite/{shopsiteId}/purchase/subscription")
    public String getSubscriptionPurchase(@PathParam("shopsiteId") Long shopsiteId, @QueryParam("contactEmail") String contactEmail) {
        return null;
    }

    /**
     * Subscribe to report stats clicks
     *
     * @param shopsiteId   shopsite Id
     * @param subscription
     */
    @PUT
    @Path("/shopsite/{shopsiteId}/statistics/subscription")
    public String subscribeToReportStatsClicks(@PathParam("shopsiteId") Long shopsiteId, Subscription subscription) {
        return null;
    }

    /**
     * Unsubscribe to report stats clicks
     *
     * @param shopsiteId shopsite Id
     */
    @DELETE
    @Path("/shopsite/{shopsiteId}/statistics/subscription")
    public String unsubscribeToReportStatsClicks(@PathParam("shopsiteId") Long shopsiteId, Subscription subscription) {
        return null;
    }

    /**
     * Subscribe to report
     *
     * @param shopsiteId   shopsite Id
     * @param subscription
     */
    @PUT
    @Path("/shopsite/{shopsiteId}/purchase/subscription")
    public String subscribeToReportPurchase(@PathParam("shopsiteId") Long shopsiteId, Subscription subscription) {
        return null;
    }

    /**
     * Unsubscribe to report
     *
     * @param shopsiteId shopsite Id
     */
    @DELETE
    @Path("/shopsite/{shopsiteId}/purchase/subscription")
    public String unsubscribeToReportPurchase(@PathParam("shopsiteId") Long shopsiteId, Subscription subscription) {
        return null;
    }

    /**
     * @param clientId client Id
     */
    @GET
    @Path("/ecritures/client/{clientId}/")
    @Produces("text/csv")
    public Double getEcritures(@PathParam("clientId") String clientId) {
        return null;
    }

}
