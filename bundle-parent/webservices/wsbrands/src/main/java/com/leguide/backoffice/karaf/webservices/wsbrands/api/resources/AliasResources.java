package com.leguide.backoffice.karaf.webservices.wsbrands.api.resources;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllAliasesFilters;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.AliasesOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.adapters.ResourcesAliasOutAdapter;
import com.leguide.backoffice.karaf.webservices.wsbrands.business.IAliasService;
import com.leguide.backoffice.karaf.webservices.wsbrands.common.IPathConstants;

@Path("alias")
@Component
public class AliasResources {

    private static Logger logger = LoggerFactory.getLogger(AliasResources.class);

    @Autowired
    private IAliasService aliasServices;

    @Autowired
    private ResourcesAliasOutAdapter resourcesAliasOutAdapter;

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public AliasesOutWrapper getAllAliases(@QueryParam(IPathConstants.QUERY_PAGE) Integer page,
            @QueryParam(IPathConstants.QUERY_LIMIT) Integer limit,
            @QueryParam(IPathConstants.QUERY_FORCE) @DefaultValue(IPathConstants.DEFAULT_FORCE_PARAM) Boolean force) {

        GetAllAliasesFilters filters = new GetAllAliasesFilters();
        filters.setPage(page);
        filters.setLimit(limit);

        return this.getAllAliases(filters, force);
    }

    protected AliasesOutWrapper getAllAliases(GetAllAliasesFilters filters, Boolean force) {

        // proceed
        List<BrandAliasBO> resultList = this.aliasServices.getAllAliases(filters);
        AliasesOutWrapper result = this.resourcesAliasOutAdapter.adapt(resultList, force);
        result.setCount(resultList.size());
        result.setTotalCount(resultList.size());

        if (filters.getLimit() != null) {
            result.setTotalCount(this.aliasServices.countAliases());
        }

        logger.debug("exiting getAllAliases");
        return result;
    }

    public IAliasService getAliasServices() {
        return this.aliasServices;
    }

    public void setAliasServices(IAliasService aliasServices) {
        this.aliasServices = aliasServices;
    }

    public ResourcesAliasOutAdapter getResourcesAliasOutAdapter() {
        return this.resourcesAliasOutAdapter;
    }

    public void setResourcesAliasOutAdapter(ResourcesAliasOutAdapter resourcesAliasOutAdapter) {
        this.resourcesAliasOutAdapter = resourcesAliasOutAdapter;
    }
}
