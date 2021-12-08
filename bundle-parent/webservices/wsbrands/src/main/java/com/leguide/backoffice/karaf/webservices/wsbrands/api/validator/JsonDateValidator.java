package com.leguide.backoffice.karaf.webservices.wsbrands.api.validator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.sdicons.json.model.JSONObject;
import com.sdicons.json.model.JSONString;
import com.sdicons.json.model.JSONValue;
import com.sdicons.json.validator.ValidationException;
import com.sdicons.json.validator.Validator;
import com.sdicons.json.validator.impl.predicates.CustomValidator;

public class JsonDateValidator extends CustomValidator {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public JsonDateValidator(String aName, JSONObject aRule, HashMap<String, Validator> aRuleset) {
        super(aName, aRule, aRuleset);
    }

    @Override
    public void validate(JSONValue aValue) throws ValidationException {

        try {
            String dateStr = ((JSONString) aValue).getValue();
            if (dateStr.equals("") || dateStr.equals("0000-00-00")) {
                return;
            }

            this.dateFormat.setLenient(false);
            this.dateFormat.parse(dateStr);
        } catch (Exception e) {
            fail(e.getMessage(), aValue);
        }
    }

}
