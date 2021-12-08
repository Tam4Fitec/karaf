package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.utils;

import org.apache.camel.CamelContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class ApplicationContextUtilsBean implements ApplicationContextAware {

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext appContext)
            throws BeansException {
        ctx = appContext;
    }

    public static CamelContext getCamelContext() {
        return ctx.getBean("camelCatalogOfferCountServices", CamelContext.class);
    }
}