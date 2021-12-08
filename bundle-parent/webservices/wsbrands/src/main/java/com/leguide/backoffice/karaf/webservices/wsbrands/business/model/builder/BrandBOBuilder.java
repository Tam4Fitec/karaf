package com.leguide.backoffice.karaf.webservices.wsbrands.business.model.builder;

import java.util.Date;
import java.util.Set;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;

public class BrandBOBuilder {
    private Long brandsId;
    private Long temporaryId;
    private String name;
    private String seoName;
    private String normalizedName;
    private Boolean blacklistedSeo;
    private Boolean blacklistedSem;
    private Date activationDate;
    private Set<BrandAliasBO> brandAliases;

    public BrandBOBuilder brandsId(Long brandsId) {
        this.brandsId = brandsId;
        return this;
    }

    public BrandBOBuilder temporaryId(Long temporaryId) {
        this.temporaryId = temporaryId;
        return this;
    }

    public BrandBOBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BrandBOBuilder seoName(String seoName) {
        this.seoName = seoName;
        return this;
    }

    public BrandBOBuilder normalizedName(String normalizedName) {
        this.normalizedName = normalizedName;
        return this;
    }

    public BrandBOBuilder blacklistedSeo(Boolean blacklistedSeo) {
        this.blacklistedSeo = blacklistedSeo;
        return this;
    }

    public BrandBOBuilder blacklistedSem(Boolean blacklistedSem) {
        this.blacklistedSem = blacklistedSem;
        return this;
    }

    public BrandBOBuilder activationDate(Date activationDate) {
        this.activationDate = activationDate;
        return this;
    }

    public BrandBOBuilder brandAliases(Set<BrandAliasBO> brandAliases) {
        this.brandAliases = brandAliases;
        return this;
    }

    public BrandBO build() {
        BrandBO brandBO = new BrandBO();
        brandBO.setBrandsId(this.brandsId);
        brandBO.setTemporaryId(this.temporaryId);
        brandBO.setName(this.name);
        brandBO.setSeoName(this.seoName);
        brandBO.setNormalizedName(this.normalizedName);
        brandBO.setBlacklistedSeo(this.blacklistedSeo);
        brandBO.setBlacklistedSem(this.blacklistedSem);
        brandBO.setActivationDate(this.activationDate);
        brandBO.setBrandAliases(this.brandAliases);
        return brandBO;
    }
}
