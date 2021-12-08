package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteBlackAndWhiteList;

import java.util.List;
import java.util.Optional;

public interface LgshopShopsiteBlackAndWhiteListDao {

    List<LgshopShopsiteBlackAndWhiteList> findBLWLByShopSiteId(Long id);

    Optional<LgshopShopsiteBlackAndWhiteList> findForShopsiteAndKsite(Long shopsiteId, Integer refKsiteId);

    void addToList(Long shopsiteId, Integer refKsiteId, LgshopShopsiteBlackAndWhiteList.STATES state);

    void removeFromList(Long shopsiteId, Integer refKsiteId);
}
