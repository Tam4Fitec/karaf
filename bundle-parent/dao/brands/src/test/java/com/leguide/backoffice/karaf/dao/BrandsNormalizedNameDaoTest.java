package com.leguide.backoffice.karaf.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.hazelcast.core.HazelcastInstance;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;
import com.leguide.backoffice.karaf.brands.common.utils.enums.SearchBrandsTypeEnum;
import com.leguide.backoffice.karaf.dao.brands.IBrandsDAO;
import com.leguide.backoffice.karaf.dao.brands.adapters.impl.BrandAdapter;
import com.leguide.backoffice.karaf.dao.brands.cache.CacheServiceImpl;
import com.leguide.backoffice.karaf.dao.brands.impl.BrandsDAOImpl;
import com.leguide.backoffice.karaf.services.hazelcast.impl.HazelcastServiceImpl;

@ContextConfiguration("classpath:dao-test-context.xml")
public class BrandsNormalizedNameDaoTest extends AbstractDaoTest {
    
//    Type of comparison
//
//    exact : exact search on brand name
//    large : all brands beginning with the searched name
//    large_split : all brands beginning with one of the searched name
//    extra_large : all brands containing the searched name
//    extra_large split : all brands containing one of the searched name
//    exact_alias : exact search on alias name
//    large_alias : all aliases beginning with searched name
//    large_alias_split : all aliases beginning with one of the searched name
//    extra_large_alias : all aliases containing the searched name
//    extra_large_alias_split : all aliases containing one of the searched names

    @Autowired
    IBrandsDAO brandsDao;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Autowired
    private CacheServiceImpl cacheService;

    @Before
    public void setUp() {
        HazelcastServiceImpl hazelcastService = new HazelcastServiceImpl();
        hazelcastService.setInstance(hazelcastInstance);
        cacheService.setHazelcastService(hazelcastService);
        brandsDao.setCacheService(cacheService);
    }

    @After
    public void tearDown() {
        cacheService.clearCaches();
    }

    @Test
    public void testGetBrandsByNameNormalized() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("brand_1",
                SearchBrandsTypeEnum.EXACT, false, false);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(1, list.size());
        BrandBO item = list.get(0);
        assertEquals("brand_1", item.getName());
        assertEquals("brand_1", item.getNormalizedName());
        assertNull(item.getBrandAliases());
    }
//
//    @Test
//    public void testGetBrandsByNameWithAliases() {
//
//        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("brand_1",
//                SearchBrandsTypeEnum.EXACT, false, true);
//        List<BrandBO> list = this.brandsDao.getBrandsByName(filters, false);
//
//        assertEquals(1, list.size());
//        BrandBO item = list.get(0);
//        assertEquals("brand_1", item.getName());
//        assertNotNull(item.getBrandAliases());
//    }

    @Test
    public void testGetBrandsByNameNormalizedNoResult() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("test",
                SearchBrandsTypeEnum.EXACT, false, false);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(0, list.size());
    }

    @Test
    //all brands where normalized name begin by the searched name
    public void testGetBrandsByNameNormalizedLarge() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("br",
                SearchBrandsTypeEnum.LARGE, false, false);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(3, list.size());
    }

    @Test
    //all brands where normalized name contains by the searched name
    public void testGetBrandsByNameNormalizedExtraLarge() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("rand_",
                SearchBrandsTypeEnum.EXTRA_LARGE, false, false);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(3, list.size());
    }
    
    @Test
    //all brands where normalized name begins by one of the searched name word
    public void testGetBrandsByNameNormalizedLargeSplit() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("bra",
                SearchBrandsTypeEnum.LARGE_SPLIT, false, false);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(3, list.size());
    }


    @Test
    //all brands where normalized name contains one of the searched name word
    public void testGetBrandsByNameNormalizedExtraLargeSplit() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("test brand",
                SearchBrandsTypeEnum.EXTRA_LARGE_SPLIT, false, false);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(3, list.size());
    }

    @Test
    //exact search on alias name normalized
    public void testGetBrandsByNameNormalizedExactAlias() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("normalized_alias_1",
                SearchBrandsTypeEnum.EXACT_ALIAS, false, true);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(1, list.size());
    }

    @Test
    //all aliases normalized beginning with searched nam
    public void testGetBrandsByNameNormalizedLargeAlias() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("norm",
                SearchBrandsTypeEnum.LARGE_ALIAS, false, true);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(1, list.size());
        assertEquals(2, list.get(0).getBrandAliases().size());
    }

    @Test
    //all aliases normalized beginning with one of the searched name
    public void testGetBrandsByNameNormalizedLargeAliasSplit() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("test norm",
                SearchBrandsTypeEnum.LARGE_ALIAS_SPLIT, false, true);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(1, list.size());
        assertEquals(2, list.get(0).getBrandAliases().size());
    }

    @Test
    //all aliases normalized containing the searched name
    public void testGetBrandsByNameNormalizedExtraLargeAlias() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("lias",
                SearchBrandsTypeEnum.EXTRA_LARGE_ALIAS, false, true);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(1, list.size());
        assertEquals(2, list.get(0).getBrandAliases().size());
    }

    @Test
    // all aliases normalized containing one of the searched names
    public void testGetBrandsByNameNormalizedExtraLargeAliasSplit() {

        GetBrandsByNameFilters filters = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("test alias",
                SearchBrandsTypeEnum.EXTRA_LARGE_ALIAS_SPLIT, false, true);
        List<BrandBO> list = this.brandsDao.getBrandsByNormalizedName(filters, false);

        assertEquals(1, list.size());
        assertEquals(2, list.get(0).getBrandAliases().size());
    }

   
    @Test
    @Ignore
    public void testGetBrandsByNameNormalizedOrAliasName() {

        GetBrandsByNameFilters filtersBrands = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("brand_2",
                SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS, false, true);
        List<BrandBO> listBrand = this.brandsDao.getBrandsByNormalizedName(filtersBrands, false);

        assertEquals(1, listBrand.size());
        BrandBO brand2 = listBrand.get(0);
        assertEquals("brand_2", brand2.getName());

        GetBrandsByNameFilters filtersAlias = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("alias_1",
                SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS, false, true);
        List<BrandBO> listAlias = this.brandsDao.getBrandsByNormalizedName(filtersAlias, false);

        assertEquals(1, listAlias.size());
        BrandBO brand1 = listAlias.get(0);
        assertEquals("brand_1", brand1.getName());
        assertEquals(2, brand1.getBrandAliases().size());
    }

    @Test
    @Ignore
    public void testGetBrandsByNameNormalizedOrAliasNameFail() {

        GetBrandsByNameFilters filtersBrands = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("brand",
                SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS, false, true);
        List<BrandBO> listBrand = this.brandsDao.getBrandsByNormalizedName(filtersBrands, false);
        assertEquals(0, listBrand.size());

        GetBrandsByNameFilters filtersAlias = GetBrandsByNameFiltersUtils.createGetBrandsByNameFilters("alias",
                SearchBrandsTypeEnum.EXACT_BRAND_OR_ALIAS, false, true);
        List<BrandBO> listAlias = this.brandsDao.getBrandsByNormalizedName(filtersAlias, false);
        assertEquals(0, listAlias.size());
    }


    protected BrandsDAOImpl mockBrandDAO() {

        BrandsDAOImpl dao = new BrandsDAOImpl();
        BrandAdapter brandAdapter = new BrandAdapter();
        EntityManager em = mock(EntityManager.class);
        dao.setEm(em);
        dao.setAdapter(brandAdapter);
        dao.setCacheService(cacheService);
        return dao;
    }
}
