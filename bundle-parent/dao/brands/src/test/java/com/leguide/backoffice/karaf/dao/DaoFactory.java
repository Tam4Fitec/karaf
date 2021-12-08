package com.leguide.backoffice.karaf.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.dao.brands.IAliasDAO;
import com.leguide.backoffice.karaf.dao.brands.IBrandsDAO;
import com.leguide.backoffice.karaf.dao.brands.impl.AliasDAOImpl;
import com.leguide.backoffice.karaf.dao.brands.impl.BrandsDAOImpl;

@Component
public class DaoFactory {

    @PersistenceContext
    private EntityManager em;

    public IAliasDAO getIAliasDAO() {
        AliasDAOImpl dao = new AliasDAOImpl();
        dao.setEm(em);
        return dao;
    }
    
    public IBrandsDAO getIBrandsDAO() {
        BrandsDAOImpl dao = new BrandsDAOImpl();
        dao.setEm(em);
        return dao;
    }
    

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
