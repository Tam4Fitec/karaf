package com.leguide.backoffice.karaf.models.lgshop.shopsite;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_shopsite_report_subscription")
@NamedQueries({
        @NamedQuery(name = LgshopShopsiteReportSubscription.FIND_SHOPSITE_SUBSCRIPTIONS_DAY_BETWEEN,
                query = "SELECT rs FROM LgshopShopsiteReportSubscription rs WHERE rs.period = 'day' " +
                        "AND rs.minuteOfDay BETWEEN :begin AND :end"),
        @NamedQuery(name = LgshopShopsiteReportSubscription.FIND_SHOPSITE_SUBSCRIPTIONS_WEEK_BETWEEN,
                query = "SELECT rs FROM LgshopShopsiteReportSubscription rs WHERE rs.period = 'week' " +
                        "AND rs.day = :day AND rs.minuteOfDay BETWEEN :begin AND :end")
})
public class LgshopShopsiteReportSubscription implements Serializable {

    private static final long serialVersionUID = -1033099902341096316L;

    public static final String FIND_SHOPSITE_SUBSCRIPTIONS_DAY_BETWEEN = "LgshopShopsiteReportSubscription.findShopsiteSubscriptionsDayBetween";

    public static final String FIND_SHOPSITE_SUBSCRIPTIONS_WEEK_BETWEEN = "LgshopShopsiteReportSubscription.findShopsiteSubscriptionsWeekBetween";

    @EmbeddedId
    private LgshopShopsiteReportSubscriptionKey key;

    @Column(name = "period")
    private String period;

    @Column(name = "minute_of_day")
    private Integer minuteOfDay;

    @Column(name = "day")
    private String day;

    public LgshopShopsiteReportSubscriptionKey getKey() {
        return key;
    }

    public void setKey(LgshopShopsiteReportSubscriptionKey key) {
        this.key = key;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LgshopShopsiteReportSubscription that = (LgshopShopsiteReportSubscription) o;

        if (day != null ? !day.equals(that.day) : that.day != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (minuteOfDay != null ? !minuteOfDay.equals(that.minuteOfDay) : that.minuteOfDay != null) return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (minuteOfDay != null ? minuteOfDay.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        return result;
    }
}
