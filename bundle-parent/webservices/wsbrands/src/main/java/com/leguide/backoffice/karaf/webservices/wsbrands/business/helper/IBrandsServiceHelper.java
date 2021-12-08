package com.leguide.backoffice.karaf.webservices.wsbrands.business.helper;

import java.util.List;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.exception.BadRequestException;

public interface IBrandsServiceHelper {

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
     * Look for a brand with the exact name or having an alias matching the
     * input name.
     * 
     * @param name name to look for
     * @return BrandBO the brand
     */
    public BrandBO getBrandByNameOrAliasName(String name, boolean useCache);

    /**
     * Normalized brands name and aliasses names if any
     * 
     * @param List<BrandBO> list to normalize
     * @return list normalized
     */
    List<BrandBO> normalize(List<BrandBO> brandsBoList);

    /**
     * Normalized brand name
     * 
     * @param name Name to normalized
     * @return normalized name
     */
    String normalize(String name);
}
