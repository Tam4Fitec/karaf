package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.mbean;

public interface CatalogMBean {

    void getAndSaveCtg_online_count(Long idshopsite, int ksite);

    void getAndSaveCtg_online_countForAll(int ksite);
}
