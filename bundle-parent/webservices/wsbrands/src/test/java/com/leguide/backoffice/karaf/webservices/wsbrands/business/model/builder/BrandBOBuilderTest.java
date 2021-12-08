package com.leguide.backoffice.karaf.webservices.wsbrands.business.model.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;

public class BrandBOBuilderTest {

    @Test
    public void testBuilder() {
        BrandBOBuilder builder = new BrandBOBuilder();
        Date date = new Date();
        Set<BrandAliasBO> brandAliases = new HashSet<BrandAliasBO>();
        BrandBO brand = builder.brandsId(1L).activationDate(date).name("name").normalizedName("normalizedName")
                .seoName("seoName").temporaryId(10L).blacklistedSem(false).blacklistedSeo(false)
                .brandAliases(brandAliases).build();

        assertEquals(1L, (long) brand.getBrandsId());
        assertEquals(date, brand.getActivationDate());
        assertEquals("name", brand.getName());
        assertEquals("normalizedName", brand.getNormalizedName());
        assertEquals("seoName", brand.getSeoName());
        assertEquals(10L, (long) brand.getTemporaryId());
        assertFalse(brand.getBlacklistedSem());
        assertFalse(brand.getBlacklistedSeo());
        assertEquals(brandAliases, brand.getBrandAliases());
    }
}
