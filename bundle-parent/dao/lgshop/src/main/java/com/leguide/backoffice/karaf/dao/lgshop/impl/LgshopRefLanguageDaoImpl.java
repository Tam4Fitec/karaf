package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.leguide.backoffice.karaf.dao.lgshop.LgshopRefLanguageDao;
import com.leguide.backoffice.karaf.models.lgshop.referentiel.LgshopRefLanguage;
import com.leguide.backoffice.karaf.services.hazelcast.HazelcastService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.Optional;

@Repository
public class LgshopRefLanguageDaoImpl implements LgshopRefLanguageDao {

    private HazelcastService hazelcastService;

    @PersistenceContext
    private EntityManager em;


    public LgshopRefLanguageDaoImpl() {

    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public String findLocaleByLanguageIdAndCountryId(Integer languageId, Integer countryId) {
        String result;
        Map<String, String> localeCache = hazelcastService.getInstance().getMap("LgShopLocaleByLangIdAndCountry");
        String key = buildLocaleCacheKey(languageId, countryId);
        if (!localeCache.containsKey(key)) {
            result = findLocaleByLanguageIdAndCountryIdQuery(languageId, countryId);
            if (result != null) {
                localeCache.put(key, result);
            }
        } else {
            result = localeCache.get(key);
        }
        return result;
    }

    protected String findLocaleByLanguageIdAndCountryIdQuery(Integer languageId, Integer countryId) {
        TypedQuery<String> query = em.createNamedQuery(LgshopRefLanguage.FIND_LOCALE_BY_LANG_ID_AND_COUNTRY_ID, String.class);
        query.setParameter(1, countryId);
        query.setParameter(2, languageId);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public Integer findIdLanguageByCountry(Integer countryId) {
        TypedQuery<Number> query = em.createNamedQuery(LgshopRefLanguage.FIND_ID_LANGUAGE_BY_COUNTRY_ID, Number.class);
        query.setParameter(1, countryId);
        return query.getResultList().stream().findFirst().map(Number::intValue).orElse(null);
    }

    @Override
    public Optional<String> findLanguageByLanguageIdAndCountryId(Integer languageId, Integer countryId) {
        TypedQuery<String> query = em.createNamedQuery(LgshopRefLanguage.FIND_LANGUAGE_BY_LANG_ID_AND_COUNTRY_ID, String.class);
        query.setParameter(1, languageId);
        query.setParameter(2, countryId);
        return query.getResultList().stream().findFirst();
    }


    @Override
    public Optional<Integer> findIdLanguageByCode(String language) {
        TypedQuery<Number> query = em.createNamedQuery(LgshopRefLanguage.FIND_ID_LANGUAGE_BY_CODE, Number.class);
        query.setParameter(1, language);
        return query.getResultList().stream().map(Number::intValue).findFirst();
    }

    @Override
    public Optional<String> findLocaleByLanguageIdAndCountryAlpha2(Integer languageId, String countryAlpha2) {
        TypedQuery<String> query = em.createNamedQuery(LgshopRefLanguage.FIND_LOCALE_BY_LANG_ID_AND_COUNTRY_ALPHA2, String.class);
        query.setParameter(1, languageId);
        query.setParameter(2, countryAlpha2);
        return query.getResultList().stream().findFirst();
    }

    private String buildLocaleCacheKey(Integer languageId, Integer countryId) {
        return languageId + "@" + countryId;
    }

    public HazelcastService getHazelcastService() {
        return hazelcastService;
    }

    public void setHazelcastService(HazelcastService hazelcastService) {
        this.hazelcastService = hazelcastService;
    }
}
