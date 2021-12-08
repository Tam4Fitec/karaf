package com.leguide.backoffice.karaf.dao.lgbase;

import java.util.Date;
import java.util.List;

import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseContractStorePricing;

public interface LgbaseContractStorePricingDao {

	List<LgbaseContractStorePricing> getLastPricingContracts(String clientId, Date from);

}
