package com.leguide.backoffice.karaf.brands.common.business.model;

import java.io.Serializable;
import java.util.Date;

public final class BrandAliasBO extends AbstractBO implements Serializable {

    private static final long serialVersionUID = -2644712534800161338L;

    private Long id;

    private Long temporaryId;

    private String name;

    private String nameNormalized;

    private BrandBO brand;

    private Date activationDate;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrandBO getBrand() {
        return this.brand;
    }

    public void setBrand(BrandBO brand) {
        this.brand = brand;
    }

    public Long getTemporaryId() {
        return this.temporaryId;
    }

    public void setTemporaryId(Long temporaryId) {
        this.temporaryId = temporaryId;
    }

    public Date getActivationDate() {
        return this.activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.activationDate == null) ? 0 : this.activationDate.hashCode());
        result = prime * result + ((this.brand == null) ? 0 : this.brand.hashCode());
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.nameNormalized == null) ? 0 : this.nameNormalized.hashCode());
        result = prime * result + ((this.temporaryId == null) ? 0 : this.temporaryId.hashCode());
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
        BrandAliasBO other = (BrandAliasBO) obj;
        if (this.activationDate == null) {
            if (other.activationDate != null) {
                return false;
            }
        } else if (!this.activationDate.equals(other.activationDate)) {
            return false;
        }
        if (this.brand == null) {
            if (other.brand != null) {
                return false;
            }
        } else if (!this.brand.equals(other.brand)) {
            return false;
        }
        if (this.id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!this.id.equals(other.id)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.nameNormalized == null) {
            if (other.nameNormalized != null) {
                return false;
            }
        } else if (!this.nameNormalized.equals(other.nameNormalized)) {
            return false;
        }
        if (this.temporaryId == null) {
            if (other.temporaryId != null) {
                return false;
            }
        } else if (!this.temporaryId.equals(other.temporaryId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BrandAliasBO [" + (this.id != null ? "id=" + this.id + ", " : "")
                + (this.temporaryId != null ? "temporaryId=" + this.temporaryId + ", " : "")
                + (this.name != null ? "name=" + this.name + ", " : "")
                + (this.nameNormalized != null ? "nameNormalized=" + this.nameNormalized + ", " : "")
                + (this.brand != null ? "brand=" + this.brand + ", " : "")
                + (this.activationDate != null ? "activationDate=" + this.activationDate : "") + "]";
    }

    public String getNameNormalized() {
        return nameNormalized;
    }

    public void setNameNormalized(String nameNormalized) {
        this.nameNormalized = nameNormalized;
    }
}
