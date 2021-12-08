package com.leguide.backoffice.karaf.bundle.dao.facade;

import java.util.List;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.ShopSite;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopSiteState;

public interface ShopSiteDao {

    ShopSite findById(Long id, ShopsiteQuery query);

    Long create(ShopSite shopSite);

    void updateShopSiteState(Long idMerchant, ShopSiteState state, String user);

    void update(ShopSite shopSite, ShopsiteQuery query);

    ShopSiteState findStateOfShopSite(Long ShopSiteId);
    
    List<Long> findListShopIdByLanguageAndRefState(Long languageId, Long idRefState);
    
    void create(ShopSite shopSite, ShopsiteQuery query);

	List<ShopSite> findListShopsiteOfAccount(Long accountId, ShopsiteQuery query);

    void createShopMapping(Long comId, Long shopId, String name,String languague, String locale);

    String retrieveLocale(Long shopsiteId);

}
