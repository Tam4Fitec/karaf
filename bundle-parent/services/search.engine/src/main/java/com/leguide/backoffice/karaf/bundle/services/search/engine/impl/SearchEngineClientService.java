package com.leguide.backoffice.karaf.bundle.services.search.engine.impl;

import com.leguide.backoffice.karaf.bundle.services.search.engine.ISearchEngineClientService;
import com.leguide.backoffice.karaf.bundle.services.search.engine.model.*;
import com.leguide.backoffice.karaf.bundle.services.search.engine.utils.ParseUtils;
import com.leguide.backoffice.karaf.webservices.client.engine.EngineResponse;
import com.leguide.backoffice.karaf.webservices.client.engine.EngineService;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.PRODUCT;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATPI;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATPN;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineJaxbException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;

public class SearchEngineClientService implements ISearchEngineClientService {

    private static final Logger logger = LoggerFactory.getLogger(SearchEngineClientService.class);
    private Properties engineProperties;
    private static final String ENGINE_PORT_KEY = "engine.port";
    private static final String ENGINE_PROTOCOL_KEY = "engine.protocole";
    private static final String ENGINE_SERVER_SUFFIXE = ".engine.server";
    private static final String ENGINE_KZONE_SUFFIXE = ".engine.kzone";

    private static final String GO_URL_KW_SHOPPING_LIST = "shoppinglist";
    private static final String GO_URL_KW_PRCING_ALERT = "pricingalert";

    //private Map<String, EngineService> services = new HashMap<String, EngineService>(10);


    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public long getOffersCount(int kSite, String country, Integer category, String words) throws Exception {
        try {
            String upCountry = country.toUpperCase();
            EngineService instance = getInstance(upCountry);
            RESULTATPN response = (RESULTATPN) instance.getOffersCount(upCountry, kSite,
                    Integer.valueOf(engineProperties.getProperty(upCountry + ENGINE_KZONE_SUFFIXE)),
                    (category == null ? -1l : category.longValue()), words, true, 10, 1, 32768, true, true).getResponse();
            logger.debug("count is " + response.getOFFRECOUNT());
            instance = null;
            return response.getOFFRECOUNT();
        } catch (Exception e) {
            logger.error("unexpected error calling search engine", e);
            throw e;
        }
    }

    @Override
    public long getInfoMagOffersCount(int kSite, String country, Long shopId) throws Exception {
        try {
            String upCountry = country.toUpperCase();
            EngineService instance = getInstance(upCountry);
            long res = instance.intraInfoMagTotalOffers(upCountry, kSite,
                    Integer.valueOf(engineProperties.getProperty(upCountry + ENGINE_KZONE_SUFFIXE)),
                    (shopId == null ? -1l : shopId.longValue()), true);
            instance = null;
            return res;
        } catch (Exception e) {
            logger.error("unexpected error calling search engine", e);
            throw e;
        }
    }

