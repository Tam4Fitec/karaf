package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "brand")
@XmlType(propOrder = { "name", "normalizedName", "seoName", "brandsAliasList" })
public final class BrandOutWrapper implements Serializable {

    private static final long serialVersionUID = 8676574842698521455L;

    private Long brandId;

    private String name;

    private String normalizedName;

    private String seoName;

    private String activationDate;

    private Boolean blacklistedSeo;

    private Boolean blacklistedSem;

    private List<BrandAliasOutWrapper> brandsAliasList = new ArrayList<BrandAliasOutWrapper>();

    @XmlAttribute(name = "id")
    public Long getBrandId() {
        return this.brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @XmlElement(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "normalizedName")
    public String getNormalizedName() {
        return this.normalizedName;
    }

    public void setNormalizedName(String normalizedName) {
        this.normalizedName = normalizedName;
    }

    @XmlElement(name = "seoName")
    public String getSeoName() {
        return this.seoName;
    }

    public void setSeoName(String seoName) {
        this.seoName = seoName;
    }

    @XmlAttribute(name = "activationDate")
    public String getActivationDate() {
        return this.activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    @XmlAttribute(name = "blacklistedSeo")
    public Boolean getBlacklistedSeo() {
        return this.blacklistedSeo;
    }

    public void setBlacklistedSeo(Boolean blacklistedSeo) {
        this.blacklistedSeo = blacklistedSeo;
    }

    @XmlAttribute(name = "blacklistedSem")
    public Boolean getBlacklistedSem() {
        return this.blacklistedSem;
    }

    public void setBlacklistedSem(Boolean blacklistedSem) {
        this.blacklistedSem = blacklistedSem;
    }

    @XmlElement(name = "alias")
    public List<BrandAliasOutWrapper> getBrandsAliasList() {
        return this.brandsAliasList;
    }

    public void addBrand(BrandAliasOutWrapper brandAliasElt) {
        this.brandsAliasList.add(brandAliasElt);
    }
}
