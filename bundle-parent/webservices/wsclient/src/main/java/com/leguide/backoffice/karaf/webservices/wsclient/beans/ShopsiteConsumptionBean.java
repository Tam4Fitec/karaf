package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import com.leguide.backoffice.karaf.bundle.business.service.ShopSiteService;
import com.leguide.backoffice.karaf.business.models.pojo.consumption.ShopsiteConsumption;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopSiteState;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ReferentialStateEnum;

public class ShopsiteConsumptionBean {

    private ShopSiteService shopSiteService;

    public void updateShopsiteState(ShopsiteConsumption shopsiteConsumption) {
        ShopSiteState currentState = shopSiteService.getShopsiteState(shopsiteConsumption.getStoreUid());
        if (currentState.getReferentialState().getId().equals(ReferentialStateEnum.CAPPED.getId())) {
            shopSiteService.updateReferentialState(shopsiteConsumption.getStoreUid(), ReferentialStateEnum.NORMAL_CLIENT, "selfcare");
        }
    }

    public void setShopSiteService(ShopSiteService shopSiteService) {
        this.shopSiteService = shopSiteService;
    }
}
