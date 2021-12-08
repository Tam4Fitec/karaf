package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "brand")
@XmlType(propOrder = { "name", "normalizedName" })
public final class BrandIntegrationOutWrapper implements Serializable {

    private static final long serialVersionUID = -5676695105431872691L;

    private Long brandId;

    private String name;

    private String normalizedName;

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
}
