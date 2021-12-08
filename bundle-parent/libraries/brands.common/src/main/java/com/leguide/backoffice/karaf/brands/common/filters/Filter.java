package com.leguide.backoffice.karaf.brands.common.filters;

import java.io.Serializable;

public final class Filter implements Serializable {

    private static final long serialVersionUID = 6861768302249098134L;

    private String name;

    private String value;

    private String likeFormat = "%%%s%%";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLikeFormat() {
        return this.likeFormat;
    }

    public void setLikeFormat(String likeFormat) {
        this.likeFormat = likeFormat;
    }
}
