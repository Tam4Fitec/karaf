package com.leguide.backoffice.karaf.models.lgbase.users;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Entity
@Table(name="tb_users_account")
@XmlRootElement(name = "UsersAccount")
@NamedNativeQueries({
	@NamedNativeQuery(name="UsersAccount.DELETE_BY_USERID", query="DELETE FROM tb_users_account WHERE tb_users_id = ?"),
    @NamedNativeQuery(name="UsersAccount.UPDATE_ACCOUNTID", query="UPDATE tb_users_account SET tb_account_id = ? WHERE tb_account_id = ? AND tb_users_id = ?"),
    @NamedNativeQuery(name = UsersAccount.FIND_BY_CLIENTID, query="SELECT tua.tb_users_id, tua.tb_account_id FROM lg_account_client lac "
    		+ "join tb_account tba on (lac.accountid = tba.id_account) join tb_users_account tua on (tba.id_account=tua.tb_account_id) "
    		+ " where lac.clientid = ? order by tua.tb_account_id asc", resultClass = UsersAccount.class)
})
@NamedQueries({
    @NamedQuery(name = UsersAccount.DELETE_BY_PK, query="DELETE FROM UsersAccount ua WHERE ua.usersAccountKey = :uapk"),
    @NamedQuery(name = UsersAccount.FIND_BY_USERID, query="SELECT ua FROM UsersAccount ua WHERE ua.usersAccountKey.usersId = :userId")
})
public class UsersAccount implements Serializable {

	private static final long serialVersionUID = -8430398485258825747L;

	public static final String UPDATE_ACCOUNTID = "UsersAccount.UPDATE_ACCOUNTID";
    public static final String DELETE_BY_USERID = "UsersAccount.DELETE_BY_USERID";

	public static final String DELETE_BY_PK = "UsersAccount.DELETE_BY_PK";
	public static final String FIND_BY_USERID = "UsersAccount.FIND_BY_USERID";
	public static final String FIND_BY_CLIENTID = "UsersAccount.FIND_BY_CLIENTID";

	@EmbeddedId
	private UsersAccountKey usersAccountKey;


	public UsersAccount() {
		super();
		this.usersAccountKey = new UsersAccountKey();
	}

	public UsersAccountKey getUsersAccountKey() {
		return usersAccountKey;
	}

	public void setUsersAccountKey(UsersAccountKey usersAccountKey) {
		this.usersAccountKey = usersAccountKey;
	}

	public Long getUsersId() {
		return this.usersAccountKey.getUsersId();
	}

	public void setUsersId(Long usersId) {
		this.usersAccountKey.setUsersId(usersId);
	}

	public Long getAccountId() {
		return this.usersAccountKey.getAccountId();
	}

	public void setAccountId(Long accountId) {
		this.usersAccountKey.setAccountId(accountId);
	}




}
