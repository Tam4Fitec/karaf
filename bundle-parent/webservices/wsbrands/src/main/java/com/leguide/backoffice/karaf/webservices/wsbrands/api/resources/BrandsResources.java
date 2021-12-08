package com.leguide.backoffice.karaf.webservices.wsbrands.api.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.exception.BadRequestException;
import com.leguide.backoffice.karaf.brands.common.exception.ErrorCodes;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllBrandsFilters;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.brands.common.utils.enums.BlacklistTypeEnum;
import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandsListInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.BrandIntegrationOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.BrandOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.BrandsOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.adapters.ResourcesInAdapter;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.adapters.ResourcesOutAdapter;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.param.DateParam;
import com.leguide.backoffice.karaf.webservices.wsbrands.business.IBrandsService;
import com.leguide.backoffice.karaf.webservices.wsbrands.common.IPathConstants;

@Path("brands")
@Component
public class BrandsResources {

    private static Logger logger = LoggerFactory.getLogger(BrandsResources.class);

    @Autowired
    private IBrandsService brandServices;

    @Autowired
    private ResourcesInAdapter resourcesInAdapter;

    @Autowired
    private ResourcesOutAdapter resourcesOutAdapter;

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public BrandsOutWrapper getAllBrands(
            @QueryParam(IPathConstants.QUERY_ALIAS) @DefaultValue(IPathConstants.DEFAULT_ALIAS_PARAM) Boolean addAlias,
            @QueryParam(IPathConstants.QUERY_PAGE) Integer page, @QueryParam(IPathConstants.QUERY_LIMIT) Integer limit,
            @QueryParam(IPathConstants.QUERY_FORCE) @DefaultValue(IPathConstants.DEFAULT_FORCE_PARAM) Boolean force) {

        GetAllBrandsFilters filters = new GetAllBrandsFilters();
        filters.setAddAliases(addAlias);
        filters.setPage(page);
        filters.setLimit(limit);

        return this.getAllBrands(filters, force);
    }


    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/id/{" + IPathConstants.PARAM_BRAND_ID + ":[0-9]*}")
    public BrandOutWrapper getBrandById(@PathParam(IPathConstants.PARAM_BRAND_ID) Long brandId,
            @QueryParam(IPathConstants.QUERY_ALIAS) @DefaultValue(IPathConstants.DEFAULT_ALIAS_PARAM) Boolean addAlias,
            @HeaderParam("cache-control") String cacheControl, @HeaderParam("pragma") String pragma) {

        logger.debug("looking up for brandId:" + brandId);
        logger.debug("cacheControl = " + cacheControl + ", Pragma = " + pragma);
        boolean useCache = true;
        if (!StringUtils.isEmpty(cacheControl) || !StringUtils.isEmpty(pragma)) {
            useCache = false;
        }
        return this.lookupBrand(brandId, addAlias, useCache);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/ids/{" + IPathConstants.PARAM_BRAND_IDS_LIST + "}")
    public BrandsOutWrapper getBrandByIds(
            @PathParam(IPathConstants.PARAM_BRAND_IDS_LIST) @DefaultValue("") String idList,
            @QueryParam(IPathConstants.QUERY_ALIAS) @DefaultValue(IPathConstants.DEFAULT_ALIAS_PARAM) Boolean addAlias,
            @HeaderParam("cache-control") String cacheControl, @HeaderParam("pragma") String pragma) {

        logger.debug("looking up for ids: " + idList);
        logger.debug("cacheControl = " + cacheControl + ", Pragma = " + pragma);
        boolean useCache = true;
        if (!StringUtils.isEmpty(cacheControl) || !StringUtils.isEmpty(pragma)) {
            useCache = false;
        }
        //parse tokenize ids
        List<Long> ids = new ArrayList<Long>(10);
        for (String s: idList.split(",")) {
            try {
                ids.add(Long.valueOf(s));
            } catch (NumberFormatException e) {
                throw new BadRequestException(ErrorCodes.ERR006);
            }
        }

        List<BrandBO> brandList = this.brandServices.getBrandsByIds(ids, addAlias, useCache);
        BrandsOutWrapper result = this.resourcesOutAdapter.adapt(brandList);

        logger.debug("exiting lookupBrand");
        return result;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/name/{" + IPathConstants.PARAM_BRAND_NAME + "}")
    public BrandsOutWrapper getBrandByName(
            @PathParam(IPathConstants.PARAM_BRAND_NAME) String brandName,
            @QueryParam(IPathConstants.QUERY_TYPE) String type,
            @QueryParam(IPathConstants.QUERY_ALIAS) @DefaultValue(IPathConstants.DEFAULT_ALIAS_PARAM) Boolean addAlias,
            @QueryParam(IPathConstants.QUERY_USE_SEO_NAME) @DefaultValue(IPathConstants.DEFAULT_USE_SEO_NAME_PARAM) Boolean includeSeoName,
            @HeaderParam("cache-control") String cacheControl, @HeaderParam("pragma") String pragma) {

        logger.debug("looking up for brandName:" + brandName);
        logger.debug("cacheControl = " + cacheControl + ", Pragma = " + pragma);
        boolean useCache = true;
        if (!StringUtils.isEmpty(cacheControl) || !StringUtils.isEmpty(pragma)) {
            useCache = false;
        }
        SearchBrandsTypeEnum _type = null;
        
        // type initialization
        if (StringUtils.isEmpty(type)) {
            _type = SearchBrandsTypeEnum.EXACT;
        } else {
            try {
                _type = SearchBrandsTypeEnum.fromValue(type);
            } catch (IllegalArgumentException e) {
                throw new BadRequestException("Parameter " + type + " is not valid.");
            }
        }

        GetBrandsByNameFilters filters = new GetBrandsByNameFilters();
        filters.setName(brandName);
        filters.setType(_type);

        // Special case: match is made on alias name. addAlias must be true.
        switch (_type) {
        case EXACT_ALIAS:
        case LARGE_ALIAS:
        case LARGE_ALIAS_SPLIT:
        case EXTRA_LARGE_ALIAS:
        case EXTRA_LARGE_ALIAS_SPLIT:
        case EXACT_BRAND_OR_ALIAS:
            addAlias = true;
            break;
        }

        filters.setAddAliases(addAlias);
        filters.setIncludeSeoName(includeSeoName);

        return this.lookupBrand(filters, useCache);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/normalizedName/{" + IPathConstants.PARAM_BRAND_NAME + "}")
    public BrandsOutWrapper getBrandByNormalizedName(@PathParam(IPathConstants.PARAM_BRAND_NAME) String brandName,
            @QueryParam(IPathConstants.QUERY_TYPE) String type,
            @QueryParam(IPathConstants.QUERY_ALIAS) @DefaultValue(IPathConstants.DEFAULT_ALIAS_PARAM) Boolean addAlias,
            @HeaderParam("cache-control") String cacheControl,
            @HeaderParam("pragma") String pragma) {
        logger.debug("looking up for brandNormalizedName:" + brandName);
        logger.debug("cacheControl = " + cacheControl + ", Pragma = " + pragma);
        boolean usecache = true;
        if (!StringUtils.isEmpty(cacheControl) || !StringUtils.isEmpty(pragma)) {
            usecache = false;
        }

        // type initialization
        SearchBrandsTypeEnum _type = null;
        if (StringUtils.isEmpty(type)) {
            _type = SearchBrandsTypeEnum.EXACT;
        } else {
            try {
                _type = SearchBrandsTypeEnum.fromValue(type);
            } catch (IllegalArgumentException e) {
                throw new BadRequestException("Parameter " + type + " is not valid.");
            }
        }

        GetBrandsByNameFilters filters = new GetBrandsByNameFilters();
        filters.setName(brandName);
        filters.setType(_type);
     // Special case: match is made on alias name. addAlias must be true.
        switch (_type) {
        case EXACT_ALIAS:
        case LARGE_ALIAS:
        case LARGE_ALIAS_SPLIT:
        case EXTRA_LARGE_ALIAS:
        case EXTRA_LARGE_ALIAS_SPLIT:
        case EXACT_BRAND_OR_ALIAS:
            addAlias = true;
            break;
        }
        filters.setAddAliases(addAlias);
        filters.setIncludeSeoName(false);
        return this.lookupNormalizedBrand(filters, usecache);
    }

    @PUT
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/{" + IPathConstants.PARAM_BRAND_NAME + "}")
    public void putbrand(@PathParam(IPathConstants.PARAM_BRAND_NAME) String brandName,
            @QueryParam(IPathConstants.QUERY_ACTIVATION_DATE) String activationDate) {
        logger.debug("putting a new brand:" + brandName);

        BrandBO brandBo = new BrandBO();
        brandBo.setName(brandName);
        if (!StringUtils.isEmpty(activationDate)) {
            DateParam _activationDate = new DateParam(activationDate); 
            brandBo.setActivationDate(_activationDate.getValue());
        }

        this.brandServices.insertBrand(brandBo);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    //@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public void importBrands(BrandsListInWrapper brandsList) {

        this.brandServices.saveBrands(this.resourcesInAdapter.adapt(brandsList));
    }

    @PUT
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/" + IPathConstants.PATH_BLACKLIST + "/" + IPathConstants.PATH_ID + "/{" + IPathConstants.PARAM_TMP_BRAND_ID
            + ":[0-9]*}")
    public void blacklistBrand(@PathParam(IPathConstants.PARAM_TMP_BRAND_ID) Long tmpBrandId,
            @QueryParam(IPathConstants.QUERY_TYPE) BlacklistTypeEnum type) {

        // type initialization
        if (type == null) {
            type = BlacklistTypeEnum.ALL;
        }

        this.brandServices.blacklistBrand(tmpBrandId, type);
    }

    @PUT
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/" + IPathConstants.PATH_UNBLACKLIST + "/" + IPathConstants.PATH_ID + "/{"
            + IPathConstants.PARAM_TMP_BRAND_ID + ":[0-9]*}")
    public void unblacklistBrand(@PathParam(IPathConstants.PARAM_TMP_BRAND_ID) Long tmpBrandId,
            @QueryParam(IPathConstants.QUERY_TYPE) BlacklistTypeEnum type) {

        // type initialization
        if (type == null) {
            type = BlacklistTypeEnum.ALL;
        }

        this.brandServices.unblacklistBrand(tmpBrandId, type);
    }

    @PUT
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/" + IPathConstants.PATH_ID + "/{" + IPathConstants.PARAM_BRAND_ID + ":[0-9]*}/"
            + IPathConstants.PATH_SEONAME + "/{" + IPathConstants.PARAM_BRAND_NAME + "}")
    public void setSeoName(@PathParam(IPathConstants.PARAM_BRAND_ID) Long brandId,
            @PathParam(IPathConstants.PARAM_BRAND_NAME) String name) {
        this.brandServices.setSeoName(name, brandId);
    }

    @PUT
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/" + IPathConstants.PATH_ID + "/{" + IPathConstants.PARAM_BRAND_ID + ":[0-9]*}/"
            + IPathConstants.PATH_RESETSEONAME)
    public void resetSeoName(@PathParam(IPathConstants.PARAM_BRAND_ID) Long brandId) {
        this.brandServices.setSeoName(null, brandId);
    }

    private BrandsOutWrapper getAllBrands(GetAllBrandsFilters filters, Boolean force) {

        // proceed
        List<BrandBO> resultList = this.brandServices.getAllBrands(filters);
        BrandsOutWrapper result = this.resourcesOutAdapter.adapt(resultList, force);
        result.setCount(resultList.size());
        result.setTotalCount(resultList.size());

        if (filters.getLimit() != null) {
            result.setTotalCount(this.brandServices.countBrands());
        }

        logger.debug("exiting lookupBrands");
        return result;
    }

    private BrandOutWrapper lookupBrand(Long brandId, Boolean addAlias, boolean useCache) {

        BrandOutWrapper result = new BrandOutWrapper();

        // proceed
        BrandBO brand = this.brandServices.getBrandbyId(brandId, addAlias, useCache);
        result = this.resourcesOutAdapter.adapt(brand);

        logger.debug("exiting lookupBrand");
        return result;
    }

    private BrandsOutWrapper lookupBrand(GetBrandsByNameFilters filters, boolean useCache) {

        // proceed
        List<BrandBO> brandList = this.brandServices.getBrandsByName(filters, useCache);
        BrandsOutWrapper result = this.resourcesOutAdapter.adapt(brandList);

        logger.debug("exiting lookupBrand");
        return result;
    }

    private BrandsOutWrapper lookupNormalizedBrand(GetBrandsByNameFilters filters, boolean useCache) {
        // proceed
        List<BrandBO> brandList = this.brandServices.getBrandsByNormalizedName(filters, useCache);
        BrandsOutWrapper result = this.resourcesOutAdapter.adapt(brandList);
        logger.debug("exiting lookupNormalizedBrand");
        return result;
    }

    public IBrandsService getBrandServices() {
        return this.brandServices;
    }

    public void setBrandServices(IBrandsService brandServices) {
        this.brandServices = brandServices;
    }

    public ResourcesInAdapter getResourcesInAdapter() {
        return this.resourcesInAdapter;
    }

    public void setResourcesInAdapter(ResourcesInAdapter resourcesInAdapter) {
        this.resourcesInAdapter = resourcesInAdapter;
    }

    public ResourcesOutAdapter getResourcesOutAdapter() {
        return this.resourcesOutAdapter;
    }

    public void setResourcesOutAdapter(ResourcesOutAdapter resourcesOutAdapter) {
        this.resourcesOutAdapter = resourcesOutAdapter;
    }
}
