package com.leguide.backoffice.karaf.bundle.dao.facade;

import java.util.List;
import java.util.Map;

import com.leguide.backoffice.karaf.business.models.pojo.integration.FeedFunction;
import com.leguide.backoffice.karaf.business.models.pojo.integration.FeedInfos;
import com.leguide.backoffice.karaf.business.models.pojo.integration.Source;

public interface FeedInfosDao {

	List<FeedInfos> getFeedInfos(Long languageId, Long idRefState, boolean onlyZeus);

	Map<String,String> getMappingForSourceId(Long sourceId, boolean isXml);

	String getXSLForSourceId(Long sourceId);

	List<FeedInfos> getFeedInfosForShopsiteId(Long shopsiteId);

	List<FeedFunction> getFeedfunctionForSourceId(Long sourceId);

    List<Source> getSourcesForShopsiteId(Long shopsiteId);

	String findFieldLabelById(Long fieldId);

	void createFeedKelkoo(FeedInfos feedInfos);
}
