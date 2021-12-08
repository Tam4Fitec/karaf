package com.leguide.backoffice.karaf.bundle.dao.facade;

import com.leguide.backoffice.karaf.business.exception.EntityNotExistException;
import com.leguide.backoffice.karaf.business.models.pojo.Role;

public interface RoleDao {

    void create(Role role) throws EntityNotExistException;

    void update(Role role);

    void delete(Role role);

}
