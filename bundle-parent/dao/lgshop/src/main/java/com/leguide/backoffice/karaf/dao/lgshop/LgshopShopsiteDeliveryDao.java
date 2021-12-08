package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteDelivery;

public interface LgshopShopsiteDeliveryDao {

    LgshopShopsiteDelivery findById(Long id);

    void update(LgshopShopsiteDelivery lgshopShopsiteDelivery);

    void create(LgshopShopsiteDelivery lgshopShopsiteDelivery);
}
