package com.leguide.backoffice.karaf.webservices.wsbrands.api.filter;

import javax.servlet.http.HttpServletRequest;

//import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

import org.apache.commons.collections.iterators.EnumerationIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Cache filter for http request to the lookup method (see web.xml)
 * 
 * @author jlboulanger
 * 
 */
@Component
public class RequestCacheFilter { //extends SimplePageCachingFilter {

  /*  private static Logger logger = LoggerFactory.getLogger(RequestCacheFilter.class);

    @Override
    protected String getCacheName() {
        return "wsbrands-request";
    }

    @Override
    protected String calculateKey(HttpServletRequest httpRequest) {
        boolean disableHTTPCache = false;
        for (EnumerationIterator iterator2 = new EnumerationIterator(httpRequest.getHeaderNames()); iterator2.hasNext();) {
            String headerName = (String) iterator2.next();
            if ("cache-control".equalsIgnoreCase(headerName) || "pragma".equalsIgnoreCase(headerName)) {
                for (EnumerationIterator iterator = new EnumerationIterator(httpRequest.getHeaders(headerName)); iterator
                        .hasNext();) {
                    String headerValue = (String) iterator.next();
                    if (headerValue.contains("no-cache")) {
                        disableHTTPCache = true;
                    }
                }
            }
        }
        if (getCacheManager() != null) {
            getCacheManager().getEhcache(this.getCacheName()).setDisabled(disableHTTPCache);
        }
        return super.calculateKey(httpRequest);
    }*/
}
