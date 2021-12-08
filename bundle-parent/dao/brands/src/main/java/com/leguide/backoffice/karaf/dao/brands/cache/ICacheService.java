package com.leguide.backoffice.karaf.dao.brands.cache;

import java.util.List;

import com.leguide.backoffice.karaf.brands.common.business.model.AbstractBO;

public interface ICacheService {

    String CACHE_BY_ID = "brandsBOCacheId";
    String CACHE_BY_NAME = "brandsBOCacheName";

    void clearCaches();

    <V extends AbstractBO, K extends AbstractCacheKey> V getFromCacheById(K key);

    <V extends AbstractBO, K extends AbstractCacheKey> void putInCacheById(K key, V value);

    <V extends AbstractBO, K extends AbstractCacheKey> List<V> getFromCacheByName(K key);

    <V extends AbstractBO, K extends AbstractCacheKey> void putInCacheByName(K key, List<V> value);
}
