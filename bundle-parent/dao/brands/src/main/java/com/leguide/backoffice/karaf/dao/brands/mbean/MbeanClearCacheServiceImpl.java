package com.leguide.backoffice.karaf.dao.brands.mbean;

import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.dao.brands.cache.ICacheService;

public class MbeanClearCacheServiceImpl extends StandardMBean implements IMbeanClearCacheService {

    private Logger logger = LoggerFactory.getLogger(MbeanClearCacheServiceImpl.class);

    public MbeanClearCacheServiceImpl() throws NotCompliantMBeanException {
        super(IMbeanClearCacheService.class);
    }

    private ICacheService cacheService;

    public void clearCaches() {
        cacheService.clearCaches();
    }

    public ICacheService getCacheService() {
        return cacheService;
    }

    public void setCacheService(ICacheService cacheService) {
        this.cacheService = cacheService;
    }

}
