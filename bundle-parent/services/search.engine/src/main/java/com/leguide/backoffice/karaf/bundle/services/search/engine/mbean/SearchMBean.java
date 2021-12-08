package com.leguide.backoffice.karaf.bundle.services.search.engine.mbean;


/**
 * SearchMBean interface
 */
public interface SearchMBean {

    long getOffersCount(int ksite, String country, Integer category, String words);

    long getInfoMagOffersCount(int kSite, String country, Long shopId);
    
}
