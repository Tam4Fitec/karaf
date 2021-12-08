package com.leguide.backoffice.karaf.dao.brands.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllAliasesFilters;
import com.leguide.backoffice.karaf.dao.brands.IAliasDAO;
import com.leguide.backoffice.karaf.dao.brands.adapters.IAdapter;
import com.leguide.backoffice.karaf.dao.brands.adapters.IBrandAliasAdapter;
import com.leguide.backoffice.karaf.dao.brands.adapters.impl.BrandAliasAdapter;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandAliasDTO;

public final class AliasDAOImpl extends AbstractDAO<BrandAliasBO, BrandAliasDTO> implements IAliasDAO {

    private IBrandAliasAdapter adapter = new BrandAliasAdapter();
    
    private EntityManager em;

    @Override
    public List<BrandAliasBO> getAllAliases(GetAllAliasesFilters filters) {

        TypedQuery<BrandAliasDTO> jpaQuery = this.em.createNamedQuery(BrandAliasDTO.FIND_ALL, BrandAliasDTO.class);

        if (filters.getLimit() != null) {
            jpaQuery.setMaxResults(filters.getLimit());
            if (filters.getPage() != null) {
                jpaQuery.setFirstResult((filters.getPage() - 1) * filters.getLimit());
            }
        }

        return this.adapter.adapt(jpaQuery.getResultList());
    }

//    @Override
//    public IAdapter<BrandAliasBO, BrandAliasDTO> getAdapter() {
//        return this.adapter;
//    }
    
    @Override
    public IBrandAliasAdapter getAdapter() {
        return this.adapter;
    }


    @Override
    public Integer countAliases() {
        TypedQuery<Long> jpaQuery = this.em.createNamedQuery(BrandAliasDTO.COUNT_ALL, Long.class);
        return Integer.valueOf(jpaQuery.getSingleResult().intValue());
    }

    public void setAdapter(IBrandAliasAdapter adapter) {
        this.adapter = adapter;
    }
    

    public EntityManager getEm() {
        return this.em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
