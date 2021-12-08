//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.22 at 04:35:15 PM CET 
//


package com.leguide.backoffice.karaf.webservices.client.engine.domain.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}kFunc"/>
 *         &lt;element ref="{}kPays"/>
 *         &lt;element ref="{}kZone"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "request", propOrder = {
    "kFunc",
    "kPays",
    "kZone"
})
@XmlSeeAlso({
    ProductsNetRequest.class,
    ListOffersRequest.class,
    ProductInfoRequest.class,
    StartPageRequest.class
})
public abstract class Request {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String kFunc;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String kPays;
    protected int kZone;

    /**
     * Gets the value of the kFunc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKFunc() {
        return kFunc;
    }

    /**
     * Sets the value of the kFunc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKFunc(String value) {
        this.kFunc = value;
    }

    /**
     * Gets the value of the kPays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKPays() {
        return kPays;
    }

    /**
     * Sets the value of the kPays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKPays(String value) {
        this.kPays = value;
    }

    /**
     * Gets the value of the kZone property.
     * 
     */
    public int getKZone() {
        return kZone;
    }

    /**
     * Sets the value of the kZone property.
     * 
     */
    public void setKZone(int value) {
        this.kZone = value;
    }

}
