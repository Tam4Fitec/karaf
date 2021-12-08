package com.leguide.backoffice.karaf.dao.lgshop.impl;

import com.hazelcast.core.IMap;
import com.leguide.backoffice.karaf.dao.lgshop.LgshopRefKSiteDao;
import com.leguide.backoffice.karaf.dao.lgshop.LgshopRefLanguageDao;
import com.leguide.backoffice.karaf.models.lgshop.referentiel.LgshopRefKSite;
import com.leguide.backoffice.karaf.models.lgshop.referentiel.LgshopRefKSiteLabel;
import com.leguide.backoffice.karaf.services.hazelcast.HazelcastService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
public class LgshopRefKSiteDaoImpl implements LgshopRefKSiteDao {
    private static final Logger logger = LoggerFactory.getLogger(LgshopRefKSiteDaoImpl.class);
    private static final String LANGUAGE_CACHE_ID = "LanguageIDReferenceMap";

    @PersistenceContext
    private EntityManager em;
    private HazelcastService hazelcastService;
    private LgshopRefLanguageDao languageDAO;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public LgshopRefKSiteDaoImpl() {
    }

    public LgshopRefKSiteDaoImpl(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    public Collection<LgshopRefKSite> findAllRefSites() {
        TypedQuery<LgshopRefKSite> query = em.createNamedQuery(LgshopRefKSite.FIND_ALL, LgshopRefKSite.class);
        logger.debug("findAllRefSites");
        return query.getResultList();
    }

    @Override
    public Collection<LgshopRefKSite> findAllByLocale(String locale) {
        Map<String, Integer> languageCache = hazelcastService.getInstance().getMap(LANGUAGE_CACHE_ID);
        if (languageCache.get(locale) == null) {
            logger.debug("loading from db for languageId for locale " + locale);
            languageCache.put(locale, languageDAO.findIdLanguageByCode(locale.split("_")[0]).orElse(99));
        }
        return findAllByLanguageId(languageCache.get(locale));
    }

    @Override
    public Collection<LgshopRefKSite> findAllByLanguageId(Integer languageId) {
        IMap<Integer, Map<Integer, LgshopRefKSite>> refKSitesCache = hazelcastService.getInstance().getMap(CACHE_ID);

        logger.debug("hazelcast ksite ref cache for " + languageId + " is " + refKSitesCache.get(languageId));
        logger.debug("hazelcast ksite ref cache for " + NO_LANGUAGE_ID + " is " + refKSitesCache.get(NO_LANGUAGE_ID));
        /*
         * the ksites list is a map: the key is the ksite PK, the value is the RefKSite object)
         * the cache key is the languageId
         *
         */
        // generic ksites without language
        Map<Integer, LgshopRefKSite> refKSitesNoLanguage = refKSitesCache.get(NO_LANGUAGE_ID);
        // ksites linked to the languageId passed in parameter
        Map<Integer, LgshopRefKSite> refKSites = refKSitesCache.get(languageId);

        //load generic ksite from DB is cache empty
        if (refKSitesNoLanguage == null) {
            logger.debug("loading from db for languageId 0 ");
            refKSitesNoLanguage = loadFromDBWithLocalizedValuesQueryZero();
            logger.debug("put in hazelcast for " + NO_LANGUAGE_ID + " : " + refKSitesNoLanguage);
            refKSitesCache.put(NO_LANGUAGE_ID, refKSitesNoLanguage, 1, TimeUnit.DAYS);
        }

        //load ksites for languageId  from DB if cache empty
        if (refKSites == null) {
            refKSites = loadFromDBWithLocalizedValuesQueryLanguage(languageId);
            //not put in cache here, as we first need to merge with refKSitesNoLanguage

            /*
             *  merge with refKSitesNoLanguage - use bit_index to know if the LgshopRefKSite from refKSites will
             *  override the one from refKSitesNoLanguage
             */
            //transform languageId Map to a new map <bit_index, refSite>
            Map<Integer, LgshopRefKSite> _bitIndexRefKSitesLanguageId = new HashMap<Integer, LgshopRefKSite>(refKSites.size());
            for (LgshopRefKSite site : refKSites.values()) {
                _bitIndexRefKSitesLanguageId.put(site.getFlagIndex(), site);
            }
            //for each element of  LanguageZero map, add it to languageId map if the bit_index is not already there
            for (LgshopRefKSite site : refKSitesNoLanguage.values()) {
                if (!_bitIndexRefKSitesLanguageId.containsKey(site.getFlagIndex())) {
                    logger.debug("add " + site + " to refKSites");
                    refKSites.put(site.getId(), site);
                }
            }

            //put the ksite list in cache
            logger.debug("put in hazelcast for " + languageId + " : " + refKSites);
            refKSitesCache.put(languageId, refKSites, 1, TimeUnit.DAYS);
        }

        return refKSites.values();
    }

    protected Map<Integer, LgshopRefKSite> loadFromDBWithLocalizedValuesQueryZero() {
        TypedQuery<LgshopRefKSite> queryZero = em.createNamedQuery(LgshopRefKSite.FIND_ALL_BY_ZERO_LANGUAGE, LgshopRefKSite.class);
        return loadFromDBWithLocalizedValues(queryZero);
    }

    protected Map<Integer, LgshopRefKSite> loadFromDBWithLocalizedValuesQueryLanguage(Integer languageId) {
        TypedQuery<LgshopRefKSite> queryLanguage = em.createNamedQuery(LgshopRefKSite.FIND_ALL_BY_LANGUAGE_ID, LgshopRefKSite.class);
        queryLanguage.setParameter(LgshopRefKSite.LANGUAGE_ID_PARAMETER, languageId);
        return loadFromDBWithLocalizedValues(queryLanguage);
    }

    /**
     * Execute the given query to load kRefSites from db, with localized labels
     *
     * @param jpaQuery
     * @return a map<ksite.id, ksite>
     */
    private Map<Integer, LgshopRefKSite> loadFromDBWithLocalizedValues(TypedQuery<LgshopRefKSite> jpaQuery) {
        Map<Integer, LgshopRefKSite> result = new HashMap<Integer, LgshopRefKSite>(64);
        for (LgshopRefKSite refSite : jpaQuery.getResultList()) {
            refSite.setLocalizedLabels(getLocalizedLabels(refSite.getId()));
            result.put(refSite.getId(), refSite);
        }
        return result;
    }

    private Map<Integer, String> getLocalizedLabels(Integer rfKsiteId) {
        TypedQuery<LgshopRefKSiteLabel> query = em.createNamedQuery(LgshopRefKSiteLabel.FIND_ALL_BY_RF_KSITE,
                LgshopRefKSiteLabel.class);
        query.setParameter("rfksiteid", rfKsiteId);
        //key is the internal country code, value is the localized label
        Map<Integer, String> localizedLabels = new HashMap<Integer, String>();
        for (LgshopRefKSiteLabel label : query.getResultList()) {
            localizedLabels.put(label.getKey().getCountryInternalNumber(), label.getKey().getLabel());
        }
        return localizedLabels;
    }

    public HazelcastService getHazelcastService() {
        return hazelcastService;
    }

    public void setHazelcastService(HazelcastService hazelcastService) {
        this.hazelcastService = hazelcastService;
    }

    public LgshopRefLanguageDao getLanguageDAO() {
        return languageDAO;
    }

    public void setLanguageDAO(LgshopRefLanguageDao languageDAO) {
        this.languageDAO = languageDAO;
    }
}
