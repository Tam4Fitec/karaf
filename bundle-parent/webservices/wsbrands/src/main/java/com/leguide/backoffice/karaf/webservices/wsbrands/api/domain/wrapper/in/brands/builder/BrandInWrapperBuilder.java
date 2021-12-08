package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.builder;

import java.util.Date;
import java.util.List;

import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.AliasInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandInWrapper;

public class BrandInWrapperBuilder {

    private String name;
    private String seoName;
    private List<AliasInWrapper> alias;
    private Date activationDate;
    private Long temporaryId;

    public BrandInWrapperBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BrandInWrapperBuilder seoName(String seoName) {
        this.seoName = seoName;
        return this;
    }

    public BrandInWrapperBuilder alias(List<AliasInWrapper> alias) {
        this.alias = alias;
        return this;
    }

    public BrandInWrapperBuilder activationDate(Date activationDate) {
        this.activationDate = activationDate;
        return this;
    }

    public BrandInWrapperBuilder temporaryId(Long temporaryId) {
        this.temporaryId = temporaryId;
        return this;
    }

    public BrandInWrapper build() {
        BrandInWrapper brandInWrapper = new BrandInWrapper();
        brandInWrapper.setName(this.name);
        brandInWrapper.setSeoName(this.seoName);
        brandInWrapper.setAlias(this.alias);
        brandInWrapper.setActivationDate(this.activationDate);
        brandInWrapper.setTemporaryId(this.temporaryId);
        return brandInWrapper;
    }
}
