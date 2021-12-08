package com.leguide.backoffice.karaf.webservices.wsbrands.business.model.builder;

import java.util.Date;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;

public class BrandAliasBOBuilder {
    private Long id;
    private Long temporaryId;
    private String name;
    private String nameNormalized;
    private BrandBO brand;
    private Date activationDate;

    public BrandAliasBOBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public BrandAliasBOBuilder temporaryId(Long temporaryId) {
        this.temporaryId = temporaryId;
        return this;
    }

    public BrandAliasBOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BrandAliasBOBuilder nameNormalized(String nameNormalized) {
        this.nameNormalized = nameNormalized;
        return this;
    }

    public BrandAliasBOBuilder brand(BrandBO brand) {
        this.brand = brand;
        return this;
    }

    public BrandAliasBOBuilder activationDate(Date activationDate) {
        this.activationDate = activationDate;
        return this;
    }

    public BrandAliasBO build() {
        BrandAliasBO brandAliasBO = new BrandAliasBO();
        brandAliasBO.setId(this.id);
        brandAliasBO.setTemporaryId(this.temporaryId);
        brandAliasBO.setName(this.name);
        brandAliasBO.setNameNormalized(this.nameNormalized);
        brandAliasBO.setBrand(this.brand);
        brandAliasBO.setActivationDate(this.activationDate);
        return brandAliasBO;
    }
}
