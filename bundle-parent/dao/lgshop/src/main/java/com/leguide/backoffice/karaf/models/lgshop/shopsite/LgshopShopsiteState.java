package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
@Entity
@Table(name="tb_shopsite_state")
@XmlRootElement(name = "LgshopShopsiteState")
public class LgshopShopsiteState implements Serializable {
	private static final long serialVersionUID = 8725224909717381413L;

	@Id
	@Column(name="id_shopsite")
	private Long shopsiteId;

	@Column(name="sps_sort")
	private Integer sort;
	
	@Column(name="sps_price")
	private Integer price;

	@Column(name="sps_shop_state")
	private Integer shopState;

	@Column(name="sps_type_clic")
	private String clicType;

	@Column(name="sps_patner_enable")
	private String shopPatner;

	@Column(name="sps_logo_enable")
	private String shopLogo;

	@Column(name="sps_logo_engine_enable")
	private String shopLogoEngine;

	@Column(name="sps_product_image_enable")
	private String shopProductImage;

	@Column(name="sps_sp_plus")
	private String shopSpPlus;

	@Column(name="sps_adult_content")
	private String shopAdultContent;

	@Column(name="sps_dooyoo_enable")
	private String shopDooyoo;

	@Column(name="sps_strategic_enable")
	private String shopStrategic;

	@Column(name="sps_internal_enable")
	private String shopInternal;

	@Column(name="sps_segmentation")
	@Enumerated(EnumType.STRING)
	private LgshopShopsiteSegmentationEnum shopSegmentation;

	@Column(name="sps_id_ref_state")
	private Long idRefState;

	@Column(name="zeus_notation")
	private Long zeusNotation;
	
	@Column(name="sps_reason")
	@Enumerated(EnumType.STRING)
	private LgshopShopsiteStateReasonEnum reason;

    @Column(name="ksite_flags")
    private Long kSiteflags;

	public Long getShopsiteId() {
		return shopsiteId;
	}

	public void setShopsiteId(Long shopsiteId) {
		this.shopsiteId = shopsiteId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getShopState() {
		return shopState;
	}

	public void setShopState(Integer shopState) {
		this.shopState = shopState;
	}

	public String getClicType() {
		return clicType;
	}

	public Long getIdRefState() {
		return idRefState;
	}
	
	public LgshopShopsiteStateReasonEnum getReason() {
		return reason;
	}
	
	public void setClicType(String clicType) {
		this.clicType = clicType;
	}

	public String getShopPartner() {
		return shopPatner;
	}

	public void setShopPatner(String shopPatner) {
		this.shopPatner = shopPatner;
	}

	public String getShopLogo() {
		return shopLogo;
	}

	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	public String getShopLogoEngine() {
		return shopLogoEngine;
	}

	public void setShopLogoEngine(String shopLogoEngine) {
		this.shopLogoEngine = shopLogoEngine;
	}

	public String getShopProductImage() {
		return shopProductImage;
	}

	public void setShopProductImage(String shopProductImage) {
		this.shopProductImage = shopProductImage;
	}

	public String getShopSpPlus() {
		return shopSpPlus;
	}

	public void setShopSpPlus(String shopSpPlus) {
		this.shopSpPlus = shopSpPlus;
	}

	public String getShopAdultContent() {
		return shopAdultContent;
	}

	public void setShopAdultContent(String shopAdultContent) {
		this.shopAdultContent = shopAdultContent;
	}

	public String getShopDooyoo() {
		return shopDooyoo;
	}

	public void setShopDooyoo(String shopDooyoo) {
		this.shopDooyoo = shopDooyoo;
	}

	public String getShopStrategic() {
		return shopStrategic;
	}

	public void setShopStrategic(String shopStrategic) {
		this.shopStrategic = shopStrategic;
	}

	public String getShopInternal() {
		return shopInternal;
	}

	public void setShopInternal(String shopInternal) {
		this.shopInternal = shopInternal;
	}

	public LgshopShopsiteSegmentationEnum getShopSegmentation() {
		return shopSegmentation;
	}

	public void setShopSegmentation(LgshopShopsiteSegmentationEnum shopSegmentation) {
		this.shopSegmentation = shopSegmentation;
	}
	
	public void setIdRefState(Long idRefState) {
		this.idRefState = idRefState;
	}
	
	public void setReason(LgshopShopsiteStateReasonEnum reason) {
		this.reason = reason;
	}

    public Long getkSiteflags() {
        return kSiteflags;
    }

    public void setkSiteflags(Long kSiteflags) {
        this.kSiteflags = kSiteflags;
    }

    public Long getZeusNotation() {
        return zeusNotation;
    }

    public void setZeusNotation(Long zeusNotation) {
        this.zeusNotation = zeusNotation;
    }
}
