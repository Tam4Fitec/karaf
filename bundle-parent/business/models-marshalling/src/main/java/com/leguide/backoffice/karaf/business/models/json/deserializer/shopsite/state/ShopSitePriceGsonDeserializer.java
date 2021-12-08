package com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.MerchantPrice;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantPriceEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown.UnknownMerchantPrice;

public class ShopSitePriceGsonDeserializer implements JsonDeserializer<MerchantPrice> {

	@Override
	public MerchantPrice deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		try {
			if(json.isJsonObject())
				throw new IllegalArgumentException("shopsite price is unknown ...");
			String price = json.getAsString();
			return MerchantPriceEnum.valueOf(price);
		} catch (IllegalArgumentException e) {
			JsonObject jsonObject = json.getAsJsonObject();
			Integer id = !(jsonObject.get("id") == null || jsonObject.get("id").isJsonNull()) ? jsonObject.get("id").getAsInt() : null;
			String libelle = !(jsonObject.get("libelle") == null || jsonObject.get("libelle").isJsonNull()) ? jsonObject.get("libelle").getAsString() : null;
			return new UnknownMerchantPrice(id, libelle);
		}
	}

}
