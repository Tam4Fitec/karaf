package com.leguide.backoffice.karaf.dao.lgshop.impl;

public class LocaleLabelTuple {

    private String locale;

    private String label;

    public LocaleLabelTuple() {
    }

    public LocaleLabelTuple(String locale, String label) {
        this.locale = locale;
        this.label = label;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
