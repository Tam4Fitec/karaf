package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "alias")
@XmlType(propOrder = { "name", "nameNormalized", "aliasBrandOutWrapper" })
public final class AliasOutWrapper implements Serializable {

    private static final long serialVersionUID = 6558091453185919538L;

    private Long aliasId;

    private String name;
    
    private String nameNormalized;

    private String activationDate;

    private AliasBrandOutWrapper aliasBrandOutWrapper;

    @XmlAttribute(name = "id")
    public Long getAliasId() {
        return this.aliasId;
    }

    public void setAliasId(Long aliasId) {
        this.aliasId = aliasId;
    }

    @XmlElement(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "activationDate")
    public String getActivationDate() {
        return this.activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    @XmlElement(name = "brand")
    public AliasBrandOutWrapper getAliasBrandOutWrapper() {
        return this.aliasBrandOutWrapper;
    }

    public void setAliasBrandOutWrapper(AliasBrandOutWrapper aliasBrandOutWrapper) {
        this.aliasBrandOutWrapper = aliasBrandOutWrapper;
    }

    @XmlElement(name = "nameNormalized")
    public String getNameNormalized() {
        return nameNormalized;
    }

    public void setNameNormalized(String nameNormalized) {
        this.nameNormalized = nameNormalized;
    }
}
