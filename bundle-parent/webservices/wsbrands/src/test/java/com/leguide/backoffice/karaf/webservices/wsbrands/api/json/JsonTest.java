package com.leguide.backoffice.karaf.webservices.wsbrands.api.json;

import org.junit.Test;

import antlr.RecognitionException;
import antlr.TokenStreamException;

import com.sdicons.json.model.JSONObject;
import com.sdicons.json.model.JSONValue;
import com.sdicons.json.parser.JSONParser;
import com.sdicons.json.validator.JSONValidator;
import com.sdicons.json.validator.ValidationException;
import com.sdicons.json.validator.Validator;

public class JsonTest {

    @Test
    public void testValidateInputValidJsonSingleBrand() throws TokenStreamException, RecognitionException,
            ValidationException {
        this.runJsonValidationTest("valid-brand.json");
    }

    @Test
    public void testValidateInputValidJson() throws TokenStreamException, RecognitionException, ValidationException {
        this.runJsonValidationTest("valid-brands.json");
    }

    @Test
    public void testValidateInputValidJsonWithAlias() throws TokenStreamException, RecognitionException,
            ValidationException {
        this.runJsonValidationTest("valid-brands-with-alias.json");
    }

    @Test
    public void testValidateInputValidJsonWithAliases() throws TokenStreamException, RecognitionException,
            ValidationException {
        this.runJsonValidationTest("valid-brands-with-aliases.json");
    }

    @Test(expected = ValidationException.class)
    public void testValidateInputJsonWithDateError() throws TokenStreamException, RecognitionException,
            ValidationException {
        this.runJsonValidationTest("invalid-brands-with-date-error.json");
    }

    @Test(expected = ValidationException.class)
    public void testValidateInputJsonWithNormalizedName() throws TokenStreamException, RecognitionException,
            ValidationException {
        this.runJsonValidationTest("invalid-brands-with-normalized-name.json");
    }

    protected void runJsonValidationTest(String jsonFile) throws TokenStreamException, RecognitionException,
            ValidationException {
        this.runJsonValidationTest(jsonFile, "brands-json-validator.json");
    }

    protected void runJsonValidationTest(String jsonFile, String validatorFile) throws TokenStreamException,
            RecognitionException, ValidationException {

        // Loading json stream
        final JSONParser parser = new JSONParser(this.getClass().getClassLoader().getResourceAsStream(jsonFile));
        JSONValue jsonValue = parser.nextValue();

        // Loading Validator stream
        // JSONParser validatorParser = new JSONParser(new
        // StringReader(validatorStr));
        JSONParser validatorParser = new JSONParser(this.getClass().getClassLoader().getResourceAsStream(validatorFile));
        JSONObject validatorObj = (JSONObject) validatorParser.nextValue();
        Validator validator = new JSONValidator(validatorObj);

        // Validating data
        validator.validate(jsonValue);
    }
}
