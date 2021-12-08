package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.UsersRoleDao;
import com.leguide.backoffice.karaf.models.lgbase.users.UsersRole;
import com.leguide.backoffice.karaf.models.lgbase.users.UsersRoleKey;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsersRoleDaoImpl implements UsersRoleDao {

    @PersistenceContext
    private EntityManager em;

    public UsersRoleDaoImpl() {
        super();
    }

    public UsersRole findById(UsersRoleKey id) {
        return em.find(UsersRole.class, id);
    }

    public boolean existCoupleUserAccount(Long userId, Long accountId) {
        Query query = em.createNamedQuery(UsersRole.FIND_USER_ACCOUNT_BY_ID);
        query.setParameter(1, userId);
        query.setParameter(2, accountId);
        return !query.getResultList().isEmpty();
    }

    @Override
    public void create(UsersRole newUsersRole) {
        em.persist(newUsersRole);
    }

    @Override
    public void updateAccountId(Long newAccountId, Long oldAccountId, Long userId) {
        Query query = em.createNamedQuery(UsersRole.UPDATE_ACCOUNT_BY_USER);
        query.setParameter(1, newAccountId);
        query.setParameter(2, oldAccountId);
        query.setParameter(3, userId);
        query.executeUpdate();
    }

    @Override
    public void delete(UsersRole userRole) {
        em.remove(userRole);
    }

    @Override
    public void deleteByUserId(Long id) {
        Query query = em.createNamedQuery(UsersRole.DELETE_BY_USERID);
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void deleteByPK(Long userId, Long roleId, Long entityId) {
        UsersRoleKey key = new UsersRoleKey();
        key.setEntityUid(entityId);
        key.setRoleUid(roleId);
        key.setUserId(userId);
        UsersRole ur = em.find(UsersRole.class, key);
        em.remove(ur);
    }

    public boolean isUserLinkedToSeveralRoles(Long userId) {
        TypedQuery<UsersRole> jpaquery = em.createNamedQuery(UsersRole.FIND_BY_USERID, UsersRole.class);
        jpaquery.setParameter("userId", userId);
        return jpaquery.getResultList().size() > 1;
    }

    @Override
    public List<Long> getRolesOfUserForShopsite(Long userId, Long shopsiteId) {
        TypedQuery<BigInteger> query = em.createNamedQuery(UsersRole.FIND_BY_USERID_ON_SHOPSITE, BigInteger.class);
        query.setParameter(1, userId);
        query.setParameter(2, shopsiteId);
        return query.getResultList().stream().filter(bi->bi != null).map(bi -> bi.longValue()).collect(Collectors.toList());
    }
    @Override
    public List<Long> getRolesOfUserForAccount(Long userId, Long accountId) {
        TypedQuery<BigInteger> query = em.createNamedQuery(UsersRole.FIND_BY_USERID_ON_ACCOUNT, BigInteger.class);
        query.setParameter(1, userId);
        query.setParameter(2, accountId);
        return query.getResultList().stream().filter(bi->bi != null).map(bi -> bi.longValue()).collect(Collectors.toList());
    }
}
