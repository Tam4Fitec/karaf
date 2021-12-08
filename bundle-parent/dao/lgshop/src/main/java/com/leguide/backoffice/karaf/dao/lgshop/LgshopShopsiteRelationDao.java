package com.leguide.backoffice.karaf.dao.lgshop;

import java.util.List;

public interface LgshopShopsiteRelationDao {

    List<Integer> findIdsByShopsiteAndNamespace(Long idShopsite, String namespace);

    void createForShopsiteAndNamespace(List<Integer> ids, Long shopsiteId, String namespace);

    void deleteAllForShopsiteAndNamespace(Long shopsiteId, String namespace);
}
