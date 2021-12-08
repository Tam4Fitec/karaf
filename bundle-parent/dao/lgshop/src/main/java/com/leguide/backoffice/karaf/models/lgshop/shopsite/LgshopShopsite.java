package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="tb_shopsite")
@XmlRootElement(name = "LgshopShopsite")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mappingIdShopsite", columns = {
                @ColumnResult(name = "id_shopsite")})
})
@NamedNativeQueries({
	@NamedNativeQuery(name = LgshopShopsite.GET_LIST_ID_BY_LANGUAGE_AND_ID_REFSTATE, query = "SELECT distinct ts.id_shopsite "
			+ " FROM lgshop.tb_shopsite ts inner join lgshop.tb_shopsite_state tss ON ts.id_shopsite = tss.id_shopsite"
			+ " where tss.sps_id_ref_state = ? and ts.shs_main_language = ? ", resultClass = Long.class, resultSetMapping = "mappingIdShopsite")
})
public class LgshopShopsite implements Serializable{

	private static final long serialVersionUID = 4191894670119043270L;

    public static final String GET_LIST_ID_BY_LANGUAGE_AND_ID_REFSTATE = "LgshopShopsite.GET_LIST_ID_BY_LANGUAGE_AND_ID_REFSTATE";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_shopsite")
	private Long shopsiteId;

	@Column(name="shs_name")
	private String name;

	@Column(name="shs_active")
	private String active;

	@Column(name="id_country")
	private Integer countryId;

	@Column(name="shs_main_language")
	private Integer mainlanguage;

	@Column(name="shs_create_date" )
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name="shs_shop_state")
	@Enumerated(EnumType.STRING)
	private LgshopShopStateEnum shopState;

	@Column(name="shs_on_line_publishing_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishingDate;

	@Column(name="shs_last_update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	@Column(name="shs_display_leguide")
	private String displayLeguide;

	@Column(name="source")
	private String source;

	@Column(name="id_lead")
	private String leadId;


	//@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE}, mappedBy = "shopsite")
	@Transient
	private List<LgshopShopsiteBlackAndWhiteList> blackAndWhite;


	/*
	 * List of Getters and Setters
	 */

	public List<LgshopShopsiteBlackAndWhiteList> getBlackAndWhite() {
        return blackAndWhite;
    }

    public void setBlackAndWhite(List<LgshopShopsiteBlackAndWhiteList> blackAndWhite) {
        this.blackAndWhite = blackAndWhite;
    }

    public Long getShopsiteId() {
		return shopsiteId;
	}

	public void setShopsiteId(Long shopsiteId) {
		this.shopsiteId = shopsiteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getMainlanguage() {
		return mainlanguage;
	}

	public void setMainlanguage(Integer mainlanguage) {
		this.mainlanguage = mainlanguage;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public LgshopShopStateEnum getShopState() {
		return shopState;
	}

	public void setShopState(LgshopShopStateEnum shopState) {
		this.shopState = shopState;
	}

	public Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getDisplayLeguide() {
		return displayLeguide;
	}

	public void setDisplayLeguide(String displayLeguide) {
		this.displayLeguide = displayLeguide;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}


}
