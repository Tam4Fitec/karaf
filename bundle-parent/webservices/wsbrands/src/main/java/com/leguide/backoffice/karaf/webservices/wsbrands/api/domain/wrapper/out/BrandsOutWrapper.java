package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "brandsList")
@XmlType(propOrder = { "totalCount", "count", "brandsList" })
public final class BrandsOutWrapper implements Serializable {

    private static final long serialVersionUID = -5592608001635946923L;

    private Integer count;

    private Integer totalCount;

    private List<BrandOutWrapper> brandsList = new ArrayList<BrandOutWrapper>();

    @XmlElement(name = "count")
    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @XmlElement(name = "brand")
    public List<BrandOutWrapper> getBrandsList() {
        return this.brandsList;
    }

    public void addBrand(BrandOutWrapper brandElt) {
        this.brandsList.add(brandElt);
    }

    @XmlElement(name = "totalCount")
    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
