package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.mbean;

import java.util.HashMap;
import java.util.Map;

import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;

import org.apache.camel.ProducerTemplate;

import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.utils.ApplicationContextUtilsBean;
import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.utils.Headers;

public class CatalogMBeanImpl extends StandardMBean implements CatalogMBean {

    public CatalogMBeanImpl() throws NotCompliantMBeanException {
        super(CatalogMBean.class);
    }

    public void getAndSaveCtg_online_count(Long idshopsite, int ksite) {
        ProducerTemplate tpl = ApplicationContextUtilsBean.getCamelContext().createProducerTemplate();
        Map<String, Object> headers = new HashMap<String, Object>(2);
        headers.put(Headers.SHOPSITE_ID, idshopsite);
        headers.put(Headers.KSITE, ksite);
        tpl.sendBodyAndHeaders("direct:getOffersByShopsiteId", null, headers);
    }

    public void getAndSaveCtg_online_countForAll(int ksite) {
        ProducerTemplate tpl = ApplicationContextUtilsBean.getCamelContext().createProducerTemplate();
        Map<String, Object> headers = new HashMap<String, Object>(2);
        headers.put(Headers.KSITE, ksite);
        tpl.sendBodyAndHeaders("seda:getOffers", null, headers);
    }
}
