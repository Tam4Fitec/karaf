package com.leguide.backoffice.karaf.dao.brands.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.dao.brands.IDAO;
import com.leguide.backoffice.karaf.dao.brands.adapters.IAdapter;
import com.leguide.backoffice.karaf.dao.brands.cache.AbstractCacheKey;
import com.leguide.backoffice.karaf.dao.brands.cache.ICacheService;
import com.leguide.backoffice.karaf.brands.common.business.model.AbstractBO;
import com.leguide.backoffice.karaf.dao.brands.entity.AbstractDTO;

public abstract class AbstractDAO<BO extends AbstractBO, DTO extends AbstractDTO> implements IDAO<BO, DTO> {


    private static Logger logger = LoggerFactory.getLogger(AbstractDAO.class);

    //cache will be : ? extends AbstractCacheKey as key, BrandBO as value
    protected ICacheService cacheService;

    @Override
    public final void flush() {
        this.getEm().flush();
    }

    public final void clear() {
        this.getEm().clear();
    }

    @Override
    public final BO persist(BO bo) {
        DTO dto = getAdapter().adapt(bo);
        this.getEm().persist(dto);
        return getAdapter().adapt(dto);
    }

    @Override
    public final void delete(Long id) {
        DTO dto = this.getEm().getReference(this.getPersistentClass(), id);
        this.getEm().remove(dto);
    }

    @Override
    public final BO merge(BO bo) {
        DTO dto = getAdapter().adapt(bo);
        BO res = getAdapter().adapt(this.getEm().merge(dto));
//        this.getEm().flush();
        return res;

    }

    @Override
    public final BO findById(Long id) {
        return getAdapter().adapt(this.getEm().find(this.getPersistentClass(), id));
    }

    @Override
    public final boolean isTransient(BO bo) {
        return this.getEm().contains(getAdapter().adapt(bo));
    }

    /**
     * A generic method to return the entity class used.
     *
     * @return the entity class
     */
    @SuppressWarnings("unchecked")
    protected Class<DTO> getPersistentClass() {
        Class<?> clazz = this.getClass();
        do {
            final Type type = clazz.getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                // no inspection unchecked
                // second class generic parameter (DTO parameter) is returned
                return (Class<DTO>) ((ParameterizedType) type).getActualTypeArguments()[1];
            }
            clazz = clazz.getSuperclass();
        } while (clazz != null);
        return null;
    }

    public abstract EntityManager getEm() ;

    public abstract void setEm(EntityManager em);

    public abstract IAdapter<BO, DTO> getAdapter();

    protected <V extends AbstractBO, K extends AbstractCacheKey> V getFromCacheById(K key) {
        logger.debug("getFromCache " + ICacheService.CACHE_BY_ID + ", key : " + key);
        return cacheService.getFromCacheById(key);
    }

    protected <V extends AbstractBO, K extends AbstractCacheKey> void putInCacheById(K key, V value) {
        logger.debug("putInCacheById " + ICacheService.CACHE_BY_ID + ", key : " + key + ", value : " + value);
        cacheService.putInCacheById(key, value);
    }

    protected <V extends AbstractBO, K extends AbstractCacheKey> List<V> getFromCacheByName(K key) {
        logger.debug("getFromCache " + ICacheService.CACHE_BY_NAME + ", key : " + key);
        return cacheService.getFromCacheByName(key);
    }

    protected <V extends AbstractBO, K extends AbstractCacheKey> void putInCacheByName(K key, List<V> value) {
        logger.debug("putInCacheByName " + ICacheService.CACHE_BY_NAME + ", key : " + key + ", value : " + value);
        cacheService.putInCacheByName(key, value);
    }

    protected void clearCaches() {
        logger.debug("clear caches");
        cacheService.clearCaches();
    }
}
