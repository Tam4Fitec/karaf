package com.leguide.backoffice.karaf.dao.brands.cache;

import java.io.Serializable;

public class IdCacheKey extends AbstractCacheKey {

    private static final long serialVersionUID = -2028091629875564800L;
    private Long id;
    private Boolean aliases = Boolean.FALSE;

    public IdCacheKey(Long id, Boolean aliases) {
        super();
        this.id = id;
        this.aliases = aliases;
    }

    public IdCacheKey() {
    }

    @Override
    public String toString() {
        return "IdCacheKey [id=" + id + ", aliases=" + aliases + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aliases == null) ? 0 : aliases.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        IdCacheKey other = (IdCacheKey) obj;
        if (aliases == null) {
            if (other.aliases != null) {
                return false;
            }
        } else if (!aliases.equals(other.aliases)) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAliases() {
        return aliases;
    }

    public void setAliases(Boolean aliases) {
        this.aliases = aliases;
    }

}
