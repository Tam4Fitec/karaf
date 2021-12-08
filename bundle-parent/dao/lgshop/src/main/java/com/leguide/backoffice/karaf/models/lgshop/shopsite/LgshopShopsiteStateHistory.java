package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="tb_shopsite_state_history")
@XmlRootElement(name = "LgshopShopsiteStateHistory")
@NamedQueries({
        @NamedQuery(name = LgshopShopsiteStateHistory.FIND_HISTORY_OF_SHOPSITE,
                query = "SELECT s FROM LgshopShopsiteStateHistory s WHERE s.shopsiteId = :shopsiteId " +
                        "ORDER BY s.date desc")
})
public class LgshopShopsiteStateHistory implements Serializable {

	private static final long serialVersionUID = 7875406253324217882L;

    public static final String FIND_HISTORY_OF_SHOPSITE = "LgshopShopsiteStateHistory.FIND_HISTORY_OF_SHOPSITE";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="shi_date")
	private Date date;

	@Column(name="id_shopsite")
	private Long shopsiteId;

	@Column(name="shi_shop_state")
	private Integer shopState;

	@Column(name="shi_patner_enable")
	private String shopPatner;

	@Column(name="shi_logo_enable")
	private String shopLogo;

	@Column(name="shi_logo_engine_enable")
	private String shopLogoEngine;

	@Column(name="shi_product_image_enable")
	private String shopProductImage;

	@Column(name="shi_dooyoo_enable")
	private String shopDooyoo;

	@Column(name="shi_strategic_enable")
	private String shopStrategic;

	@Column(name="shi_adult_content")
	private String shopAdultContent;

	@Column(name="shi_id_ref_state")
	private Long idRefState;

	@Column(name="shi_reason")
	@Enumerated(EnumType.STRING)
	private LgshopShopsiteStateReasonEnum reason;

	@Column(name="shi_ksite_flags")
	private Long kSite;
	
	@Column(name="shi_segmentation")
	@Enumerated(EnumType.STRING)
	private LgshopShopsiteSegmentationEnum shopSegmentation;

	@Column(name="shi_zeus_notation")
	private Long zeusNotation;
	
	@Column(name="shi_user")
	private String user;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getShopsiteId() {
		return shopsiteId;
	}

	public void setShopsiteId(Long shopsiteId) {
		this.shopsiteId = shopsiteId;
	}

	public Integer getShopState() {
		return shopState;
	}

	public void setShopState(Integer shopState) {
		this.shopState = shopState;
	}

	public String getShopPatner() {
		return shopPatner;
	}

	public void setShopPartner(String shopPatner) {
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

	public String getShopAdultContent() {
		return shopAdultContent;
	}
	
	public void setShopAdultContent(String shopAdultContent) {
		this.shopAdultContent = shopAdultContent;
	}
	
	public Long getIdRefState() {
		return idRefState;
	}

	public void setIdRefState(Long idRefState) {
		this.idRefState = idRefState;
	}

	public LgshopShopsiteStateReasonEnum getReason() {
		return reason;
	}

	public void setReason(LgshopShopsiteStateReasonEnum reason) {
		this.reason = reason;
	}

	public Long getkSite() {
		return kSite;
	}
	
	public void setkSite(Long kSite) {
		this.kSite = kSite;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public LgshopShopsiteSegmentationEnum getShopSegmentation() {
		return shopSegmentation;
	}
	
	public void setShopSegmentation(LgshopShopsiteSegmentationEnum shopSegmentation) {
		this.shopSegmentation = shopSegmentation;
	}
	
	public Long getZeusNotation() {
		return zeusNotation;
	}
	
	public void setZeusNotation(Long zeusNotation) {
		this.zeusNotation = zeusNotation;
	}
	
	public String getUser() {
		return user;
	}
}

