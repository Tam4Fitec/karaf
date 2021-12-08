package com.leguide.backoffice.karaf.webservices.wsbrands.business.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.runners.MockitoJUnitRunner;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.exception.NotFoundException;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllBrandsFilters;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.dao.brands.IBrandsDAO;
import com.leguide.backoffice.karaf.webservices.wsbrands.business.helper.IBrandsServiceHelper;
import com.leguide.backoffice.karaf.webservices.wsbrands.utils.BrandBOUtils;

@RunWith(MockitoJUnitRunner.class)
public class BrandsServiceImplTest {

    private BrandsServiceImpl service;
    private IBrandsServiceHelper brandsHelper;
    private IBrandsDAO dao;

    @Before
    public void setUp() {
        this.service = new BrandsServiceImpl();

        this.dao = mock(IBrandsDAO.class);
        this.brandsHelper = mock(IBrandsServiceHelper.class);

        this.service.setBrandsDAO(this.dao);
        this.service.setBrandsServiceHelper(this.brandsHelper);
    }

    @Test(expected = NotFoundException.class)
    public void testGetBrandbyIdByIdNotFound() {
        when(this.service.getBrandsDAO().getBrandById(1L, false, false)).thenReturn(null);
        this.service.getBrandbyId(1L, false, false);
    }

    @Test(expected = NotFoundException.class)
    public void testGetBrandbyIdByNameNotFound() {

        GetBrandsByNameFilters filters = new GetBrandsByNameFilters();
        filters.setName("name");

        ArrayList<BrandBO> resultList = new ArrayList<BrandBO>();

        when(this.service.getBrandsDAO().getBrandsByName(filters, false)).thenReturn(resultList);
        this.service.getBrandsByName(filters, false);
    }

    @Test(expected = NotFoundException.class)
    public void testGetBrandbyIdAndAliasesByIdNotFound() throws NotFoundException {
        when(this.service.getBrandsDAO().getBrandById(1L, true, false)).thenReturn(null);
        this.service.getBrandbyId(1L, true, false);
    }

    @Test(expected = NotFoundException.class)
    public void testGetBrandbyIdNotFound() {
        List<BrandBO> result = new LinkedList<BrandBO>();

        GetAllBrandsFilters filters = new GetAllBrandsFilters();
        filters.setAddAliases(false);

        when(this.service.getBrandsDAO().getAllBrands(filters)).thenReturn(result);
        this.service.getAllBrands(filters);
    }

    @Test(expected = NotFoundException.class)
    public void testGetBrandbyIdsAndAliasesNotFound() {

        GetAllBrandsFilters filters = new GetAllBrandsFilters();
        filters.setAddAliases(true);

        List<BrandBO> result = new LinkedList<BrandBO>();
        when(this.service.getBrandsDAO().getAllBrands(filters)).thenReturn(result);
        this.service.getAllBrands(filters);
    }

    @Test
    public void testCountBrands() {

        when(this.dao.countBrands()).thenReturn(150);
        assertEquals(this.service.countBrands(), new Integer(150));
    }

    @Test
    public void testSetSeoName() {

        BrandBO brandBo = new BrandBO();
        brandBo.setBrandsId(1L);
        
        BrandBO res = new BrandBO();
        res.setBrandsId(1L);
        res.setSeoName("test");

        ArgumentCaptor<BrandBO> captor = ArgumentCaptor.forClass(BrandBO.class);

        when(this.dao.setSeoName("test", 1L)).thenReturn(res);
        //when(this.dao.merge(captor.capture())).thenReturn(brandBo);

        this.service.setSeoName("test", 1L);
        assertEquals(new Long(1L), res.getBrandsId());
        assertEquals("test", res.getSeoName());
    }

    @Test(expected = NotFoundException.class)
    public void testSetSeoNameException() {

        BrandBO brandBo = new BrandBO();
        brandBo.setBrandsId(1L);

        when(this.dao.setSeoName("test", 1L)).thenThrow(NotFoundException.class);
        this.service.setSeoName("test", 1L);
    }

    @Test
    public void testInsertBrand() {
        BrandBO brandBo = new BrandBO();
        BrandBO result = new BrandBO();
        result.setBrandsId(1L);

        when(this.brandsHelper.insertBrand(brandBo)).thenReturn(result);
        BrandBO test = this.service.insertBrand(brandBo);
        assertEquals(1L, (long) test.getBrandsId());
    }

    @Test(expected = NotFoundException.class)
    public void testGetBrandsByIdsListNull() {
        when(this.service.getBrandsDAO().getBrandsByIds(null, false, true)).thenReturn(new ArrayList<BrandBO>());
        this.service.getBrandsByIds(null, false, true);
    }

    @Test
    public void testGetBrandsByIds() {
        List<BrandBO> expected = new ArrayList<BrandBO>();
        BrandBO bo1 = new BrandBO();
        bo1.setName("name1");
        bo1.setBrandsId(1l);
        BrandBO bo2 = new BrandBO();
        bo2.setName("name2");
        bo2.setBrandsId(2l);
        expected.add(bo1);
        expected.add(bo2);
        when(this.service.getBrandsDAO().getBrandsByIds(null, false, true)).thenReturn(expected);
        List<BrandBO> actual = this.service.getBrandsByIds(null, false, true);
        assertNotNull(actual);
        assertTrue(actual.size() == 2);
        assertEquals(expected, actual);
    }
}
