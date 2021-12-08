package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request;

import com.leguide.backoffice.karaf.webservice.client.webs.exception.InvalidWebsRequestException;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.LangEnum;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.ShuffleSortType;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.SortType;
import com.leguide.backoffice.karaf.webservice.client.webs.model.product.request.WebSProductRequestUsingSiteId;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class WebSProductRequestTest {

    @Test
    public void buildBasicValidRequest() throws InvalidWebsRequestException {
        new WebSProductRequestUsingSiteId("127.0.0.1", "8080", "fr", "1", "54543sdsdsd45");
    }

    @Test(expected = InvalidWebsRequestException.class)
    public void buildBasicInvalidLangRequest() throws InvalidWebsRequestException {
        new WebSProductRequestUsingSiteId("127.0.0.1", "8080", "ab", "1", "54543sdsdsd45");
    }

    @Test(expected = InvalidWebsRequestException.class)
    public void buildBasicEmptyHostquest() throws InvalidWebsRequestException {
        new WebSProductRequestUsingSiteId("", "8080", "fr", "1", "54543sdsdsd45");
    }

    @Test(expected = InvalidWebsRequestException.class)
    public void buildBasicNullHostquest() throws InvalidWebsRequestException {
        new WebSProductRequestUsingSiteId(null, "8080", "fr", "1", "54543sdsdsd45");
    }

    @Test(expected = InvalidWebsRequestException.class)
    public void buildBasicNaNPortRequest() throws InvalidWebsRequestException {
        new WebSProductRequestUsingSiteId("127.0.0.1", "NaN", "fr", "1", "54543sdsdsd45");
    }

    @Test(expected = InvalidWebsRequestException.class)
    public void buildBasicProductIdNotDefinedRequest() throws InvalidWebsRequestException {
        new WebSProductRequestUsingSiteId("127.0.0.1", "NaN", "fr", "1", "");
    }

    @Test(expected = InvalidWebsRequestException.class)
    public void buildBasicProductIdNullRequest() throws InvalidWebsRequestException {
        new WebSProductRequestUsingSiteId("127.0.0.1", "NaN", "fr", "1", null);
    }


}
