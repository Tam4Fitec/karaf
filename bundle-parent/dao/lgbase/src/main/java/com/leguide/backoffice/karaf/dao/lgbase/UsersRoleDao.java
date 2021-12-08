package com.leguide.backoffice.karaf.dao.lgbase;

import com.leguide.backoffice.karaf.models.lgbase.users.UsersRole;
import com.leguide.backoffice.karaf.models.lgbase.users.UsersRoleKey;

import java.util.List;

public interface UsersRoleDao {

    /**
     * Finds by id
     * @param id Id
     * @return user role
     */
    UsersRole findById(UsersRoleKey id);

    /**
     * Exists couple user / account ?
     * @param userId
     * @param accountId
     * @return
     */
    boolean existCoupleUserAccount(Long userId, Long accountId);

    /**
     * Create a new usersRole
     *
     * @param newUsersRole
     */
    void create(UsersRole newUsersRole);

    void updateAccountId(Long newAccountId, Long oldAccountId, Long userId);

    /**
     * Deletes a user role
     * @param userRole
     */
    void delete(UsersRole userRole);

    /**
     * @param id userId
     * @return
     */
    void deleteByUserId(Long id);

    /**
     * Delete the association by (userid, role, entity)
     *
     * @param userId   not null
     * @param roleId   not null
     * @param entityId not null
     */
    void deleteByPK(Long userId, Long roleId, Long entityId);

    boolean isUserLinkedToSeveralRoles(Long userId);

    /**
     * Get all users roles of userId for given shopsiteId
     *
     * @param userId
     * @param shopsiteId
     * @return all roles
     */
    List<Long> getRolesOfUserForShopsite(Long userId, Long shopsiteId);

    /**
     * Get all users roles of userId for given accountId
     *
     * @param userId
     * @param accountId
     * @return all roles
     */
    List<Long> getRolesOfUserForAccount(Long userId, Long accountId);
}
