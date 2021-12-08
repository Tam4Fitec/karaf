package com.leguide.backoffice.karaf.webservices.wsbrands.business.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.exception.BadRequestException;
import com.leguide.backoffice.karaf.brands.common.exception.NormalizerException;
import com.leguide.backoffice.karaf.brands.common.exception.NotFoundException;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllBrandsFilters;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.brands.common.utils.enums.BlacklistTypeEnum;
import com.leguide.backoffice.karaf.dao.brands.IBrandsDAO;
import com.leguide.backoffice.karaf.webservices.wsbrands.business.IBrandsService;
import com.leguide.backoffice.karaf.webservices.wsbrands.business.helper.IBrandsServiceHelper;

@Service("loadBrandsService")
@Transactional
public final class BrandsServiceImpl implements IBrandsService {

    @Autowired
    private IBrandsDAO brandsDAO;

    @Autowired
    private IBrandsServiceHelper brandsServiceHelper;

    @Override
    public List<BrandBO> getAllBrands(GetAllBrandsFilters filters) {

        List<BrandBO> result = this.brandsDAO.getAllBrands(filters);

        if (result.size() != 0) {
            return result;
        }

        throw new NotFoundException();
    }

    @Override
    public BrandBO getBrandbyId(Long brandId, Boolean addAliases, boolean useCache) {

        BrandBO result = this.brandsDAO.getBrandById(brandId, addAliases, useCache);

        if (result != null) {
            return result;
        }

        throw new NotFoundException("Brand" + brandId + " not found");
    }

    @Override
    public List<BrandBO> getBrandsByName(GetBrandsByNameFilters filters, boolean useCache) {

        List<BrandBO> result = this.brandsDAO.getBrandsByName(filters, useCache);

        if (result.size() > 0) {
            return result;
        }

        throw new NotFoundException();
    }

    @Override
    public List<BrandBO> getBrandsByIds(List<Long> ids, boolean getAliases, boolean useCache) {
        List<BrandBO> result = this.brandsDAO.getBrandsByIds(ids, getAliases, useCache);
        if (result.size() > 0) {
            return result;
        }
        throw new NotFoundException();
    }

    @Override
    public List<BrandBO> getBrandsByNormalizedName(GetBrandsByNameFilters filters, boolean useCache) {
        List<BrandBO> result = this.brandsDAO.getBrandsByNormalizedName(filters, useCache);
        if (result.size() > 0) {
            return result;
        }
        throw new NotFoundException();
    }

    @Override
    public void blacklistBrand(Long brandId, BlacklistTypeEnum type) {
        this.blacklistBrand(brandId, type, true);
    }

    @Override
    public void unblacklistBrand(Long brandId, BlacklistTypeEnum type) {
        this.blacklistBrand(brandId, type, false);
    }

    protected void blacklistBrand(Long brandId, BlacklistTypeEnum type, Boolean blacklist) {

        BrandBO brandBo = this.brandsDAO.findById(brandId);

        if (brandBo == null) {
            throw new NotFoundException("Brand " + brandId + " not found");
        }

        switch (type) {
        case SEM:
            brandBo.setBlacklistedSem(blacklist);
            break;

        case SEO:
            brandBo.setBlacklistedSeo(blacklist);
            break;

        case ALL:
        default:
            brandBo.setBlacklistedSem(blacklist);
            brandBo.setBlacklistedSeo(blacklist);
            break;
        }

        this.brandsDAO.merge(brandBo);
    }

    @Override
    public List<BrandBO> saveBrands(List<BrandBO> brandsBoList) {

        LinkedList<BrandBO> list = new LinkedList<BrandBO>();

        // for (BrandBO brandBo : brandsBoList) {
        // list.add(this.saveBrand(brandBo));
        // }

        try {
            this.brandsDAO.save(this.brandsServiceHelper.normalize(brandsBoList));
        } catch (NormalizerException e) {
            throw new BadRequestException(e);
        }

        return list;
    }

    @Override
    public Integer countBrands() {
        return this.brandsDAO.countBrands();
    }

    @Override
    public BrandBO setSeoName(String name, Long brandId) {
        BrandBO brandBo = this.brandsDAO.setSeoName(name, brandId);

        /*BrandBO brandBo = this.brandsDAO.findById(brandId);

        if (brandBo == null) {
            throw new NotFoundException("Brand " + brandId + " not found");
        }

        brandBo.setSeoName(name);
        brandBo = this.brandsDAO.merge(brandBo);*/

        return brandBo;
    }

    @Override
    public BrandBO insertBrand(BrandBO brandBo) {
        return this.brandsServiceHelper.insertBrand(brandBo);
    }

    public IBrandsDAO getBrandsDAO() {
        return this.brandsDAO;
    }

    public void setBrandsDAO(IBrandsDAO brandsDAO) {
        this.brandsDAO = brandsDAO;
    }

    public IBrandsServiceHelper getBrandsServiceHelper() {
        return this.brandsServiceHelper;
    }

    public void setBrandsServiceHelper(IBrandsServiceHelper brandsServiceHelper) {
        this.brandsServiceHelper = brandsServiceHelper;
    }

}
