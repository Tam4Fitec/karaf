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
 *         &lt;element ref="{}CRIT_ID"/>
 *         &lt;element ref="{}CRIT_NAME"/>
 *         &lt;element ref="{}CRIT_TYPE"/>
 *         &lt;element ref="{}PLAGE_LIST_COUNT"/>
 *         &lt;element ref="{}PLAGE_LIST"/>
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
    "critid",
    "critname",
    "crittype",
    "plagelistcount",
    "plagelist"
})
@XmlRootElement(name = "CRIT")
public class CRIT {

    @XmlElement(name = "CRIT_ID")
    protected long critid;
    @XmlElement(name = "CRIT_NAME", required = true)
    protected String critname;
    @XmlElement(name = "CRIT_TYPE")
    protected short crittype;
    @XmlElement(name = "PLAGE_LIST_COUNT")
    protected int plagelistcount;
    @XmlElement(name = "PLAGE_LIST", required = true)
    protected PLAGELIST plagelist;
    @XmlAttribute(name = "PLACE", required = true)
    protected int place;

    /**
     * Gets the value of the critid property.
     * 
     */
    public long getCRITID() {
        return critid;
    }

    /**
     * Sets the value of the critid property.
     * 
     */
    public void setCRITID(long value) {
        this.critid = value;
    }

    /**
     * Gets the value of the critname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRITNAME() {
        return critname;
    }

    /**
     * Sets the value of the critname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRITNAME(String value) {
        this.critname = value;
    }

    /**
     * Gets the value of the crittype property.
     * 
     */
    public short getCRITTYPE() {
        return crittype;
    }

    /**
     * Sets the value of the crittype property.
     * 
     */
    public void setCRITTYPE(short value) {
        this.crittype = value;
    }

    /**
     * Gets the value of the plagelistcount property.
     * 
     */
    public int getPLAGELISTCOUNT() {
        return plagelistcount;
    }

    /**
     * Sets the value of the plagelistcount property.
     * 
     */
    public void setPLAGELISTCOUNT(int value) {
        this.plagelistcount = value;
    }

    /**
     * Gets the value of the plagelist property.
     * 
     * @return
     *     possible object is
     *     {@link PLAGELIST }
     *     
     */
    public PLAGELIST getPLAGELIST() {
        return plagelist;
    }

    /**
     * Sets the value of the plagelist property.
     * 
     * @param value
     *     allowed object is
     *     {@link PLAGELIST }
     *     
     */
    public void setPLAGELIST(PLAGELIST value) {
        this.plagelist = value;
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
