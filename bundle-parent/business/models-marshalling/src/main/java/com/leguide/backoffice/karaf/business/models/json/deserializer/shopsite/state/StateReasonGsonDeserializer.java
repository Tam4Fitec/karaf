package com.leguide.backoffice.karaf.business.models.json.deserializer.shopsite.state;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.StateReason;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.StateReasonEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.unknown.UnknownStateReason;

public class StateReasonGsonDeserializer implements JsonDeserializer<StateReason> {

	@Override
	public StateReason deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		String stateReason = json.getAsString();
		try {
			return StateReasonEnum.valueOf(stateReason);
		} catch (IllegalArgumentException e) {
			return new UnknownStateReason(stateReason, stateReason);
		}
	}

}
