package com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.adapters;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.AliasBrandOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.AliasOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.AliasesOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.common.IGlobalConstants;

@Component
public final class ResourcesAliasOutAdapter {

    public AliasesOutWrapper adapt(List<BrandAliasBO> list, Boolean initialize) {

        AliasesOutWrapper wrapper = new AliasesOutWrapper();

        for (BrandAliasBO brandAliasBO : list) {
            wrapper.addAlias(this.adapt(brandAliasBO, initialize));
        }

        return wrapper;
    }

    public AliasOutWrapper adapt(BrandAliasBO bo, Boolean initialize) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(IGlobalConstants.WS_DATE_FORMAT);

        AliasOutWrapper aliasOutWrapper = new AliasOutWrapper();

        if (initialize) {
            this.initializeAliasOutWrapper(aliasOutWrapper);
        }

        aliasOutWrapper.setName(bo.getName());
        if (bo.getActivationDate() != null) {
            aliasOutWrapper.setActivationDate(dateFormat.format(bo.getActivationDate()));
        }

        if (bo.getBrand() != null) {
            aliasOutWrapper.setAliasBrandOutWrapper(this.adapt(bo.getBrand(), initialize));
        }

        return aliasOutWrapper;
    }

    public AliasBrandOutWrapper adapt(BrandBO bo, Boolean initialize) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(IGlobalConstants.WS_DATE_FORMAT);

        AliasBrandOutWrapper aliasBrandOutWrapper = new AliasBrandOutWrapper();

        if (initialize) {
            this.initializeAliasBrandOutWrapper(aliasBrandOutWrapper);
        }

        aliasBrandOutWrapper.setBrandId(bo.getBrandsId());
        aliasBrandOutWrapper.setName(bo.getName());
        aliasBrandOutWrapper.setNormalizedName(bo.getNormalizedName());
        aliasBrandOutWrapper.setBlacklistedSem(bo.getBlacklistedSem());
        aliasBrandOutWrapper.setBlacklistedSeo(bo.getBlacklistedSeo());
        if (bo.getActivationDate() != null) {
            aliasBrandOutWrapper.setActivationDate(dateFormat.format(bo.getActivationDate()));
        }

        return aliasBrandOutWrapper;
    }

    private AliasOutWrapper initializeAliasOutWrapper(AliasOutWrapper wrapper) {

        wrapper.setActivationDate("");
        wrapper.setName("");
        wrapper.setNameNormalized("");

        return wrapper;
    }

    private AliasBrandOutWrapper initializeAliasBrandOutWrapper(AliasBrandOutWrapper wrapper) {

        wrapper.setActivationDate("");
        wrapper.setName("");
        wrapper.setNormalizedName("");

        return wrapper;
    }
}
