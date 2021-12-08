package com.leguide.backoffice.karaf.webservices.wsbrands.business;

import java.util.List;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllBrandsFilters;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.brands.common.utils.enums.BlacklistTypeEnum;

public interface IBrandsService {

    /**
     * This method looks for all the brands.
     * 
     * @param filters.addAliases if true, brand's aliases will be returned
     * @param filters.page index of the page
     * @param filters.limit number of brands in a page
     * @return a list of brands, never null, never empty
     * @throws NotFoundException if no result found
     */
    List<BrandBO> getAllBrands(GetAllBrandsFilters filters);

    /**
     * This method look for the brand with the provided id.
     * 
     * @param brandId id of the brand
     * @param addAliases if true, brand's aliases will be returned
     * @return a brand, never null
     * @param useCache check first in the cache
     * @throws LoadException if an error occurred while fetching data
     * @throws NotFoundException if no result found
     */
    BrandBO getBrandbyId(Long brandId, Boolean addAliases, boolean useCache);

    /**
     * This method look for the brand with the provided name.
     * 
     * @param filters.brandName name of the brand
     * @param filters.addAliases if true, brand's aliases will be returned
     * @param filters.type type of search (Exact, Large or extra large)
     * @param useCache check first in the cache
     * @return a brand, never null
     * @throws LoadException if an error occurred while fetching data
     * @throws NotFoundException if no result found
     */
    List<BrandBO> getBrandsByName(GetBrandsByNameFilters filters, boolean useCache);

    /**
     * This method look for the brand with the provided normalized name. Does
     * not support seoNames
     * 
     * @param filters.brandName normalized name of the brand
     * @param filters.type type of search (Exact, Large, extra large, split and alias)
     * <li> exact : exact search on brand name large : all brands beginning with the
     * searched name
     * <li> large_split : all brands beginning with one of the searched
     * name
     * <li> extra_large : all brands containing the searched name
     * <li> extra_large_split : all brands containing one of the searched name
     * <li> exact_alias : exact search on alias name 
     * <li>large_alias : all aliases beginning with searched name 
     * <li>large_alias_split : all aliases beginning with one of the searched name 
     * <li> extra_large_alias : all aliases containing the searched
     * name
     * <li> extra_large_alias_split : all aliases containing one of the searched
     * names
     * @param filters.addAliases if true, brand's aliases will be returned
     * @param useCache check first in the cache
     * @return a brand, never null
     * @throws LoadException if an error occurred while fetching data
     * @throws NotFoundException if no result found
     */
    List<BrandBO> getBrandsByNormalizedName(GetBrandsByNameFilters filters, boolean useCache);

    /**
     * Blacklist a brand.
     * 
     * @param brandId temporary brand id
     * @param type blacklist type
     * @throws BadRequestException
     * @throws NotFoundException
     */
    void blacklistBrand(Long brandId, BlacklistTypeEnum type);

    /**
     * Unblacklist a brand.
     * 
     * @param brandId temporary brand id
     * @param type blacklist type
     * @throws BadRequestException
     * @throws NotFoundException
     */
    void unblacklistBrand(Long brandId, BlacklistTypeEnum type);

    /**
     * Save a brand into the database
     * 
     * @param brando Brand to save
     * @return Brand saved
     * @throws LoadException Thrown if an error occurred while loading data
     * @throws BadRequestException Thrown if an error occurred while saving data
     */
    BrandBO insertBrand(BrandBO brandBo);

    /**
     * Save a brand list into the database
     * 
     * @param brandsBoList List of brands to save
     * @return Saved List
     * @throws LoadException Thrown if an error occurred while loading data
     * @throws BadRequestException Thrown if an error occurred while saving the
     *             data
     */
    List<BrandBO> saveBrands(List<BrandBO> brandsBoList);

    /**
     * Count the number of brands in the database
     * 
     * @return number of brands
     */
    Integer countBrands();

    /**
     * Change the seo name
     * 
     * @param name name to set
     * @param brandId brand id
     * @return merged brandBo
     */
    BrandBO setSeoName(String name, Long brandId);

    /**
     * Takes a list of ids in parameters, and return a list of brands corresponding to those ids.
     * @param ids a non null list of ids
     * @param getAliases if aliases are required
     * @param useCache use or not the internal cache
     * @return a list of brands. The list size may be inferior to the ids.size(). If an id is not found, no error will
     *  be raised in the dao part. This list cannot be null, and if empty, a NotFoundException will be thrown
     */
    List<BrandBO> getBrandsByIds(List<Long> ids, boolean getAliases, boolean useCache);
}
