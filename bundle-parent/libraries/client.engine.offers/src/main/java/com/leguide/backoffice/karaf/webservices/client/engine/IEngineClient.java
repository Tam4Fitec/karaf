package com.leguide.backoffice.karaf.webservices.client.engine;

import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineException;

public interface IEngineClient {

    /**
     * calls products_net
     * 
     * @param catId can be null, -1 means no cat
     * @param wordsSearch
     * @param markSearch
     * @param criteria
     * @param priceMin can be null
     * @param priceMax can be null
     * @param pageSize
     * @param pageNum cannot be null or 0. should starts at 1
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param groupProducts group products flag
     * @param excludeOccasion if true, exclude occasion from result set
     * @param onlyCat only categories
     * @return response to cast to : (RESULTATPN) response.getResponse();
     * @throws EngineException
     */
    EngineResponse productsNet(Long catId, String wordsSearch, String markSearch, String criteria, Float priceMin,
            Float priceMax, Integer pageSize, Integer pageNum, int discountMin, int discountMax, boolean groupProducts,
            boolean excludeOccasion, boolean onlyCat) throws EngineException;
    
    /**
     * calls list offres, with a storeId (shop_id, not the shopsite_id)
     * 
     * @param storeId, cannot be null
     * @param criteria
     * @param pageSize
     * @param pageNum cannot be null or 0. should starts at 1
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param groupProducts group products flag
     * @param excludeOccasion if true, exclude occasion from result set
     * @return response to cast to : (RESULTATPN) response.getResponse();
     * @throws EngineException
     */
    EngineResponse listOffresByStoreId(Long storeId, Integer pageSize, Integer pageNum, int discountMin,
            int discountMax, boolean groupProducts, boolean excludeOccasion) throws EngineException;

    /**
     * calls list offres, with a storeId (shop_id, not the shopsite_id), sets kDebug to true
     * 
     * @param storeId, cannot be null
     * @param pageSize
     * @param pageNum cannot be null or 0. should starts at 1
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param groupProducts group products flag
     * @param excludeOccasion if true, exclude occasion from result set
     * @return response to cast to : (RESULTATPN) response.getResponse();
     * @throws EngineException
     */
    EngineResponse listOffresByStoreIdWithDebug(Long storeId, Integer pageSize, Integer pageNum, int discountMin,
            int discountMax, boolean groupProducts, boolean excludeOccasion) throws EngineException;

    /**
     * calls products_net
     * 
     * @param catId can be null -1 means no cat
     * @param wordsSearch
     * @param markSearch
     * @param criteria
     * @param priceMin can be null
     * @param priceMax can be null
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param groupProducts group products flag
     * @param excludeOccasion if true, exclude occasion from result set
     * @param onlyCat only categories
     * @return response to cast to : (RESULTATPN) response.getResponse();
     * @throws EngineException
     */
    EngineResponse getMarks(Long catId, String wordsSearch, String markSearch, String criteria, Float priceMin,
            Float priceMax, int discountMin, int discountMax, boolean groupProducts, boolean excludeOccasion,
            boolean onlyCat) throws EngineException;

    /**
     * 
     * @param catId can be null -1 means no cat
     * @param wordsSearch
     * @param markSearch
     * @param criteria
     * @param priceMin can be null
     * @param priceMax can be null
     * @param pageSize
     * @param pageNum cannot be null or 0. should starts at 1
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param groupProducts group products flag
     * @param excludeOccasion if true, exclude occasion from result set
     * @param onlyCat only categories
     * @return response to cast to : (RESULTATPN) response.getResponse();
     * @throws EngineException
     */
    EngineResponse getPrices(Long catId, String wordsSearch, String markSearch, String criteria, Float priceMin,
            Float priceMax, Integer pageSize, Integer pageNum, int discountMin, int discountMax, boolean groupProducts,
            boolean excludeOccasion, boolean onlyCat) throws EngineException;

    /**
     * Liste_offres
     * 
     * @param productId cannot be null
     * @param pageSize
     * @param pageNum cannot be null or 0. should starts at 1
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param excludeOccasion if true, exclude occasion from result set
     * @param groupProducts group products flag
     * @return result = (RESULTATPN) xmlResponse.getResponse()
     * @throws EngineException
     */
    EngineResponse findOffersByProductId(Long productId, Integer pageSize, Integer pageNum, int discountMin,
            int discountMax, boolean excludeOccasion, boolean groupProducts) throws EngineException;

    /**
     * Liste_offres
     * 
     * @param productId cannot be null
     * @param pageSize
     * @param pageNum cannot be null or 0. should starts at 1
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param excludeOccasion if true, exclude occasion from result set
     * @param groupProducts group products flag
     * @return result = (RESULTATPN) xmlResponse.getResponse()
     * @throws EngineException
     */
    EngineResponse findAttributesWithProductId(Long productId, Integer pageSize, Integer pageNum, int discountMin,
            int discountMax, boolean excludeOccasion, boolean groupProducts) throws EngineException;

