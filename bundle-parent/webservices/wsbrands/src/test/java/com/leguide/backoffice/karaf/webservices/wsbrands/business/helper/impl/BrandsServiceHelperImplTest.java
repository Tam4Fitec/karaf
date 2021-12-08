package com.leguide.backoffice.karaf.webservices.wsbrands.business.helper.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;
import com.leguide.backoffice.karaf.webservices.wsbrands.utils.BrandAliasBOUtils;
import com.leguide.backoffice.karaf.dao.brands.IBrandsDAO;
import com.leguide.common.libraries.normalizer.Normalizer;
import com.leguide.common.libraries.normalizer.impl.SimpleNormalizer;
import com.leguide.backoffice.karaf.webservices.wsbrands.utils.BrandBOUtils;
import com.leguide.backoffice.karaf.webservices.wsbrands.utils.GetBrandsByNameFiltersUtils;


public class BrandsServiceHelperImplTest {

    private BrandsServiceHelperImpl helper;
    private IBrandsDAO dao;
    private Normalizer normalizer;

    @Before
    public void setUp() {
        this.helper = new BrandsServiceHelperImpl();
        this.dao = mock(IBrandsDAO.class);
        this.normalizer =  mock(SimpleNormalizer.class);
        this.helper.setBrandsDAO(this.dao);
        this.helper.setNormalizer(this.normalizer);
    }

    @Test
    public void testInsertBrand() {

        BrandBO brandBo = new BrandBO();
        brandBo.setName("test");

        BrandBO daoResult = new BrandBO();
        daoResult.setBrandsId(1L);
        daoResult.setName("test");
        daoResult.setNormalizedName("normalized");

        when(this.helper.getBrandsDAO().getBrandById(1L, false, true)).thenReturn(null);
        when(this.helper.getBrandsDAO().persist(brandBo)).thenReturn(daoResult);

        when(normalizer.fullNormalizeString("test", null)).thenReturn("normalized");

        BrandBO result = this.helper.insertBrand(brandBo);

        assertNotSame(brandBo, result);
        assertEquals(1L, (long) result.getBrandsId());
        assertEquals("test", result.getName());
        assertEquals("normalized", result.getNormalizedName());
    }


    @Test
    public void testNormalizeList() {

        List<BrandBO> brandList = new LinkedList<BrandBO>();
        BrandBO brandBo = new BrandBO();
        brandBo.setName("test");
        BrandBO brandBo2 = new BrandBO();
        brandBo2.setName("test2");

        brandList.add(brandBo);
        brandList.add(brandBo2);

//        NormalizerResult normalizerResult = mock(NormalizerResult.class);
//        when(normalizerResult.getBrandNormalizedName()).thenReturn("normalized");
//        when(this.normalizer.normalizeBrand("test", null, false)).thenReturn(normalizerResult);
//
//        NormalizerResult normalizerResult2 = mock(NormalizerResult.class);
//        when(normalizerResult2.getBrandNormalizedName()).thenReturn("normalized2");
//        when(this.normalizer.normalizeBrand("test2", null, false)).thenReturn(normalizerResult2);

        when(normalizer.fullNormalizeString("test", null)).thenReturn("normalized");
        when(normalizer.fullNormalizeString("test2", null)).thenReturn("normalized2");
        List<BrandBO> normalizedList = this.helper.normalize(brandList);

        assertEquals("normalized", normalizedList.get(0).getNormalizedName());
        assertEquals("normalized2", normalizedList.get(1).getNormalizedName());
    }

//    @Test(expected = NormalizerException.class)
//    public void testNormalizerException() {
//        when(this.normalizer.normalizeBrand("test", null, false)).thenThrow(new BrandNotFoundException());
//        this.helper.normalize("test");
//    }

    @Test
    public void testGetBrandByNameOrAliasNameWhenLookingForABrand() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("brand",
                SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS, false, true);
        BrandBO brandBo = BrandBOUtils.createBrandBO(1L, "brand", "brand", null);
        List<BrandBO> resultList = new ArrayList<BrandBO>();
        resultList.add(brandBo);

        when(this.dao.getBrandsByName(filters, true)).thenReturn(resultList);
        BrandBO result = this.helper.getBrandByNameOrAliasName("brand", true);

        assertEquals(1L, (long) result.getBrandsId());
        assertEquals("brand", result.getName());
        assertEquals("brand", result.getNormalizedName());
    }

    @Test
    public void testGetBrandByNameOrAliasNameWhenLookingForAnAlias() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("alias",
                SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS, false, true);
        String[] aliasNames = { "alias" };
        String[] aliasNamesNormalized = { "normalized_alias" };
        Set<BrandAliasBO> aliasSet = BrandAliasBOUtils.createBrandAliasBOList(aliasNames, aliasNamesNormalized);
        BrandBO brandBo = BrandBOUtils.createBrandBO(1L, "brand", "brand", null, aliasSet);
        List<BrandBO> resultList = new ArrayList<BrandBO>();
        resultList.add(brandBo);

        when(this.dao.getBrandsByName(filters, true)).thenReturn(resultList);
        BrandBO result = this.helper.getBrandByNameOrAliasName("alias", true);

        assertEquals(1L, (long) result.getBrandsId());
        assertEquals("brand", result.getName());
        assertEquals("brand", result.getNormalizedName());

        Iterator<BrandAliasBO> iterator = result.getBrandAliases().iterator();
        BrandAliasBO alias1 = iterator.next();
        assertEquals("alias", alias1.getName());
    }
}
