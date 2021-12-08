package com.leguide.backoffice.karaf.webservices.client.engine;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.webservices.client.engine.connection.EngineConnection;
import com.leguide.backoffice.karaf.webservices.client.engine.connection.EngineConnectionHelper;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.request.GetOffersRequest;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.request.InfoMagRequest;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.request.ListOffersRequest;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.request.ProductInfoRequest;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.request.ProductsNetRequest;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.request.StartPageRequest;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATPI;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATPN;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.RESULTATSP;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.Response;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineException;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineJaxbException;

/**
 * XMLEngine is a proxy object for working with LeGuide's XML engines
 * 
 * @author frederic.quinet
 * 
 */
public class EngineService implements IEngineProtocol {

    private EngineConnectionHelper engineConnectionHelper;
    private String protocoleNumber;
    private JAXBContext context;

    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(EngineService.class);

    public EngineService(String protocoleNumber, String host, int port) throws EngineJaxbException {
        this.protocoleNumber = protocoleNumber;
        engineConnectionHelper = new EngineConnectionHelper(host, port);
        try {
            ClassLoader cl = com.leguide.backoffice.karaf.webservices.client.engine.domain.response.ObjectFactory.class.getClassLoader();
            context = JAXBContext.newInstance("com.leguide.backoffice.karaf.webservices.client.engine.domain.response:com.leguide.backoffice.karaf.webservices.client.engine.domain.request",
                    cl);
        } catch (JAXBException e) {
            logger.error("error when unmarshalling", e);
            throw new EngineJaxbException("error when unmarshalling", e);
        }
    }

    /**
     * Product net query:  products_net - no filter on offers ( kFilter is null)
     * @param language KPays
     * @param site KSite
     * @param deliveryZone KZone
     * @param catId KCat (catId != -1 ? String.valueOf(catId) : "")
     * @param words KWords
     * @param mark KMark
     * @param pageSize KProdCount
     * @param pageNumber KPage This the engine page number, which starts at 0
     * @param priceMin KPriceMin (if not null)
     * @param priceMax KPriceMax (if not null)
     * @param groupProducts KGroup (groupProducts ? 1 : 0)
     * @param sortType KSort
     * @param occasion KOccasion (occasion ? 1 : 0). Excludes occasions if true
     * @param discountMin KDiscountMin (if not -1)
     * @param discountMax KDiscountMax (if not -1)
     * @param onlyCat KOnlyCat (onlyCat ? 1 : 0)
     * @param markCount KMarkCount (if not -1)
     * @param catCount KCatCount (if not -1)
     * @param productsCriteria KCriteres ( if not null)
     * @param shortLinksCount KShortlinks if not -1
     * @param reviewsSources kReviewsSources if not -1
     * @return RESULTATPN object
     * @throws EngineException
     */
    public EngineResponse productsNet(String language, int site, int deliveryZone, long catId, String words,
            String mark, Integer pageSize, Integer pageNumber, Float priceMin, Float priceMax, boolean groupProducts,
            int sortType, boolean occasion, int discountMin, int discountMax, boolean onlyCat, int markCount,
            int catCount, String productsCriteria, short shortLinksCount, short reviewsSources) throws EngineException {
        return productsNet(language, site, deliveryZone, catId, words, mark, pageSize, pageNumber, priceMin, priceMax,
                groupProducts, sortType, occasion, discountMin, discountMax, onlyCat, markCount, catCount,
                productsCriteria, shortLinksCount, reviewsSources, -1);
    }

