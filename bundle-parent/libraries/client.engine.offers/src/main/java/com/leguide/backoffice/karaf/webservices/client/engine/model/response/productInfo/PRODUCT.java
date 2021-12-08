//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.22 at 05:45:26 PM CEST 
//


package com.leguide.backoffice.karaf.webservices.client.engine.model.response.productInfo;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{}PROD_ID"/>
 *         &lt;element ref="{}PROD_BASE_ID"/>
 *         &lt;element ref="{}PROD_MARK"/>
 *         &lt;element ref="{}PROD_WITH_CARAC"/>
 *         &lt;element ref="{}PROD_MASQUE"/>
 *         &lt;element ref="{}PROD_GARANTIE"/>
 *         &lt;element ref="{}PROD_DISPO"/>
 *         &lt;element ref="{}PROD_DISPO_NAME"/>
 *         &lt;element ref="{}PROD_OCCASION"/>
 *         &lt;element ref="{}PROD_SOLDE"/>
 *         &lt;element ref="{}PROD_PRIVE"/>
 *         &lt;element ref="{}CAT_ID_INTERNE"/>
 *         &lt;element ref="{}CAT_ID"/>
 *         &lt;element ref="{}CAT_SINGLE_NAME"/>
 *         &lt;element ref="{}CAT_URL"/>
 *         &lt;element ref="{}SHOP_ID"/>
 *         &lt;element ref="{}SHOP_VARS"/>
 *         &lt;element ref="{}SHOP_LOGO"/>
 *         &lt;element ref="{}SHOP_NAME"/>
 *         &lt;element ref="{}SHOP_GLOBAL"/>
 *         &lt;element ref="{}SHOP_MEDIATION"/>
 *         &lt;element ref="{}SHOP_PAYS"/>
 *         &lt;element ref="{}SHOP_LABEL_VALID"/>
 *         &lt;element ref="{}SHOP_LABEL_DEBUT"/>
 *         &lt;element ref="{}SHOP_LABEL_FIN"/>
 *         &lt;element ref="{}PROD_EURO_PRICE"/>
 *         &lt;element ref="{}PROD_EURO_FP"/>
 *         &lt;element ref="{}PROD_EURO_DISCOUNT"/>
 *         &lt;element ref="{}PROD_D3E"/>
 *         &lt;element ref="{}PROD_INTL_DEVISE"/>
 *         &lt;element ref="{}PROD_INTL_PRICE"/>
 *         &lt;element ref="{}PROD_INTL_FP"/>
 *         &lt;element ref="{}PROD_CAT_SHOP"/>
 *         &lt;element ref="{}PROD_ALPHA1"/>
 *         &lt;element ref="{}PROD_ALPHA2"/>
 *         &lt;element ref="{}PROD_EAN13"/>
 *         &lt;element ref="{}PROD_REF_INTERNE"/>
 *         &lt;element ref="{}PROD_REF"/>
 *         &lt;element ref="{}PROD_URL"/>
 *         &lt;element ref="{}PROD_IMG"/>
 *         &lt;element ref="{}PROD_DESIGNATION"/>
 *         &lt;element ref="{}PROD_DESCRIPTION"/>
 *         &lt;element ref="{}PROD_EXTRAS"/>
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
    "prodid",
    "prodbaseid",
    "prodmark",
    "prodwithcarac",
    "prodmasque",
    "prodgarantie",
    "proddispo",
    "proddisponame",
    "prodoccasion",
    "prodsolde",
    "prodprive",
    "catidinterne",
    "catid",
    "catsinglename",
    "caturl",
    "shopid",
    "shopvars",
    "shoplogo",
    "shopname",
    "shopglobal",
    "shopmediation",
    "shoppays",
    "shoplabelvalid",
    "shoplabeldebut",
    "shoplabelfin",
    "prodeuroprice",
    "prodeurofp",
    "prodeurodiscount",
    "prodd3E",
    "prodintldevise",
    "prodintlprice",
    "prodintlfp",
    "prodcatshop",
    "prodalpha1",
    "prodalpha2",
    "prodean13",
    "prodrefinterne",
    "prodref",
    "produrl",
    "prodimg",
    "proddesignation",
    "proddescription",
    "prodextras"
})
@XmlRootElement(name = "PRODUCT")
public class PRODUCT {

