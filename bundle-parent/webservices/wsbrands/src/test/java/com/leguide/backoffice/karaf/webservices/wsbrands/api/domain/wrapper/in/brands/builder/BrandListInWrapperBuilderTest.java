package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.builder;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandsListInWrapper;

public class BrandListInWrapperBuilderTest {

    @Test
    public void testBuilder() {
        BrandsListInWrapperBuilder builder = new BrandsListInWrapperBuilder();
        List<BrandInWrapper> brands = new ArrayList<BrandInWrapper>();
        ;
        BrandsListInWrapper wrapper = builder.brand(brands).build();

        assertEquals(brands, wrapper.getBrand());
    }
}
