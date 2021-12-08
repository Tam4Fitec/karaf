package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.builder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.AliasInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandInWrapper;

public class BrandInWrapperBuilderTest {

    @Test
    public void testBuilder() {
        BrandInWrapperBuilder builder = new BrandInWrapperBuilder();
        Date date = new Date();
        List<AliasInWrapper> aliases = new ArrayList<AliasInWrapper>();
        ;
        BrandInWrapper wrapper = builder.activationDate(date).name("name").seoName("seoName").temporaryId(10L)
                .alias(aliases).build();

        assertEquals(date, wrapper.getActivationDate());
        assertEquals("name", wrapper.getName());
        assertEquals("seoName", wrapper.getSeoName());
        assertEquals(10L, (long) wrapper.getTemporaryId());
        assertEquals(aliases, wrapper.getAlias());
    }
}
