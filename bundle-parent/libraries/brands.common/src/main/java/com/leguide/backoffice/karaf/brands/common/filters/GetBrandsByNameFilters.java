package com.leguide.backoffice.karaf.brands.common.filters;

import java.io.Serializable;

import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;

public final class GetBrandsByNameFilters implements Serializable {

    private static final long serialVersionUID = -6337112899400809980L;

    private String name;

    private SearchBrandsTypeEnum type;

    private Boolean addAliases;

    private Boolean includeSeoName;

    public GetBrandsByNameFilters() {
        // Parameters initialization
        this.addAliases = false;
        this.type = SearchBrandsTypeEnum.EXACT;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchBrandsTypeEnum getType() {
        return this.type;
    }

    public void setType(SearchBrandsTypeEnum type) {
        this.type = type;
    }

    public Boolean getAddAliases() {
        return this.addAliases;
    }

    public void setAddAliases(Boolean addAliases) {
        this.addAliases = addAliases;
    }

    public Boolean getIncludeSeoName() {
        return this.includeSeoName;
    }

    public void setIncludeSeoName(Boolean useSeoName) {
        this.includeSeoName = useSeoName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.addAliases == null) ? 0 : this.addAliases.hashCode());
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
        result = prime * result + ((this.includeSeoName == null) ? 0 : this.includeSeoName.hashCode());
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
        GetBrandsByNameFilters other = (GetBrandsByNameFilters) obj;
        if (this.addAliases == null) {
            if (other.addAliases != null) {
                return false;
            }
        } else if (!this.addAliases.equals(other.addAliases)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (this.includeSeoName == null) {
            if (other.includeSeoName != null) {
                return false;
            }
        } else if (!this.includeSeoName.equals(other.includeSeoName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GetBrandsByNameFilters [" + (this.name != null ? "name=" + this.name + ", " : "")
                + (this.type != null ? "type=" + this.type + ", " : "")
                + (this.addAliases != null ? "addAliases=" + this.addAliases + ", " : "")
                + (this.includeSeoName != null ? "useSeoName=" + this.includeSeoName : "") + "]";
    }
}
