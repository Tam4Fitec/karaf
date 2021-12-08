package com.leguide.backoffice.karaf.dao.lgbase.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.leguide.backoffice.karaf.dao.lgbase.UsersDao;
import com.leguide.backoffice.karaf.models.lgbase.users.Users;

@Repository
public class UsersDaoImpl implements UsersDao {

    @PersistenceContext
    private EntityManager em;

    public UsersDaoImpl() {
        super();
    }

    @Override
    public void create(Users user) {
        em.persist(user);
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public Users update(Users user) {
        return em.merge(user);
    }

    @Override
    public Users findById(Long id) {
        return em.find(Users.class, id);
    }

    @Override
    public void deleteById(Long id) {
        Users userToDelete = findById(id);
        if (userToDelete != null) {
            em.remove(userToDelete);
        }
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        TypedQuery<Users> jpaquery = em.createNamedQuery(Users.FIND_BY_USER_EMAIL, Users.class);
        jpaquery.setParameter("email", email);
        return jpaquery.getResultList().stream().findFirst();
    }

    /**
     * Find by email and password, used for authentication
     *
     * @param email    email
     * @param password password
     * @return user, or null
     */
    @Override
    public Optional<Users> findByEmailAndPassword(String email, String password) {
        TypedQuery<Users> query = em.createNamedQuery(Users.FIND_BY_EMAIL_AND_PASSWORD, Users.class);
        query.setParameter(1, email);
        query.setParameter(2, password);
        return query.getResultList().stream().findFirst();
    }

    /**
     * Used in Merchant record form (fiche marchand)
     *
     * @param shopsiteId shopsiteId
     * @return User
     */
    @Override
    public Users findFirstByShopsite(Long shopsiteId) {
        String q = "SELECT tbu.id_user, tbu.usr_email, tbu.usr_password, tbu.usr_civility, tbu.usr_firstname, tbu.usr_lastname, " +
                "tbu.usr_phone_number, tbu.usr_mobile_number, tbu.usr_fax_number, tbu.usr_service_id, tbu.usr_function_id, " +
                "tbu.usr_other_service, tbu.usr_other_function, tbu.usr_status, tbu.usr_create_date, tbu.usr_last_login, " +
                "tbu.usr_add_date, tbu.usr_main_language, tbu.opt_out_token_partner, tbu.opt_out_token_leguide " +
                "FROM tb_account_store tbas " +
                "INNER join tb_users_account tbua ON (tbua.tb_account_id = tbas.account_uid) " +
                "INNER JOIN tb_users tbu ON (tbu.id_user = tbua.tb_users_id) " +
                "INNER JOIN tb_users_role tbur ON (tbur.user_uid = tbu.id_user) " +
                "WHERE tbas.store_uid = ? " +
                "AND tbur.role_uid in (1,2,3,4,5,7) " +
                "LIMIT 1";
        Query query = em.createNativeQuery(q, Users.class);
        query.setParameter(1, shopsiteId);
        return (Users) query.getSingleResult();
    }

    /**
     * Return, for one shopsiteId, the list of user_id :
     * <li> having a role
     * <li> having a valid email
     *
     * @param shopsiteId shopsiteId
     * @return List of user id
     */
    @Override
    public List<Long> findUsersByShopsite(Long shopsiteId) {
        String q = "SELECT distinct tbu.id_user " + 
                "FROM tb_account_store tbas " +
                "INNER join tb_users_account tbua ON (tbua.tb_account_id = tbas.account_uid) " +
                "INNER JOIN tb_users tbu ON (tbu.id_user = tbua.tb_users_id) " +
                "INNER JOIN tb_users_role tbur ON (tbur.user_uid = tbu.id_user) " +
                "WHERE tbas.store_uid = ? " +
                "AND tbu.usr_email  like '%@%.%' ";
        Query query = em.createNativeQuery(q);
        query.setParameter(1, shopsiteId);
        //mappingfor native query returns a BigInteger for the number sql type
        return (List<Long>) query.getResultList().stream().map(id -> Long.valueOf(id.toString())).collect(Collectors.toList());
    }

    /**
     * Find all contacts for shopsite and roles
     *
     * @param shopsiteId shopsiteId
     * @param roles      roles
     * @return all contacts
     */
    @Override
    @SuppressWarnings(value = "unchecked")
    public List<Users> findAllByShopsiteAndRoles(Long shopsiteId, List<Integer> roles) {
        String q = "SELECT tbu.id_user, tbu.usr_email, tbu.usr_password, tbu.usr_civility, tbu.usr_firstname, tbu.usr_lastname, " +
                "tbu.usr_phone_number, tbu.usr_mobile_number, tbu.usr_fax_number, tbu.usr_service_id, tbu.usr_function_id, " +
                "tbu.usr_other_service, tbu.usr_other_function, tbu.usr_status, tbu.usr_create_date, tbu.usr_last_login, " +
                "tbu.usr_add_date, tbu.usr_main_language, tbu.opt_out_token_partner, tbu.opt_out_token_leguide " +
                "FROM tb_account_store tbas " +
                "INNER join tb_users_account tbua ON (tbua.tb_account_id = tbas.account_uid) " +
                "INNER JOIN tb_users tbu ON (tbu.id_user = tbua.tb_users_id) " +
                "INNER JOIN tb_users_role tbur ON (tbur.user_uid = tbu.id_user) " +
                "WHERE tbas.store_uid = ? " +
                "AND tbur.role_uid in (?) " +
                "AND tbu.usr_email LIKE '%@%' ";
        Query query = em.createNativeQuery(q, Users.class);
        query.setParameter(1, shopsiteId);
        query.setParameter(2, StringUtils.join(roles, ","));
        return (List<Users>) query.getResultList();
    }

}
