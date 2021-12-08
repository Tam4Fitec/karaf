package com.leguide.backoffice.karaf.webservice.client.webs.model.common.request;

import java.util.Map;

public abstract class AbstractWebsRequest {

    protected Map<WebSFieldInterface, AbstractRequestParameter> parameters;

    protected String host;

    protected String port;

    public abstract String buildQuery();
}