    @Override
    public List<ProductOfferEmailDisplay> getShoppingListOffersInfos(List<ShoppingListItem> items, String country, int delivery, int ksite) {

        List<ProductOfferEmailDisplay> productOfferEmailDisplays = new ArrayList<ProductOfferEmailDisplay>();
        ProductOfferEmailDisplay tempProdOfferDisplay = new ProductOfferEmailDisplay();
        String itemReference;
        String upCountry = country.toUpperCase();
        try {
            // Connect to Engine
            EngineService instance = getInstance(upCountry);
            for (ShoppingListItem item : items) {
                // If ShoppingListItem is product, get the 3 cheapest offers linked to this product
                if (item.getIsProduct()) {
                    itemReference = item.getReference();
                    //call liste_offre
                    EngineResponse engineResponse = instance.liste_offres(upCountry, delivery, ksite, Long.valueOf(itemReference),
                            true, 3, 0, 2, true, -1, -1, false);//2 -> sort by price asc
                    RESULTATPN atpn = (RESULTATPN) engineResponse.getResponse();
                    for (PRODUCT prod : atpn.getPRODUCTLIST().getPRODUCT()) {
                        ProductOfferEmailDisplay pod = new ProductOfferEmailDisplay();
                        pod.setPrice1(ParseUtils.parsePriceFrenchLocale(prod.getPRODEUROPRICE()));
                        pod.setPrice1BeforeDiscount(ParseUtils.parsePriceFrenchLocale(prod.getPRODEURODISCOUNT()));
                        pod.setDesignation(prod.getPRODDESIGNATION());
                        pod.setGoUrl(buildGoUrl(prod.getSHOPID(), prod.getCATID(), prod.getPRODID(), prod.getSHOPVARS(),
                                GO_URL_KW_SHOPPING_LIST));
                        pod.setImageUrl(buildOfferImageUrl(prod.getPRODID(), prod.getPRODDESIGNATION()));
                        pod.setShopName(prod.getSHOPNAME());
                        pod.setShopSiteId(prod.getSHOPID());
                        pod.setShoppingListId(item.getShoppingListId());
                        pod.setShoppingListName(item.getShoppingListName());
                        pod.setFromProduct(true);
                        pod.setReference(itemReference);
                        pod.setOnSales(prod.getPRODSOLDE() == 1 ? true : false);
                        pod.setPrice1DiscountPerc(100 - ParseUtils.discount(prod.getPRODEUROPRICE(), prod.getPRODEURODISCOUNT()));
                        productOfferEmailDisplays.add(pod);
                    }
                }
                // If ShoppingListItem is an offer, get informations about the offer
                else {
                    itemReference = item.getReference();
                    RESULTATPI response = (RESULTATPI) instance.productInfo(upCountry, itemReference).getResponse();
                    if (null != response.getPRODUCT()) {
                        PRODUCT offer = response.getPRODUCT();
                        tempProdOfferDisplay.setShopSiteId(offer.getShopsiteid());
                        tempProdOfferDisplay.setShopName(offer.getSHOPNAME());
                        tempProdOfferDisplay.setImageUrl(buildOfferImageUrl(offer.getPRODID(), offer.getPRODDESIGNATION()));
                        tempProdOfferDisplay.setDesignation(offer.getPRODDESIGNATION());
                        tempProdOfferDisplay.setPrice1(ParseUtils.parsePriceFrenchLocale(offer.getPRODEUROPRICE()));
                        tempProdOfferDisplay.setPrice1BeforeDiscount(ParseUtils.parsePriceFrenchLocale(offer.getPRODEURODISCOUNT()));
                        tempProdOfferDisplay.setGoUrl(buildGoUrl(Integer.valueOf(offer.getSHOPID()), offer.getCATID(),
                                offer.getPRODID(), offer.getSHOPVARS(), GO_URL_KW_SHOPPING_LIST));
                        tempProdOfferDisplay.setShoppingListId(item.getShoppingListId());
                        tempProdOfferDisplay.setShoppingListName(item.getShoppingListName());
                        tempProdOfferDisplay.setFromProduct(false);
                        tempProdOfferDisplay.setOnSales(offer.getPRODSOLDE() == 1 ? true : false);
                        tempProdOfferDisplay.setPrice1DiscountPerc(100 - ParseUtils.discount(offer.getPRODEUROPRICE(),
                                offer.getPRODEURODISCOUNT()));
                        productOfferEmailDisplays.add(tempProdOfferDisplay);
                        tempProdOfferDisplay = new ProductOfferEmailDisplay();
                    }
                }
            }
        } catch (Exception e) {
            logger.error("unexpected error calling search engine", e);
        }

        return productOfferEmailDisplays;
    }

