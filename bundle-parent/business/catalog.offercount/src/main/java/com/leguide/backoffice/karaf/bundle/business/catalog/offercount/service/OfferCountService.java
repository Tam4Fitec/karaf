package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.service;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.utils.Headers;

@WebService
@Path("/offercount")
public class OfferCountService {

    @GET
    @Path("/update/ksite/{" + Headers.KSITE + "}/shopsite/{" + Headers.SHOPSITE_ID +"}")
    public void updateByShopsite(@PathParam(Headers.KSITE) int ksite, @PathParam(Headers.SHOPSITE_ID) Long shopsite) {

    }

    @GET
    @Path("/update/ksite/{" + Headers.KSITE + "}")
    public void updateForAllShopsite(@PathParam(Headers.KSITE) int ksite) {

    }
}
