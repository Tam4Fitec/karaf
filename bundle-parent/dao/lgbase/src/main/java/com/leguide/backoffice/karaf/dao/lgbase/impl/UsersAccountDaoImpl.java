package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.UsersAccountDao;
import com.leguide.backoffice.karaf.models.lgbase.users.UsersAccount;
import com.leguide.backoffice.karaf.models.lgbase.users.UsersAccountKey;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UsersAccountDaoImpl implements UsersAccountDao {

    @PersistenceContext
    private EntityManager em;

    public UsersAccountDaoImpl() {
        super();
    }

    /**
     * Finds by id
     *
     * @param accountId
     * @param userId
     * @return
     */
    public UsersAccount findById(Long accountId, Long userId) {
        return em.find(UsersAccount.class, new UsersAccountKey(userId, accountId));
    }

    @Override
    public void create(UsersAccount newUsersAccount) {
        em.persist(newUsersAccount);
    }


    /**
     * Updates accountId
     *
     * @param newAccountId
     * @param oldAccountId
     * @param userId
     */
    @Override
    public void updateAccountId(Long newAccountId, Long oldAccountId, Long userId) {
        Query query = em.createNamedQuery(UsersAccount.UPDATE_ACCOUNTID);
        query.setParameter(1, newAccountId);
        query.setParameter(2, oldAccountId);
        query.setParameter(3, userId);
        query.executeUpdate();
    }

    /**
     * @see com.leguide.backoffice.karaf.dao.lgbase.UsersAccountDao#deleteByUserId(java.lang.Long)
     */
    @Override
    public void deleteByUserId(Long id) {
        Query query = em.createNamedQuery(UsersAccount.DELETE_BY_USERID);
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public void deleteByPk(Long userId, Long accountId) {
        UsersAccountKey key = new UsersAccountKey();
        key.setAccountId(accountId);
        key.setUsersId(userId);
        /*Query jpaquery = em.createNamedQuery(UsersAccount.DELETE_BY_PK);
        jpaquery.setParameter("uapk", key);
        jpaquery.executeUpdate();*/
        //
        UsersAccount ua = em.find(UsersAccount.class, key);
        em.remove(ua);
    }

    public boolean isUserLinkedToSeveralAccounts(Long userId) {
        TypedQuery<UsersAccount> jpaquery = em.createNamedQuery(UsersAccount.FIND_BY_USERID, UsersAccount.class);
        jpaquery.setParameter("userId", userId);
        return jpaquery.getResultList().size() > 1;
    }
    
    @Override
    public List<UsersAccount> getAccountsOfUser(Long userId) {
    	TypedQuery<UsersAccount> jpaquery = em.createNamedQuery(UsersAccount.FIND_BY_USERID, UsersAccount.class);
    	jpaquery.setParameter("userId", userId);
    	return jpaquery.getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<UsersAccount> findByClientId(String clientId) {

        TypedQuery<UsersAccount> jpaQuery = em.createNamedQuery(UsersAccount.FIND_BY_CLIENTID, UsersAccount.class);
        jpaQuery.setParameter(1, clientId);
        List<UsersAccount> resList = jpaQuery.getResultList();
        return resList;
    }

}
