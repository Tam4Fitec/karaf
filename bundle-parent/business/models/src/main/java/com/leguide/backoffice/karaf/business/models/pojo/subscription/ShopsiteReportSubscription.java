package com.leguide.backoffice.karaf.business.models.pojo.subscription;

public class ShopsiteReportSubscription {

    public enum ReportType {
        STATSCLICKS, PURCHASE, PRICING_MATCHING, PRICING_GATHERING
    }

    private Long shopsiteId;

    private String contactEmail;

    private String period;

    private Integer minuteOfDay;

    private String day;

    private ReportType reportType;

    private String complementary;

    public ShopsiteReportSubscription() {
    }

    public ShopsiteReportSubscription(Long shopsiteId, String contactEmail, String period, ReportType reportType, String complementary) {
        this.shopsiteId = shopsiteId;
        this.contactEmail = contactEmail;
        this.period = period;
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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Integer getMinuteOfDay() {
        return minuteOfDay;
    }

    public void setMinuteOfDay(Integer minuteOfDay) {
        this.minuteOfDay = minuteOfDay;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public String getComplementary() {
        return complementary;
    }

    public void setComplementary(String complementary) {
        this.complementary = complementary;
    }

    @Override
    public String toString() {
        return "ShopsiteReportSubscription{" +
                "shopsiteId=" + shopsiteId +
                ", contactEmail='" + contactEmail + '\'' +
                ", period='" + period + '\'' +
                ", minuteOfDay=" + minuteOfDay +
                ", day='" + day + '\'' +
                ", reportType=" + reportType +
                ", complementary='" + complementary + '\'' +
                '}';
    }
}
