package com.leguide.backoffice.karaf.bundle.services.search.engine.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.leguide.backoffice.karaf.bundle.services.search.engine.ISearchEngineClientService;
import com.leguide.backoffice.karaf.bundle.services.search.engine.impl.SearchEngineClientService;

public class ApplicationContextUtilsBean implements ApplicationContextAware {

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext appContext)
            throws BeansException {
        ctx = appContext;
    }

    public static ISearchEngineClientService getSearchEngineClient() {
        return ctx.getBean("engineClientService", SearchEngineClientService.class);
    }
}