    @Override
    public PriceAlertProductOfferDisplay getPriceAlertOfferInfo(PriceAlert priceAlert, String country, int delivery, int ksite) {
        PriceAlertProductOfferDisplay productOfferEmailDisplay = new PriceAlertProductOfferDisplay();
        String itemReference;
        String upCountry = country.toUpperCase();
        try {
            // Connect to Engine
            EngineService instance = getInstance(upCountry);

            if (priceAlert.getIsProduct()) {
                List<PriceAlertProductOfferDisplay> productOfferEmailDisplays = new ArrayList<PriceAlertProductOfferDisplay>();
                itemReference = priceAlert.getReference();
                EngineResponse engineResponse = instance.liste_offres(upCountry, delivery, ksite, Long.valueOf(itemReference),
                        true, 100, 0, 2, true, -1, -1, false);//2 -> sort by price asc
                RESULTATPN atpn = (RESULTATPN) engineResponse.getResponse();
                for (PRODUCT prod : atpn.getPRODUCTLIST().getPRODUCT()) {
                    PriceAlertProductOfferDisplay pod = new PriceAlertProductOfferDisplay();
                    pod.setId(priceAlert.getId());
                    pod.setPrice(prod.getPRODEUROPRICE());
                    pod.setDesignation(prod.getPRODDESIGNATION());
                    pod.setGoUrl(buildGoUrl(prod.getSHOPID(), prod.getCATID(), prod.getPRODID(), prod.getSHOPVARS(),
                            GO_URL_KW_PRCING_ALERT));
                    pod.setImageUrl(buildOfferImageUrl(prod.getPRODID(), prod.getPRODDESIGNATION()));
                    pod.setShopName(prod.getSHOPNAME());
                    pod.setShopSiteId(prod.getSHOPID());
                    pod.setAlertDate(sdf.format(priceAlert.getActivatedOn()));
                    pod.setAlertPrice(priceAlert.getMaxPrice());
                    pod.setFormattedPrice(ParseUtils.parsePriceFrenchLocale(prod.getPRODEUROPRICE()));
                    pod.setFormattedAlertPrice(ParseUtils.parsePriceFrenchLocale(
                            priceAlert.getMaxPrice().doubleValue()));

                    productOfferEmailDisplays.add(pod);
                }
                productOfferEmailDisplay = productOfferEmailDisplays.stream()
                        .min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get();
            }
            // If ShoppingListItem is an offer, get informations about the offer
            else {
                itemReference = priceAlert.getReference();
                RESULTATPI response = (RESULTATPI) instance.productInfo(upCountry, itemReference).getResponse();
                if (null != response.getPRODUCT()) {
                    PRODUCT offer = response.getPRODUCT();
                    productOfferEmailDisplay.setId(priceAlert.getId());
                    productOfferEmailDisplay.setShopSiteId(offer.getShopsiteid());
                    productOfferEmailDisplay.setShopName(offer.getSHOPNAME());
                    productOfferEmailDisplay.setImageUrl(buildOfferImageUrl(offer.getPRODID(), offer.getPRODDESIGNATION()));
                    productOfferEmailDisplay.setDesignation(offer.getPRODDESIGNATION());
                    productOfferEmailDisplay.setPrice(offer.getPRODEUROPRICE());
                    productOfferEmailDisplay.setGoUrl(buildGoUrl(offer.getSHOPID(), offer.getCATID(),
                            offer.getPRODID(), offer.getSHOPVARS(), GO_URL_KW_PRCING_ALERT));
                    productOfferEmailDisplay.setAlertDate(sdf.format(priceAlert.getActivatedOn()));
                    productOfferEmailDisplay.setAlertPrice(priceAlert.getMaxPrice());
                    productOfferEmailDisplay.setFormattedPrice(
                            ParseUtils.parsePriceFrenchLocale(offer.getPRODEUROPRICE()));
                    productOfferEmailDisplay.setFormattedAlertPrice(ParseUtils.parsePriceFrenchLocale(
                            priceAlert.getMaxPrice().doubleValue()));
                }
            }
        } catch (Exception e) {
            logger.error("unexpected error calling search engine", e);
        }

        return productOfferEmailDisplay;
    }

