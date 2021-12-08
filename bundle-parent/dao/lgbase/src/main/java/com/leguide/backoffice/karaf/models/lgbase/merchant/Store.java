package com.leguide.backoffice.karaf.models.lgbase.merchant;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lg_store")
@NamedNativeQueries({
        @NamedNativeQuery(name = "Store.FIND_STOREID_FROM_IDSHOPSITE", query = "SELECT store_id FROM lg_store WHERE store_uid = ?")
})
public class Store implements Serializable {

    private static final long serialVersionUID = -9060635664978160541L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_uid")
    private Long storeUid;

    @Column(name = "country")
    private String country;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "store_name")
    private String storeName;

    public Long getStoreUid() {
        return storeUid;
    }

    public void setStoreUid(Long storeUid) {
        this.storeUid = storeUid;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
