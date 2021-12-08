package com.leguide.backoffice.karaf.bundle.dao.facade;

public interface ShopsiteBlackAndWhiteListDao {

    String findStateForShopsiteAndKsite(Long shopsiteId, Integer refKsiteId);

    void addToBlacklist(Long shopsiteId, Integer refKsiteId);

    void removeFromBlacklist(Long shopsiteId, Integer refKsiteId);
}
