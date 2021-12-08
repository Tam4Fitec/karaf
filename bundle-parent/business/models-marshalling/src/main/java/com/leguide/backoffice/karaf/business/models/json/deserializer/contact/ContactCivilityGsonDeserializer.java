package com.leguide.backoffice.karaf.business.models.json.deserializer.contact;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.leguide.backoffice.karaf.business.models.pojo.contact.ContactCivility;
import com.leguide.backoffice.karaf.business.models.pojo.contact.custom.CustomContactCivility;
import com.leguide.backoffice.karaf.business.models.pojo.contact.enums.ContactCivilityEnum;

public class ContactCivilityGsonDeserializer implements JsonDeserializer<ContactCivility> {

	@Override
	public ContactCivility deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		try {
			if(json.isJsonObject())
				throw new IllegalArgumentException("Contact title is unknown ...");
			String title = json.getAsString();
			return ContactCivilityEnum.valueOf(title);
		} catch (IllegalArgumentException e) {
			JsonObject jsonObject = json.getAsJsonObject();
			Integer id = !(jsonObject.get("id") == null || jsonObject.get("id").isJsonNull()) ? jsonObject.get("id").getAsInt() : null;
			String libelle = !(jsonObject.get("libelle") == null || jsonObject.get("libelle").isJsonNull()) ? jsonObject.get("libelle").getAsString() : null;
			return new CustomContactCivility(id, libelle);
		}
	}

}
