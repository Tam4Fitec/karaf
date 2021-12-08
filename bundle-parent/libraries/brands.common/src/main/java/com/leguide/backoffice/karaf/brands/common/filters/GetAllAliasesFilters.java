package com.leguide.backoffice.karaf.brands.common.filters;

import java.io.Serializable;

public final class GetAllAliasesFilters implements Serializable {

    private static final long serialVersionUID = 1562091822493359901L;

    private Integer page;

    private Integer limit;

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
}
