package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="tb_shopsite_sandbox")
@XmlRootElement(name = "LgshopShopsiteSandbox")
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "mappingFlag", columns = {
                @ColumnResult(name = "flag")})
})
@NamedNativeQueries({
	@NamedNativeQuery(name="LgshopShopsiteSandbox.findFlagDelivery", query="SELECT ROUND(POW(2, rdc.rdc_id_zone-1)) as flag FROM lgshop.rf_delivery_country rdc INNER JOIN lgshop.rf_country rc ON rdc.rdc_country_code = rc.cty_alpha2_code "
			+ " WHERE rdc.rdc_locale = 'fr_FR' AND rc.cty_internal_number = ?", resultClass = Long.class, resultSetMapping = "mappingFlag")
})
public class LgshopShopsiteSandbox implements Serializable {


	private static final long serialVersionUID = 316958790680630405L;


	public static final String FIND_FLAG_DELIVERY_ZONE= "LgshopShopsiteSandbox.findFlagDelivery";


	@Id
	@Column(name="id_shopsite")
	private Long shopsiteId;

	@Column(name="id_sand_commercial")
	private Integer commercial;

	@Column(name="id_sand_delivery_zone_update")
	private Date deliveryZoneUpdate;

	@Column(name="id_sand_flag")
	private Integer flag;

	@Column(name="id_sand_delivery_zone")
	private Long deliveryZone;

	@Column(name="id_sand_mantis")
	private Integer mantis;

	@Column(name="id_sand_nmediation")
	private Float nMediation;

	@Column(name="id_sand_mediation")
	private String mediation;

	@Column(name="id_sand_paynova")
	private Integer paynova;

	@Column(name="id_sand_agency")
	private Integer agency;


	public Long getShopsiteId() {
		return shopsiteId;
	}

	public void setShopsiteId(Long shopsiteId) {
		this.shopsiteId = shopsiteId;
	}

	public Integer getCommercial() {
		return commercial;
	}

	public void setCommercial(Integer commercial) {
		this.commercial = commercial;
	}

	public Date getDeliveryZoneUpdate() {
		return deliveryZoneUpdate;
	}

	public void setDeliveryZoneUpdate(Date deliveryZoneUpdate) {
		this.deliveryZoneUpdate = deliveryZoneUpdate;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Long getDeliveryZone() {
		return deliveryZone;
	}

	public void setDeliveryZone(Long deliveryZone) {
		this.deliveryZone = deliveryZone;
	}

	public Integer getMantis() {
		return mantis;
	}

	public void setMantis(Integer mantis) {
		this.mantis = mantis;
	}

	public Float getnMediation() {
		return nMediation;
	}

	public void setnMediation(Float nMediation) {
		this.nMediation = nMediation;
	}

	public String getMediation() {
		return mediation;
	}

	public void setMediation(String mediation) {
		this.mediation = mediation;
	}

	public Integer getPaynova() {
		return paynova;
	}

	public void setPaynova(Integer paynova) {
		this.paynova = paynova;
	}

	public Integer getAgency() {
		return agency;
	}

	public void setAgency(Integer agency) {
		this.agency = agency;
	}




}