    /**
     * Product net query:  products_net
     * @param language KPays
     * @param site KSite
     * @param deliveryZone KZone
     * @param catId KCat (catId != -1 ? String.valueOf(catId) : "")
     * @param words KWords
     * @param mark KMark
     * @param pageSize KProdCount
     * @param pageNumber KPage This the engine page number, which starts at 0
     * @param priceMin KPriceMin (if not null)
     * @param priceMax KPriceMax (if not null)
     * @param groupProducts KGroup (groupProducts ? 1 : 0)
     * @param sortType KSort
     * @param occasion KOccasion (occasion ? 1 : 0). Excludes occasions if true
     * @param discountMin KDiscountMin (if not -1)
     * @param discountMax KDiscountMax (if not -1)
     * @param onlyCat KOnlyCat (onlyCat ? 1 : 0)
     * @param markCount KMarkCount (if not -1)
     * @param catCount KCatCount (if not -1)
     * @param productsCriteria KCriteres ( if not null)
     * @param shortLinksCount KShortlinks if not -1
     * @param reviewsSources kReviewsSources if not -1
     * @param kFilter - filter offers by type . -1 means no filter
     * @return RESULTATPN object
     * @throws EngineException
     */
    public EngineResponse productsNet(String language, int site, int deliveryZone, long catId, String words,
            String mark, Integer pageSize, Integer pageNumber, Float priceMin, Float priceMax, boolean groupProducts,
            int sortType, boolean occasion, int discountMin, int discountMax, boolean onlyCat, int markCount,
            int catCount, String productsCriteria, short shortLinksCount, short reviewsSources, int kFilter) throws EngineException {
        ProductsNetRequest productsNetRequest = new ProductsNetRequest();
        productsNetRequest.setKFunc(PRODUCTS_NET_QUERY);
        productsNetRequest.setKPays(language.toUpperCase());
        productsNetRequest.setKZone(deliveryZone);
        productsNetRequest.setKSite(site);
        productsNetRequest.setKProtocol(protocoleNumber);
        productsNetRequest.setKCat(catId != NO_CAT ? String.valueOf(catId) : "");
        productsNetRequest.setKMark(mark);
        productsNetRequest.setKWords(words);
        productsNetRequest.setKGroup(groupProducts ? 1 : 0);
        productsNetRequest.setKProdCount(pageSize);
        productsNetRequest.setKPage(pageNumber);
        productsNetRequest.setKSort(sortType);
        productsNetRequest.setKOccasion(occasion ? 1 : 0);

        if (discountMin != NO_DISCOUNT) {
            productsNetRequest.setKDiscountMin(discountMin);
        }
        if (discountMax != NO_DISCOUNT) {
            productsNetRequest.setKDiscountMax(discountMax);
        }
        productsNetRequest.setKOnlyCat(onlyCat ? 1 : 0);
        if (markCount != NO_MARK_COUNT) {
            productsNetRequest.setKMarkCount(markCount);
        }
        if (catCount != NO_CAT_COUNT) {
            productsNetRequest.setKCatCount(catCount);
        }
        if (StringUtils.isNotBlank(productsCriteria)) {
            productsNetRequest.setKCriteres(productsCriteria);
        }
        if (shortLinksCount != NO_SHORTLINKS) {
            productsNetRequest.setKShortlinks(shortLinksCount);
        }
        if (reviewsSources != NO_REVIEWSOURCES) {
            productsNetRequest.setKReviewsSources(reviewsSources);
        }
        if (kFilter != NO_KFILTER) {
            productsNetRequest.setKFilter(kFilter);
        }
        productsNetRequest.setKPhp(0);
        if (priceMin != null) {
            productsNetRequest.setKPriceMin(priceMin);
        }
        if (priceMax != null) {
            productsNetRequest.setKPriceMax(priceMax);
        }
        EngineConnection engineConnection = engineConnectionHelper.getEngineConnection();
        try {
            long time = 0l;
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis();
            }
            logger.debug("Request connection hashCode = [{}]", engineConnection.hashCode());
            logger.debug("Request = [{}]", productsNetRequest);
            engineConnection.postRequest(productsNetRequest, context);
            logger.debug("Response connection hashCode = [{}]", engineConnection.hashCode());
            String resp = engineConnection.getResponse();
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis() - time;
                logger.info("engineTime = [" + time + "]ms");
            }
            Response response = buildResponse(resp, RESULTATPN.class);
            return new EngineResponse(response);
        } catch (EngineException e) {
            throw e;
        } catch (Exception e) {
            String msg = "unexpected exception in productsNet";
            logger.error(msg, e);
            throw new EngineException(msg, e);
        } finally {
            engineConnection.disconnect();
            engineConnection = null;
        }

    }

    /**
     * Product net query:  list_offres, same as {@link #productsNet(String, int, int, long, String, String, Integer, Integer, Float, Float, boolean, int, boolean, int, int, boolean, int, int, String, short, short, int)}
     * but with a store id instead of a category id
     * @param language KPays
     * @param site KSite
     * @param deliveryZone KZone
     * @param storeId : the merchant id unique by country (when looking at 2s results, it is not the shopsite_id, but the shop_id)
     * @param pageSize KProdCount
     * @param pageNumber KPage This the engine page number, which starts at 0
     * @param priceMin KPriceMin (if not null)
     * @param priceMax KPriceMax (if not null)
     * @param groupProducts KGroup (groupProducts ? 1 : 0)
     * @param sortType KSort
     * @param occasion KOccasion (occasion ? 1 : 0). Excludes occasions if true
     * @param discountMin KDiscountMin (if not -1)
     * @param discountMax KDiscountMax (if not -1)
     * @param debugMode set kDebug to 1 (true) or 0 (false)
     * @return RESULTATPN object
     * @throws EngineException
     */
    public EngineResponse listOffresByStoreId(String language, int site, int deliveryZone, long storeId,
            Integer pageSize, Integer pageNumber, boolean groupProducts, int sortType, boolean occasion,
            int discountMin, int discountMax, boolean debugMode) throws EngineException {
        ListOffersRequest loRequest = new ListOffersRequest();
        loRequest.setKFunc(LISTE_OFFRES_QUERY);
        loRequest.setKPays(language.toUpperCase());
        loRequest.setKZone(deliveryZone);
        loRequest.setKSite(site);
        loRequest.setKProtocol(protocoleNumber);
        loRequest.setkShop(storeId);
        loRequest.setKGroup(groupProducts ? 1 : 0);
        loRequest.setKProdCount(pageSize);
        loRequest.setKPage(pageNumber);
        loRequest.setKSort(sortType);
        loRequest.setKOccasion(occasion ? 1 : 0);
        loRequest.setkDebug(debugMode ? 1 : 0);

        loRequest.setKDiscountMin(discountMin != NO_DISCOUNT ? discountMin : 0);
        loRequest.setKDiscountMax(discountMax != NO_DISCOUNT ? discountMax : 100);
       
        loRequest.setKPhp(0);
        EngineConnection engineConnection = engineConnectionHelper.getEngineConnection();
        try {
            long time = 0l;
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis();
            }
            logger.debug("Request connection hashCode = [{}]", engineConnection.hashCode());
            logger.debug("Request = [{}]", loRequest);
            engineConnection.postRequest(loRequest, context);
            logger.debug("Response connection hashCode = [{}]", engineConnection.hashCode());
            String resp = engineConnection.getResponse();
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis() - time;
                logger.info("engineTime = [" + time + "]ms");
            }
            Response response = buildResponse(resp, RESULTATPN.class);
            return new EngineResponse(response);
        } catch (EngineException e) {
            throw e;
        } catch (Exception e) {
            String msg = "unexpected exception in productsNet";
            logger.error(msg, e);
            throw new EngineException(msg, e);
        } finally {
            engineConnection.disconnect();
            engineConnection = null;
        }

    }


    /**
     * KFunc = Liste_offres
     * @param language KPays (upper case)
     * @param deliveryZone KZone
     * @param site KSite
     * @param productId KBaseID
     * @param occasion KOccasion (occasion ? 1 : 0). Excludes occasions if true
     * @param pageSize KProdCount
     * @param pageNumber KPage This the engine page number, which starts at 0
     * @param sortType KSort
     * @param groupProducts KGroup (groupProducts ? 1 : 0)
     * @param discountMin KDiscountMin (discountMin != -1 ? discountMin : 0)
     * @param discountMax KDiscountMax (discountMax != -1 ? discountMax : 100)
     * @param phpSort KPhp (phpSort ? 1 : 0)
     * @return RESULTATPN.class
     * @throws EngineException
     */
    public EngineResponse liste_offres(String language, int deliveryZone, int site, long productId,
            boolean occasion, Integer pageSize, Integer pageNumber, int sortType, boolean groupProducts,
            int discountMin, int discountMax, boolean phpSort) throws EngineException {
        EngineConnection engineConnection = engineConnectionHelper.getEngineConnection();
        try {
            ListOffersRequest request = new ListOffersRequest();
            request.setKFunc(LISTE_OFFRES_QUERY);
            request.setKPays(language.toUpperCase());
            request.setKZone(deliveryZone);
            request.setKSite(site);
            request.setKBaseID(productId);
            request.setKOccasion(occasion ? 1 : 0);
            request.setKProdCount(pageSize);
            request.setKPage(pageNumber);
            request.setKSort(sortType);
            request.setKGroup(groupProducts ? 1 : 0);
            request.setKDiscountMin(discountMin != NO_DISCOUNT ? discountMin : 0);
            request.setKDiscountMax(discountMax != NO_DISCOUNT ? discountMax : 100);
            request.setKPhp(phpSort ? 1 : 0);
            request.setKProtocol(protocoleNumber);

            long time = 0l;
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis();
            }
            logger.debug("Request connection = [" + engineConnection.hashCode() + "]");
            logger.debug("Request = [{}]", request);
            engineConnection.postRequest(request, context);
            logger.debug("Response connection = [" + engineConnection.hashCode() + "]");
            String resp = engineConnection.getResponse();
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis() - time;
                logger.info("engineTime = [" + time + "]ms");
            }
            Response response = buildResponse(resp, RESULTATPN.class);
            return new EngineResponse(response);
        } catch (EngineException e) {
            throw e;
        } catch (Exception e) {
            String msg = "unexpected exception in liste_offres";
            logger.error(msg, e);
            throw new EngineException(msg, e);
        } finally {
            engineConnection.disconnect();
            engineConnection = null;
        }
    }

    /**
     * KFunc is prod_info
     * @param language KPays (upper case)
     * @param productId KProduct
     * @return RESULTATPI.class
     * @throws EngineException
     */
    public EngineResponse productInfo(String language, String productId) throws EngineException {
        EngineConnection engineConnection = engineConnectionHelper.getEngineConnection(30);
        try {
            ProductInfoRequest productInfoRequest = new ProductInfoRequest();
            productInfoRequest.setKFunc(PRODUCT_INFO_QUERY);
            productInfoRequest.setKPays(language.toUpperCase());
            productInfoRequest.setKProduct(productId);
            long time = 0l;
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis();
            }
            logger.debug("Request connection = [" + engineConnection.hashCode() + "]");
            logger.debug("Request = [{}]", productInfoRequest);
            engineConnection.postRequest(productInfoRequest, context);
            logger.debug("Response connection = [" + engineConnection.hashCode() + "]");
            String resp = engineConnection.getResponse();
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis() - time;
                logger.info("engineTime = [" + time + "]ms");
            }
            Response response = buildResponse(resp, RESULTATPI.class);
            return new EngineResponse(response);
        } catch (EngineException e) {
            throw e;
        } catch (Exception e) {
            String msg = "unexpected exception in productInfo";
            logger.error(msg, e);
            throw new EngineException(e);
        } finally {
            engineConnection.disconnect();
            engineConnection = null;
        }
    }

    /**
     * KFunc is start_page 
     * @param state KPays
     * @param zone KZone
     * @param site KSite
     * @return RESULTATSP.class
     * @throws EngineException
     */
    public EngineResponse startPage(String state, int zone, int site) throws EngineException {
        EngineConnection engineConnection = engineConnectionHelper.getEngineConnection();
        try {
            StartPageRequest startPageRequest = new StartPageRequest();
            startPageRequest.setKFunc(START_PAGE_QUERY);
            startPageRequest.setKPays(state);
            startPageRequest.setKZone(zone);
            startPageRequest.setKSite(site);
            long time = 0l;
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis();
            }
            logger.debug("Request connection = [" + engineConnection.hashCode() + "]");
            logger.debug("Request = [{}]", startPageRequest);
            engineConnection.postRequest(startPageRequest, context);
            logger.debug("Response connection = [" + engineConnection.hashCode() + "]");
            String resp = engineConnection.getResponse();
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis() - time;
                logger.info("engineTime = [" + time + "]ms");
            }
            Response response = buildResponse(resp, RESULTATSP.class);
            return new EngineResponse(response);
        } catch (EngineException e) {
            throw e;
        } catch (Exception e) {
            String msg = "unexpected exception in startPage";
            logger.error(msg, e);
            throw new EngineException(msg, e);
        } finally {
            engineConnection.disconnect();
            engineConnection = null;
        }
    }

    /**
     * Get offers - get the number of offers
     * @param kPays language
     * @param kSite
     * @param kZone
     * @param kCat (catId != -1 ? String.valueOf(catId) : "")
     * @param kWords search keywords
     * @param kGroup (groupProducts ? 1 : 0)
     * @param kProdCount  pageSize 
     * @param kPage This the engine page number, which starts at 0
     * @param kSort sortType
     * @param kOccasion (occasion ? 1 : 0). Excludes occasions if true
     * @param kDebug - debug mode 1 or 0 
     * @return RESULTATPN object
     * @throws EngineException
     */
    public EngineResponse getOffersCount(String kPays, int kSite, int kZone, long kCat, String kWords,
            boolean kGroup, Integer kProdCount, Integer kPage, int kSort, boolean kOccasion, boolean kDebug) throws EngineException {
        GetOffersRequest getOffersRequest = new GetOffersRequest();
        getOffersRequest.setKFunc(GET_OFFERS_QUERY);
        getOffersRequest.setKPays(kPays.toUpperCase());
        getOffersRequest.setKZone(kZone);
        getOffersRequest.setkSite(kSite);
        getOffersRequest.setkProtocol(protocoleNumber);
        getOffersRequest.setkCat(kCat != NO_CAT ? String.valueOf(kCat) : "");
        getOffersRequest.setkWords(kWords);
        getOffersRequest.setkGroup(kGroup ? 1 : 0);
        getOffersRequest.setkProdCount(kProdCount);
        getOffersRequest.setkPage(kPage);
        getOffersRequest.setkSort(kSort);
        getOffersRequest.setkOccasion(kOccasion ? 1 : 0);
        getOffersRequest.setkPhp(0);
        getOffersRequest.setkDebug(kDebug ? 1 : 0);

        EngineConnection engineConnection = engineConnectionHelper.getEngineConnection();
        try {
            long time = 0l;
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis();
            }
            logger.debug("Request connection hashCode = [{}]", engineConnection.hashCode());
            logger.debug("Request = [{}]", getOffersRequest);
            engineConnection.postRequest(getOffersRequest, context);
            logger.debug("Response connection hashCode = [{}]", engineConnection.hashCode());
            String resp = engineConnection.getResponse();
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis() - time;
                logger.info("engineTime = [" + time + "]ms");
            }
            Response response = buildResponse(resp, RESULTATPN.class);
            return new EngineResponse(response);
        } catch (EngineException e) {
            throw e;
        } catch (Exception e) {
            String msg = "unexpected exception in getOffers";
            logger.error(msg, e);
            throw new EngineException(msg, e);
        } finally {
            engineConnection.disconnect();
            engineConnection = null;
        }
    }

    /**
     * Get offers for a category + shopId, kwords optionnal
     * @param kPays language
     * @param kSite
     * @param kZone
     * @param kCat (catId != -1 ? String.valueOf(catId) : "")
     * @param kShop (kShop != -1 ? String.valueOf(kShop) : "") . This is the storeId, not the id_shopsite !
     * @param kWords search keywords
     * @param kGroup (groupProducts ? 1 : 0)
     * @param kProdCount  pageSize 
     * @param kPage This the engine page number, which starts at 0
     * @param kSort sortType
     * @param kOccasion (occasion ? 1 : 0). Excludes occasions if true
     * @param kDebug - debug mode 1 or 0 
     * @return RESULTATPN object
     * @throws EngineException
     */
    public EngineResponse getOffersByShopCategoryKwords(String kPays, int kSite, int kZone, String kCat, String kShop, String kWords,
            boolean kGroup, Integer kProdCount, Integer kPage, int kSort, boolean kOccasion, boolean kDebug) throws EngineException {
        GetOffersRequest getOffersRequest = new GetOffersRequest();
        getOffersRequest.setKFunc(GET_OFFERS_QUERY);
        getOffersRequest.setKPays(kPays.toUpperCase());
        getOffersRequest.setKZone(kZone);
        getOffersRequest.setkSite(kSite);
        getOffersRequest.setkProtocol(protocoleNumber);
        getOffersRequest.setkCat(kCat != null ? kCat : "");
        getOffersRequest.setkShop(kShop != null ? kShop : "");
        getOffersRequest.setkWords(kWords);
        getOffersRequest.setkGroup(kGroup ? 1 : 0);
        getOffersRequest.setkProdCount(kProdCount);
        getOffersRequest.setkPage(kPage);
        getOffersRequest.setkSort(kSort);
        getOffersRequest.setkOccasion(kOccasion ? 1 : 0);
        getOffersRequest.setkPhp(0);
        getOffersRequest.setkDebug(kDebug ? 1 : 0);

        EngineConnection engineConnection = engineConnectionHelper.getEngineConnection();
        try {
            long time = 0l;
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis();
            }
            logger.debug("Request connection hashCode = [{}]", engineConnection.hashCode());
            logger.debug("Request = [{}]", getOffersRequest);
            engineConnection.postRequest(getOffersRequest, context);
            logger.debug("Response connection hashCode = [{}]", engineConnection.hashCode());
            String resp = engineConnection.getResponse();
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis() - time;
                logger.info("engineTime = [" + time + "]ms");
            }
            Response response = buildResponse(resp, RESULTATPN.class);
            return new EngineResponse(response);
        } catch (EngineException e) {
            throw e;
        } catch (Exception e) {
            String msg = "unexpected exception in getOffers";
            logger.error(msg, e);
            throw new EngineException(msg, e);
        } finally {
            engineConnection.disconnect();
            engineConnection = null;
        }
    }

    /**
     *  Get offers - get the number of offers from intra_infomag
     * @param kPays kPays parameter
     * @param kSite kSite parameter
     * @param kZone kZone , linked to the country
     * @param kShop kShop, the shop_id
     * @param kDebug 
     * @return SHOP_TOTAL_OFFRE_COUNT
     * @throws EngineException
     */
    public Long intraInfoMagTotalOffers(String kPays, int kSite, int kZone, long kShop, boolean kDebug) throws EngineException {
       //?kProtocol=1.1&kFunc=intra_infomag&kPays=FR&kZone=1&kSite=2&kPhp=0&kShop=929&kDebug=1
        InfoMagRequest infoMagRequest = new InfoMagRequest();
        infoMagRequest.setKFunc(INFO_MAG_QUERY);
        infoMagRequest.setKPays(kPays.toUpperCase());
        infoMagRequest.setKZone(kZone);
        infoMagRequest.setkSite(kSite);
        infoMagRequest.setkProtocol(protocoleNumber);
        infoMagRequest.setkShop(kShop);
        infoMagRequest.setkPhp(0);
        infoMagRequest.setkDebug(kDebug ? 1 : 0);

        EngineConnection engineConnection = engineConnectionHelper.getEngineConnection(15);
        try {
            long time = 0l;
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis();
            }
            logger.debug("Request = [{}]", infoMagRequest);
            engineConnection.postRequest(infoMagRequest, context);
            String resp = engineConnection.getResponseReadLine();
            if (logger.isInfoEnabled()) {
                time = System.currentTimeMillis() - time;
                logger.info("engineTime = [" + time + "]ms");
            }
            return extractIntraInfoMagTotalCount(resp);
        } catch (EngineException e) {
            throw e;
        } catch (Exception e) {
            String msg = "unexpected exception in intraInfoMag";
            logger.error(msg, e);
            throw new EngineException(msg, e);
        } finally {
            engineConnection.disconnect();
            engineConnection = null;
        }
    }

    protected Long extractIntraInfoMagTotalCount(String resp) {
        Pattern p = Pattern.compile("^*.<SHOP_TOTAL_OFFRE_COUNT>([0-9]+)<\\.*");
        Matcher m = p.matcher(resp);
        Long res = -1l;
        if (m.find()) {
            res = Long.valueOf(m.group(1));
        }
        m = null;
        p = null;
        return res;
    }

    protected Response buildResponse(String response, Class clazz) throws EngineException {
        logger.debug("response = [" + response + "]");
        logger.debug("response_size = [" + response.length() + "]");
        Response result = null;
        try {
            result = (Response) unMarshallResultat(response, clazz);
        } catch (JAXBException e) {
            logger.warn("error when unmarshalling", e);
            throw new EngineJaxbException("error when unmarshalling", e);
        } catch (XMLStreamException e) {
            logger.warn("error when unmarshalling", e);
            throw new EngineJaxbException("error when unmarshalling", e);
        }
        return result;
    }

    private Response unMarshallResultat(String doc, Class<? extends Response> clazz) throws JAXBException, XMLStreamException {
        logger.debug("package = [" + clazz.getPackage().getName() + "]");
        logger.debug("clazz = [" + clazz.getName() + "]");
        logger.debug(doc);
        //JAXBContext context = JAXBContext.newInstance(clazz.getPackage().getName());
        Unmarshaller um = context.createUnmarshaller();
        Response response = null;
        XMLStreamReader reader = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        reader = factory.createXMLStreamReader(new ByteArrayInputStream(doc.getBytes(Charset.forName("UTF-8"))));
        // listOffers = (RESULTATPI)um.unmarshal(new
        // ByteArrayInputStream(doc.getBytes()));
        response = (Response) um.unmarshal(reader, clazz).getValue();
        logger.debug("Response class = [" + response.getClass().getName() + "]");
        return response;
    }
    
//    public static <T> T unmarshal(Class<? extends T> type, InputStream in) {
//        try {
//            JAXBContext ctx = JAXBContext.newInstance(type);
//            Unmarshaller unMarshaller = ctx.createUnmarshaller();
//            return unMarshaller.unmarshal(new StreamSource(in), type).getValue();
//        } catch (JAXBException ex) {
//            LOGGER.warn("Could not un marshal type: " + type, ex);
//            throw new IllegalArgumentException("The type: " + type.getName() + " could not be unmarshalled", ex);
//        }
//    }

    public EngineConnectionHelper getEngineConnectionHelper() {
        return engineConnectionHelper;
    }

    public void setEngineConnectionHelper(EngineConnectionHelper engineConnectionHelper) {
        this.engineConnectionHelper = engineConnectionHelper;
    }

    public String getProtocoleNumber() {
        return protocoleNumber;
    }

    public void setProtocoleNumber(String protocoleNumber) {
        this.protocoleNumber = protocoleNumber;
    }

}
