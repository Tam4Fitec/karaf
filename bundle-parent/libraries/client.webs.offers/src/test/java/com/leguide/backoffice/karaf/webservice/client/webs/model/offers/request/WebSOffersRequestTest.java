package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request;

import com.leguide.backoffice.karaf.webservice.client.webs.exception.InvalidWebsRequestException;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.LangEnum;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.ShuffleSortType;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.request.type.SortType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class WebSOffersRequestTest {

    @Test
    public void buildBasicValidRequest() throws InvalidWebsRequestException {
        new WebSOffersRequestWithSiteId("127.0.0.1", "8080", "fr", "1");
    }

    @Test(expected = InvalidWebsRequestException.class)
    public void buildBasicInvalidLangRequest() throws InvalidWebsRequestException {
        new WebSOffersRequestWithSiteId("127.0.0.1", "8080", "ab", "1");
    }

    @Test(expected = InvalidWebsRequestException.class)
    public void buildBasicEmptyHostquest() throws InvalidWebsRequestException {
        new WebSOffersRequestWithSiteId("", "8080", "fr", "1");
    }

    @Test(expected = InvalidWebsRequestException.class)
    public void buildBasicNullHostquest() throws InvalidWebsRequestException {
        new WebSOffersRequestWithSiteId(null, "8080", "fr", "1");
    }

    @Test(expected = InvalidWebsRequestException.class)
    public void buildBasicNaNPortRequest() throws InvalidWebsRequestException {
        new WebSOffersRequestWithSiteId("127.0.0.1", "NaN", "fr", "1");
    }

    @Test
    public void checkBasicExpectedRequest() throws InvalidWebsRequestException {
        final String expected= "127.0.0.1:8080/webs/api/1.0/offer/search/lang/fr/site-id/1?";
        WebSOffersRequestWithSiteId request = new WebSOffersRequestWithSiteId("127.0.0.1","8080", "fr", "1");

        Assert.assertEquals(expected, request.buildQuery());
    }

    @Test
    public void checkRequestUsingWords() throws InvalidWebsRequestException {
        final String expected= "127.0.0.1:8080/webs/api/1.0/offer/search/lang/fr/site-id/1?words=iphone";
        WebSOffersRequestWithSiteId request = new WebSOffersRequestWithSiteId("127.0.0.1","8080", "fr", "1");
        request.addParameter(WebSOfferField.WORDS, "iphone");

        Assert.assertEquals(expected, request.buildQuery());
    }


    @Test
    public void checkRequestBooleanParams() throws InvalidWebsRequestException {
        final String expected= "127.0.0.1:8080/webs/api/1.0/offer/search/lang/fr/site-id/1?only_cat=true";
        WebSOffersRequestWithSiteId request = new WebSOffersRequestWithSiteId("127.0.0.1","8080", "fr", "1");
        request.addParameter(WebSOfferField.ONLY_CAT, "true");

        Assert.assertEquals(expected, request.buildQuery());
    }

    @Test
    public void checkRequestCollectionStringParams() throws InvalidWebsRequestException {
        final String expected= "127.0.0.1:8080/webs/api/1.0/offer/search/lang/fr/site-id/1?fil_cats=1010500,1010506,1011400";
        WebSOffersRequestWithSiteId request = new WebSOffersRequestWithSiteId("127.0.0.1","8080", "fr", "1");
        Collection<String> cats = new ArrayList<>();
        cats.add("1010500");
        cats.add("1010506");
        cats.add("1011400");
        request.addParameter(WebSOfferField.FIL_CATS, cats);

        Assert.assertEquals(expected, request.buildQuery());
    }

    @Test
    public void checkRequestCollectionIntegerParams() throws InvalidWebsRequestException {
        final String expected= "127.0.0.1:8080/webs/api/1.0/offer/search/lang/fr/site-id/1?fil_cats=1010500,1010506,1011400";
        WebSOffersRequestWithSiteId request = new WebSOffersRequestWithSiteId("127.0.0.1","8080", "fr", "1");
        Collection<Integer> cats = new ArrayList<>();
        cats.add(1010500);
        cats.add(1010506);
        cats.add(1011400);
        request.addParameter(WebSOfferField.FIL_CATS, cats);

        Assert.assertEquals(expected, request.buildQuery());
    }

    @Test
    public void checkRequestUsingLangEnumTypeParams() throws InvalidWebsRequestException {
        final String expected= "127.0.0.1:8080/webs/api/1.0/offer/search/lang/fr/site-id/1?deliv=fr";
        WebSOffersRequestWithSiteId request = new WebSOffersRequestWithSiteId("127.0.0.1","8080", "fr", "1");
        request.addParameter(WebSOfferField.DELIV, LangEnum.FR);

        Assert.assertEquals(expected, request.buildQuery());
    }

    @Test
    public void checkRequestUsingSortOptEnumTypeParams() throws InvalidWebsRequestException {
        final String expected= "127.0.0.1:8080/webs/api/1.0/offer/search/lang/fr/site-id/1?sort_opt=shuffle-ops";
        WebSOffersRequestWithSiteId request = new WebSOffersRequestWithSiteId("127.0.0.1","8080", "fr", "1");
        request.addParameter(WebSOfferField.SORT_OPT, ShuffleSortType.SHUFFLE_OPS);

        Assert.assertEquals(expected, request.buildQuery());
    }

    @Test
    public void checkRequestUsingSortEnumTypeParams() throws InvalidWebsRequestException {
        final String expected= "127.0.0.1:8080/webs/api/1.0/offer/search/lang/fr/site-id/1?sort=popu";
        WebSOffersRequestWithSiteId request = new WebSOffersRequestWithSiteId("127.0.0.1","8080", "fr", "1");
        request.addParameter(WebSOfferField.SORT, SortType.POPU);

        Assert.assertEquals(expected, request.buildQuery());
    }
}
