package com.leguide.backoffice.karaf.dao.lgbase;

import com.leguide.backoffice.karaf.models.lgbase.users.UsersOptInOut;

public interface UsersOptInOutDao {

    /**
     * Find by id
     *
     * @param id id
     * @return usersOptInout
     */
    UsersOptInOut findById(Long id);

    /**
     * Create a new usersOptInOut
     *
     * @param newUsersOptInOut
     */
    void create(UsersOptInOut newUsersOptInOut);


    /**
     * @param id
     * @return
     */
    void deleteByUserId(Long id);

    void optOutUserIdFromPartnerList(Long id);

    void optOutUserIdFromLeguideList(Long id);

}
