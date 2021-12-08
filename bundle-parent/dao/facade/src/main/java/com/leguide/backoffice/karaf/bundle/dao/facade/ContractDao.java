package com.leguide.backoffice.karaf.bundle.dao.facade;

import com.leguide.backoffice.karaf.business.models.pojo.contract.ContractState;
import com.leguide.backoffice.karaf.business.models.pojo.contract.LightContract;

import java.util.Optional;

public interface ContractDao {

    Optional<LightContract> getActiveContractCode(Long shopsiteId);

    boolean hasActiveContract(Long shopsiteId);

    boolean isContractSuspended(Long idMerchant);

    ContractState getContractState(Long idShopsite);
}
