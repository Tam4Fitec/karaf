package com.leguide.backoffice.karaf.models.lgbase.account;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "lg_account_client")
@XmlRootElement(name = "LgbaseAccountClient")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mappingClientId", columns = {
                @ColumnResult(name = "clientid")})
})
@NamedNativeQueries({
	@NamedNativeQuery(name=LgbaseAccountClient.FIND_CLIENTID_WITH_MULTIPLE_ACCOUNTID, query="SELECT lgac.clientid FROM lg_account_client lgac  join lg_client lgc on (lgac.clientid = lgc.client_id)"
			+ "join tb_account tba on (lgac.accountid = tba.id_account) where lgac.clientid not in (SELECT distinct bc.client_id FROM billing_contract bc"
			+ " WHERE contract_type LIKE 'AGENCY%') group by lgac.clientid having count(1) > 1 limit 10 ", resultClass = String.class, resultSetMapping = "mappingClientId"),
	@NamedNativeQuery(name=LgbaseAccountClient.FIND_MASTER_ACCOUNT_BY_CLIENT_ID, query="SELECT * FROM lg_account_client lgac WHERE clientid = ? order by accountid limit 1", resultClass = LgbaseAccountClient.class)
})
public class LgbaseAccountClient implements Serializable {

	public static final String FIND_CLIENTID_WITH_MULTIPLE_ACCOUNTID = "LgbaseAccountClient.FIND_CLIENTID_WITH_MULTIPLE_ACCOUNTID";
	public static final String FIND_MASTER_ACCOUNT_BY_CLIENT_ID= "LgbaseAccountClient.FIND_MASTER_ACCOUNT_BY_CLIENT_ID";

    /**
	 *
	 */
	private static final long serialVersionUID = -8649264326180344660L;

	@Id
    @Column(name = "accountid", nullable = false)
    private Long accountId;

    @Column(name = "clientid", nullable = false)
    private String clientId;

    public LgbaseAccountClient() {
        super();
    }

	/**
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LgbaseAccountClient that = (LgbaseAccountClient) o;

        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) return false;
        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId != null ? accountId.hashCode() : 0;
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        return result;
    }
}


