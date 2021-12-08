package com.leguide.backoffice.karaf.models.lgbase.account;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "tb_account")
@XmlRootElement(name = "LgbaseAccount")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mappingClientId2", columns = {
                @ColumnResult(name = "clientid")}),
        @SqlResultSetMapping(name = "mappingAccountId", columns = {
                @ColumnResult(name = "accountid")}),
        @SqlResultSetMapping(name = "mappingShopsiteId", columns = {
        		@ColumnResult(name = "store_uid")}),
})
@NamedNativeQueries({
        @NamedNativeQuery(name = LgbaseAccount.FIND_CLIENTID_BY_ACCOUNTID, query = "SELECT lac.clientid FROM lg_account_client lac WHERE lac.accountid = ?", resultClass = String.class, resultSetMapping = "mappingClientId2"),
        @NamedNativeQuery(name = LgbaseAccount.FIND_SHOPSITE_IDS_BY_ACCOUNTID, query = "SELECT tas.store_uid FROM tb_account_store tas WHERE tas.account_uid = ?", resultClass = Long.class, resultSetMapping = "mappingShopsiteId"),
        @NamedNativeQuery(name = LgbaseAccount.FIND_ACCOUNTID_BY_CLIENTID, query = "SELECT lac.accountid FROM lg_account_client lac WHERE lac.clientid = ?", resultClass = Number.class, resultSetMapping = "mappingAccountId"),
        @NamedNativeQuery(name = LgbaseAccount.FIND_ACCOUNT_BY_SHOPSITEID, query = "SELECT acc.id_account, acc.act_name, acc.act_create_date FROM tb_account acc left join tb_account_store acs on acs.account_uid = acc.id_account WHERE acs.store_uid = ?", resultClass = LgbaseAccount.class),
        @NamedNativeQuery(name = LgbaseAccount.FIND_ACCOUNTS_BY_USERID, query = "SELECT acc.id_account, acc.act_name, acc.act_create_date FROM tb_account acc inner join tb_users_account ua ON ua.tb_account_id = acc.id_account WHERE ua.tb_users_id = ?", resultClass = LgbaseAccount.class),
        @NamedNativeQuery(name = LgbaseAccount.FIND_CLIENT_ID_BY_SHOPSITEID, query = "SELECT acc.clientid FROM lg_account_client acc inner join tb_account_store acs on acs.account_uid = acc.accountid WHERE acs.store_uid = ?", resultClass = String.class, resultSetMapping = "mappingClientId2")
})


public class LgbaseAccount implements Serializable {

    private static final long serialVersionUID = 6193228920318963523L;

    public static final String FIND_CLIENTID_BY_ACCOUNTID = "LgbaseAccount.FIND_CLIENTID_BY_ACCOUNTID";
    public static final String FIND_SHOPSITE_IDS_BY_ACCOUNTID = "LgbaseAccount.FIND_SHOPSITE_IDS_BY_ACCOUNTID";
    public static final String FIND_ACCOUNTID_BY_CLIENTID = "LgbaseAccount.FIND_ACCOUNTID_BY_CLIENTID";

    public static final String FIND_ACCOUNT_BY_SHOPSITEID = "LgbaseAccount.FIND_ACCOUNT_BY_SHOPSITEID";
    public static final String FIND_ACCOUNTS_BY_USERID = "LgbaseAccount.FIND_ACCOUNTS_BY_USERID";
    public static final String FIND_CLIENT_ID_BY_SHOPSITEID = "LgbaseAccount.FIND_CLIENT_ID_BY_SHOPSITEID";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Long accountId;

    @Column(name = "act_name")
    private String name;

    @Column(name = "act_create_date")
    private Date createDate;


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LgbaseAccount account = (LgbaseAccount) o;

        if (accountId != null ? !accountId.equals(account.accountId) : account.accountId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return accountId != null ? accountId.hashCode() : 0;
    }
}
