package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.RefRolesDao;
import com.leguide.backoffice.karaf.models.lgbase.users.RefRoles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class RefRolesDaoImpl implements RefRolesDao {

    @PersistenceContext
    private EntityManager em;

    public RefRolesDaoImpl() {
        super();
    }

    public RefRoles findById(Long roleId) {
        return em.find(RefRoles.class, roleId);
    }

    public RefRoles findByRoleCode(String roleCode) {
        Query query = em.createNamedQuery(RefRoles.FIND_BY_CODE, RefRoles.class);
        query.setParameter("roleCode", roleCode);
        return (RefRoles) query.getSingleResult();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
