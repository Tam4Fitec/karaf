package com.leguide.backoffice.karaf.dao.brands.adapters;

import java.util.List;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.dao.brands.entity.BrandAliasDTO;

public interface IBrandAliasAdapter extends IAdapter<BrandAliasBO, BrandAliasDTO> {
	BrandAliasBO adapt(BrandAliasDTO brandAliasDto, BrandBO brandBo);
	List<BrandAliasBO> adapt(List<BrandAliasDTO> listDto);
}
