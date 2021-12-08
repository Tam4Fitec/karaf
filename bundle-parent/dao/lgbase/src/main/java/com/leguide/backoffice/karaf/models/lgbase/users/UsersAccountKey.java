package com.leguide.backoffice.karaf.models.lgbase.users;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UsersAccountKey implements Serializable {

    @Column(name = "tb_users_id")
    private Long usersId;

    @Column(name = "tb_account_id")
    private Long accountId;

    public UsersAccountKey() {
    }

    public UsersAccountKey(Long usersId, Long accountId) {
        this.usersId = usersId;
        this.accountId = accountId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((accountId == null) ? 0 : accountId.hashCode());
        result = prime * result + ((usersId == null) ? 0 : usersId.hashCode());
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
        UsersAccountKey other = (UsersAccountKey) obj;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;
        if (usersId == null) {
            if (other.usersId != null)
                return false;
        } else if (!usersId.equals(other.usersId))
            return false;
        return true;
    }


}
