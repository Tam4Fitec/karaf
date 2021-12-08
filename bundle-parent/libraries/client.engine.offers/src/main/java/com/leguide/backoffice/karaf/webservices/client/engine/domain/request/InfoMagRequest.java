package com.leguide.backoffice.karaf.webservices.client.engine.domain.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{}request">
 *       &lt;sequence>
 *         &lt;element ref="{}kSite"/>
 *         &lt;element ref="{}kProtocol"/>
 *         &lt;element ref="{}kPhp"/>
 *         &lt;element ref="{}kShop"/>
 *         &lt;element ref="{}kDebug"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "kSite", "kProtocol", "kPhp", "kShop", "kDebug" })
@XmlRootElement(name = "query")
public class InfoMagRequest extends Request {

    @XmlElement(required = true)
    protected int kSite;
    @XmlElement(required = true)
    protected String kProtocol;
    protected int kPhp;
    @XmlElement(required = true)
    protected Long kShop;
    // search engine debug mode: 1 or 0
    protected int kDebug;

    public int getkSite() {
        return kSite;
    }
    public void setkSite(int kSite) {
        this.kSite = kSite;
    }
    public String getkProtocol() {
        return kProtocol;
    }
    public void setkProtocol(String kProtocol) {
        this.kProtocol = kProtocol;
    }
    public int getkPhp() {
        return kPhp;
    }
    public void setkPhp(int kPhp) {
        this.kPhp = kPhp;
    }
    public Long getkShop() {
        return kShop;
    }
    public void setkShop(Long kShop) {
        this.kShop = kShop;
    }
    public int getkDebug() {
        return kDebug;
    }
    public void setkDebug(int kDebug) {
        this.kDebug = kDebug;
    }
    @Override
    public String toString() {
        return "InfoMagRequest [kSite=" + kSite + ", " + (kProtocol != null ? "kProtocol=" + kProtocol + ", " : "")
                + "kPhp=" + kPhp + ", " + (kShop != null ? "kShop=" + kShop + ", " : "") + "kDebug=" + kDebug + "]";
    }

}
