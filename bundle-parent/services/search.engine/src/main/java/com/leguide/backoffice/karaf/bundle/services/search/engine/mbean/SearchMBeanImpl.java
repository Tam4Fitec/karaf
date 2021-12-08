package com.leguide.backoffice.karaf.bundle.services.search.engine.mbean;


import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;
import com.leguide.backoffice.karaf.bundle.services.search.engine.utils.ApplicationContextUtilsBean;

/**
 * SearchMBean implementation
 */
public class SearchMBeanImpl extends StandardMBean implements SearchMBean {

    public SearchMBeanImpl() throws NotCompliantMBeanException {
        super(SearchMBean.class);
    }

    @Override
    public long getOffersCount(int ksite, String country, Integer category, String words) {
        try {
            return ApplicationContextUtilsBean.getSearchEngineClient().getOffersCount(ksite, country, category, words);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public long getInfoMagOffersCount(int kSite, String country, Long shopId) {
        try {
            return ApplicationContextUtilsBean.getSearchEngineClient().getInfoMagOffersCount(kSite, country, shopId);
        } catch (Exception e) {
            return 0;
        }
    }

}
