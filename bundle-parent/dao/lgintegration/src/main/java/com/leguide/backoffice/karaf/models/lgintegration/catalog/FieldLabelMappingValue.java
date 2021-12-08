package com.leguide.backoffice.karaf.models.lgintegration.catalog;

import javax.persistence.Entity;

@Entity
public class FieldLabelMappingValue {

    private String label;

    private String value;

    public FieldLabelMappingValue() {
    }

    public FieldLabelMappingValue(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
