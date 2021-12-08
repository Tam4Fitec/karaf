package com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.adapters;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.BrandAliasOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.BrandIntegrationOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.BrandOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.BrandsOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.common.IGlobalConstants;

@Component
public final class ResourcesOutAdapter {

    public BrandOutWrapper adapt(BrandBO brandBo) {
        return this.adapt(brandBo, false);
    }

    public BrandOutWrapper adapt(BrandBO brandBo, Boolean initialize) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(IGlobalConstants.WS_DATE_FORMAT);

        BrandOutWrapper brandWrapper = new BrandOutWrapper();
        if (initialize) {
            this.initializeBrandOutWrapper(brandWrapper);
        }

        brandWrapper.setBrandId(brandBo.getBrandsId());
        brandWrapper.setName(brandBo.getName());
        brandWrapper.setBlacklistedSem(brandBo.getBlacklistedSem());
        brandWrapper.setBlacklistedSeo(brandBo.getBlacklistedSeo());

        if (brandBo.getNormalizedName() != null) {
            brandWrapper.setNormalizedName(brandBo.getNormalizedName());
        }

        if (brandBo.getSeoName() != null) {
            brandWrapper.setSeoName(brandBo.getSeoName());
        }

        if (brandBo.getActivationDate() != null) {
            brandWrapper.setActivationDate(dateFormat.format(brandBo.getActivationDate()));
        }

        Set<BrandAliasBO> brandAliases = brandBo.getBrandAliases();

        if (brandAliases != null) {
            for (BrandAliasBO brandAlias : brandAliases) {
                BrandAliasOutWrapper brandAliasWrapper = new BrandAliasOutWrapper();

                if (initialize) {
                    this.initializeBrandAliasOutWrapper(brandAliasWrapper);
                }

                brandAliasWrapper.setAliasId(brandAlias.getId());
                brandAliasWrapper.setName(brandAlias.getName());
                if (brandAlias.getNameNormalized() != null) {
                    brandAliasWrapper.setNameNormalized(brandAlias.getNameNormalized());
                }
                if (brandBo.getActivationDate() != null) {
                    brandAliasWrapper.setActivationDate(dateFormat.format(brandAlias.getActivationDate()));
                }

                brandWrapper.addBrand(brandAliasWrapper);
            }
        }

        return brandWrapper;
    }

    public BrandsOutWrapper adapt(List<BrandBO> listBrandBo) {
        return this.adapt(listBrandBo, false);
    }

    public BrandsOutWrapper adapt(List<BrandBO> listBrandBo, Boolean initialize) {

        BrandsOutWrapper result = new BrandsOutWrapper();

        for (BrandBO brand : listBrandBo) {
            result.addBrand(this.adapt(brand, initialize));
        }
        result.setCount(listBrandBo.size());
        result.setTotalCount(listBrandBo.size());
        return result;
    }


    public BrandIntegrationOutWrapper adaptForIntegration(BrandBO brandBo) {

        BrandIntegrationOutWrapper outWrapper = new BrandIntegrationOutWrapper();
        if (brandBo.getBlacklistedSeo() != null && !brandBo.getBlacklistedSeo()) {
            outWrapper.setBrandId(brandBo.getBrandsId());
        }

        if (brandBo.getBrandsId() == null) {
            outWrapper.setBrandId(-brandBo.getTemporaryId());
        }

        outWrapper.setName(brandBo.getName());
        outWrapper.setNormalizedName(brandBo.getNormalizedName());

        return outWrapper;
    }

    private BrandOutWrapper initializeBrandOutWrapper(BrandOutWrapper wrapper) {

        wrapper.setActivationDate("");
        wrapper.setName("");
        wrapper.setNormalizedName("");
        wrapper.setSeoName("");

        return wrapper;
    }

    private BrandAliasOutWrapper initializeBrandAliasOutWrapper(BrandAliasOutWrapper wrapper) {

        wrapper.setActivationDate("");
        wrapper.setName("");
        wrapper.setNameNormalized("");
        return wrapper;
    }

}
