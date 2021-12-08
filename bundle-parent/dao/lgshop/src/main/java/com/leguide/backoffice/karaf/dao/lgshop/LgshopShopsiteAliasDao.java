package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsiteAlias;

public interface LgshopShopsiteAliasDao {

    LgshopShopsiteAlias findById(Long id);

    void create(LgshopShopsiteAlias lgshopShopsiteAlias);

    void update(LgshopShopsiteAlias lgshopShopsiteAlias);
}
