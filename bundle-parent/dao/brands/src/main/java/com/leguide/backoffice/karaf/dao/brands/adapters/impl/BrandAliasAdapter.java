package com.leguide.backoffice.karaf.dao.brands.adapters.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.dao.brands.adapters.IBrandAdapter;
import com.leguide.backoffice.karaf.dao.brands.adapters.IBrandAliasAdapter;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandAliasDTO;


public final class BrandAliasAdapter implements IBrandAliasAdapter {

    public BrandAliasBO adapt(BrandAliasDTO brandAliasDto) {

        BrandAliasBO brandAliasBo = mainAdapter(brandAliasDto);

        if (brandAliasDto.getBrand() != null) {
            IBrandAdapter brandAdapter = new BrandAdapter();
            brandAliasBo.setBrand(brandAdapter.adapt(brandAliasDto.getBrand()));
            brandAdapter = null;
        }

        return brandAliasBo;
    }

    public BrandAliasBO adapt(BrandAliasDTO brandAliasDto, BrandBO brandBo) {

        BrandAliasBO brandAliasBo = mainAdapter(brandAliasDto);
        brandAliasBo.setBrand(brandBo);

        return brandAliasBo;
    }

    public BrandAliasDTO adapt(BrandAliasBO bo) {

        BrandAliasDTO brandAliasDto = new BrandAliasDTO();
        brandAliasDto.setId(bo.getId());
        brandAliasDto.setTemporaryId(bo.getTemporaryId());
        brandAliasDto.setName(bo.getName());
        brandAliasDto.setNameNormalized(bo.getNameNormalized());

        // DTO date cannot be empty
        if (bo.getActivationDate() != null) {
            brandAliasDto.setActivationDate(new Date(bo.getActivationDate().getTime()));
        } else {
            Calendar calendar = Calendar.getInstance();
            brandAliasDto.setActivationDate(new Date(calendar.getTime().getTime()));
        }

        return brandAliasDto;
    }

    public List<BrandAliasBO> adapt(List<BrandAliasDTO> listDto) {

        List<BrandAliasBO> result = new LinkedList<BrandAliasBO>();

        for (BrandAliasDTO brandAliasDto : listDto) {
            result.add(adapt(brandAliasDto));
        }

        return result;
    }

    public BrandAliasBO mainAdapter(BrandAliasDTO brandAliasDto) {

        BrandAliasBO brandAliasBo = new BrandAliasBO();
        brandAliasBo.setId(brandAliasDto.getId());
        brandAliasBo.setTemporaryId(brandAliasDto.getTemporaryId());
        brandAliasBo.setName(brandAliasDto.getName());
        brandAliasBo.setNameNormalized(brandAliasDto.getNameNormalized());
        brandAliasBo.setActivationDate(brandAliasDto.getActivationDate());

        return brandAliasBo;
    }
}
