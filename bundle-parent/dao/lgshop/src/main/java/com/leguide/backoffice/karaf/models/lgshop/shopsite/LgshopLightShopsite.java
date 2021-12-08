package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name=LgshopLightShopsite.FIND_LIGHT_SHOP_INFO_BY_ID, query="select lang.language, store.store_id, country.cty_alpha2_code, s.zeus_notation, w.* from lgshop.wm_shopsite w inner join lgshop.tb_shopsite_state s on w.id_shopsite = s.id_shopsite left join lgshop.tb_shopsite_delivery d on d.id_shopsite = w.id_shopsite inner join lgbase.lg_store store on store.store_uid = w.id_shopsite inner join lgshop.rf_country country on country.cty_internal_number = w.id_country inner join lgshop.rf_language lang on lang.id_language = w.shs_main_language and lang.country = country.cty_alpha2_code where w.id_shopsite = ?", resultClass = LgshopLightShopsite.class),
	@NamedNativeQuery(name=LgshopLightShopsite.FIND_LIGHT_SHOP_INFO_BY_KSITE, query="select lang.language, store.store_id, country.cty_alpha2_code, s.zeus_notation, w.* from lgshop.wm_shopsite w inner join lgshop.tb_shopsite_state s on w.id_shopsite = s.id_shopsite inner join lgshop.tb_shopsite_delivery d on d.id_shopsite = w.id_shopsite inner join lgbase.lg_store store on store.store_uid = w.id_shopsite inner join lgshop.rf_country country on country.cty_internal_number = w.id_country inner join lgshop.rf_language lang on lang.id_language = w.shs_main_language and lang.country = country.cty_alpha2_code where s.ksite_flags & ? = ?", resultClass = LgshopLightShopsite.class),
    @NamedNativeQuery(name=LgshopLightShopsite.FIND_LIGHT_SHOP_INFO_BY_ZEUS_NOTATION, query="select lang.language, store.store_id, country.cty_alpha2_code, s.zeus_notation, w.* from lgshop.wm_shopsite w inner join lgshop.tb_shopsite_state s on w.id_shopsite = s.id_shopsite inner join lgshop.tb_shopsite_delivery d on d.id_shopsite = w.id_shopsite inner join lgbase.lg_store store on store.store_uid = w.id_shopsite inner join lgshop.rf_country country on country.cty_internal_number = w.id_country inner join lgshop.rf_language lang on lang.id_language = w.shs_main_language and lang.country = country.cty_alpha2_code where s.zeus_notation = ?", resultClass = LgshopLightShopsite.class)
})
public class LgshopLightShopsite implements Serializable{

	private static final long serialVersionUID = 8050188726515482391L;
	public static final String FIND_LIGHT_SHOP_INFO_BY_ID = "LgshopShopsite.findLightShopInfoById";
	public static final String FIND_LIGHT_SHOP_INFO_BY_KSITE = "LgshopShopsite.findLightShopInfoByKSite";
    public static final String FIND_LIGHT_SHOP_INFO_BY_ZEUS_NOTATION = "LgshopShopsite.findLightShopInfoByZeusNotation";

	@Id
	@Column(name="id_shopsite")
	private Long shopsiteId;

	@Column(name="shs_name")
	private String name;

	@Column(name="shu_displayed_url")
	private String url;

	//@Column(name="shu_logo_url")
    @Transient
	private String logoURL = null;

	@Column(name="shl_general_description")
	private String description;

    @Transient
	private List<String> deliveryOptions;

    @Transient
	private LgshopPaymentOptions paymentOptions;


	@Column(name="shd_cooling_off_period")
	private Integer retractation;

	@Column(name="zeus_notation")
	private Integer zeusNotation;

	@Column(name="sso_compagny_name")
	private String companyName;

	@Column(name="sso_adress")
	private String address1;

	@Column(name="sso_adress2")
	private String address2;

	@Column(name="sso_zipcode")
	private String zipCode;

	@Column(name="sso_city")
	private String city;

	@Column(name="cty_alpha2_code")
	private String country;

	@Column(name="store_id")
	private Long storeId;

	@Column(name="language")
	private String language;


	@Column(name="shl_customer_service_email")
	private String customerServiceEmail;

	@Column(name="shl_customer_service_phone_number")
	private String customerServicePhone;



	public LgshopLightShopsite() {
		paymentOptions = new LgshopPaymentOptions();
		deliveryOptions = new ArrayList<String>();
		//merchant.setImage("http://csimg.leguide.com/srvlogo/"+country.toUpperCase()+"/"+storeId+"/T/80x30/F/gif/C/FFFFFF/url/logo.gif");

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



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getLogoURL() {
		return "http://csimg.leguide.com/srvlogo/"+language.toUpperCase()+"/"+storeId+"/T/{width}x{height}/F/gif/C/{backgroundColor}/url/http/img.leguide.com/v5/logo_sb/"+language+"/"+name.toLowerCase().charAt(0)+"/logo_"+storeId+".gif";
	}




	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public List<String> getDeliveryOptions() {
		return deliveryOptions;
	}



	public void setDeliveryOptions(List<String> deliveryOptions) {
		this.deliveryOptions = deliveryOptions;
	}



	public LgshopPaymentOptions getPaymentOptions() {
		return paymentOptions;
	}



	public void setPaymentOptions(LgshopPaymentOptions paymentOptions) {
		this.paymentOptions = paymentOptions;
	}



	public Integer getRetractation() {
		return retractation;
	}



	public void setRetractation(Integer retractation) {
		this.retractation = retractation;
	}



	public Integer getZeusNotation() {
		return zeusNotation;
	}



	public void setZeusNotation(Integer zeusNotation) {
		this.zeusNotation = zeusNotation;
	}


	public void setPaymentSolutions(List<String> paymentSolutions) {
		this.paymentOptions.setPaymentSolutions(paymentSolutions);
	}

	public void setPaymentCards(List<String> paymentCards) {
		this.paymentOptions.setPaymentCards(paymentCards);
	}

	public void setOtherPaymentMethods(List<String> otherPaymentMethods) {
		this.paymentOptions.setOtherPaymentMethods(otherPaymentMethods);
	}


	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getStoreId() {
		return storeId;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}




}