    @XmlElement(name = "PROD_ID", required = true)
    protected BigInteger prodid;
    @XmlElement(name = "PROD_BASE_ID", required = true)
    protected BigInteger prodbaseid;
    @XmlElement(name = "PROD_MARK", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String prodmark;
    @XmlElement(name = "PROD_WITH_CARAC", required = true)
    protected BigInteger prodwithcarac;
    @XmlElement(name = "PROD_MASQUE", required = true)
    protected BigInteger prodmasque;
    @XmlElement(name = "PROD_GARANTIE", required = true)
    protected BigInteger prodgarantie;
    @XmlElement(name = "PROD_DISPO", required = true)
    protected BigInteger proddispo;
    @XmlElement(name = "PROD_DISPO_NAME", required = true)
    protected BigInteger proddisponame;
    @XmlElement(name = "PROD_OCCASION", required = true)
    protected BigInteger prodoccasion;
    @XmlElement(name = "PROD_SOLDE", required = true)
    protected BigInteger prodsolde;
    @XmlElement(name = "PROD_PRIVE", required = true)
    protected BigInteger prodprive;
    @XmlElement(name = "CAT_ID_INTERNE", required = true)
    protected BigInteger catidinterne;
    @XmlElement(name = "CAT_ID", required = true)
    protected BigInteger catid;
    @XmlElement(name = "CAT_SINGLE_NAME", required = true)
    protected String catsinglename;
    @XmlElement(name = "CAT_URL", required = true)
    protected String caturl;
    @XmlElement(name = "SHOP_ID", required = true)
    protected BigInteger shopid;
    @XmlElement(name = "SHOP_VARS", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String shopvars;
    @XmlElement(name = "SHOP_LOGO", required = true)
    protected BigInteger shoplogo;
    @XmlElement(name = "SHOP_NAME", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shopname;
    @XmlElement(name = "SHOP_GLOBAL", required = true)
    protected BigDecimal shopglobal;
    @XmlElement(name = "SHOP_MEDIATION", required = true)
    protected BigInteger shopmediation;
    @XmlElement(name = "SHOP_PAYS", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shoppays;
    @XmlElement(name = "SHOP_LABEL_VALID", required = true)
    protected BigInteger shoplabelvalid;
    @XmlElement(name = "SHOP_LABEL_DEBUT", required = true)
    protected SHOPLABELDEBUT shoplabeldebut;
    @XmlElement(name = "SHOP_LABEL_FIN", required = true)
    protected SHOPLABELFIN shoplabelfin;
    @XmlElement(name = "PROD_EURO_PRICE", required = true)
    protected BigDecimal prodeuroprice;
    @XmlElement(name = "PROD_EURO_FP", required = true)
    protected BigDecimal prodeurofp;
    @XmlElement(name = "PROD_EURO_DISCOUNT", required = true)
    protected BigDecimal prodeurodiscount;
    @XmlElement(name = "PROD_D3E", required = true)
    protected BigInteger prodd3E;
    @XmlElement(name = "PROD_INTL_DEVISE", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String prodintldevise;
    @XmlElement(name = "PROD_INTL_PRICE", required = true)
    protected BigDecimal prodintlprice;
    @XmlElement(name = "PROD_INTL_FP", required = true)
    protected BigDecimal prodintlfp;
    @XmlElement(name = "PROD_CAT_SHOP", required = true)
    protected String prodcatshop;
    @XmlElement(name = "PROD_ALPHA1", required = true)
    protected PRODALPHA1 prodalpha1;
    @XmlElement(name = "PROD_ALPHA2", required = true)
    protected PRODALPHA2 prodalpha2;
    @XmlElement(name = "PROD_EAN13", required = true)
    protected PRODEAN13 prodean13;
    @XmlElement(name = "PROD_REF_INTERNE", required = true)
    protected BigInteger prodrefinterne;
    @XmlElement(name = "PROD_REF", required = true)
    protected PRODREF prodref;
    @XmlElement(name = "PROD_URL", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String produrl;
    @XmlElement(name = "PROD_IMG", required = true)
    protected String prodimg;
    @XmlElement(name = "PROD_DESIGNATION", required = true)
    protected String proddesignation;
    @XmlElement(name = "PROD_DESCRIPTION", required = true)
    protected String proddescription;
    @XmlElement(name = "PROD_EXTRAS", required = true)
    protected PRODEXTRAS prodextras;

    /**
     * Gets the value of the prodid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODID() {
        return prodid;
    }

    /**
     * Sets the value of the prodid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODID(BigInteger value) {
        this.prodid = value;
    }

    /**
     * Gets the value of the prodbaseid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODBASEID() {
        return prodbaseid;
    }

    /**
     * Sets the value of the prodbaseid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODBASEID(BigInteger value) {
        this.prodbaseid = value;
    }

    /**
     * Gets the value of the prodmark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODMARK() {
        return prodmark;
    }

    /**
     * Sets the value of the prodmark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODMARK(String value) {
        this.prodmark = value;
    }

    /**
     * Gets the value of the prodwithcarac property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODWITHCARAC() {
        return prodwithcarac;
    }

    /**
     * Sets the value of the prodwithcarac property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODWITHCARAC(BigInteger value) {
        this.prodwithcarac = value;
    }

    /**
     * Gets the value of the prodmasque property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODMASQUE() {
        return prodmasque;
    }

    /**
     * Sets the value of the prodmasque property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODMASQUE(BigInteger value) {
        this.prodmasque = value;
    }

    /**
     * Gets the value of the prodgarantie property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODGARANTIE() {
        return prodgarantie;
    }

    /**
     * Sets the value of the prodgarantie property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODGARANTIE(BigInteger value) {
        this.prodgarantie = value;
    }

    /**
     * Gets the value of the proddispo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODDISPO() {
        return proddispo;
    }

    /**
     * Sets the value of the proddispo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODDISPO(BigInteger value) {
        this.proddispo = value;
    }

    /**
     * Gets the value of the proddisponame property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODDISPONAME() {
        return proddisponame;
    }

    /**
     * Sets the value of the proddisponame property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODDISPONAME(BigInteger value) {
        this.proddisponame = value;
    }

    /**
     * Gets the value of the prodoccasion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODOCCASION() {
        return prodoccasion;
    }

    /**
     * Sets the value of the prodoccasion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODOCCASION(BigInteger value) {
        this.prodoccasion = value;
    }

    /**
     * Gets the value of the prodsolde property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODSOLDE() {
        return prodsolde;
    }

    /**
     * Sets the value of the prodsolde property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODSOLDE(BigInteger value) {
        this.prodsolde = value;
    }

    /**
     * Gets the value of the prodprive property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODPRIVE() {
        return prodprive;
    }

    /**
     * Sets the value of the prodprive property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODPRIVE(BigInteger value) {
        this.prodprive = value;
    }

    /**
     * Gets the value of the catidinterne property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCATIDINTERNE() {
        return catidinterne;
    }

    /**
     * Sets the value of the catidinterne property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCATIDINTERNE(BigInteger value) {
        this.catidinterne = value;
    }

    /**
     * Gets the value of the catid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCATID() {
        return catid;
    }

    /**
     * Sets the value of the catid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCATID(BigInteger value) {
        this.catid = value;
    }

    /**
     * Gets the value of the catsinglename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCATSINGLENAME() {
        return catsinglename;
    }

    /**
     * Sets the value of the catsinglename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCATSINGLENAME(String value) {
        this.catsinglename = value;
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

    /**
     * Gets the value of the shopid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSHOPID() {
        return shopid;
    }

    /**
     * Sets the value of the shopid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSHOPID(BigInteger value) {
        this.shopid = value;
    }

    /**
     * Gets the value of the shopvars property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHOPVARS() {
        return shopvars;
    }

    /**
     * Sets the value of the shopvars property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHOPVARS(String value) {
        this.shopvars = value;
    }

    /**
     * Gets the value of the shoplogo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSHOPLOGO() {
        return shoplogo;
    }

    /**
     * Sets the value of the shoplogo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSHOPLOGO(BigInteger value) {
        this.shoplogo = value;
    }

    /**
     * Gets the value of the shopname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHOPNAME() {
        return shopname;
    }

    /**
     * Sets the value of the shopname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHOPNAME(String value) {
        this.shopname = value;
    }

    /**
     * Gets the value of the shopglobal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSHOPGLOBAL() {
        return shopglobal;
    }

    /**
     * Sets the value of the shopglobal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSHOPGLOBAL(BigDecimal value) {
        this.shopglobal = value;
    }

    /**
     * Gets the value of the shopmediation property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSHOPMEDIATION() {
        return shopmediation;
    }

    /**
     * Sets the value of the shopmediation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSHOPMEDIATION(BigInteger value) {
        this.shopmediation = value;
    }

    /**
     * Gets the value of the shoppays property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHOPPAYS() {
        return shoppays;
    }

    /**
     * Sets the value of the shoppays property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHOPPAYS(String value) {
        this.shoppays = value;
    }

    /**
     * Gets the value of the shoplabelvalid property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSHOPLABELVALID() {
        return shoplabelvalid;
    }

    /**
     * Sets the value of the shoplabelvalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSHOPLABELVALID(BigInteger value) {
        this.shoplabelvalid = value;
    }

    /**
     * Gets the value of the shoplabeldebut property.
     * 
     * @return
     *     possible object is
     *     {@link SHOPLABELDEBUT }
     *     
     */
    public SHOPLABELDEBUT getSHOPLABELDEBUT() {
        return shoplabeldebut;
    }

    /**
     * Sets the value of the shoplabeldebut property.
     * 
     * @param value
     *     allowed object is
     *     {@link SHOPLABELDEBUT }
     *     
     */
    public void setSHOPLABELDEBUT(SHOPLABELDEBUT value) {
        this.shoplabeldebut = value;
    }

    /**
     * Gets the value of the shoplabelfin property.
     * 
     * @return
     *     possible object is
     *     {@link SHOPLABELFIN }
     *     
     */
    public SHOPLABELFIN getSHOPLABELFIN() {
        return shoplabelfin;
    }

    /**
     * Sets the value of the shoplabelfin property.
     * 
     * @param value
     *     allowed object is
     *     {@link SHOPLABELFIN }
     *     
     */
    public void setSHOPLABELFIN(SHOPLABELFIN value) {
        this.shoplabelfin = value;
    }

    /**
     * Gets the value of the prodeuroprice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPRODEUROPRICE() {
        return prodeuroprice;
    }

    /**
     * Sets the value of the prodeuroprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPRODEUROPRICE(BigDecimal value) {
        this.prodeuroprice = value;
    }

    /**
     * Gets the value of the prodeurofp property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPRODEUROFP() {
        return prodeurofp;
    }

    /**
     * Sets the value of the prodeurofp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPRODEUROFP(BigDecimal value) {
        this.prodeurofp = value;
    }

    /**
     * Gets the value of the prodeurodiscount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPRODEURODISCOUNT() {
        return prodeurodiscount;
    }

    /**
     * Sets the value of the prodeurodiscount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPRODEURODISCOUNT(BigDecimal value) {
        this.prodeurodiscount = value;
    }

    /**
     * Gets the value of the prodd3E property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODD3E() {
        return prodd3E;
    }

    /**
     * Sets the value of the prodd3E property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODD3E(BigInteger value) {
        this.prodd3E = value;
    }

    /**
     * Gets the value of the prodintldevise property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODINTLDEVISE() {
        return prodintldevise;
    }

    /**
     * Sets the value of the prodintldevise property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODINTLDEVISE(String value) {
        this.prodintldevise = value;
    }

    /**
     * Gets the value of the prodintlprice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPRODINTLPRICE() {
        return prodintlprice;
    }

    /**
     * Sets the value of the prodintlprice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPRODINTLPRICE(BigDecimal value) {
        this.prodintlprice = value;
    }

    /**
     * Gets the value of the prodintlfp property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPRODINTLFP() {
        return prodintlfp;
    }

    /**
     * Sets the value of the prodintlfp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPRODINTLFP(BigDecimal value) {
        this.prodintlfp = value;
    }

    /**
     * Gets the value of the prodcatshop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODCATSHOP() {
        return prodcatshop;
    }

    /**
     * Sets the value of the prodcatshop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODCATSHOP(String value) {
        this.prodcatshop = value;
    }

    /**
     * Gets the value of the prodalpha1 property.
     * 
     * @return
     *     possible object is
     *     {@link PRODALPHA1 }
     *     
     */
    public PRODALPHA1 getPRODALPHA1() {
        return prodalpha1;
    }

    /**
     * Sets the value of the prodalpha1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRODALPHA1 }
     *     
     */
    public void setPRODALPHA1(PRODALPHA1 value) {
        this.prodalpha1 = value;
    }

    /**
     * Gets the value of the prodalpha2 property.
     * 
     * @return
     *     possible object is
     *     {@link PRODALPHA2 }
     *     
     */
    public PRODALPHA2 getPRODALPHA2() {
        return prodalpha2;
    }

    /**
     * Sets the value of the prodalpha2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRODALPHA2 }
     *     
     */
    public void setPRODALPHA2(PRODALPHA2 value) {
        this.prodalpha2 = value;
    }

    /**
     * Gets the value of the prodean13 property.
     * 
     * @return
     *     possible object is
     *     {@link PRODEAN13 }
     *     
     */
    public PRODEAN13 getPRODEAN13() {
        return prodean13;
    }

    /**
     * Sets the value of the prodean13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRODEAN13 }
     *     
     */
    public void setPRODEAN13(PRODEAN13 value) {
        this.prodean13 = value;
    }

    /**
     * Gets the value of the prodrefinterne property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPRODREFINTERNE() {
        return prodrefinterne;
    }

    /**
     * Sets the value of the prodrefinterne property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPRODREFINTERNE(BigInteger value) {
        this.prodrefinterne = value;
    }

    /**
     * Gets the value of the prodref property.
     * 
     * @return
     *     possible object is
     *     {@link PRODREF }
     *     
     */
    public PRODREF getPRODREF() {
        return prodref;
    }

    /**
     * Sets the value of the prodref property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRODREF }
     *     
     */
    public void setPRODREF(PRODREF value) {
        this.prodref = value;
    }

    /**
     * Gets the value of the produrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODURL() {
        return produrl;
    }

    /**
     * Sets the value of the produrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODURL(String value) {
        this.produrl = value;
    }

    /**
     * Gets the value of the prodimg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODIMG() {
        return prodimg;
    }

    /**
     * Sets the value of the prodimg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODIMG(String value) {
        this.prodimg = value;
    }

    /**
     * Gets the value of the proddesignation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODDESIGNATION() {
        return proddesignation;
    }

    /**
     * Sets the value of the proddesignation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODDESIGNATION(String value) {
        this.proddesignation = value;
    }

    /**
     * Gets the value of the proddescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODDESCRIPTION() {
        return proddescription;
    }

    /**
     * Sets the value of the proddescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODDESCRIPTION(String value) {
        this.proddescription = value;
    }

    /**
     * Gets the value of the prodextras property.
     * 
     * @return
     *     possible object is
     *     {@link PRODEXTRAS }
     *     
     */
    public PRODEXTRAS getPRODEXTRAS() {
        return prodextras;
    }

    /**
     * Sets the value of the prodextras property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRODEXTRAS }
     *     
     */
    public void setPRODEXTRAS(PRODEXTRAS value) {
        this.prodextras = value;
    }

}