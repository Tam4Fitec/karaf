package com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.param;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public abstract class AbstractParam<V> {

    private V value;
    private String originalParam;

    public AbstractParam(String param) throws WebApplicationException {
        this.originalParam = param;
        try {
            this.value = parse(param);
        } catch (Exception e) {
            throw new WebApplicationException(onError(param, e));
        }
    }

    public V getValue() {
        return this.value;
    }

    public String getOriginalParam() {
        return this.originalParam;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    protected abstract V parse(String param) throws Exception;

    protected String getErrorMessage(String param, Throwable e) {
        return "Invalid parameter: " + param + " (" + e.getMessage() + ")";
    }

    private Response onError(String param, Throwable e) {
        return Response.status(Status.BAD_REQUEST).entity(getErrorMessage(param, e)).build();
    }
}
