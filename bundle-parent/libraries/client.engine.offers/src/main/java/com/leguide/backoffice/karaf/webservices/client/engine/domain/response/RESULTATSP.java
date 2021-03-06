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
 *     &lt;extension base="{com.leguide.mobile.xsd.response}Response">
 *       &lt;sequence>
 *         &lt;element ref="{}SHOP_COUNT"/>
 *         &lt;element ref="{}PRODUCT_COUNT"/>
 *         &lt;element ref="{}CAT_LIST_COUNT"/>
 *         &lt;element ref="{}CAT_LIST"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "shopcount",
    "productcount",
    "catlistcount",
    "catlist"
})
@XmlRootElement(name = "RESULTATSP")
public class RESULTATSP
    extends Response
{

    @XmlElement(name = "SHOP_COUNT")
    protected int shopcount;
    @XmlElement(name = "PRODUCT_COUNT")
    protected long productcount;
    @XmlElement(name = "CAT_LIST_COUNT")
    protected int catlistcount;
    @XmlElement(name = "CAT_LIST", required = true)
    protected CATLIST catlist;

    /**
     * Gets the value of the shopcount property.
     * 
     */
    public int getSHOPCOUNT() {
        return shopcount;
    }

    /**
     * Sets the value of the shopcount property.
     * 
     */
    public void setSHOPCOUNT(int value) {
        this.shopcount = value;
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
     * Gets the value of the catlistcount property.
     * 
     */
    public int getCATLISTCOUNT() {
        return catlistcount;
    }

    /**
     * Sets the value of the catlistcount property.
     * 
     */
    public void setCATLISTCOUNT(int value) {
        this.catlistcount = value;
    }

    /**
     * Gets the value of the catlist property.
     * 
     * @return
     *     possible object is
     *     {@link CATLIST }
     *     
     */
    public CATLIST getCATLIST() {
        return catlist;
    }

    /**
     * Sets the value of the catlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link CATLIST }
     *     
     */
    public void setCATLIST(CATLIST value) {
        this.catlist = value;
    }

}
