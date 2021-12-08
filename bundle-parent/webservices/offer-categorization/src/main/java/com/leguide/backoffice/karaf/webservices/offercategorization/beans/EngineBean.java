package com.leguide.backoffice.karaf.webservices.offercategorization.beans;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.bundle.services.search.engine.ISearchEngineClientService;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.PRODUCT;
import com.leguide.backoffice.karaf.webservices.offercategorization.models.ws.OfferInformation;
import com.leguide.backoffice.karaf.webservices.offercategorization.models.ws.OfferInformations;

/**
 * Bean getting information from Engine
 */
public class EngineBean {

    private ISearchEngineClientService engineClientService;
    private static final Logger logger = LoggerFactory.getLogger(EngineBean.class);

    /**
     * Get offers informations
     *
     * @param country
     * @param List of offerid (String)
     * @return List of AddOnOfferContent
     */
    public OfferInformations getOfferInfos(String country, String offerIds) {

        OfferInformations offersContents =  new OfferInformations();

        if (offerIds.length() > 0 ) {

            OfferInformation singleOfferInformation = new OfferInformation();            

            // Get Informations from Engine
            List<PRODUCT> listProduct = engineClientService.getOffersCategory(country, offerIds);
			
            if (listProduct.size() > 0)
            {
            	for (PRODUCT product : listProduct) {
            		singleOfferInformation = new OfferInformation();
					singleOfferInformation.setInternalThesaurusId(String.valueOf(product.getCATIDINTERNE()));
					singleOfferInformation.setThesaurusId(String.valueOf(product.getCATID()));
					singleOfferInformation.setLabel(product.getCATSINGLENAME());
					singleOfferInformation.setMerchantCategorie(product.getPRODCATSHOP());
					singleOfferInformation.setPays(product.getSHOPPAYS());
					singleOfferInformation.setProductId(product.getPRODID());
					offersContents.addOfferInfo(singleOfferInformation);                
            	}
            	offersContents.setCount(listProduct.size());
            	offersContents.setPagecount(1);
			}
			else
			{
				offersContents.setCount(0);
				offersContents.setPagecount(0);
			}
		return offersContents;
        } else {
				logger.debug("No offer found for " + offerIds +  " {}!!!");        	
            return new OfferInformations();
        }
    }
    
    public ISearchEngineClientService getEngineClientService() {
        return engineClientService;
    }
    public void setEngineClientService(ISearchEngineClientService engineClientService) {
        this.engineClientService = engineClientService;
    } 
}
