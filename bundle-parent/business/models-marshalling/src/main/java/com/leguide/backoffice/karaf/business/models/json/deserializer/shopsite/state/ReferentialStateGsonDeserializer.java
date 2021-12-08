package com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ReferentialState;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ReferentialStateEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown.UnknownReferentialState;

public class ReferentialStateGsonDeserializer implements JsonDeserializer<ReferentialState> {

	@Override
	public ReferentialState deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		try {
			if(json.isJsonObject())
				throw new IllegalArgumentException("Ref state is unknown ...");
			String refState = json.getAsString();
			return ReferentialStateEnum.valueOf(refState);
		} catch (IllegalArgumentException e) {
			JsonObject jsonObject = json.getAsJsonObject();
			Long idRef = !(jsonObject.get("id") == null || jsonObject.get("id").isJsonNull()) ? jsonObject.get("id").getAsLong() : null;
			String libelle = !(jsonObject.get("libelle") == null || jsonObject.get("libelle").isJsonNull()) ? jsonObject.get("libelle").getAsString() : null;
			return new UnknownReferentialState(idRef, libelle);
		}
	}

}
