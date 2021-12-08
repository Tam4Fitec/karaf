package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.response;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*
 * Created by stephane.ben-zakoun on 12/06/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHeader {

    private int status;

    private int queryTime;

    private String queryID;

    private String req_id;

    private String search_id;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(int queryTime) {
        this.queryTime = queryTime;
    }

    public String getReq_id() {
        return req_id;
    }

    public void setReq_id(String req_id) {
        this.req_id = req_id;
    }

    public String getQueryID() {

        return queryID;
    }

    public void setQueryID(String queryID) {
        this.queryID = queryID;
    }

    public void setSearch_id(String search_id) {
        this.search_id = search_id;
    }

    public String getSearch_id() {
        return search_id;
    }
}
