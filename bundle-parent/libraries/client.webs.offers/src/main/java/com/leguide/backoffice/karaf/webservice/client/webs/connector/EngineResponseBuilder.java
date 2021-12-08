package com.leguide.backoffice.karaf.webservice.client.webs.connector;

import com.leguide.backoffice.karaf.webservice.client.webs.exception.RequestConnectionException;
import com.leguide.backoffice.karaf.webservice.client.webs.model.common.request.AbstractWebsRequest;
import com.leguide.backoffice.karaf.webservice.client.webs.model.offers.response.WebSOfferResponse;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class EngineResponseBuilder {

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(EngineResponseBuilder.class);

    private WebsResponseConverter websResponseConverter;

    public WebSOfferResponse buildResponse(AbstractWebsRequest request) {

        websResponseConverter = new WebsResponseConverter();
        String requestStr = "http://" + request.buildQuery();
        logger.debug("webs request: " + requestStr);
        try {
            String response = getHttpGetResponse(requestStr);
            return convertJsonToWebSResponse(response);
        } catch (RequestConnectionException e) {
            logger.error("An error occured when launching request " + requestStr);
            return null;
        } catch (IOException e) {
            logger.error("An connection error occured when launching request " + requestStr);
            return null;
        }

    }

    private WebSOfferResponse convertJsonToWebSResponse(String response) throws IOException {

        websResponseConverter.setResponse(response);
        return websResponseConverter.convertJsonToWebSResponse();
    }

    /**
     * Method to make an http call and get the return
     *
     * @param url
     * @return
     * @throws RequestConnectionException
     */
    private String getHttpGetResponse(String url) throws RequestConnectionException {
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10 * 1000).setConnectionRequestTimeout(10 * 1000)
                .setSocketTimeout(10 * 1000).build();
        HttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();

        HttpGet request = new HttpGet(url);
        request.setConfig(requestConfig);
        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                InputStream is = response.getEntity().getContent();
                return IOUtils.toString(is, StandardCharsets.UTF_8);
            } else {
                throw new RequestConnectionException("Error Code : " + response.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            throw new RequestConnectionException(e);
        }
    }

}
