package com.leguide.backoffice.karaf.webservices.wsbrands.business.model.builder;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;

public class BrandAliasBOBuilderTest {

    @Test
    public void testBuilder() {
        BrandAliasBOBuilder builder = new BrandAliasBOBuilder();
        Date date = new Date();
        BrandBO brandBo = new BrandBO();
        BrandAliasBO alias = builder.id(1L).activationDate(date).name("name").nameNormalized("nameNormalized")
                .temporaryId(10L).brand(brandBo).build();

        assertEquals(1L, (long) alias.getId());
        assertEquals(date, alias.getActivationDate());
        assertEquals("name", alias.getName());
        assertEquals("nameNormalized", alias.getNameNormalized());
        assertEquals(10L, (long) alias.getTemporaryId());
        assertEquals(brandBo, alias.getBrand());
    }
}
