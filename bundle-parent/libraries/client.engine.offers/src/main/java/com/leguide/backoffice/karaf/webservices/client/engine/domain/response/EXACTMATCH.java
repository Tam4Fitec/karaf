//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.18 at 12:17:06 PM CET 
//


package com.leguide.backoffice.karaf.webservices.client.engine.domain.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}CAT_ID"/>
 *         &lt;element ref="{}CAT_NAME"/>
 *         &lt;element ref="{}CAT_URL"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "catid",
    "catname",
    "caturl"
})
@XmlRootElement(name = "EXACT_MATCH")
public class EXACTMATCH {

    @XmlElement(name = "CAT_ID")
    protected long catid;
    @XmlElement(name = "CAT_NAME", required = true)
    protected String catname;
    @XmlElement(name = "CAT_URL", required = true)
    protected String caturl;

    /**
     * Gets the value of the catid property.
     * 
     */
    public long getCATID() {
        return catid;
    }

    /**
     * Sets the value of the catid property.
     * 
     */
    public void setCATID(long value) {
        this.catid = value;
    }

    /**
     * Gets the value of the catname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCATNAME() {
        return catname;
    }

    /**
     * Sets the value of the catname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCATNAME(String value) {
        this.catname = value;
    }

    /**
     * Gets the value of the caturl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCATURL() {
        return caturl;
    }

    /**
     * Sets the value of the caturl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCATURL(String value) {
        this.caturl = value;
    }

}