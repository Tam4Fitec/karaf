package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.bean;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.dao.CatalogDao;
import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.pojo.UpdatePojo;
import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.utils.Headers;
import com.leguide.backoffice.karaf.bundle.services.search.engine.ISearchEngineClientService;
import com.leguide.backoffice.karaf.webservices.wsstore.dao.IStoreDao;

/**
 * Bean used to enrich camel body
 * @author jlboulanger
 *
 */
public class EnrichBean {

    private static final Logger logger = LoggerFactory.getLogger(EnrichBean.class);
    private CatalogDao catalogDao;
    private IStoreDao storeDao;
    private ISearchEngineClientService engineClientService;

    /**
     * Get the store_id and country from the wsstore feature. The header Headers.SHOPSITE_ID must be present
     * @param ex contains the header {@link Headers#SHOPSITE_ID} as a Long
     * @return the store_id@country corresponding to the shopsite_id
     */
    public String enrichWithShopIdAndCountry(Exchange ex) {
        //storeid@country
        return storeDao.findStoreAndLanguageByUID(ex.getIn().getHeader(Headers.SHOPSITE_ID, Long.class));
    }

    /**
     * Get the catalog_id linked to the {@link Headers#SHOPSITE_ID}
     * @param ex contains the header {@link Headers#SHOPSITE_ID} as a Long
     * @return the catalog id from lgintegration DB
     */
    public Long enrichWithCatalogId(Exchange ex) {
        return catalogDao.getCatalogId(ex.getIn().getHeader(Headers.SHOPSITE_ID, Long.class));
    }
 
    /**
     * Call the search engine (intra_infomag) to get the total number of offers (SHOP_TOTAL_OFFRE_COUNT) 
     * for the {@link Headers#KSITE}, {@link Headers#COUNTRY} and {@link Headers#SHOP_ID} . Will then set the 
     * body {@link UpdatePojo#setTotalOffers(Long)} and {@link Headers#TOTAL_OFFER_COUNT}  and update the exchange
     * @param ex must contains headers {@link Headers#KSITE}, {@link Headers#COUNTRY} and {@link Headers#SHOP_ID}
     * 
     */
    public void enrichWithTotalOffer(Exchange ex) {
        try {
            Long total = engineClientService.getInfoMagOffersCount(ex.getIn().getHeader(Headers.KSITE, Integer.class),
                    ex.getIn().getHeader(Headers.COUNTRY, String.class),
                    ex.getIn().getHeader(Headers.SHOP_ID, Long.class));
            ex.getIn().getBody(UpdatePojo.class).setTotalOffers(total);
            ex.getIn().setHeader(Headers.TOTAL_OFFER_COUNT, total);
        } catch (Exception e) {
            logger.warn("Exception", e);
        }   
    }
 
    public CatalogDao getCatalogDao() {
        return catalogDao;
    }

    public void setCatalogDao(CatalogDao catalogDao) {
        this.catalogDao = catalogDao;
    }

    public IStoreDao getStoreDao() {
        return storeDao;
    }

    public void setStoreDao(IStoreDao storeDao) {
        this.storeDao = storeDao;
    }

    public ISearchEngineClientService getEngineClientService() {
        return engineClientService;
    }

    public void setEngineClientService(ISearchEngineClientService engineClientService) {
        this.engineClientService = engineClientService;
    }
}
