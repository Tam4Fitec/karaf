package com.leguide.backoffice.karaf.webservices.offercategorization.models.ws;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "response")
@XmlType(propOrder={"pagecount","count", "offerinformations"})
public class OfferInformations implements Serializable {

 	private static final long serialVersionUID = 844265057114286239L;
 	private List<OfferInformation> offerinformations = new ArrayList<OfferInformation>();

	private Integer pagecount = 0;
	private Integer count = 0;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	@XmlElementWrapper(name="offerinformations")
	@XmlElement(name="offerinformation")
	public List<OfferInformation> getOfferinformations() {
		return offerinformations;
	}

	public void setOfferinformations(List<OfferInformation> offerinformations) {
		this.offerinformations = offerinformations;
	}	
	
	public void addOfferInfo(OfferInformation offerinformation) {
		this.offerinformations.add(offerinformation);
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPagecount() {
		return pagecount;
	}
	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}
}