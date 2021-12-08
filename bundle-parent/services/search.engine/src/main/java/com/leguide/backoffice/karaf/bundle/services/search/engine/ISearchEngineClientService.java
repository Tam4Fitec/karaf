package com.leguide.backoffice.karaf.bundle.services.search.engine;

import java.util.List;
import java.util.Map;

import com.leguide.backoffice.karaf.bundle.services.search.engine.model.ShoppingListItem;
import com.leguide.backoffice.karaf.webservices.client.engine.domain.response.PRODUCT;
import com.leguide.backoffice.karaf.bundle.services.search.engine.model.PriceAlert;
import com.leguide.backoffice.karaf.bundle.services.search.engine.model.PriceAlertProductOfferDisplay;
import com.leguide.backoffice.karaf.bundle.services.search.engine.model.ProductOfferEmailDisplay;

public interface ISearchEngineClientService {

    /**
     * Get the number of offersfor the given (word, categoryId)
     * @param kSite the ksite to pass to the search engine, use {@link EngineKSite}
     * @param String country code . The country code from a locale, needed to create the search engine client and select the KPays and KZone
     * @param category the category id
     * @param words search expression
     * @return the number of offers
     */
    long getOffersCount(int kSite, String country, Integer category, String words) throws Exception;

    /**
     * Get the number of offers for the given shop_id, ksite using <b>intra_infomag</b>
     * @param kSite the ksite to pass to the search engine, use {@link EngineKSite}
     * @param String country code . The country code from a locale, needed to create the search engine client and select the KPays and KZone
     * @param shop_id the shop_id <b>(NOT the shopsite_id)</b>
     * @return the number of offers in catalog for the shop_id (SHOP_TOTAL_OFFRE_COUNT)
     */
    long getInfoMagOffersCount(int kSite, String country, Long shopId) throws Exception;

    /**
     * Return all usefull informations about about item of a shopping list
     * @param items of a shopping list
     * @param country country of the website (only 'fr' for now)
     * @param delivery delivery code to pass to the search engine
     * @param ksite ksite code to pass to the search engine
     * @return a list of ProductOfferEmailDisplay
     */
    public List<ProductOfferEmailDisplay>  getShoppingListOffersInfos(List<ShoppingListItem> items, String country, int delivery, int ksite);

    /**
     * Return all useful informations about about a price alert
     * @param priceAlert price Alert item
     * @param country country of the website (only 'fr' for now)
     * @param delivery delivery code to pass to the search engine
     * @param ksite ksite code to pass to the search engine
     * @return a ProductOfferEmailDisplay
     */
    PriceAlertProductOfferDisplay getPriceAlertOfferInfo(PriceAlert priceAlert, String country, int delivery, int ksite);


    /**
     * Return all useful informations about about a price alert list
     * @param priceAlerts price Alert items
     * @param country country of the website (only 'fr' for now)
     * @param delivery delivery code to pass to the search engine
     * @param ksite ksite code to pass to the search engine
     * @return a list of ProductOfferEmailDisplay
     */
    List<PriceAlertProductOfferDisplay> getPriceAlertOfferInfo(List<PriceAlert> priceAlerts, String country, int delivery, int ksite);

    /**
     * Return usefull informations on offer to display on AddOn
     * @param offerIds
     * @param country
     * @return  a List of map, each map giving informations about an offer
     */
    public List<Map<String, Object>> getAddonOfferInfosList(List<String> offerIds, String country);


	/**
	 * Get the shopsiteId for each offerId and return the matching as a map
	 * @param offerIds
	 * @param country
	 * @return map of offerId as key, ShopSiteId as value
	 */
	public Map<String, Object> getOfferAndShopSiteIds(List<String> offerIds, String country);

	/**
	 * Get Informations for each offerId and return the matching as a map
	 * @param offerIds
	 * @param country
	 * @return
	 */
	public Map<String, Object> getOfferIdsAndLightContents(List<String> offerIds, String country);
	
	
	/**
	 * Get Informations for each offerId and return EngineResponse
	 * @param offerIds
	 * @param country
	 * @return
	 */
	public List<PRODUCT> getOffersCategory(String country, String offerIds);
}
