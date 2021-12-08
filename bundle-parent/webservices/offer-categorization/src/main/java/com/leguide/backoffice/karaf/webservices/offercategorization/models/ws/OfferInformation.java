package com.leguide.backoffice.karaf.webservices.offercategorization.models.ws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "offerinformation")
@XmlType(propOrder={"productId","internalThesaurusId","thesaurusId","label","merchantCategorie","pays"})
public class OfferInformation implements Serializable {

	private static final long serialVersionUID = 8518185307535105829L;


	private String productId;
	private String internalThesaurusId;
	private String thesaurusId;
	private String label;
	private String merchantCategorie;
	private String pays;

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getInternalThesaurusId() {
		return internalThesaurusId;
	}
	public void setInternalThesaurusId(String internalThesaurusId) {
		this.internalThesaurusId = internalThesaurusId;
	}
	public String getThesaurusId() {
		return thesaurusId;
	}
	public void setThesaurusId(String thesaurusId) {
		this.thesaurusId = thesaurusId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getMerchantCategorie() {
		return merchantCategorie;
	}
	public void setMerchantCategorie(String merchantCategorie) {
		this.merchantCategorie = merchantCategorie;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
}
