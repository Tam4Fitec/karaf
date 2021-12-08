package com.leguide.backoffice.karaf.webservices.wsbrands.business.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllAliasesFilters;
import com.leguide.backoffice.karaf.dao.brands.IAliasDAO;

public class AliasesServiceImplTest {

    private AliasesServiceImpl service;
    private IAliasDAO dao;

    @Before
    public void setUp() {
        this.service = new AliasesServiceImpl();
        this.dao = mock(IAliasDAO.class);
        this.service.setAliasDAO(this.dao);
    }

    @Test
    public void testCountAliases() {
        when(this.dao.countAliases()).thenReturn(10);
        assertEquals(10, (int) this.service.countAliases());
    }

    @Test
    public void testGetAllAliases() {
        GetAllAliasesFilters filters = new GetAllAliasesFilters();
        ArrayList<BrandAliasBO> res = new ArrayList<BrandAliasBO>();
        when(this.dao.getAllAliases(filters)).thenReturn(res);
        assertEquals(res, this.service.getAllAliases(filters));
    }
}
