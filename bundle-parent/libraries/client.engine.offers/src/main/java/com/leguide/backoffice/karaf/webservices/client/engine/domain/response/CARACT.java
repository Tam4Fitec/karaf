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
 *         &lt;element ref="{}CARACT_ID"/>
 *         &lt;element ref="{}CARACT_NAME"/>
 *         &lt;element ref="{}CARACT_VALUE"/>
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
    "caractid",
    "caractname",
    "caractvalue"
})
@XmlRootElement(name = "CARACT")
public class CARACT {

    @XmlElement(name = "CARACT_ID")
    protected int caractid;
    @XmlElement(name = "CARACT_NAME", required = true)
    protected String caractname;
    @XmlElement(name = "CARACT_VALUE", required = true)
    protected String caractvalue;
    @XmlAttribute(name = "PLACE", required = true)
    protected int place;

    /**
     * Gets the value of the caractid property.
     * 
     */
    public int getCARACTID() {
        return caractid;
    }

    /**
     * Sets the value of the caractid property.
     * 
     */
    public void setCARACTID(int value) {
        this.caractid = value;
    }

    /**
     * Gets the value of the caractname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARACTNAME() {
        return caractname;
    }

    /**
     * Sets the value of the caractname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARACTNAME(String value) {
        this.caractname = value;
    }

    /**
     * Gets the value of the caractvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARACTVALUE() {
        return caractvalue;
    }

    /**
     * Sets the value of the caractvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARACTVALUE(String value) {
        this.caractvalue = value;
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