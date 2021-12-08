package com.leguide.backoffice.karaf.dao.lgintegration;

import java.util.List;

import com.leguide.backoffice.karaf.models.lgintegration.custom.FeedFunctionDTO;

public interface SourceFunctionDao {

	/**
	 *
	 * @param sourceId
	 * @return
	 */
    List<FeedFunctionDTO> getFeedfunctionForSourceId(Long sourceId);

}
