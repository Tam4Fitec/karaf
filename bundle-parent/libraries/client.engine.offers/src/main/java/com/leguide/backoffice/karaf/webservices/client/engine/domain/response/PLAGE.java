//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.18 at 12:17:06 PM CET 
//


package com.leguide.backoffice.karaf.webservices.client.engine.domain.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{}PLAGE_ID"/>
 *           &lt;sequence>
 *             &lt;element ref="{}PLAGE_MIN"/>
 *             &lt;element ref="{}PLAGE_MAX"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element ref="{}PLAGE_NAME"/>
 *         &lt;element ref="{}PRODUCT_COUNT"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PLACE" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "plageid",
    "plagemin",
    "plagemax",
    "plagename",
    "productcount"
})
@XmlRootElement(name = "PLAGE")
public class PLAGE {

    @XmlElement(name = "PLAGE_ID")
    protected Long plageid;
    @XmlElement(name = "PLAGE_MIN")
    protected String plagemin;
    @XmlElement(name = "PLAGE_MAX")
    protected String plagemax;
    @XmlElement(name = "PLAGE_NAME", required = true)
    protected String plagename;
    @XmlElement(name = "PRODUCT_COUNT")
    protected long productcount;
    @XmlAttribute(name = "PLACE", required = true)
    protected int place;

    /**
     * Gets the value of the plageid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPLAGEID() {
        return plageid;
    }

    /**
     * Sets the value of the plageid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPLAGEID(Long value) {
        this.plageid = value;
    }

    /**
     * Gets the value of the plagemin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLAGEMIN() {
        return plagemin;
    }

    /**
     * Sets the value of the plagemin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLAGEMIN(String value) {
        this.plagemin = value;
    }

    /**
     * Gets the value of the plagemax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLAGEMAX() {
        return plagemax;
    }

    /**
     * Sets the value of the plagemax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLAGEMAX(String value) {
        this.plagemax = value;
    }

    /**
     * Gets the value of the plagename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLAGENAME() {
        return plagename;
    }

    /**
     * Sets the value of the plagename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLAGENAME(String value) {
        this.plagename = value;
    }

    /**
     * Gets the value of the productcount property.
     * 
     */
    public long getPRODUCTCOUNT() {
        return productcount;
    }

    /**
     * Sets the value of the productcount property.
     * 
     */
    public void setPRODUCTCOUNT(long value) {
        this.productcount = value;
    }

    /**
     * Gets the value of the place property.
     * 
     */
    public int getPLACE() {
        return place;
    }

    /**
     * Sets the value of the place property.
     * 
     */
    public void setPLACE(int value) {
        this.place = value;
    }

}