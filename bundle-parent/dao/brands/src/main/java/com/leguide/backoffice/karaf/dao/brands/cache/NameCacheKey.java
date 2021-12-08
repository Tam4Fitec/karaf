package com.leguide.backoffice.karaf.dao.brands.cache;

import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;

public class NameCacheKey extends AbstractCacheKey {

    private static final long serialVersionUID = -337892954787175526L;
    private String name;
    private SearchBrandsTypeEnum type;
    private Boolean addAliases;
    private Boolean includeSeoName;

    public NameCacheKey() {
        this.addAliases = false;
        this.type = SearchBrandsTypeEnum.EXACT;
    }

    public NameCacheKey(String name, SearchBrandsTypeEnum type, Boolean addAliases, Boolean includeSeoName) {
        super();
        this.name = name;
        this.type = type;
        this.addAliases = addAliases;
        this.includeSeoName = includeSeoName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchBrandsTypeEnum getType() {
        return type;
    }

    public void setType(SearchBrandsTypeEnum type) {
        this.type = type;
    }

    public Boolean getAddAliases() {
        return addAliases;
    }

    public void setAddAliases(Boolean addAliases) {
        this.addAliases = addAliases;
    }

    public Boolean getIncludeSeoName() {
        return includeSeoName;
    }

    public void setIncludeSeoName(Boolean includeSeoName) {
        this.includeSeoName = includeSeoName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addAliases == null) ? 0 : addAliases.hashCode());
        result = prime * result + ((includeSeoName == null) ? 0 : includeSeoName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        NameCacheKey other = (NameCacheKey) obj;
        if (addAliases == null) {
            if (other.addAliases != null) {
                return false;
            }
        } else if (!addAliases.equals(other.addAliases)) {
            return false;
        }
        if (includeSeoName == null) {
            if (other.includeSeoName != null) {
                return false;
            }
        } else if (!includeSeoName.equals(other.includeSeoName)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NameCacheKey [name=" + name + ", type=" + type + ", addAliases=" + addAliases + ", includeSeoName="
                + includeSeoName + "]";
    }

}
