package com.leguide.backoffice.karaf.dao.brands.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hazelcast.core.IMap;
import com.leguide.backoffice.karaf.brands.common.business.model.AbstractBO;
import com.leguide.backoffice.karaf.services.hazelcast.HazelcastService;

public class CacheServiceImpl implements ICacheService {

    private Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);

    private HazelcastService hazelcastService;

    public void clearCaches() {
        ClassLoader old = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        logger.debug("clear cache " + CACHE_BY_ID);
        hazelcastService.getInstance().getMap(CACHE_BY_ID).clear();
        logger.debug("clear cache " + CACHE_BY_NAME);
        hazelcastService.getInstance().getMap(CACHE_BY_NAME).clear();
        Thread.currentThread().setContextClassLoader(old);
    }

    public <V extends AbstractBO, K extends AbstractCacheKey> V getFromCacheById(K key) {
        IMap<K, V> cache = hazelcastService.getInstance().getMap(CACHE_BY_ID);
        logger.debug("getFromCache " + CACHE_BY_ID + ", key : " + key);
        return cache.get(key);
    }

    public <V extends AbstractBO, K extends AbstractCacheKey> void putInCacheById(K key, V value) {
        IMap<K, V> cache = hazelcastService.getInstance().getMap(CACHE_BY_ID);
        logger.debug("putInCacheById " + CACHE_BY_ID + ", key : " + key + ", value : " + value);
        cache.put(key, value);
    }

    public <V extends AbstractBO, K extends AbstractCacheKey> List<V> getFromCacheByName(K key) {
        IMap<K, List<V>> cache = hazelcastService.getInstance().getMap(CACHE_BY_NAME);
        logger.debug("getFromCache " + CACHE_BY_NAME + ", key : " + key);
        return cache.get(key);
    }

    public <V extends AbstractBO, K extends AbstractCacheKey> void putInCacheByName(K key, List<V> value) {
        IMap<K, List<V>> cache = hazelcastService.getInstance().getMap(CACHE_BY_NAME);
        logger.debug("putInCacheByName " + CACHE_BY_NAME + ", key : " + key + ", value : " + value);
        cache.put(key, value);
    }

    public HazelcastService getHazelcastService() {
        return hazelcastService;
    }

    public void setHazelcastService(HazelcastService hazelcastService) {
        this.hazelcastService = hazelcastService;
    }
}
