package com.leguide.backoffice.karaf.business.models.pojo.light;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LightShopsite implements Serializable {


	private static final long serialVersionUID = -4161332099895871012L;

	private Long shopsiteId;
	private String name;
	private String url;
	private String description;
	private List<String> deliveryOptions;
	private LightPaymentOptions paymentOptions;
	private Integer retractation;
	private Integer zeusNotation;
	private String country;
	private String language;
	private Long storeId;

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

    public LightPaymentOptions getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(LightPaymentOptions paymentOptions) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getLogoURL() {
		return "http://csimg.leguide.com/srvlogo/"+language.toUpperCase()+"/"+storeId+"/T/{width}x{height}/F/gif/C/{backgroundColor}/url/http/img.leguide.com/v5/logo_sb/"+language+"/"+name.toLowerCase().charAt(0)+"/logo_"+storeId+".gif";
	}



}
