package com.leguide.backoffice.karaf.webservices.wsbrands.api.ressources;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXB;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.exception.NotFoundException;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllBrandsFilters;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.BrandOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.out.BrandsOutWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.BrandsResources;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.adapters.ResourcesOutAdapter;
import com.leguide.backoffice.karaf.webservices.wsbrands.business.IBrandsService;

@Ignore
public class BrandsResourcesTest {

    private BrandsResources brandsResource;
    private IBrandsService business;

    @Before
    public void setUp() {
        this.brandsResource = new BrandsResources();
        this.business = mock(IBrandsService.class);
        this.brandsResource.setBrandServices(this.business);
        this.brandsResource.setResourcesOutAdapter(new ResourcesOutAdapter());
    }

    @Test
    public void testGetAllBrandsEmpty() {
        GetAllBrandsFilters filters = new GetAllBrandsFilters();
        filters.setAddAliases(false);

        when(this.brandsResource.getBrandServices().getAllBrands(filters)).thenReturn(new LinkedList<BrandBO>());
        assertEquals(0, (int) this.brandsResource.getAllBrands(false, null, null, false).getCount());
    }

    @Test
    public void testGetAllBrands() {

        GetAllBrandsFilters filters = new GetAllBrandsFilters();
        filters.setAddAliases(false);

        BrandBO brandBO = new BrandBO();
        brandBO.setBrandsId(1L);
        brandBO.setName("name");
        brandBO.setNormalizedName("normalizedNamed");
        brandBO.setActivationDate(new Date(1328883991000L)); // 2012-02-10

        LinkedList<BrandBO> list = new LinkedList<BrandBO>();
        list.add(brandBO);

        when(this.brandsResource.getBrandServices().getAllBrands(filters)).thenReturn(list);

        assertEquals(1, (int) this.brandsResource.getAllBrands(false, null, null, false).getCount());

        BrandOutWrapper elt = this.brandsResource.getAllBrands(false, null, null, false).getBrandsList().get(0);

        assertEquals(1L, (long) elt.getBrandId());
        assertEquals("name", elt.getName());
        assertEquals("normalizedNamed", elt.getNormalizedName());
        assertEquals("2012-02-10", elt.getActivationDate());
    }

    @Test(expected = NotFoundException.class)
    public void testGetAllBrandsException() {

        GetAllBrandsFilters filters = new GetAllBrandsFilters();
        filters.setAddAliases(false);

        when(this.brandsResource.getBrandServices().getAllBrands(filters)).thenThrow(new NotFoundException());
        this.brandsResource.getAllBrands(false, null, null, false);
    }

    @Test
    public void testGetBrandByNameBrand() {

        BrandBO result = new BrandBO();
        result.setBrandsId(1L);
        result.setName("brand1");

        when(this.business.getBrandbyId(1L, false, true)).thenReturn(result);

        BrandOutWrapper brandWrapper = this.brandsResource.getBrandById(1L, false, null, null);

        assertEquals(1L, (long) brandWrapper.getBrandId());
        assertEquals("brand1", brandWrapper.getName());
    }

    @Test(expected = NotFoundException.class)
    public void testGetBrandByNameBrandNotFoundException() {
        when(this.brandsResource.getBrandServices().getBrandbyId(1L, false, true)).thenThrow(new NotFoundException());
        this.brandsResource.getBrandById(1L, false, null, null);
    }

    @Test
    public void testGetBrandByNameBrandByName() {

        GetBrandsByNameFilters filters = new GetBrandsByNameFilters();
        filters.setAddAliases(false);
        filters.setIncludeSeoName(false);
        filters.setName("brand");
        filters.setType(SearchBrandsTypeEnum.EXACT);

        BrandBO brand1 = new BrandBO();
        brand1.setBrandsId(1L);
        brand1.setName("brand");

        List<BrandBO> result = new ArrayList<BrandBO>();
        result.add(brand1);

        when(this.business.getBrandsByName(filters, true)).thenReturn(result);

        BrandsOutWrapper brandsWrapper = this.brandsResource.getBrandByName("brand", "exact", false,
                false, null, null);
        BrandOutWrapper brandWrapper = brandsWrapper.getBrandsList().get(0);

        assertEquals(1L, (long) brandWrapper.getBrandId());
        assertEquals("brand", brandWrapper.getName());
    }

    @Test
    public void testGetBrandByNameBrandByNormalizedName() {

        GetBrandsByNameFilters filters = new GetBrandsByNameFilters();
        filters.setAddAliases(false);
        filters.setIncludeSeoName(false);
        filters.setName("brand");
        filters.setType(SearchBrandsTypeEnum.EXACT);

        BrandBO brand1 = new BrandBO();
        brand1.setBrandsId(1L);
        brand1.setName("BRAND");
        brand1.setNormalizedName("brand");

        List<BrandBO> result = new ArrayList<BrandBO>();
        result.add(brand1);

        when(this.business.getBrandsByNormalizedName(filters, true)).thenReturn(result);

        BrandsOutWrapper brandsWrapper = this.brandsResource.getBrandByNormalizedName("brand",
                "exact", false, null, null);
        BrandOutWrapper brandWrapper = brandsWrapper.getBrandsList().get(0);

        assertEquals(1L, (long) brandWrapper.getBrandId());
        assertEquals("brand", brandWrapper.getNormalizedName());
        assertEquals("BRAND", brandWrapper.getName());
    }

    @Test(expected = NotFoundException.class)
    public void testGetBrandByNameBrandByNameNotFoundException() {

        GetBrandsByNameFilters filters = new GetBrandsByNameFilters();
        filters.setAddAliases(false);
        filters.setIncludeSeoName(false);
        filters.setName("brand");
        filters.setType(SearchBrandsTypeEnum.EXACT);

        when(this.brandsResource.getBrandServices().getBrandsByName(filters, true)).thenThrow(new NotFoundException());
        this.brandsResource.getBrandByName("brand","exact", false, false, null, null);
    }
}
