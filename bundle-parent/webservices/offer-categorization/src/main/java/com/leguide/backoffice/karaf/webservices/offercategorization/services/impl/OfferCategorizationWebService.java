package com.leguide.backoffice.karaf.webservices.offercategorization.services.impl;


import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.leguide.backoffice.karaf.webservices.offercategorization.models.ws.OfferInformations;


/**
 * Offer Gathering WebService
 */
@WebService
public class OfferCategorizationWebService {

	@GET
	@Path("/getCategorizationOffers/country/{country}/idx/{listProduct}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public OfferInformations getCategorizationOffers(@PathParam("country") String country, @PathParam("listProduct") String listProduct ) {
		return null;
	}

	@POST
	@Path("/saveCategoryOffer/country/{country}/offer/{idoffer}/thesaurus/{idthesaurus}")    
	public void saveCategoryOffer(@PathParam("country") String country, @PathParam("idoffer") String idoffer, @PathParam("idthesaurus") String idthesaurus) {
	}
	
}