package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.connection;

import com.leguide.backoffice.karaf.webservice.client.webs.connector.EngineResponseBuilder;
import com.leguide.backoffice.karaf.webservice.client.webs.exception.InvalidWebsRequestException;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.*;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.ShuffleSortType;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.SortType;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

// TODO Improve Integration test as failing time to time and prevent to compile
@Ignore
public class WebsResponseConverterTest {


    @Test
    public void testStandardWebSCallUsingSiteId() throws InvalidWebsRequestException {

        EngineResponseBuilder engineResponseBuilder = new EngineResponseBuilder();

        WebSOffersRequestWithSiteId request = new WebSOffersRequestWithSiteId("pre-search04.preprod.leguide.com","8080", "fr", "1");
        request.addParameter(WebSOfferField.WORDS,"iphone");
        request.addParameter(WebSOfferField.FIL_CATS,"10000748");
        request.addParameter(WebSOfferField.SORT, SortType.POPU);
        request.addParameter(WebSOfferField.SORT_OPT, ShuffleSortType.SHUFFLE_OPS);
        request.addParameter(WebSOfferField.ROWS, "10");

        Assert.assertNotNull(engineResponseBuilder.buildResponse(request));

    }

    @Test
    public void testStandardWebSCallUsingKsite() throws InvalidWebsRequestException {

        EngineResponseBuilder engineResponseBuilder = new EngineResponseBuilder();

        WebSOffersRequestWithKSite request = new WebSOffersRequestWithKSite("pre-search04.preprod.leguide.com","8080", "fr", "1");
        request.addParameter(WebSOfferField.WORDS,"iphone");
        request.addParameter(WebSOfferField.FIL_CATS,"10000748");
        request.addParameter(WebSOfferField.SORT, SortType.POPU);
        request.addParameter(WebSOfferField.SORT_OPT, ShuffleSortType.SHUFFLE_OPS);
        request.addParameter(WebSOfferField.ROWS, "10");

        Assert.assertNotNull(engineResponseBuilder.buildResponse(request));

    }



}
