package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LgshopShopsiteReportSubscriptionKey implements Serializable {

    private static final long serialVersionUID = 8628105056668307884L;

    @Column(name = "id_shopsite")
    private Long shopsiteId;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "report_type")
    private String reportType;

    @Column(name = "complementary")
    private String complementary;

    public LgshopShopsiteReportSubscriptionKey() {
    }

    public LgshopShopsiteReportSubscriptionKey(Long shopsiteId, String contactEmail, String reportType, String complementary) {
        this.shopsiteId = shopsiteId;
        this.contactEmail = contactEmail;
        this.reportType = reportType;
        this.complementary = complementary;
    }

    public Long getShopsiteId() {
        return shopsiteId;
    }

    public void setShopsiteId(Long shopsiteId) {
        this.shopsiteId = shopsiteId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getComplementary() {
        return complementary;
    }

    public void setComplementary(String complementary) {
        this.complementary = complementary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LgshopShopsiteReportSubscriptionKey that = (LgshopShopsiteReportSubscriptionKey) o;

        if (complementary != null ? !complementary.equals(that.complementary) : that.complementary != null) return false;
        if (contactEmail != null ? !contactEmail.equals(that.contactEmail) : that.contactEmail != null) return false;
        if (reportType != null ? !reportType.equals(that.reportType) : that.reportType != null) return false;
        if (shopsiteId != null ? !shopsiteId.equals(that.shopsiteId) : that.shopsiteId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shopsiteId != null ? shopsiteId.hashCode() : 0;
        result = 31 * result + (complementary != null ? complementary.hashCode() : 0);
        result = 31 * result + (contactEmail != null ? contactEmail.hashCode() : 0);
        result = 31 * result + (reportType != null ? reportType.hashCode() : 0);
        return result;
    }
}