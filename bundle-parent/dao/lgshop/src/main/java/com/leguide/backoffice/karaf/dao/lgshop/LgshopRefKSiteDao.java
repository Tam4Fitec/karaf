package com.leguide.backoffice.karaf.dao.lgshop;

import java.util.Collection;
import java.util.List;

import com.leguide.backoffice.karaf.models.lgshop.referentiel.LgshopRefKSite;

public interface LgshopRefKSiteDao {
    Integer NO_LANGUAGE_ID = 0;
    String CACHE_ID = "KSiteReferenceMap";
    /**
     * Find all ksite ref values. This method does not put them in a hazelcast cache.  It is recommanded to use instead
     * {@link LgshopRefKSiteDao#findAllByLanguageId(Integer)}
     * @return
     */
    Collection<LgshopRefKSite> findAllRefSites();

    /**
     * Find all ksite ref values by language id. This method puts them in a hazelcast cache for future use, with the
     * languageId as Key. As in DB the languageId can be null, gets first the list of refSite without languageId (0, this list
     * always exists), then replace objects with those providing the proper language Id
     * @param languageId
     * @return a list containing LgshopRefKSite linked to the provided languageId, or the row without it if not provided
     */
    Collection<LgshopRefKSite> findAllByLanguageId(Integer languageId);

    /**
     * Find all ksite ref values by locale. This method puts them in a hazelcast cache for future use, with the
     * languageId as Key. As in DB the languageId can be null, gets first the list of refSite without languageId (0, this list
     * always exists), then replace objects with those providing the proper language Id
     * @param locale xx_XX as in fr_FR
     * @return a list containing LgshopRefKSite linked to the provided languageId, or the row without it if not provided
     */
    Collection<LgshopRefKSite> findAllByLocale(String locale);
}
