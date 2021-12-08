package com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state.ClickTypeGsonDeserializer;
import com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state.ReferentialStateGsonDeserializer;
import com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state.ShopSitePriceGsonDeserializer;
import com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state.ShopSiteSortGsonDeserializer;
import com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state.ShopStateGsonDeserializer;
import com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state.StateReasonGsonDeserializer;
import com.leguide.backoffice.karaf.business.models.pojo.Account;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.ShopSite;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.ShopSiteSociety;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ClicType;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.MerchantPrice;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.MerchantSort;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ReferentialState;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopSiteState;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopState;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.StateReason;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ClicTypeEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantPriceEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantSortEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ReferentialStateEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.SegmentationEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ShopStateEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.StateReasonEnum;

public class ShopsiteDeserializerTest {

	private Gson gson;
	
	@Before
	public void setUp() {
		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(ReferentialState.class, new ReferentialStateGsonDeserializer());
		builder.registerTypeAdapter(ShopState.class, new ShopStateGsonDeserializer());
		builder.registerTypeAdapter(MerchantPrice.class, new ShopSitePriceGsonDeserializer());
		builder.registerTypeAdapter(MerchantSort.class, new ShopSiteSortGsonDeserializer());
		builder.registerTypeAdapter(ClicType.class, new ClickTypeGsonDeserializer());
		builder.registerTypeAdapter(StateReason.class, new StateReasonGsonDeserializer());
		
		gson = builder.create();
	}
	
	@Test
	public void testDeserialize() {
		String json = "{\"shopSiteId\":29073794,\"state\":{\"referentialState\":\"REFERENCED_FREE_PLUS\",\"shopState\":\"FREE_PLUS\",\"price\":\"INDIFFERENT\",\"sort\":\"FREE\",\"clicType\":\"FREE\",\"reason\":\"STOPPED\",\"segmentation\":\"D\",\"options\":{\"partnerEnabled\":false,\"logoEnabled\":false,\"engineLogoEnabled\":false,\"productsDisplayed\":true,\"dooyooEnabled\":false,\"strategic\":false}},\"name\":\"Modavilona\",\"url\":\"http://www.modavilona.fr/\",\"country\":\"FR\",\"language\":\"fr\",\"phoneCustomerSupport\":\"09.69.39.08.18\",\"faxCustomerSupport\":\"\",\"emailCustomerSupport\":\"\",\"selfcareAccountId\":147180,\"society\":{\"name\":\"3SW\",\"address1\":\"12 rue de la Centenaire\",\"address2\":\"\",\"zip\":\"59170 \",\"country\":\"FR\",\"phone\":\"09.69.39.08.18\",\"type\":\"SAS\",\"siret\":\" 428 625 032\",\"tvaIntra\":\"\"},\"account\":{\"id\":147180,\"name\":\"modavilona\",\"agency\":false,\"selfcareAccountId\":147180}}";

		ShopSite shopSite = gson.fromJson(json, ShopSite.class);
		
		assertEquals(29073794, shopSite.getShopSiteId().longValue());
		assertEquals("Modavilona", shopSite.getName());
		assertEquals("Modavilona", shopSite.getName());
		assertEquals("http://www.modavilona.fr/", shopSite.getUrl());
		assertEquals("FR", shopSite.getCountry());
		assertEquals("fr", shopSite.getLanguage());
		assertEquals("09.69.39.08.18", shopSite.getPhoneCustomerSupport());
		assertEquals("", shopSite.getFaxCustomerSupport());
		assertEquals("", shopSite.getEmailCustomerSupport());
		assertEquals(147180, shopSite.getSelfcareAccountId().longValue());
		
		ShopSiteSociety society = shopSite.getSociety();
		assertEquals("3SW", society.getName());
		assertEquals("12 rue de la Centenaire", society.getAddress1());
		assertEquals("", society.getAddress2());
		assertEquals("59170 ", society.getZip());
		assertEquals("FR", society.getCountry());
		assertEquals("09.69.39.08.18", society.getPhone());
		assertEquals("SAS", society.getType());
		assertEquals(" 428 625 032", society.getSiret());
		assertEquals("", society.getTvaIntra());
		assertNull(society.getRcs());
		
		ShopSiteState shopSiteState = shopSite.getState();
		assertEquals(ReferentialStateEnum.REFERENCED_FREE_PLUS, shopSiteState.getReferentialState());
		assertEquals(StateReasonEnum.STOPPED, shopSiteState.getReason());
		assertEquals(ShopStateEnum.FREE_PLUS, shopSiteState.getShopState());
		assertEquals(MerchantPriceEnum.INDIFFERENT, shopSiteState.getPrice());
		assertEquals(MerchantSortEnum.FREE, shopSiteState.getSort());
		assertEquals(ClicTypeEnum.FREE, shopSiteState.getClicType());
		assertEquals(SegmentationEnum.D, shopSiteState.getSegmentation());
		
		assertFalse(shopSiteState.getOptions().isPartnerEnabled());
		assertFalse(shopSiteState.getOptions().isLogoEnabled());
		assertFalse(shopSiteState.getOptions().isEngineLogoEnabled());
		assertTrue(shopSiteState.getOptions().isProductsDisplayed());
		assertFalse(shopSiteState.getOptions().isDooyooEnabled());
		assertFalse(shopSiteState.getOptions().isStrategic());
		
		Account account = shopSite.getAccount();
		assertEquals(147180L, account.getId().longValue());
		assertEquals("modavilona", account.getName());
		assertFalse(account.isAgency());
		assertEquals(147180L, account.getSelfcareAccountId().longValue());
	}

}
