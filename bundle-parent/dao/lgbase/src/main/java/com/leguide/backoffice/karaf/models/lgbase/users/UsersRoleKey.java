package com.leguide.backoffice.karaf.models.lgbase.users;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UsersRoleKey implements Serializable {

    @Column(name = "user_uid", nullable = false)
    private Long userId;

    @Column(name = "role_uid", nullable = false)
    private Long roleUid;

    @Column(name = "entity_uid", nullable = false)
    private Long entityUid;

    public UsersRoleKey() {
    }

    public UsersRoleKey(Long userId, Long roleUid, Long entityUid) {
        this.userId = userId;
        this.roleUid = roleUid;
        this.entityUid = entityUid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(Long roleUid) {
        this.roleUid = roleUid;
    }

    public Long getEntityUid() {
        return entityUid;
    }

    public void setEntityUid(Long entityUid) {
        this.entityUid = entityUid;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((entityUid == null) ? 0 : entityUid.hashCode());
        result = prime * result + ((roleUid == null) ? 0 : roleUid.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsersRoleKey other = (UsersRoleKey) obj;
        if (entityUid == null) {
            if (other.entityUid != null)
                return false;
        } else if (!entityUid.equals(other.entityUid))
            return false;
        if (roleUid == null) {
            if (other.roleUid != null)
                return false;
        } else if (!roleUid.equals(other.roleUid))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }


}
