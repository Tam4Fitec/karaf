package com.leguide.backoffice.karaf.webservice.client.webs.model.common.request;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class AbstractRequestParameter<TYPE> {

    protected WebSFieldInterface field;

    protected boolean mandatory;

    protected TYPE value;

    public AbstractRequestParameter(WebSFieldInterface name, boolean mandatory) {
        this.field = name;
        this.mandatory = mandatory;
    }

    public AbstractRequestParameter(WebSFieldInterface name, boolean mandatory, TYPE value) {
        this.field = name;
        this.mandatory = mandatory;
        this.value=value;
    }

    public WebSFieldInterface getField() {
        return field;
    }

    public TYPE getValue() {
        return value;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public String getValueStr() {

        if (value instanceof String) {
            return (String) value;
        } else if (value instanceof Integer || value instanceof Long || value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof Collection) {
            Collection collection = (Collection) value;
            return (String) collection.stream().map(Objects::toString).collect(Collectors.joining(","));
        }

        return null;
    }
}
