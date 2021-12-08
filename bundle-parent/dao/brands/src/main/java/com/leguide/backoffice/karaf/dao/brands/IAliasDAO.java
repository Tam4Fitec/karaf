package com.leguide.backoffice.karaf.dao.brands;

import java.util.List;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllAliasesFilters;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandAliasDTO;

public interface IAliasDAO extends IDAO<BrandAliasBO, BrandAliasDTO> {

    /**
     * This method looks for all the aliases.
     * 
     * @param filters.page index of the page
     * @param filters.limit number of brands in a page
     * @return a list of entity representing brands, never null, can be empty
     */
    List<BrandAliasBO> getAllAliases(GetAllAliasesFilters filters);

    Integer countAliases();
}
