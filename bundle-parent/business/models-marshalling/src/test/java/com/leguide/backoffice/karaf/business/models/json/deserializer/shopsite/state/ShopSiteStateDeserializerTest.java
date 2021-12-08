package com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ShopStateEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.StateReasonEnum;

public class ShopSiteStateDeserializerTest {

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
		String json = "{\"referentialState\":\"NON_REFERENCED\",\"shopState\":\"NEW\",\"price\":\"INDIFFERENT\",\"sort\":\"FREE\",\"clicType\":\"FREE\",\"reason\":\"BAD_PAYER\",\"options\":{\"partnerEnabled\":false,\"logoEnabled\":false,\"engineLogoEnabled\":false,\"productsDisplayed\":true,\"dooyooEnabled\":false,\"strategic\":false}}";

		ShopSiteState shopSiteState = gson.fromJson(json, ShopSiteState.class);
		assertEquals(ReferentialStateEnum.NON_REFERENCED, shopSiteState.getReferentialState());
		assertEquals(StateReasonEnum.BAD_PAYER, shopSiteState.getReason());
		assertEquals(ShopStateEnum.NEW, shopSiteState.getShopState());
		assertEquals(MerchantPriceEnum.INDIFFERENT, shopSiteState.getPrice());
		assertEquals(MerchantPriceEnum.INDIFFERENT, shopSiteState.getPrice());
		assertEquals(MerchantSortEnum.FREE, shopSiteState.getSort());
		assertEquals(ClicTypeEnum.FREE, shopSiteState.getClicType());
		
		assertFalse(shopSiteState.getOptions().isPartnerEnabled());
		assertFalse(shopSiteState.getOptions().isLogoEnabled());
		assertFalse(shopSiteState.getOptions().isEngineLogoEnabled());
		assertTrue(shopSiteState.getOptions().isProductsDisplayed());
		assertFalse(shopSiteState.getOptions().isDooyooEnabled());
		assertFalse(shopSiteState.getOptions().isStrategic());
	}

	@Test
	public void testDeserializeWithUnknownFields() {
		String json = "{\"referentialState\":{\"libelle\":\"Unknown\"},\"shopState\":\"NEW_POTENTIAL_CLIENT\",\"price\":{\"id\":0,\"libelle\":\"Unknown\"},\"sort\":\"FREE\",\"clicType\":\"FREE\",\"segmentation\":\"D\",\"options\":{\"partnerEnabled\":false,\"logoEnabled\":false,\"engineLogoEnabled\":false,\"productsDisplayed\":false,\"dooyooEnabled\":false,\"strategic\":false}}";

		ShopSiteState shopSiteState = gson.fromJson(json, ShopSiteState.class);
		assertNull(shopSiteState.getReferentialState().getId());
		assertEquals("Unknown", shopSiteState.getReferentialState().getLibelle());
		assertEquals(0, shopSiteState.getPrice().getId().intValue());
		assertEquals("Unknown", shopSiteState.getPrice().getLibelle());
		
		
	}
	
}
