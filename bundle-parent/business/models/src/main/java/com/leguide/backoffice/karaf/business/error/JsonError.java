package com.leguide.backoffice.karaf.business.error;

import java.util.List;

public class JsonError {

    private String message;

    private List<JsonFieldError> fieldErrors;

    public JsonError(String message, List<JsonFieldError> fieldErrors) {
        this.message = message;
        this.fieldErrors = fieldErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<JsonFieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<JsonFieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