    @Override
    public List<PriceAlertProductOfferDisplay> getPriceAlertOfferInfo(List<PriceAlert> priceAlerts, String country, int delivery, int ksite) {
        List<PriceAlertProductOfferDisplay> productOfferEmailDisplays = new ArrayList<>();
        PriceAlertProductOfferDisplay productOfferEmailDisplay;
        String itemReference;
        String upCountry = country.toUpperCase();
        try {
            // Connect to Engine
            EngineService instance = getInstance(upCountry);

            for (PriceAlert priceAlert : priceAlerts) {
                if (priceAlert.getIsProduct()) {
                    List<PriceAlertProductOfferDisplay> tempProductOfferEmailDisplays = new ArrayList<PriceAlertProductOfferDisplay>();
                    itemReference = priceAlert.getReference();
                    EngineResponse engineResponse = instance.liste_offres(upCountry, delivery, ksite, Long.valueOf(itemReference),
                            true, 100, 0, 2, true, -1, -1, false);//2 -> sort by price asc
                    RESULTATPN atpn = (RESULTATPN) engineResponse.getResponse();
                    for (PRODUCT prod : atpn.getPRODUCTLIST().getPRODUCT()) {
                        PriceAlertProductOfferDisplay pod = new PriceAlertProductOfferDisplay();
                        pod.setId(priceAlert.getId());
                        pod.setPrice(prod.getPRODEUROPRICE());
                        pod.setDesignation(prod.getPRODDESIGNATION());
                        pod.setGoUrl(buildGoUrl(prod.getSHOPID(), prod.getCATID(), prod.getPRODID(), prod.getSHOPVARS(),
                                GO_URL_KW_PRCING_ALERT));
                        pod.setImageUrl(buildOfferImageUrl(prod.getPRODID(), prod.getPRODDESIGNATION()));
                        pod.setShopName(prod.getSHOPNAME());
                        pod.setShopSiteId(prod.getSHOPID());
                        pod.setAlertDate(sdf.format(priceAlert.getActivatedOn()));
                        pod.setAlertPrice(priceAlert.getMaxPrice());
                        pod.setFormattedPrice(ParseUtils.parsePriceFrenchLocale(prod.getPRODEUROPRICE()));
                        pod.setFormattedAlertPrice(ParseUtils.parsePriceFrenchLocale(
                                priceAlert.getMaxPrice().doubleValue()));

                        tempProductOfferEmailDisplays.add(pod);
                    }
                    productOfferEmailDisplay = tempProductOfferEmailDisplays.stream()
                            .min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).get();
                }
                // If ShoppingListItem is an offer, get informations about the offer
                else {
                    itemReference = priceAlert.getReference();
                    RESULTATPI response = (RESULTATPI) instance.productInfo(upCountry, itemReference).getResponse();
                    productOfferEmailDisplay = new PriceAlertProductOfferDisplay();
                    if (null != response.getPRODUCT()) {
                        PRODUCT offer = response.getPRODUCT();
                        productOfferEmailDisplay.setId(priceAlert.getId());
                        productOfferEmailDisplay.setShopSiteId(offer.getShopsiteid());
                        productOfferEmailDisplay.setShopName(offer.getSHOPNAME());
                        productOfferEmailDisplay.setImageUrl(buildOfferImageUrl(offer.getPRODID(), offer.getPRODDESIGNATION()));
                        productOfferEmailDisplay.setDesignation(offer.getPRODDESIGNATION());
                        productOfferEmailDisplay.setPrice(offer.getPRODEUROPRICE());
                        productOfferEmailDisplay.setGoUrl(buildGoUrl(offer.getSHOPID(), offer.getCATID(),
                                offer.getPRODID(), offer.getSHOPVARS(), GO_URL_KW_PRCING_ALERT));
                        productOfferEmailDisplay.setAlertDate(sdf.format(priceAlert.getActivatedOn()));
                        productOfferEmailDisplay.setAlertPrice(priceAlert.getMaxPrice());
                        productOfferEmailDisplay.setFormattedPrice(ParseUtils.parsePriceFrenchLocale(
                                offer.getPRODEUROPRICE()));
                        productOfferEmailDisplay.setFormattedAlertPrice(ParseUtils.parsePriceFrenchLocale(
                                priceAlert.getMaxPrice().doubleValue()));
                    }
                }
                if(productOfferEmailDisplay != null) {
                    if (productOfferEmailDisplay.getPrice() < priceAlert.getMaxPrice().doubleValue()) {
                        productOfferEmailDisplays.add(productOfferEmailDisplay);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("unexpected error calling search engine", e);
        }
        return productOfferEmailDisplays;
    }

    // Build offer image url
    private String buildOfferImageUrl(String offerId, String offerName) {

        //TODO :trouver fonction javascirpt urlify
        StringBuilder builder = new StringBuilder();
        builder.append("http://csimg.leguide.com/srv/FR/")
                .append(offerId)
                .append("/T/107x106/C/FFFFFF/url/")
                .append("offer")
                        //.append("URLify(offerName)")
                .append(".jpg");

        return builder.toString();

    }

    // Build the Go Url
    //newsid=1
    private String buildGoUrl(Integer storeId, Long categoryId, String offerId, String shopVars, String keyword) {

        StringBuilder builder = new StringBuilder();
        builder.append("http://go.leguide.com/nav/lg_pt_fr.php?id_mag=")
                .append(storeId)
                .append("&idx=")
                .append(categoryId)
                .append("&idlg=")
                .append(offerId)
                .append("&lang=fr&vars=")
                .append(shopVars)
                .append("&slkw=")
                .append(keyword)
                .append("&type_r=0&gov2=1")
                ;
        return builder.toString();
    }


    @Override
    public List<Map<String, Object>> getAddonOfferInfosList(List<String> offerIds, String country) {

        Map<String, Object> addonOfferInfos = new HashMap<String, Object>();
        List<Map<String, Object>> addonOfferInfosList = new ArrayList<Map<String, Object>>();

        String upCountry = country.toUpperCase();

        // Start Time for logging purpose
//        long time = 0l;
//        if (logger.isInfoEnabled()) {
//            time = System.currentTimeMillis();
//        }

        // Fetch engine Informations
        try {
            EngineService instance = getInstance(upCountry);
            for (String offerId : offerIds) {
                RESULTATPI response = (RESULTATPI) instance.productInfo(upCountry, offerId).getResponse();
                if (null != response.getPRODUCT()) {
                    PRODUCT offer = response.getPRODUCT();
                    addonOfferInfos.put("offerId", offerId); // Offer Id - String
                    addonOfferInfos.put("proddesignation", offer.getPRODDESIGNATION()); // Offer Title - String
                    addonOfferInfos.put("proddescription", offer.getPRODDESCRIPTION()); // Description - String
                    addonOfferInfos.put("shopsiteid", offer.getShopsiteid()); // ShopsiteId - int
                    addonOfferInfos.put("shopname", offer.getSHOPNAME()); // Shop name - String
                    addonOfferInfos.put("prodintlprice", offer.getPRODINTLPRICE()); // Price TTC in national devise -Double
                    addonOfferInfos.put("prodintlfp", offer.getPRODINTLFP()); // Deleviry in national devise - BigDecimal
                    addonOfferInfos.put("prodintldevise", offer.getPRODINTLDEVISE()); // National Devise
                    addonOfferInfos.put("prodean", offer.getPRODEAN13()); // EAN - String


                    addonOfferInfosList.add(addonOfferInfos);
                    addonOfferInfos = new HashMap<String, Object>();
                }
            }

        } catch (Exception e) {
            logger.error("unexpected error calling search engine", e);
        }

        // End Time for logging purpose
//        if (logger.isInfoEnabled()) {
//            time = System.currentTimeMillis() - time;
//            logger.info("AddOnOffersInfoLISTTime = [" + time + "]ms");
//        }

        return addonOfferInfosList;
    }


    @Override
    public Map<String, Object> getOfferAndShopSiteIds(List<String> offerIds, String country) {

        Map<String, Object> offerAndShopSiteIdMap = new HashMap<String, Object>();
        String upCountry = country.toUpperCase();

        // Start Time for logging purpose
        long time = 0l;
        if (logger.isInfoEnabled()) {
            time = System.currentTimeMillis();
        }

        // Fetch engine Informations
        try {
            EngineService instance = getInstance(upCountry);
            for (String offerId : offerIds) {
                RESULTATPI response = (RESULTATPI) instance.productInfo(upCountry, offerId).getResponse();
                if (null != response.getPRODUCT()) {
                    PRODUCT offer = response.getPRODUCT();
                    offerAndShopSiteIdMap.put(offerId, offer.getShopsiteid()); //int
                }
            }
        } catch (Exception e) {
            logger.error("unexpected error calling search engine", e);
        }

        // End Time for logging purpose
        if (logger.isInfoEnabled()) {
            time = System.currentTimeMillis() - time;
            logger.info("AddOnOffersInfoLISTTime = [" + time + "]ms");
        }

        return offerAndShopSiteIdMap;
    }


    public Map<String, Object> getOfferIdsAndLightContents(List<String> offerIds, String country) {

        Map<String, Object> offerAndShopSiteIdMap = new HashMap<String, Object>();
        String upCountry = country.toUpperCase();
        MetaHistorizedInfosJson metaHistorizedInfosJson = new MetaHistorizedInfosJson();

        // Start Time for logging purpose
        long time = 0l;
        if (logger.isInfoEnabled()) {
            time = System.currentTimeMillis();
        }

        // Fetch engine Informations
        try {
            EngineService instance = getInstance(upCountry);
            for (String offerId : offerIds) {
                RESULTATPI response = (RESULTATPI) instance.productInfo(upCountry, offerId).getResponse();
                if (null != response.getPRODUCT()) {
                    PRODUCT offer = response.getPRODUCT();

                    metaHistorizedInfosJson.setOfferName(offer.getPRODDESIGNATION());
                    metaHistorizedInfosJson.setOfferDescription(offer.getPRODDESCRIPTION());
                    metaHistorizedInfosJson.setShopSiteName(offer.getSHOPNAME());
                    offerAndShopSiteIdMap.put("metainfos" + offerId, metaHistorizedInfosJson);
                }
                metaHistorizedInfosJson = new MetaHistorizedInfosJson();
            }
        } catch (Exception e) {
            logger.error("unexpected error calling search engine", e);
        }

        // End Time for logging purpose
        if (logger.isInfoEnabled()) {
            time = System.currentTimeMillis() - time;
            logger.info("AddOnOffersInfoLISTTime = [" + time + "]ms");
        }

        return offerAndShopSiteIdMap;
    }

    public List<PRODUCT> getOffersCategory(String country, String offerIds) {

    	List<PRODUCT> listProductInfo = new ArrayList<PRODUCT>();;
        Integer offerCount;
        String upCountry = country.toUpperCase();
        try {
            // Connect to Engine
            EngineService instance = getInstance(upCountry);
			String[] sb = offerIds.split(",");
			offerCount = sb.length;

			for (int i = 0; i < offerCount.intValue(); i++) {
                RESULTATPI response = (RESULTATPI) instance.productInfo(upCountry, sb[i]).getResponse();
                if (null != response.getPRODUCT()) {
                    PRODUCT offer = response.getPRODUCT();
                    listProductInfo.add(offer);
                }
			}
        } catch (Exception e) {
            logger.error("unexpected error calling search engine", e);
        }
        return listProductInfo;
    }
    
    private EngineService getInstance(String country) throws EngineJaxbException {
        logger.debug("country is " + country);
        logger.debug(engineProperties.getProperty(ENGINE_PROTOCOL_KEY));
        logger.debug(engineProperties.getProperty(country + ENGINE_SERVER_SUFFIXE));
        logger.debug("" + engineProperties.get(ENGINE_PORT_KEY));
        logger.debug("" + engineProperties.get(country + ENGINE_KZONE_SUFFIXE));
        /*if (!services.containsKey(country)) {
            services.put(country, new EngineService(engineProperties.getProperty(ENGINE_PROTOCOL_KEY),
                    engineProperties.getProperty(country + ENGINE_SERVER_SUFFIXE),
                    Integer.valueOf(engineProperties.getProperty(ENGINE_PORT_KEY))));
        }
        return services.get(country);*/
        return new EngineService(engineProperties.getProperty(ENGINE_PROTOCOL_KEY),
                engineProperties.getProperty(country + ENGINE_SERVER_SUFFIXE),
                Integer.valueOf(engineProperties.getProperty(ENGINE_PORT_KEY)));
    }

    public Properties getEngineProperties() {
        return engineProperties;
    }

    public void setEngineProperties(Properties engineProperties) {
        this.engineProperties = engineProperties;
    }


}
