package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import com.leguide.backoffice.karaf.bundle.dao.facade.FeedInfosDao;
import com.leguide.backoffice.karaf.business.models.pojo.integration.Source;
import org.apache.camel.Header;

import java.util.List;

public class ShopsiteFeedsBean {

    private FeedInfosDao feedInfosDao;

    /**
     * Gets shopsite feeds
     *
     * @param shopsiteId shopsiteId
     * @return shopsite feeds
     * @throws Exception
     */
    public List<Source> getShopsiteFeeds(@Header("shopsiteId") Long shopsiteId) throws Exception {
        return feedInfosDao.getSourcesForShopsiteId(shopsiteId);
    }

    public void setFeedInfosDao(FeedInfosDao feedInfosDao) {
        this.feedInfosDao = feedInfosDao;
    }

}