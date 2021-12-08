package com.leguide.backoffice.karaf.webservice.client.webs.connector;

import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.response.WebSOfferResponse;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class WebsResponseConverter {

    private String response;

    public WebSOfferResponse convertJsonToWebSResponse() throws IOException {

        //use jackon to read json
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, WebSOfferResponse.class);
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
