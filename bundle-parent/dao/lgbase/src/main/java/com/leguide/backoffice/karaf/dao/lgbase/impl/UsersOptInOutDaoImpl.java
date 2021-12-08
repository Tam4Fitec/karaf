package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.UsersOptInOutDao;
import com.leguide.backoffice.karaf.models.lgbase.users.UsersOptInOut;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UsersOptInOutDaoImpl implements UsersOptInOutDao {

    @PersistenceContext
    private EntityManager em;

    public UsersOptInOutDaoImpl() {
        super();
    }

    public UsersOptInOut findById(Long id) {
        return em.find(UsersOptInOut.class, id);
    }

    @Override
    public void create(UsersOptInOut newUsersOptInOut) {
        em.persist(newUsersOptInOut);
    }

    @Override
    public void deleteByUserId(Long id) {
        UsersOptInOut usersOptInOut = findById(id);
        if(usersOptInOut != null) {
            em.remove(usersOptInOut);
        }
    }

    @Override
    public void optOutUserIdFromPartnerList(Long id) {
        UsersOptInOut usersOptInOut = findById(id);
        if (usersOptInOut != null) {
            usersOptInOut.setPartners("N");
            em.flush();
        }
    }

    @Override
    public void optOutUserIdFromLeguideList(Long id) {
        UsersOptInOut usersOptInOut = findById(id);
        if (usersOptInOut != null) {
            usersOptInOut.setLeguide("N");
            em.flush();
        }
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


}
