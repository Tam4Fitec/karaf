package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "brand")
@XmlType(propOrder = { "name", "normalizedName" })
public final class AliasBrandOutWrapper implements Serializable {

    private static final long serialVersionUID = 8676574842698521455L;

    private Long brandId;

    private String name;

    private String normalizedName;

    private String activationDate;

    private Boolean blacklistedSeo;

    private Boolean blacklistedSem;

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
}
