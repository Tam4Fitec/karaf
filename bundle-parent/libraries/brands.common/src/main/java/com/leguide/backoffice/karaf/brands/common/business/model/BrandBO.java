package com.leguide.backoffice.karaf.brands.common.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public final class BrandBO extends AbstractBO implements Serializable {

    private static final long serialVersionUID = -4679850106777205514L;

    private Long brandsId;

    private Long temporaryId;

    private String name;

    private String seoName;

    private String normalizedName;

    private Boolean blacklistedSeo;

    private Boolean blacklistedSem;

    private Date activationDate;

    private Set<BrandAliasBO> brandAliases;

    public Long getBrandsId() {
        return this.brandsId;
    }

    public void setBrandsId(Long brandsId) {
        this.brandsId = brandsId;
    }

    public Long getTemporaryId() {
        return this.temporaryId;
    }

    public void setTemporaryId(Long temporaryId) {
        this.temporaryId = temporaryId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeoName() {
        return this.seoName;
    }

    public void setSeoName(String seoName) {
        this.seoName = seoName;
    }

    public String getNormalizedName() {
        return this.normalizedName;
    }

    public void setNormalizedName(String normalizedName) {
        this.normalizedName = normalizedName;
    }

    public Date getActivationDate() {
        return this.activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Set<BrandAliasBO> getBrandAliases() {
        return this.brandAliases;
    }

    public void setBrandAliases(Set<BrandAliasBO> brandAliases) {
        this.brandAliases = brandAliases;
    }

    public Boolean getBlacklistedSeo() {
        return this.blacklistedSeo;
    }

    public void setBlacklistedSeo(Boolean blacklistedSeo) {
        this.blacklistedSeo = blacklistedSeo;
    }

    public Boolean getBlacklistedSem() {
        return this.blacklistedSem;
    }

    public void setBlacklistedSem(Boolean blacklistedSem) {
        this.blacklistedSem = blacklistedSem;
    }

    @Override
    public String toString() {
        return "BrandsBO [" + (this.brandsId != null ? "brandsId=" + this.brandsId + ", " : "")
                + (this.name != null ? "name=" + this.name + ", " : "")
                + (this.normalizedName != null ? "normalizedNamed=" + this.normalizedName + ", " : "")
                + (this.activationDate != null ? "activationDate=" + this.activationDate : "") + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.activationDate == null) ? 0 : this.activationDate.hashCode());
        result = prime * result + ((this.brandsId == null) ? 0 : this.brandsId.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.normalizedName == null) ? 0 : this.normalizedName.hashCode());
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
        BrandBO other = (BrandBO) obj;
        if (this.activationDate == null) {
            if (other.activationDate != null) {
                return false;
            }
        } else if (!this.activationDate.equals(other.activationDate)) {
            return false;
        }
        if (this.brandsId == null) {
            if (other.brandsId != null) {
                return false;
            }
        } else if (!this.brandsId.equals(other.brandsId)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.normalizedName == null) {
            if (other.normalizedName != null) {
                return false;
            }
        } else if (!this.normalizedName.equals(other.normalizedName)) {
            return false;
        }
        return true;
    }

}
