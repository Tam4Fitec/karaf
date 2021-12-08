package com.leguide.backoffice.karaf.bundle.dao.facade;

import java.util.List;

import com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist.BlackIP;
import com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist.BlackIPOnShopsite;

public interface ClickDao {

	List<BlackIP> getIPsBlackListed();

	List<BlackIPOnShopsite> getBlackListedIPsOnShopsite();

}
