package com.leguide.backoffice.karaf.dao.brands.adapters.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.exception.BadRequestException;
import com.leguide.backoffice.karaf.dao.brands.adapters.IBrandAdapter;
import com.leguide.backoffice.karaf.dao.brands.adapters.IBrandAliasAdapter;
import com.leguide.backoffice.karaf.dao.brands.entity.AbstractDTO;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandAliasDTO;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandDTO;

public final class BrandAdapter implements IBrandAdapter {

    public BrandBO adapt(BrandDTO brandDto) {

        if (brandDto == null) {
            return null;
        }

        BrandBO brandBo = mainAdapter(brandDto);
        brandBo.setBrandAliases(adaptAliases(brandDto, brandBo));

        return brandBo;
    }

    public BrandDTO adapt(BrandBO brandBo) {

        BrandDTO brandDto = new BrandDTO();

        brandDto.setId(brandBo.getBrandsId());
        brandDto.setTemporaryId(brandBo.getTemporaryId());
        brandDto.setName(brandBo.getName());
        brandDto.setNormalizedName(brandBo.getNormalizedName());

        brandDto.setBrandAliases(adaptAliases(brandBo.getBrandAliases(), brandDto));

        if (brandBo.getSeoName() == null || brandBo.getSeoName().trim().equals("")) {
            brandDto.setSeoName(null);
        } else {
            brandDto.setSeoName(brandBo.getSeoName());
        }

        // Blacklist SEM default value is false
        if (brandBo.getBlacklistedSem() != null) {
            brandDto.setBlacklistedSem(brandBo.getBlacklistedSem());
        } else {
            brandDto.setBlacklistedSem(false);
        }

        // Blacklist SEO default value is false
        if (brandBo.getBlacklistedSeo() != null) {
            brandDto.setBlacklistedSeo(brandBo.getBlacklistedSeo());
        } else {
            brandDto.setBlacklistedSeo(false);
        }

        // DTO date cannot be empty
        if (brandBo.getActivationDate() != null) {
            brandDto.setActivationDate(new Date(brandBo.getActivationDate().getTime()));
        } else {
            Calendar calendar = Calendar.getInstance();
            brandDto.setActivationDate(new Date(calendar.getTime().getTime()));
        }

        return brandDto;
    }

    public BrandBO adapt(BrandDTO brandDto, Boolean addAliases) {

        if (brandDto == null) {
            return null;
        }

        BrandBO brandBo = mainAdapter(brandDto);
        if (addAliases) {
            brandBo.setBrandAliases(adaptAliases(brandDto, brandBo));
        }

        return brandBo;
    }

    public BrandBO mainAdapter(BrandDTO brandDto) {

        BrandBO brandBo = new BrandBO();
        brandBo.setBrandsId(brandDto.getId());
        brandBo.setTemporaryId(brandDto.getTemporaryId());
        brandBo.setName(brandDto.getName());
        brandBo.setSeoName(brandDto.getSeoName());
        brandBo.setNormalizedName(brandDto.getNormalizedName());
        brandBo.setBlacklistedSem(brandDto.getBlacklistedSem());
        brandBo.setBlacklistedSeo(brandDto.getBlacklistedSeo());
        brandBo.setActivationDate(brandDto.getActivationDate());

        return brandBo;
    }

    public Set<BrandAliasBO> adaptAliases(BrandDTO brandDto, BrandBO brandBo) {

        Set<BrandAliasDTO> tmpAlias = brandDto.getBrandAliases();
        Set<BrandAliasBO> brandAliases = new LinkedHashSet<BrandAliasBO>();

        if (tmpAlias != null) {
            IBrandAliasAdapter brandAliasAdapter = new BrandAliasAdapter();
            for (BrandAliasDTO brandAliasItem : tmpAlias) {
                brandAliases.add(brandAliasAdapter.adapt(brandAliasItem, brandBo));
            }
            brandAliasAdapter = null;
        }

        return brandAliases;
    }

    public Set<BrandAliasDTO> adaptAliases(Set<BrandAliasBO> tmpAlias, BrandDTO brandDto) {

        Set<BrandAliasDTO> brandAliases = new LinkedHashSet<BrandAliasDTO>();

        if (tmpAlias != null) {
            IBrandAliasAdapter brandAliasAdapter = new BrandAliasAdapter();
            for (BrandAliasBO brandAliasItem : tmpAlias) {
                BrandAliasDTO aliasDto = brandAliasAdapter.adapt(brandAliasItem);
                aliasDto.setBrand(brandDto);
                brandAliases.add(aliasDto);
            }
            brandAliasAdapter = null;
        }

        return brandAliases;
    }

    public Map<String, ? extends AbstractDTO> adapt(Set<? extends AbstractDTO> dtoSet) {

        Map<String, AbstractDTO> map = new HashMap<String, AbstractDTO>();

        for (AbstractDTO abstractDTO : dtoSet) {
            if (abstractDTO.getMapKey() == null || map.containsKey(abstractDTO.getMapKey())) {
                throw new BadRequestException();
            }
            map.put(abstractDTO.getMapKey(), abstractDTO);
        }
        return map;
    }
    
}
