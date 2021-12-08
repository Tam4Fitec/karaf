package com.leguide.backoffice.karaf.dao.lgbase;

import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseContractStoreConsumption;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LgbaseContractStoreConsumptionDao {

    Optional<LgbaseContractStoreConsumption> findByStoreAtDate(Long storeUid, Date now);

    List<LgbaseContractStoreConsumption> findByStoreFromDate(Long storeUid, Date now);

    void update(LgbaseContractStoreConsumption csc);
}
