package com.leguide.backoffice.karaf.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.filters.GetAllAliasesFilters;
import com.leguide.backoffice.karaf.dao.brands.IAliasDAO;

@ContextConfiguration("classpath:dao-test-context.xml")
public class AliasDaoTest extends AbstractDaoTest {

    @Autowired
    IAliasDAO aliasDao;

    @Test
    public void testGetAllAliases() {
        GetAllAliasesFilters filters = new GetAllAliasesFilters();
        BrandAliasBO alias = this.aliasDao.getAllAliases(filters).get(0);
        assertEquals(1L, (long) alias.getId());
        assertEquals("alias_1", alias.getName());
        assertEquals("normalized_alias_1", alias.getNameNormalized());

        alias = this.aliasDao.getAllAliases(filters).get(1);
        assertEquals(2L, (long) alias.getId());
        assertEquals("alias_1.1", alias.getName());
        assertEquals("normalized_alias_1.1", alias.getNameNormalized());
    }

    @Test
    public void testCountAliases() {
        assertEquals(2, (int) this.aliasDao.countAliases());
    }
}
