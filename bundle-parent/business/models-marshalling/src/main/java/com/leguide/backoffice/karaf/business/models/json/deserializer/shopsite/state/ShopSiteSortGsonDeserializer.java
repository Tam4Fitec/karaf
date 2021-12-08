package com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.MerchantSort;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.MerchantSortEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown.UnknownMerchantSort;

public class ShopSiteSortGsonDeserializer implements JsonDeserializer<MerchantSort> {

	@Override
	public MerchantSort deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		try {
			if(json.isJsonObject())
				throw new IllegalArgumentException("shopsite sort is unknown ...");
			String sort = json.getAsString();
			return MerchantSortEnum.valueOf(sort);
		} catch (IllegalArgumentException e) {
			JsonObject jsonObject = json.getAsJsonObject();
			Integer id = !(jsonObject.get("id") == null || jsonObject.get("id").isJsonNull()) ? jsonObject.get("id").getAsInt() : null;
			String libelle = !(jsonObject.get("libelle") == null || jsonObject.get("libelle").isJsonNull()) ? jsonObject.get("libelle").getAsString() : null;
			return new UnknownMerchantSort(id, libelle);
		}
	}

}
