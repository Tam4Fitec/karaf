package com.leguide.backoffice.karaf.dao.lgintegration;

import java.util.List;
import java.util.Map;

import com.leguide.backoffice.karaf.models.lgintegration.catalog.SourceDTO;
import com.leguide.backoffice.karaf.models.lgintegration.catalog.SourceFormatDTO;
import com.leguide.backoffice.karaf.models.lgintegration.custom.FeedInfosDTO;

public interface SourceDao {

	/**
	 *  Retrieve Feedsinfos by language and  Refstate
	 * @param languageId
	 * @param idRefState
	 * @param onlyZeus if true, only zeus merchant are included.
	 * @return
	 */
    List<FeedInfosDTO> getFeedInfos(Long languageId, Long idRefState, boolean onlyZeus);

	/**
	 * Retrieve the mapping text for a source.
	 * @param sourceId
	 * @return
	 */
    Map<String,String> getTextMappingForSourceId(Long sourceId);

	/**
	 * Retrieve the mapping xml for a source.
	 * @param sourceId
	 * @return
	 */
    Map<String, String> getXMLMappingForSourceId(Long sourceId);

	/**
	 *
	 * @param sourceId
	 * @return
	 */
    String getXSLForSourceId(Long sourceId);

	/**
	 *
	 * @param shopsiteId
	 * @return
	 */
    List<FeedInfosDTO> getFeedInfosForShopsiteId(Long shopsiteId);

    /**
     * Get sources for shopsite id
     * @param shopsiteId shopsite id
     * @return sources
     */
    List<SourceDTO> getSourcesForShopsiteId(Long shopsiteId);

	/**
	 * Create source
	 * @param sourceDTO
     */
	void createSource(SourceDTO sourceDTO);

	/**
	 *
	 * @param sourceId
	 * @param typeFormatId
     * @return
     */
	Boolean createFieldsAssoc(Long sourceId, Long typeFormatId);

	/**
	 *
	 * @param country
	 * @param name
     * @return
     */
	SourceFormatDTO getSourceFormat(String country, String name);



}
