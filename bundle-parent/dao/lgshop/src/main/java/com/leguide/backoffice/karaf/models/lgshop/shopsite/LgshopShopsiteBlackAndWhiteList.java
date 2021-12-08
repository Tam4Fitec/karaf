package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "tb_shopsite_blacklist_whitelist")
@XmlRootElement(name = "LgshopShopsiteBlackAndWhiteList")
@NamedQueries({
        @NamedQuery(name = LgshopShopsiteBlackAndWhiteList.FIND_BLACKLIST_BY_SHOPSITE,
                query = "select sbwl FROM LgshopShopsiteBlackAndWhiteList sbwl "
                        + "WHERE sbwl.key.shopsiteId = :shopsiteId AND sbwl.state = 'BLACKLISTED'"),
        @NamedQuery(name = LgshopShopsiteBlackAndWhiteList.FIND_ALL_BY_SHOPSITE,
                query = "select sbwl FROM LgshopShopsiteBlackAndWhiteList sbwl "
                        + "WHERE sbwl.key.shopsiteId = :shopsiteId"),
        @NamedQuery(name = LgshopShopsiteBlackAndWhiteList.FIND_WHITELIST_BY_SHOPSITE,
                query = "select sbwl FROM LgshopShopsiteBlackAndWhiteList sbwl "
                        + "WHERE sbwl.key.shopsiteId = :shopsiteId AND sbwl.state = 'WHITELISTED'"),
        @NamedQuery(name = LgshopShopsiteBlackAndWhiteList.FIND_FOR_SHOPSITE_AND_KSITE,
                query = "select sbwl FROM LgshopShopsiteBlackAndWhiteList sbwl "
                        + "WHERE sbwl.key.shopsiteId = :shopsiteId AND sbwl.key.refKsiteId = :refKsiteId")})

public class LgshopShopsiteBlackAndWhiteList implements Serializable {

    private static final long serialVersionUID = 2993964242817118787L;

    public static final String FIND_BLACKLIST_BY_SHOPSITE = "LgshopShopsiteBlackAndWhiteList.FIND_BLACKLIST_BY_SHOPSITE";
    public static final String FIND_ALL_BY_SHOPSITE = "LgshopShopsiteBlackAndWhiteList.FIND_ALL_BY_SHOPSITE";
    public static final String FIND_WHITELIST_BY_SHOPSITE = "LgshopShopsiteBlackAndWhiteList.FIND_WHITELIST_BY_SHOPSITE";
    public static final String FIND_FOR_SHOPSITE_AND_KSITE = "LgshopShopsiteBlackAndWhiteList.FIND_FOR_SHOPSITE_AND_KSITE";

    public enum STATES {BLACKLISTED, WHITELISTED}

    @EmbeddedId
    private LgshopShopsiteBlackAndWhiteListKey key;

    @Column(name = "blacklist_whitelist_state")
    @Enumerated(EnumType.STRING)
    private STATES state;

    public LgshopShopsiteBlackAndWhiteList() {
    }

    public LgshopShopsiteBlackAndWhiteList(LgshopShopsiteBlackAndWhiteListKey key) {
        this.key = key;
    }

    public LgshopShopsiteBlackAndWhiteListKey getKey() {
        return key;
    }

    public void setKey(LgshopShopsiteBlackAndWhiteListKey key) {
        this.key = key;
    }

    public STATES getState() {
        return state;
    }

    public void setState(STATES state) {
        this.state = state;
    }

}
