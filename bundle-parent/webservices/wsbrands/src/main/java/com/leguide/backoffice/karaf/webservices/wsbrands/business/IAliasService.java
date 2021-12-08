package com.leguide.backoffice.karaf.webservices.wsbrands.business;

import java.util.List;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllAliasesFilters;

public interface IAliasService {

    /**
     * This method looks for all the aliases.
     * 
     * @param filters.page index of the page
     * @param filters.limit number of brands in a page
     * @return a list of aliases, never null, never empty
     * @throws NotFoundException if no result found
     */
    List<BrandAliasBO> getAllAliases(GetAllAliasesFilters filters);

    /**
     * Get the number of aliases
     * 
     * @return the number of aliases
     */
    Integer countAliases();
}
