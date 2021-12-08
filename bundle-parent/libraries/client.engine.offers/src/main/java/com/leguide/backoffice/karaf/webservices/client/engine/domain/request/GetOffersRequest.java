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
 *         &lt;element ref="{}kPage"/>
 *         &lt;element ref="{}kSort"/>
 *         &lt;element ref="{}kGroup"/>
 *         &lt;element ref="{}kOccasion"/>
 *         &lt;element ref="{}kPhp"/>
 *         &lt;element ref="{}kCat"/>
 *         &lt;element ref="{}kShop"/>
 *         &lt;element ref="{}kWords"/>
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
@XmlType(name = "", propOrder = { "kSite", "kProtocol", "kProdCount", "kPage", "kSort", "kGroup", "kOccasion", "kPhp", "kCat",
        "kShop", "kWords", "kDebug" })
@XmlRootElement(name = "query")
public class GetOffersRequest extends Request {

    protected int kSite;
    @XmlElement(required = true)
    protected String kProtocol;
    protected Integer kPage;
    protected Integer kProdCount;
    protected int kSort;
    protected int kGroup;
    protected int kOccasion;
    protected int kPhp;
    protected String kCat;
    protected String kShop;
    @XmlElement(required = true)
    protected String kWords;
    // search engine debug mode: 1 or 0
    protected int kDebug;

    public int getkSite() {
        return kSite;
    }

    public void setkSite(int kSite) {
        this.kSite = kSite;
    }

    public Integer getkProdCount() {
        return kProdCount;
    }

    public void setkProdCount(Integer kProdCount) {
        this.kProdCount = kProdCount;
    }
    
    public String getkProtocol() {
        return kProtocol;
    }

    public void setkProtocol(String kProtocol) {
        this.kProtocol = kProtocol;
    }

    public Integer getkPage() {
        return kPage;
    }

    public void setkPage(Integer kPage) {
        this.kPage = kPage;
    }

    public int getkSort() {
        return kSort;
    }

    public void setkSort(int kSort) {
        this.kSort = kSort;
    }

    public int getkGroup() {
        return kGroup;
    }

    public void setkGroup(int kGroup) {
        this.kGroup = kGroup;
    }

    public int getkOccasion() {
        return kOccasion;
    }

    public void setkOccasion(int kOccasion) {
        this.kOccasion = kOccasion;
    }

    public int getkPhp() {
        return kPhp;
    }

    public void setkPhp(int kPhp) {
        this.kPhp = kPhp;
    }

    public String getkCat() {
        return kCat;
    }

    public void setkCat(String kCat) {
        this.kCat = kCat;
    }

    public String getkWords() {
        return kWords;
    }

    public void setkWords(String kWords) {
        this.kWords = kWords;
    }

    public int getkDebug() {
        return kDebug;
    }

    public void setkDebug(int kDebug) {
        this.kDebug = kDebug;
    }

    @Override
    public String toString() {
        return "GetOffersRequest [kSite=" + kSite + ", " + (kProtocol != null ? "kProtocol=" + kProtocol + ", " : "")
                + (kPage != null ? "kPage=" + kPage + ", " : "")
                + (kProdCount != null ? "kProdCount=" + kProdCount + ", " : "") + "kSort=" + kSort + ", kGroup="
                + kGroup + ", kOccasion=" + kOccasion + ", kPhp=" + kPhp + ", "
                + (kCat != null ? "kCat=" + kCat + ", " : "")
                + (kShop != null ? "kShop=" + kShop + ", " : "")
                + (kWords != null ? "kWords=" + kWords + ", " : "")
                + "kDebug=" + kDebug + "]";
    }

    public String getkShop() {
        return kShop;
    }

    public void setkShop(String kShop) {
        this.kShop = kShop;
    }

}
