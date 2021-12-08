package com.leguide.backoffice.karaf.webservices.wsbrands.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllAliasesFilters;
import com.leguide.backoffice.karaf.dao.brands.IAliasDAO;
import com.leguide.backoffice.karaf.webservices.wsbrands.business.IAliasService;

@Service("aliasesService")
@Transactional
public final class AliasesServiceImpl implements IAliasService {

    @Autowired
    private IAliasDAO aliasDAO;

    @Override
    public List<BrandAliasBO> getAllAliases(GetAllAliasesFilters filters) {
        return this.aliasDAO.getAllAliases(filters);
    }

    @Override
    public Integer countAliases() {
        return this.aliasDAO.countAliases();
    }

    public IAliasDAO getAliasDAO() {
        return this.aliasDAO;
    }

    public void setAliasDAO(IAliasDAO aliasDAO) {
        this.aliasDAO = aliasDAO;
    }
}
