package com.leguide.backoffice.karaf.webservices.client.engine.impl;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.leguide.backoffice.karaf.webservices.client.engine.EngineResponse;
import com.leguide.backoffice.karaf.webservices.client.engine.EngineService;
import com.leguide.backoffice.karaf.webservices.client.engine.IEngineClient;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATPI;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATPN;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineException;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineJaxbException;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineRequestParameterException;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineResponseException;


@Component
public class EngineClient implements IEngineClient {

    private EngineService xmlEngineService;

    private String language;
    private Integer deliveryZone;
    private Integer site;
    private Integer marksNumber;
    private Short shortLinksNumber;
    private Short shortReviewsSources;
    //private boolean groupProducts;// true, false for  findOffersWithBarCode
    private int sortTypeProductNet;// 45056
    private int sortTypeListOffre; // 176
    //private boolean excludeOccasion;// true
    //private boolean phpsort;// false
    //private boolean authorisedOccasion;// true
    //private boolean onlyCat;// false 
    private int catCount;// 25

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(EngineClient.class);

    public EngineClient() {
        
    }

    public EngineClient(String protocoleNumber, String host, int port) throws EngineJaxbException {
        super();
        xmlEngineService = new EngineService(protocoleNumber, host, port);
    }

    public EngineResponse productsNet(Long catId, String wordsSearch, String markSearch, String criteria,
            Float priceMin, Float priceMax, Integer pageSize, Integer pageNum, int discountMin, int discountMax,
            boolean groupProducts, boolean excludeOccasion, boolean onlyCat) throws EngineException {

        logger.debug("-------> entering productsNet");
        if (pageNum == null) {
            throw new EngineRequestParameterException("page num is null");
        }
        if (pageNum < 1) {
            throw new EngineRequestParameterException("page num is 0 or less");
        }

        EngineResponse xmlResponse = xmlEngineService.productsNet(language, site, deliveryZone, (catId == null ? -1l
                : catId.longValue()), wordsSearch, markSearch, pageSize, pageNum - 1, priceMin, priceMax,
                groupProducts, sortTypeProductNet, excludeOccasion, discountMin, discountMax, onlyCat, marksNumber,
                catCount, criteria, shortLinksNumber, shortReviewsSources);

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            // logger.debug("productsNetResponse = [{}]",xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getPRODUCTCOUNT() == 0) {
                logger.warn("PRODUCTCOUNT = 0 for this request");
                logger.warn("<------- exiting productsNet with error");
                throw new EngineResponseException("no offer for this request");
            }
        } else {
            logger.warn("<------- exiting productsNet with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting productsNet");
        return xmlResponse;
    }

    public EngineResponse listOffresByStoreId(Long storeId, Integer pageSize, Integer pageNum, int discountMin,
            int discountMax, boolean groupProducts, boolean excludeOccasion) throws EngineException {

        logger.debug("-------> entering productsNetByStoreId");
        if (pageNum == null) {
            throw new EngineRequestParameterException("page num is null");
        }
        if (pageNum < 1) {
            throw new EngineRequestParameterException("page num is 0 or less");
        }

       EngineResponse xmlResponse = xmlEngineService.listOffresByStoreId(language, site, deliveryZone, storeId.longValue(),
                pageSize, pageNum - 1, 
                groupProducts, sortTypeProductNet, excludeOccasion, discountMin, discountMax,  false);
                
                

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            // logger.debug("productsNetResponse = [{}]",xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getPRODUCTCOUNT() == 0) {
                logger.warn("PRODUCTCOUNT = 0 for this request");
                logger.warn("<------- exiting productsNetByStoreId with error");
                throw new EngineResponseException("no offer for this request");
            }
        } else {
            logger.warn("<------- exiting productsNetByStoreId with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting productsNetByStoreId");
        return xmlResponse;
    }

    public EngineResponse listOffresByStoreIdWithDebug(Long storeId, Integer pageSize, Integer pageNum, int discountMin,
            int discountMax, boolean groupProducts, boolean excludeOccasion) throws EngineException {

        logger.debug("-------> entering productsNetByStoreId");
        if (pageNum == null) {
            throw new EngineRequestParameterException("page num is null");
        }
        if (pageNum < 1) {
            throw new EngineRequestParameterException("page num is 0 or less");
        }

        EngineResponse xmlResponse = xmlEngineService.listOffresByStoreId(language, site, deliveryZone, storeId.longValue(),
                pageSize, pageNum - 1,
                groupProducts, sortTypeProductNet, excludeOccasion, discountMin, discountMax, true);
        

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            // logger.debug("productsNetResponse = [{}]",xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getPRODUCTCOUNT() == 0) {
                logger.warn("PRODUCTCOUNT = 0 for this request");
                logger.warn("<------- exiting productsNetByStoreId with error");
                throw new EngineResponseException("no offer for this request");
            }
        } else {
            logger.warn("<------- exiting productsNetByStoreId with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting productsNetByStoreId");
        return xmlResponse;
    }

    public EngineResponse getMarks(Long catId, String wordsSearch, String markSearch, String criteria, Float priceMin,
            Float priceMax, int discountMin, int discountMax, boolean groupProducts, boolean excludeOccasion,
            boolean onlyCat) throws EngineException {
        logger.debug("-------> entering getMarks");

        EngineResponse xmlResponse = xmlEngineService.productsNet(language, site, deliveryZone, (catId == null ? -1l
                : catId.longValue()), wordsSearch, markSearch, null, null, priceMin, priceMax, groupProducts,
                sortTypeProductNet, excludeOccasion, discountMin, discountMax, onlyCat, marksNumber, catCount,
                criteria, shortLinksNumber, shortReviewsSources);

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            logger.debug("getMarksResponse = [{}]", xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getMARKCOUNT() == 0) {
                logger.warn("no mark for this request");
                logger.warn("<------- exiting getMarks with error");
                throw new EngineResponseException("no mark for this request");
            }
        } else {
            logger.warn("<------- exiting getMarks with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting getMarks");
        return xmlResponse;
    }

    public EngineResponse getPrices(Long catId, String wordsSearch, String markSearch, String criteria, Float priceMin,
            Float priceMax, Integer pageSize, Integer pageNum, int discountMin, int discountMax, boolean groupProducts,
            boolean excludeOccasion, boolean onlyCat) throws EngineException {
        logger.debug("-------> entering getPrices");
        if (pageNum == null) {
            throw new EngineRequestParameterException("page num is null");
        }
        if (pageNum < 1) {
            throw new EngineRequestParameterException("page num is 0 or less");
        }

        EngineResponse xmlResponse = xmlEngineService.productsNet(language, site, deliveryZone, (catId == null ? -1l
                : catId.longValue()), wordsSearch, markSearch, null, null, priceMin, priceMax, groupProducts,
                sortTypeProductNet, excludeOccasion, discountMin, discountMax, onlyCat, marksNumber, catCount,
                criteria, shortLinksNumber, shortReviewsSources);

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            logger.debug("productsNetResponse = [{}]", xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            /*
             * check PRICECOUNT here ?
             */
            if (result.getPRODUCTCOUNT() == 0) {
                logger.warn("PRODUCTCOUNT = 0 for this request");
                logger.warn("<------- exiting getPrices with error");
                throw new EngineResponseException("no PRODUCTCOUNT for this request");
            }
        } else {
            logger.warn("<------- exiting getPrices with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting getPrices");
        return xmlResponse;
    }

    public EngineResponse findOffersByProductId(Long productId, Integer pageSize, Integer pageNum, int discountMin,
            int discountMax, boolean excludeOccasion, boolean groupProducts) throws EngineException {
        logger.debug("-------> entering findOffersByProductId");
        if (pageNum == null) {
            throw new EngineRequestParameterException("page num is null");
        }
        if (pageNum < 1) {
            throw new EngineRequestParameterException("page num is 0 or less");
        }
        if (productId == null) {
            throw new EngineRequestParameterException("productId is null");
        }

        EngineResponse xmlResponse = xmlEngineService.liste_offres(language, deliveryZone, site, productId,
                excludeOccasion, pageSize, pageNum - 1, sortTypeListOffre, groupProducts, discountMin, discountMax,
                false);

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            logger.debug("findOffersByProductIdResponse = [{}]", xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getPRODUCTCOUNT() == 0) {
                logger.warn("PRODUCTCOUNT = 0 for this request");
                logger.warn("<------- exiting findOffersByProductId with error");
                throw new EngineResponseException("PRODUCTCOUNT = 0 for this request");
            }
        } else {
            logger.warn("<------- exiting findOffersByProductId with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting findOffersByProductId");
        return xmlResponse;
    }

    public EngineResponse findAttributesWithProductId(Long productId, Integer pageSize, Integer pageNum,
            int discountMin, int discountMax, boolean excludeOccasion, boolean groupProducts) throws EngineException {
        logger.debug("-------> entering findAttributesWithProductId");
        if (pageNum == null) {
            throw new EngineRequestParameterException("page num is null");
        }
        if (pageNum < 1) {
            throw new EngineRequestParameterException("page num is 0 or less");
        }
        if (productId == null) {
            throw new EngineRequestParameterException("productId is null");
        }
        EngineResponse xmlResponse = xmlEngineService.liste_offres(language, deliveryZone, site, productId,
                excludeOccasion, pageSize, pageNum - 1, sortTypeListOffre, groupProducts, discountMin, discountMax,
                false);
        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            logger.debug("findAttributesWithProductIdResponse = [{}]", xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getPRODUCTCOUNT() == 0) {
                logger.warn("PRODUCTCOUNT = 0 for this request");
                logger.warn("<------- exiting findAttributesWithProductId with error");
                throw new EngineResponseException("PRODUCTCOUNT = 0 for this request");
            }
        } else {
            logger.warn("<------- exiting findAttributesWithProductId with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting findAttributesWithProductId");
        return xmlResponse;
    }

    public EngineResponse findProdInfoByProductId(String productId) throws EngineException {
        logger.debug("-------> entering findProdInfoByProductId");
        EngineResponse xmlResponse = xmlEngineService.productInfo(language, productId);
        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            logger.debug("findOfferByIdResponse = [{}]", xmlResponse);
            RESULTATPI result = (RESULTATPI) xmlResponse.getResponse();
            if (result.getPRODUCT() == null) {
                logger.warn("product null for this id [{}]", productId);
                logger.warn("<------- exiting findProdInfoByProductId with error");
                throw new EngineResponseException("product null for this request");
            }
        } else {
            logger.warn("<------- exiting findProdInfoByProductId with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting findProdInfoByProductId");
        return xmlResponse;
    }

    public EngineResponse findOffersWithBarCode(String barCode, Integer pageSize, Integer pageNum, int discountMin,
            int discountMax, boolean groupProducts, boolean excludeOccasion, boolean onlyCat) throws EngineException {
        logger.debug("-------> entering findOffersWithBarCode");
        if (pageNum == null) {
            throw new EngineRequestParameterException("page num is null");
        }
        if (pageNum < 1) {
            throw new EngineRequestParameterException("page num is 0 or less");
        }
        EngineResponse xmlResponse = xmlEngineService.productsNet(language, site, deliveryZone, -1L, barCode, null,
                pageSize, pageNum - 1, null, null, groupProducts, sortTypeProductNet, excludeOccasion, discountMin,
                discountMax, onlyCat, marksNumber, catCount, null, shortLinksNumber, shortReviewsSources);

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            logger.debug("findOffersWithBarCodeResponse = [{}]", xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getPRODUCTCOUNT() == 0) {
                logger.warn("PRODUCTCOUNT = 0 for this request");
                logger.warn("<------- exiting findOffersWithBarCode with error");
                throw new EngineResponseException("PRODUCTCOUNT = 0 for this request");
            }
        } else {
            logger.warn("<------- exiting findOffersWithBarCode with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting findOffersWithBarCode");
        return xmlResponse;
    }

    public EngineResponse getPopCats(Long catId, String wordsSearch, String markSearch, Float priceMin, Float priceMax,
            Integer popCatNumberMax, int discountMin, int discountMax, boolean groupProducts, boolean excludeOccasion,
            boolean onlyCat) throws EngineException {
        logger.debug("-------> entering getPopCats");
        EngineResponse xmlResponse = xmlEngineService.productsNet(language, site, deliveryZone, (catId == null ? -1l
                : catId.longValue()), wordsSearch, markSearch, null, null, priceMin, priceMax, groupProducts,
                sortTypeProductNet, excludeOccasion, discountMin, discountMax, onlyCat, marksNumber,
                (popCatNumberMax == null ? -1 : popCatNumberMax.intValue()), null, shortLinksNumber, shortReviewsSources);

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            logger.debug("getPopCatsResponse = [{}]", xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getPOPULARCATLISTCOUNT() == 0) {
                logger.warn("POPULARCATLISTCOUNT = 0 for this request");
                logger.warn("<------- exiting getPopCats with error");
                throw new EngineResponseException("POPULARCATLISTCOUNT = 0 for this request");
            }
        } else {
            logger.warn("<------- exiting getPopCats with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting getPopCats");
        return xmlResponse;
    }

    public EngineResponse getCriteria(Long catId, String wordsSearch, String markSearch, Float priceMin,
            Float priceMax, int discountMin, int discountMax, boolean groupProducts, boolean excludeOccasion,
            boolean onlyCat) throws EngineException {
        logger.debug("-------> entering getCriteria");
        EngineResponse xmlResponse = xmlEngineService.productsNet(language, site, deliveryZone, (catId == null ? -1l
                : catId.longValue()), wordsSearch, markSearch, null, null, priceMin, priceMax, groupProducts,
                sortTypeProductNet, excludeOccasion, discountMin, discountMax, onlyCat, marksNumber, catCount, null,
                shortLinksNumber, shortReviewsSources);

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            logger.debug("getCriteriaResponse = [{}]", xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getPRODUCTCOUNT() == 0) {
                logger.warn("PRODUCTCOUNT = 0 for this request");
                logger.warn("<------- exiting getCriteria with error");
                throw new EngineResponseException("PRODUCTCOUNT = 0 for this request");
            }
        } else {
            logger.warn("<------- exiting getCriteria with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting getCriteria");
        return xmlResponse;
    }

    public EngineResponse getFilters(Long catId, String wordsSearch, String markSearch, Float priceMin, Float priceMax,
            String criteria, Integer popCatNumberMax, int discountMin, int discountMax, boolean groupProducts,
            boolean excludeOccasion, boolean onlyCat) throws EngineException {
        logger.debug("-------> entering getFilters");
        EngineResponse xmlResponse = xmlEngineService.productsNet(language, site, deliveryZone, (catId == null ? -1l
                : catId.longValue()), wordsSearch, markSearch, null, null, priceMin, priceMax, groupProducts,
                sortTypeProductNet, excludeOccasion, discountMin, discountMax, onlyCat, marksNumber,
                (popCatNumberMax == null ? -1 : popCatNumberMax.intValue()), criteria, shortLinksNumber,
                shortReviewsSources);

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            logger.debug("productsNetResponse = [{}]", xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getPRODUCTCOUNT() == 0) {
                logger.warn("PRODUCTCOUNT = 0 for this request");
                logger.warn("<------- exiting getFilters with error");
                throw new EngineResponseException("PRODUCTCOUNT = 0 for this request");
            }
        } else {
            logger.warn("<------- exiting getFilters with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting getFilters");
        return xmlResponse;
    }

    /**
     * getOffers - get nb offers by catId and word
     * 
     * @param catId can be null -1 means no cat
     * @param words 
     * @param kSite
     * @param language 
     * @param kZone
     * @return result = (RESULTATPN) xmlResponse.getResponse()
     * @throws EngineException
     */
    public EngineResponse getOffersCount(Long catId, String words, int kSite, String language, int kZone) throws EngineException {
        logger.debug("-------> entering getOffersCount");
        EngineResponse xmlResponse = xmlEngineService.getOffersCount(language, kSite, kZone, (catId == null ? -1l
                : catId.longValue()), words, true, 10, 1, 32768, true, true);

        if (xmlResponse != null && xmlResponse.getResponse() != null) {
            logger.debug("getOfferCountResponse = [{}]", xmlResponse);
            RESULTATPN result = (RESULTATPN) xmlResponse.getResponse();
            if (result.getPRODUCTCOUNT() == 0) {
                logger.warn("PRODUCTCOUNT = 0 for this request");
                logger.warn("<------- exiting getOffersCount with error");
                throw new EngineResponseException("PRODUCTCOUNT = 0 for this request");
            }
        } else {
            logger.warn("<------- exiting getOffersCount with error");
            throw new EngineResponseException("no response for this request");
        }
        logger.debug("<------- exiting getOffersCount");
        return xmlResponse;
    }

    public EngineService getXmlEngineService() {
        return xmlEngineService;
    }

    public void setXmlEngineService(EngineService xmlEngineService) {
        this.xmlEngineService = xmlEngineService;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDeliveryZone() {
        return deliveryZone;
    }

    public void setDeliveryZone(Integer deliveryZone) {
        this.deliveryZone = deliveryZone;
    }

    public Integer getSite() {
        return site;
    }

    public void setSite(Integer site) {
        this.site = site;
    }

    public Integer getMarksNumber() {
        return marksNumber;
    }

    public void setMarksNumber(Integer marksNumber) {
        this.marksNumber = marksNumber;
    }

    public Short getShortLinksNumber() {
        return shortLinksNumber;
    }

    public void setShortLinksNumber(Short shortLinksNumber) {
        this.shortLinksNumber = shortLinksNumber;
    }

    public int getSortTypeProductNet() {
        return sortTypeProductNet;
    }

    public void setSortTypeProductNet(int sortTypeProductNet) {
        this.sortTypeProductNet = sortTypeProductNet;
    }

    public int getSortTypeListOffre() {
        return sortTypeListOffre;
    }

    public void setSortTypeListOffre(int sortTypeListOffre) {
        this.sortTypeListOffre = sortTypeListOffre;
    }

    public int getCatCount() {
        return catCount;
    }

    public void setCatCount(int catCount) {
        this.catCount = catCount;
    }

    public Short getShortReviewsSources() {
        return shortReviewsSources;
    }

    public void setShortReviewsSources(Short shortReviewsSources) {
        this.shortReviewsSources = shortReviewsSources;
    }
    
}