    /**
     * prod_info Get product data (and list offer) by productId
     * 
     * @param productId
     * @return result = (com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATPI) xmlResponse.getResponse()
     * @throws EngineException
     */
    EngineResponse findProdInfoByProductId(String productId) throws EngineException;

    /**
     * products_net
     * 
     * @param barCode
     * @param pageSize
     * @param pageNum cannot be null or 0. should starts at 1
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param groupProducts group products flag
     * @param excludeOccasion if true, exclude occasion from result set
     * @param onlyCat only categories
     * @return result = (RESULTATPN) xmlResponse.getResponse()
     * @throws EngineException
     */
    EngineResponse findOffersWithBarCode(String barCode, Integer pageSize, Integer pageNum, int discountMin,
            int discountMax, boolean groupProducts, boolean excludeOccasion, boolean onlyCat) throws EngineException;

    /**
     * products_net
     * 
     * @param catId can be null -1 means no cat
     * @param wordsSearch
     * @param markSearch
     * @param priceMin can be null
     * @param priceMax can be null
     * @param popCatNumberMax can be null -1 means no max
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param groupProducts group products flag
     * @param excludeOccasion if true, exclude occasion from result set
     * @param onlyCat only categories
     * @return result = (RESULTATPN) xmlResponse.getResponse()
     * @throws EngineException
     */
    EngineResponse getPopCats(Long catId, String wordsSearch, String markSearch, Float priceMin, Float priceMax,
            Integer popCatNumberMax, int discountMin, int discountMax, boolean groupProducts, boolean excludeOccasion,
            boolean onlyCat) throws EngineException;

    /**
     * products_net
     * 
     * @param catId can be null -1 means no cat
     * @param wordsSearch
     * @param markSearch
     * @param priceMin can be null
     * @param priceMax can be null
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param groupProducts group products flag
     * @param excludeOccasion if true, exclude occasion from result set
     * @param onlyCat only categories
     * @return result = (RESULTATPN) xmlResponse.getResponse()
     * @throws EngineException
     */
    EngineResponse getCriteria(Long catId, String wordsSearch, String markSearch, Float priceMin, Float priceMax,
            int discountMin, int discountMax, boolean groupProducts, boolean excludeOccasion, boolean onlyCat)
            throws EngineException;

    /**
     * products_net
     * 
     * @param catId can be null -1 means no cat
     * @param words
     * @param mark
     * @param priceMin can be null
     * @param priceMax can be null
     * @param criteria
     * @param popCatNumberMax can be null -1 means no max
     * @param discountMin -1 means no discount. Percentage, from 0 to 100
     * @param discountMax -1 means no discount. Percentage, from 0 to 100
     * @param groupProducts group products flag
     * @param excludeOccasion if true, exclude occasion from result set
     * @param onlyCat only categories
     * @return result = (RESULTATPN) xmlResponse.getResponse()
     * @throws EngineException
     */
    EngineResponse getFilters(Long catId, String words, String mark, Float priceMin, Float priceMax, String criteria,
            Integer popCatNumberMax, int discountMin, int discountMax, boolean groupProducts, boolean excludeOccasion,
            boolean onlyCat) throws EngineException;
 
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
    EngineResponse getOffersCount(Long catId, String words, int kSite, String language, int kZone) throws EngineException;

    // parameters keys,
   /* engineRequest.language=FR
    engineRequest.site=1
    engineRequest.deliveryZone=1
    engineRequest.marksNumber=100
    engineRequest.shortLinksNumber=20
    engine.protocole=1.1
     engine.adress=192.168.0.23
     engine.port=12560
     sortTypeProductNet;// 45056
     sortTypeListOffre; // 176
     catCount;// 25
     engineRequest.shortReviewsSources=15 for win8
     */
    static final String engineRequestLanguage = "client.engineRequest.language";
    static final String engineRequestSite = "client.engineRequest.site";
    static final String engineRequestDeliveryZone = "client.engineRequest.deliveryZone";
    static final String engineRequestMarksNumber = "client.engineRequest.marksNumber";
    static final String engineRequestShortLinksNumber = "client.engineRequest.shortLinksNumber";
    static final String engineRequestShortReviewsSources = "client.engineRequest.shortReviewsSources";
    static final String engineRequestProtocole = "client.engineRequest.protocole";
    static final String engineRequestAddress = "client.engineRequest.address";
    static final String engineRequestPort = "client.engineRequest.port";
    static final String engineRequestSortTypeProductNet = "client.engineRequest.sortTypeProductNet";
    static final String engineRequestSortTypeListOffre = "client.engineRequest.sortTypeListOffre";
    static final String engineRequestCatCount = "client.engineRequest.catCount";
}
