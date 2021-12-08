package com.leguide.backoffice.karaf.dao.lgbase;

import com.leguide.backoffice.karaf.models.lgbase.users.RefRoles;

public interface RefRolesDao {

    RefRoles findById(Long roleId);

    RefRoles findByRoleCode(String roleCode);
}
