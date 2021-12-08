package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.shopsite.LgshopShopsitePrivacyPolicy;

public interface LgshopShopsitePrivacyPolicyDao {

    LgshopShopsitePrivacyPolicy findById(Long id);

    void update(LgshopShopsitePrivacyPolicy lgshopShopsitePrivacyPolicy);

    void create(LgshopShopsitePrivacyPolicy lgshopShopsitePrivacyPolicy);
}
