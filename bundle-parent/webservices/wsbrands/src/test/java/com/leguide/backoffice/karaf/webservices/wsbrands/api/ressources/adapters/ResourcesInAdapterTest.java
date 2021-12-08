package com.leguide.backoffice.karaf.webservices.wsbrands.api.ressources.adapters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.AliasInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandInWrapper;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.builder.AliasInWrapperBuilder;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.builder.BrandInWrapperBuilder;
import com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.adapters.ResourcesInAdapter;

public class ResourcesInAdapterTest {

    private ResourcesInAdapter resourceInAdapter;

    private BrandInWrapperBuilder brandInWrapperBuilder;

    private AliasInWrapperBuilder aliasInWrapperBuilder;


    @Before
    public void setUp() {
        this.resourceInAdapter = new ResourcesInAdapter();
        this.brandInWrapperBuilder = new BrandInWrapperBuilder();
        this.aliasInWrapperBuilder = new AliasInWrapperBuilder();
    }

    @Test
    public void testAdaptBrandInWrapperWithAllFields() {
        BrandInWrapper wrapper = this.brandInWrapperBuilder.temporaryId(1L).name("name").seoName("seoName").build();
        BrandBO bo = this.resourceInAdapter.adapt(wrapper);
        assertAdaptedBrandBoEquals(bo, 1L, "name", "seoName");
    }

    @Test
    public void testAdaptBrandInWrapperNoTemporaryId() {
        BrandInWrapper wrapper = this.brandInWrapperBuilder.name("name").seoName("seoName").build();
        BrandBO bo = this.resourceInAdapter.adapt(wrapper);
        assertAdaptedBrandBoEquals(bo, null, "name", "seoName");
    }

    @Test
    public void testAdaptBrandInWrapperNoSeoName() {
        BrandInWrapper wrapper = this.brandInWrapperBuilder.temporaryId(1L).name("name").build();
        BrandBO bo = this.resourceInAdapter.adapt(wrapper);
        assertAdaptedBrandBoEquals(bo, 1L, "name", null);
    }

    @Test
    public void testAdaptBrandInWrapperNoName() {
        BrandInWrapper wrapper = this.brandInWrapperBuilder.temporaryId(1L).seoName("seoName").build();
        BrandBO bo = this.resourceInAdapter.adapt(wrapper);
        assertAdaptedBrandBoEquals(bo, 1L, null, "seoName");
    }

    @Test
    public void testAdaptAliasInWrapper() {
        AliasInWrapper wrapper = this.aliasInWrapperBuilder.temporaryId(1L).name("name").build();
        BrandAliasBO bo = this.resourceInAdapter.adapt(wrapper);
        assertAdaptedBrandAliasBoEquals(bo, 1L, "name");
    }

    @Test
    public void testAdaptAliasInWrapperNoName() {
        AliasInWrapper wrapper = this.aliasInWrapperBuilder.temporaryId(1L).build();
        BrandAliasBO bo = this.resourceInAdapter.adapt(wrapper);
        assertAdaptedBrandAliasBoEquals(bo, 1L, null);
    }

    private void assertAdaptedBrandBoEquals(BrandBO bo, Long temporaryId, String name, String seoName) {
        assertEquals(temporaryId, bo.getTemporaryId());
        assertEquals(name, bo.getName());
        assertEquals(seoName, bo.getSeoName());
    }

    private void assertAdaptedBrandAliasBoEquals(BrandAliasBO bo, Long temporaryId, String name) {
        assertEquals(temporaryId, bo.getTemporaryId());
        assertEquals(name, bo.getName());
    }
}
