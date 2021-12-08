package com.leguide.backoffice.karaf.business.models.pojo.integration;

public class Source {

    private String mode;

    private String url;

    private Boolean active;

    public Source() {
    }

    public Source(String url, Boolean active) {
        this.url = url;
        this.active = active;
    }

    public Source(String mode, String url, Boolean active) {
        this.mode = mode;
        this.url = url;
        this.active = active;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
