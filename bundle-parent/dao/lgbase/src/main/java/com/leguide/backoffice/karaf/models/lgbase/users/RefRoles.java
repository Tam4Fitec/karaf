package com.leguide.backoffice.karaf.models.lgbase.users;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rf_role")
@NamedQuery(name = RefRoles.FIND_BY_CODE, query = "SELECT rr FROM RefRoles rr WHERE rr.roleCode = :roleCode")
public class RefRoles implements Serializable {

    private static final long serialVersionUID = -1950756825765068960L;

    public static final String FIND_BY_CODE = "RefRoles.FIND_BY_CODE";

    @Id
    @Column(name = "id_role", nullable = false)
    private Long roleId;

    @Column(name = "rol_code", nullable = false)
    private String roleCode;

    @Column(name = "rol_type", nullable = false)
    private String roleType;

    @Column(name = "rol_comment")
    private String roleComment;

    @Column(name = "rol_enabled", nullable = false)
    private String roleEnabled;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleComment() {
        return roleComment;
    }

    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment;
    }

    public String getRoleEnabled() {
        return roleEnabled;
    }

    public void setRoleEnabled(String roleEnabled) {
        this.roleEnabled = roleEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefRoles refRoles = (RefRoles) o;

        if (roleCode != null ? !roleCode.equals(refRoles.roleCode) : refRoles.roleCode != null) return false;
        if (roleComment != null ? !roleComment.equals(refRoles.roleComment) : refRoles.roleComment != null)
            return false;
        if (roleEnabled != null ? !roleEnabled.equals(refRoles.roleEnabled) : refRoles.roleEnabled != null)
            return false;
        if (roleId != null ? !roleId.equals(refRoles.roleId) : refRoles.roleId != null) return false;
        if (roleType != null ? !roleType.equals(refRoles.roleType) : refRoles.roleType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        result = 31 * result + (roleType != null ? roleType.hashCode() : 0);
        result = 31 * result + (roleComment != null ? roleComment.hashCode() : 0);
        result = 31 * result + (roleEnabled != null ? roleEnabled.hashCode() : 0);
        return result;
    }
}
