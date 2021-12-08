package com.leguide.backoffice.karaf.webservices.wsbrands.business.helper.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.exception.BadRequestException;
import com.leguide.backoffice.karaf.brands.common.exception.NormalizerException;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;
import com.leguide.backoffice.karaf.dao.brands.IBrandsDAO;
import com.leguide.common.libraries.normalizer.Normalizer;
import com.leguide.backoffice.karaf.webservices.wsbrands.business.helper.IBrandsServiceHelper;

@Service("brandsServiceHelper")
public final class BrandsServiceHelperImpl implements IBrandsServiceHelper {

    @Autowired
    private IBrandsDAO brandsDAO;

    @Autowired
    private Normalizer normalizer;

    @Override
    public BrandBO insertBrand(BrandBO brandBo) {

        // Checking the date
        if (brandBo.getActivationDate() == null) {
            Calendar calendar = Calendar.getInstance();
            brandBo.setActivationDate(calendar.getTime());
        }

        // Inserting the new brand into database
        GetBrandsByNameFilters filters = new GetBrandsByNameFilters();
        filters.setType(SearchBrandsTypeEnum.EXACT);
        filters.setName(brandBo.getName());
        filters.setAddAliases(false);

        //insert will purge the cache anyway, and we need here to chekc if the brand already exists in DB
        List<BrandBO> resultList = this.brandsDAO.getBrandsByName(filters, false);
        BrandBO result;
        if (resultList.size() == 0) {
            try {
                brandBo.setNormalizedName(this.normalize(brandBo.getName()));
                result = this.brandsDAO.persist(brandBo);
            } catch (NormalizerException e) {
                throw new BadRequestException(e);
            }
        } else {
            throw new BadRequestException("Brand " + brandBo.getName() + " has already been inserted");
        }

        return result;
    }

    @Override
    public BrandBO getBrandByNameOrAliasName(String name, boolean useCache) {

        GetBrandsByNameFilters filters = new GetBrandsByNameFilters();
        filters.setAddAliases(true);
        filters.setName(name);
        filters.setIncludeSeoName(false);
        filters.setType(SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS);

        List<BrandBO> resultList = this.brandsDAO.getBrandsByName(filters, useCache);

        if (resultList.size() == 1) {
            return resultList.get(0);
        }

        return null;
    }

    @Override
    public List<BrandBO> normalize(List<BrandBO> brandsBoList) {
        for (BrandBO brandBo : brandsBoList) {
            brandBo.setNormalizedName(this.normalize(brandBo.getName()));
            if (brandBo.getBrandAliases() != null) {
                for (BrandAliasBO alias : brandBo.getBrandAliases()) {
                    alias.setNameNormalized(this.normalize(alias.getName()));
                }
            }
        }

        return brandsBoList;
    }

    @Override
    public String normalize(String name) throws NormalizerException {
        return this.normalizer.fullNormalizeString(name, null);
    }

    public IBrandsDAO getBrandsDAO() {
        return this.brandsDAO;
    }

    public void setBrandsDAO(IBrandsDAO brandsDAO) {
        this.brandsDAO = brandsDAO;
    }

    public Normalizer getNormalizer() {
        return this.normalizer;
    }

    public void setNormalizer(Normalizer normalizer) {
        this.normalizer = normalizer;
    }
}
