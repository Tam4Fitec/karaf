package com.leguide.backoffice.karaf.webservices.wsbrands.utils;

import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;

public final class GetBrandsByNameFiltersUtils {

    private GetBrandsByNameFiltersUtils() {
    }

    public static GetBrandsByNameFilters createGetBrandsByNameFilters(String name, SearchBrandsTypeEnum type,
            Boolean useSeoName, Boolean addAliases) {

        GetBrandsByNameFilters filters = new GetBrandsByNameFilters();
        filters.setName(name);
        filters.setType(type);
        filters.setIncludeSeoName(useSeoName);
        filters.setAddAliases(addAliases);

        return filters;
    }

    public static GetBrandsByNameFilters createGetBrandsByNameFilters(String name, SearchBrandsTypeEnum type) {
        return GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters(name, type, false, false);
    }
}
