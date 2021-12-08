package com.leguide.backoffice.karaf.models.lgbase.account;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "tb_account_store")
@XmlRootElement(name = "LgbaseAccountStore")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mappingStoreUid", columns = {
                @ColumnResult(name = "store_uid")})
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "LgbaseAccountStore.GET_LIST_BY_ACCOUNTID", query = "SELECT tas.store_uid FROM tb_account_store tas WHERE tas.account_uid = ?",
                resultClass = Long.class, resultSetMapping = "mappingStoreUid"),
        @NamedNativeQuery(name = "LgbaseAccountStore.GET_LIST_BY_IDCLIENT", query = "SELECT tas.store_uid, tas.account_uid FROM lg_account_client lac "
        		+ " join tb_account tba on (lac.accountid = tba.id_account) join tb_account_store tas on (tba.id_account=tas.account_uid) "
        		+ " where lac.clientid = ? order by tas.account_uid asc ", resultClass = LgbaseAccountStore.class),
})
@NamedQueries({
        @NamedQuery(name = LgbaseAccountStore.GET_LIST_BY_IDSHOPSITE, query = "SELECT distinct tas FROM LgbaseAccountStore tas WHERE" +
                " tas.storeUid = :idshopsite")
})
public class LgbaseAccountStore implements Serializable {

    private static final long serialVersionUID = 6955099375931819152L;

    public static final String GET_LIST_BY_ACCOUNTID = "LgbaseAccountStore.GET_LIST_BY_ACCOUNTID";
    public static final String GET_LIST_BY_IDSHOPSITE = "LgbaseAccountStore.GET_LIST_BY_IDSHOPSITE";
    public static final String GET_LIST_BY_IDCLIENT = "LgbaseAccountStore.GET_LIST_BY_IDCLIENT";

    @Id
    @Column(name = "store_uid", nullable = false)
    private Long storeUid;

    @Column(name = "account_uid", nullable = false)
    private Long accountUid;

    public LgbaseAccountStore() {
        super();
    }

    public Long getAccountUid() {
        return accountUid;
    }

    public void setAccountUid(Long accountUid) {
        this.accountUid = accountUid;
    }

    public Long getStoreUid() {
        return storeUid;
    }

    public void setStoreUid(Long storeUid) {
        this.storeUid = storeUid;
    }
}


