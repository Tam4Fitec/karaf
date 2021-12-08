package com.leguide.backoffice.karaf.dao.brands.adapters;

import java.util.Map;
import java.util.Set;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.dao.brands.entity.AbstractDTO;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandAliasDTO;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandDTO;

public interface IBrandAdapter extends IAdapter<BrandBO, BrandDTO> {
	/**
	 * Adapt a brand dto to a brand bo
	 * @param brandDto to adapt
	 * @param addAliases true if the alias list shlould be added, false otherwise
	 * @return Brand BO
	 */
	BrandBO adapt(BrandDTO brandDto, Boolean addAliases);
	
	/**
	 * Adapt a list of Brand alias bo to brand alias dto
	 * @param tmpAlias list to adapt
	 * @param brandDto brand linked to alias list
	 * @return adapted list
	 */
	Set<BrandAliasDTO> adaptAliases(Set<BrandAliasBO> tmpAlias, BrandDTO brandDto);
	
	/**
	 * 
	 * @param dtoSet
	 * @return 
	 */
	Map<String, ? extends AbstractDTO> adapt(Set<? extends AbstractDTO> dtoSet);
}
