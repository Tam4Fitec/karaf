package com.leguide.backoffice.karaf.business.models.json.deserializer.contact;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactFunction;
import com.leguide.backoffice.karaf.business.models.pojo.contact.custom.CustomContactFunction;
import com.leguide.backoffice.karaf.business.models.pojo.contact.enums.ContactFunctionEnum;

public class ContactFunctionGsonDeserializer implements JsonDeserializer<ContactFunction> {

	@Override
	public ContactFunction deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		try {
			if(json.isJsonObject())
				throw new IllegalArgumentException("Contact function is unknown ...");
			String function = json.getAsString();
			return ContactFunctionEnum.valueOf(function);
		} catch (IllegalArgumentException e) {
			JsonObject jsonObject = json.getAsJsonObject();
			Integer id = !(jsonObject.get("id") == null || jsonObject.get("id").isJsonNull()) ? jsonObject.get("id").getAsInt() : null;
			String libelle = !(jsonObject.get("libelle") == null || jsonObject.get("libelle").isJsonNull()) ? jsonObject.get("libelle").getAsString() : null;
			return new CustomContactFunction(id, libelle);
		}
	}

}
