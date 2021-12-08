package com.leguide.backoffice.karaf.models.lgbase.users;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "tb_users_role")
@XmlRootElement(name = "UsersRole")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mappingRoles", columns = {
                @ColumnResult(name = "role_uid")})
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "UsersRole.FIND_USER_ACCOUNT_BY_ID", query = "SELECT entity_uid FROM tb_users_role WHERE user_uid = ? and entity_uid = ? " +
                "AND role_uid IN (SELECT id_role FROM rf_role WHERE rol_type = 'ACCOUNT')"),
        @NamedNativeQuery(name = "UsersRole.UPDATE_ACCOUNT_BY_USER", query = "UPDATE tb_users_role SET entity_uid = ? WHERE entity_uid = ? AND user_uid = ? " +
                "AND role_uid IN (SELECT id_role FROM rf_role WHERE rol_type = 'ACCOUNT')"),
        @NamedNativeQuery(name = "UsersRole.DELETE_BY_USERID", query = "DELETE FROM tb_users_role WHERE  user_uid = ?"),
        @NamedNativeQuery(name = UsersRole.FIND_BY_USERID_ON_SHOPSITE, query = "SELECT uro.role_uid FROM tb_users_role uro inner join rf_role rf on uro.role_uid = rf.id_role where user_uid = ? and entity_uid = ? and rf.rol_type = 'SITE'", resultClass = BigInteger.class, resultSetMapping = "mappingRoles"),
        @NamedNativeQuery(name = UsersRole.FIND_BY_USERID_ON_ACCOUNT, query = "SELECT uro.role_uid FROM tb_users_role uro inner join rf_role rf on uro.role_uid = rf.id_role where user_uid = ? and entity_uid = ? and rf.rol_type = 'ACCOUNT'", resultClass = BigInteger.class, resultSetMapping = "mappingRoles")
})
@NamedQueries({
        @NamedQuery(name = UsersRole.FIND_BY_USERID, query = "SELECT ur FROM UsersRole ur WHERE ur.usersRoleKey.userId = :userId"),
})
public class UsersRole implements Serializable {

    private static final long serialVersionUID = 2939464785793723356L;

    @EmbeddedId
    private UsersRoleKey usersRoleKey;

    public static final String FIND_USER_ACCOUNT_BY_ID = "UsersRole.FIND_USER_ACCOUNT_BY_ID";
    public static final String UPDATE_ACCOUNT_BY_USER = "UsersRole.UPDATE_ACCOUNT_BY_USER";
    public static final String DELETE_BY_USERID = "UsersRole.DELETE_BY_USERID";
    public static final String FIND_BY_USERID = "UsersRole.FIND_BY_USERID";
    public static final String FIND_BY_USERID_ON_SHOPSITE = "UsersRole.FIND_BY_USERID_ON_SHOPSITE";
    public static final String FIND_BY_USERID_ON_ACCOUNT = "UsersRole.FIND_BY_USERID_ON_ACCOUNT";

    public UsersRole() {
        super();
        this.usersRoleKey = new UsersRoleKey();
    }

    public UsersRoleKey getUsersRoleKey() {
        return usersRoleKey;
    }

    public void setUsersRoleKey(UsersRoleKey usersRoleKey) {
        this.usersRoleKey = usersRoleKey;
    }

    public Long getUserId() {
        return this.usersRoleKey.getUserId();
    }

    public void setUserId(Long userId) {
        this.usersRoleKey.setUserId(userId);
    }

    public Long getRoleUid() {
        return this.usersRoleKey.getRoleUid();
    }

    public void setRoleUid(Long roleUid) {
        this.usersRoleKey.setRoleUid(roleUid);
    }

    public Long getEntityUid() {
        return this.usersRoleKey.getEntityUid();
    }

    public void setEntityUid(Long entityUid) {
        this.usersRoleKey.setEntityUid(entityUid);
    }


}
