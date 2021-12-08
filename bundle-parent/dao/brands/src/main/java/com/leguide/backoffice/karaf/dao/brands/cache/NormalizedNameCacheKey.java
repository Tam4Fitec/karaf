package com.leguide.backoffice.karaf.dao.brands.cache;

import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;

public class NormalizedNameCacheKey extends AbstractCacheKey {

    private static final long serialVersionUID = -337892954787175526L;
    private String nameNormalized;
    private SearchBrandsTypeEnum type;
    private Boolean addAliases;
    private Boolean includeSeoName;

    public NormalizedNameCacheKey() {
        this.addAliases = false;
        this.type = SearchBrandsTypeEnum.EXACT;
    }

    public NormalizedNameCacheKey(String nameNormalized, SearchBrandsTypeEnum type, Boolean addAliases,
            Boolean includeSeoName) {
        super();
        this.nameNormalized = nameNormalized;
        this.type = type;
        this.addAliases = addAliases;
        this.includeSeoName = includeSeoName;
    }

    public String getNameNormalized() {
        return nameNormalized;
    }

    public void setNameNormalized(String nameNormalized) {
        this.nameNormalized = nameNormalized;
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
    public String toString() {
        return "NormalizedNameCacheKey [nameNormalized=" + nameNormalized + ", type=" + type + ", addAliases="
                + addAliases + ", includeSeoName=" + includeSeoName + "]";
    }

}
