package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "tb_shopsite_url")
@XmlRootElement(name = "LgshopShopsiteUrl")
public class LgshopShopsiteUrl implements Serializable {

    private static final long serialVersionUID = 8292587134318117028L;

    @Id
    @Column(name = "id_shopsite")
    private Long shopsiteId;

    @Column(name = "shu_displayed_url")
    private String shopUrlDisplay;

    @Column(name = "shu_tracked_url")
    private String shopUrlTracked;

    @Column(name = "shu_logo_url")
    private String shopUrlLogo;

    @Column(name = "shu_gtsd")
    private String shopGtsd;

    @Column(name = "shu_privacy_notice")
    private String shopPrivacyNotice;

    @Column(name = "shu_logo_status")
    private String shopUrlLogoStatus;

    public Long getShopsiteId() {
        return shopsiteId;
    }


    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }


    public String getShopUrlDisplay() {
        return shopUrlDisplay;
    }


    public void setShopUrlDisplay(String shopUrlDisplay) {
        this.shopUrlDisplay = shopUrlDisplay;
    }


    public String getShopUrlTracked() {
        return shopUrlTracked;
    }


    public void setShopUrlTracked(String shopUrlTracked) {
        this.shopUrlTracked = shopUrlTracked;
    }


    public String getShopUrlLogo() {
        return shopUrlLogo;
    }


    public void setShopUrlLogo(String shopUrlLogo) {
        this.shopUrlLogo = shopUrlLogo;
    }


    public String getShopGtsd() {
        return shopGtsd;
    }


    public void setShopGtsd(String shopGtsd) {
        this.shopGtsd = shopGtsd;
    }


    public String getShopPrivacyNotice() {
        return shopPrivacyNotice;
    }


    public void setShopPrivacyNotice(String shopPrivacyNotice) {
        this.shopPrivacyNotice = shopPrivacyNotice;
    }

    public String getShopUrlLogoStatus() {
        return shopUrlLogoStatus;
    }

    public void setShopUrlLogoStatus(String shopUrlLogoStatus) {
        this.shopUrlLogoStatus = shopUrlLogoStatus;
    }
}
