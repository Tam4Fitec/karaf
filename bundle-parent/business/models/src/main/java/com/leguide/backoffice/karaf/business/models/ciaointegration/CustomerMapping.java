package com.leguide.backoffice.karaf.business.models.ciaointegration;

import java.io.Serializable;

public class CustomerMapping implements Serializable {

    private static final long serialVersionUID = -5033460783352926678L;

    private Long id;

    private String country;

    private Long shopsiteId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setShopsiteId(Long shopsiteId) {this.shopsiteId = shopsiteId;}
    public Long getShopsiteId() { return shopsiteId;}
    @Override
    public String toString() {
        return "CustomerMappingResult [" + (id != null ? "id=" + id + ", " : "")
                + (country != null ? "country=" + country : "") + (shopsiteId != null ? "shopsiteId="+shopsiteId : "")+"]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((shopsiteId == null) ? 0 : shopsiteId.hashCode());

        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CustomerMapping other = (CustomerMapping) obj;
        if (country == null) {
            if (other.country != null) {
                return false;
            }
        } else if (!country.equals(other.country)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
