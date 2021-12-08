package com.leguide.backoffice.karaf.webservices.offercategorization.utils;

import org.apache.camel.model.ModelCamelContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtilsBean implements ApplicationContextAware {


//	}

    private static ApplicationContext ctx;

    private static final String CAMEL_CONTEXT = "camelContextOfferCategorization";

    public static ModelCamelContext getCamelContext() {
        return (ModelCamelContext) ctx.getBean(CAMEL_CONTEXT);
    }

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        ctx = appContext;
    }
}
