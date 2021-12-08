package com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.adapters;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.AliasInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandsListInWrapper;

@Component
public final class ResourcesInAdapter {
	
	private Logger logger = LoggerFactory.getLogger(ResourcesInAdapter.class);
	
	
    public BrandBO adapt(BrandInWrapper wrapper) {

        BrandBO brandBo = new BrandBO();
        brandBo.setTemporaryId(wrapper.getTemporaryId());
        if (wrapper.getName() != null) {
            brandBo.setName(wrapper.getName().trim());
        }
        if (wrapper.getSeoName() != null) {
            brandBo.setSeoName(wrapper.getSeoName().trim());
        }
        brandBo.setActivationDate(wrapper.getActivationDate());
        brandBo.setBrandAliases(this.adapt(wrapper.getAlias()));

        return brandBo;
    }

    public BrandAliasBO adapt(AliasInWrapper alias) {

        BrandAliasBO brandAliasBo = new BrandAliasBO();
        brandAliasBo.setTemporaryId(alias.getTemporaryId());
        if (alias.getName() != null) {
            brandAliasBo.setName(alias.getName().trim());
        }
        if (alias.getNameNormalized() != null) {
            brandAliasBo.setNameNormalized(alias.getNameNormalized().trim());
        }
        brandAliasBo.setActivationDate(alias.getActivationDate());

        return brandAliasBo;
    }

    public List<BrandBO> adapt(BrandsListInWrapper brandsList) {

        LinkedList<BrandBO> brandBoList = new LinkedList<BrandBO>();

        for (BrandInWrapper brand : brandsList.getBrand()) {
            brandBoList.add(this.adapt(brand));
        }

        return brandBoList;
    }

    public Set<BrandAliasBO> adapt(List<AliasInWrapper> aliases) {

        Set<BrandAliasBO> aliasBoList = new LinkedHashSet<BrandAliasBO>();

        for (AliasInWrapper alias : aliases) {
            aliasBoList.add(this.adapt(alias));
        }

        return aliasBoList;
    }
    
}
