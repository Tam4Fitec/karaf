package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteInternalNotification;

public interface LgshopShopsiteInternalNotificationDao {

    LgshopShopsiteInternalNotification findById(Long id);

    void update(LgshopShopsiteInternalNotification lgshopShopsiteInternalNotification);

    void create(LgshopShopsiteInternalNotification lgshopShopsiteInternalNotification);
}
