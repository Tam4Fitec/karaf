package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "aliases")
@XmlType(propOrder = { "totalCount", "count", "aliases" })
public final class AliasesOutWrapper implements Serializable {

    private static final long serialVersionUID = 6056539633156289908L;

    private Integer count;

    private Integer totalCount;

    private List<AliasOutWrapper> aliases = new ArrayList<AliasOutWrapper>();

    @XmlElement(name = "count")
    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @XmlElement(name = "alias")
    public List<AliasOutWrapper> getAliases() {
        return this.aliases;
    }

    public void addAlias(AliasOutWrapper aliasElt) {
        this.aliases.add(aliasElt);
    }

    @XmlElement(name = "totalCount")
    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
