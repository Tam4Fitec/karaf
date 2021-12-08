package com.leguide.backoffice.karaf.dao.brands;

import java.util.List;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.exception.BadRequestException;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllBrandsFilters;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.dao.brands.cache.ICacheService;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandDTO;

public interface IBrandsDAO extends IDAO<BrandBO, BrandDTO> {

    /**
     * This method looks for all the brands.
     * 
     * @param filters.addAliases if true, brand's aliases will be returned
     * @param filters.page index of the page
     * @param filters.limit number of brands in a page
     * @return a list of entity representing brands, never null, can be empty
     */
    List<BrandBO> getAllBrands(GetAllBrandsFilters filters);

    /**
     * This method look for the brand with the provided id.
     * 
     * @param brandId id of the brand
     * @param addAliases if true, brand's aliases will be returned
     * @param useCache check first in the cache
     * @return an entity representing a brand, null if not found
     */
    BrandBO getBrandById(Long brandId, Boolean addAliases, boolean useCache);

    /**
     * This method look for the brand with the provided name.
     * 
     * @param filters.brandName name of the brand
     * @param filters.type type of search (Exact, Large or extra large)
     * @param filters.addAliases if true, brand's aliases will be returned
     * @param useCache check first in the cache
     * @return an entity representing a brand, null if not found
     */
    List<BrandBO> getBrandsByName(GetBrandsByNameFilters filters, boolean useCache);

    /**
     * This method look for the brand with the provided normalized name.
     * 
     * @param filters.brandName name of the brand
     * @param filters.type type of search (Exact, Large or extra large) This
     *            method does not support aliases
     * @param useCache check first in the cache
     * @return an entity representing a brand, null if not found
     */
    List<BrandBO> getBrandsByNormalizedName(GetBrandsByNameFilters filters, boolean useCache);

    /**
     * This method update The brand list in database. New aliases and new brands
     * will be added. Entities already inserted won't be updated.
     * 
     * @param brandBoList The list to update.
     * @throws BadRequestException If the list contains invalid data.
     * @return number of brand added
     */
    int save(List<BrandBO> brandBoList);

    /**
     * Get the number of brands in database
     * 
     * @return number of brands
     */
    Integer countBrands();
    
    BrandBO setSeoName(String name, Long brandId);

    ICacheService getCacheService();

    void setCacheService(ICacheService cacheService);

    /**
     * Get the list of brands corresponding to ids in parameter. If one id does not exist, no error will be thrown.
     * @param ids a list of brand ids. If null, a empty (non null) result will be returned. 
     * @param getAliases returned aliases with the brand.
     * @param useCache use hazelcast cache
     */
    List<BrandBO> getBrandsByIds(List<Long> ids, boolean getAliases, boolean useCache);
}
