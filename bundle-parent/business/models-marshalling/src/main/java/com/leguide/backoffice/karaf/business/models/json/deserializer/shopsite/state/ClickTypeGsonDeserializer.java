package com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ClicType;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ClicTypeEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown.UnknownClicType;

public class ClickTypeGsonDeserializer implements JsonDeserializer<ClicType> {

	@Override
	public ClicType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		try {
			if(json.isJsonObject())
				throw new IllegalArgumentException("Click type is unknown ...");
			String clicType = json.getAsString();
			return ClicTypeEnum.valueOf(clicType);
		} catch (IllegalArgumentException e) {
			JsonObject jsonObject = json.getAsJsonObject();
			Character id = !(jsonObject.get("id") == null || jsonObject.get("id").isJsonNull()) ? jsonObject.get("id").getAsCharacter() : null;
			String libelle = !(jsonObject.get("libelle") == null || jsonObject.get("libelle").isJsonNull()) ? jsonObject.get("libelle").getAsString() : null;
			return new UnknownClicType(id, libelle);
		}
	}

}
