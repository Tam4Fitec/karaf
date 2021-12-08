package com.leguide.backoffice.karaf.brands.common.filters;

import java.io.Serializable;

public final class GetAllBrandsFilters implements Serializable {

    private static final long serialVersionUID = 7810731827515291650L;

    private Boolean addAliases;

    private Integer page;

    private Integer limit;

    public GetAllBrandsFilters() {
        // Parameters initialization
        this.addAliases = false;
    }

    public Boolean getAddAliases() {
        return this.addAliases;
    }

    public void setAddAliases(Boolean addAliases) {
        this.addAliases = addAliases;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.addAliases == null) ? 0 : this.addAliases.hashCode());
        result = prime * result + ((this.limit == null) ? 0 : this.limit.hashCode());
        result = prime * result + ((this.page == null) ? 0 : this.page.hashCode());
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
        GetAllBrandsFilters other = (GetAllBrandsFilters) obj;
        if (this.addAliases == null) {
            if (other.addAliases != null) {
                return false;
            }
        } else if (!this.addAliases.equals(other.addAliases)) {
            return false;
        }
        if (this.limit == null) {
            if (other.limit != null) {
                return false;
            }
        } else if (!this.limit.equals(other.limit)) {
            return false;
        }
        if (this.page == null) {
            if (other.page != null) {
                return false;
            }
        } else if (!this.page.equals(other.page)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LookupBrandsFilters [" + (this.addAliases != null ? "addAliases=" + this.addAliases + ", " : "")
                + (this.page != null ? "page=" + this.page + ", " : "")
                + (this.limit != null ? "limit=" + this.limit : "") + "]";
    }
}
