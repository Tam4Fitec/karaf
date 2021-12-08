package com.leguide.backoffice.karaf.webservice.client.webs.model.offers.response;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/*
 * Created by stephane.ben-zakoun on 12/06/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacetResponseElement {

    private String name;

    @JsonIgnore
    private List<Object> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }
}
