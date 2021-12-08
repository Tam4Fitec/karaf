package com.leguide.backoffice.karaf.dao.brands.adapters;

import com.leguide.backoffice.karaf.brands.common.business.model.AbstractBO;
import com.leguide.backoffice.karaf.dao.brands.entity.AbstractDTO;

public interface IAdapter<BO extends AbstractBO, DTO extends AbstractDTO> {
	
	BO adapt(DTO dto);
	DTO adapt(BO bo);
}
