package com.leguide.backoffice.karaf.dao.lgshop.mbean;

import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.dao.lgshop.impl.LgshopRefKSiteDaoImpl;
import com.leguide.backoffice.karaf.services.hazelcast.HazelcastService;

public class MbeanClearCacheServiceImpl extends StandardMBean implements IMbeanClearCacheService {

    private Logger logger = LoggerFactory.getLogger(MbeanClearCacheServiceImpl.class);
    private HazelcastService hazelcastService;

    public HazelcastService getHazelcastService() {
        return hazelcastService;
    }


    public void setHazelcastService(HazelcastService hazelcastService) {
        this.hazelcastService = hazelcastService;
    }


    public MbeanClearCacheServiceImpl() throws NotCompliantMBeanException {
        super(IMbeanClearCacheService.class);
    }

   
    public void clearCache() {
        ClassLoader old = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        logger.debug("clear cache " + LgshopRefKSiteDaoImpl.CACHE_ID);
        hazelcastService.getInstance().getMap(LgshopRefKSiteDaoImpl.CACHE_ID).clear();
        Thread.currentThread().setContextClassLoader(old);
    }

}
