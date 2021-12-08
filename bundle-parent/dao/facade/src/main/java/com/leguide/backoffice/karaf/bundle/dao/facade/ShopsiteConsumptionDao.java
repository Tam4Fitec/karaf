package com.leguide.backoffice.karaf.bundle.dao.facade;

import com.leguide.backoffice.karaf.business.models.pojo.consumption.ShopsiteConsumption;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * ShopsiteConsumptionDao interface
 */
public interface ShopsiteConsumptionDao {

    Optional<ShopsiteConsumption> findByStoreAtDate(Long storeUid, Date date);

    List<ShopsiteConsumption> findByStoreFromDate(Long storeUid, Date date);

    void update(ShopsiteConsumption csc);
}
