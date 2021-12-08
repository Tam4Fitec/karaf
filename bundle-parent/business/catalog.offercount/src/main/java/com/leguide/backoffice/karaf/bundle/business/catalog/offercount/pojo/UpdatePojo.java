package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.pojo;

import java.io.Serializable;

public class UpdatePojo implements Serializable {

    private static final long serialVersionUID = 5214465525574699489L;
    private Long idshopsite;
    private Long idCatalog;
    private Long totalOffers;
    public Long getIdshopsite() {
        return idshopsite;
    }
    public void setIdshopsite(Long idshopsite) {
        this.idshopsite = idshopsite;
    }
    public Long getIdCatalog() {
        return idCatalog;
    }
    public void setIdCatalog(Long idCatalog) {
        this.idCatalog = idCatalog;
    }
    public Long getTotalOffers() {
        return totalOffers;
    }
    public void setTotalOffers(Long totalOffers) {
        this.totalOffers = totalOffers;
    }

    @Override
    public String toString() {
        return "UpdatePojo [" + (idshopsite != null ? "idshopsite=" + idshopsite + ", " : "")
                + (idCatalog != null ? "idCatalog=" + idCatalog + ", " : "")
                + (totalOffers != null ? "totalOffers=" + totalOffers : "") + "]";
    }

}
