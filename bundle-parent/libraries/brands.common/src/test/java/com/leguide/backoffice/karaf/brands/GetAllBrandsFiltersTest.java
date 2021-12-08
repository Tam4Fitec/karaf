package com.leguide.backoffice.karaf.brands;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

import com.leguide.backoffice.karaf.brands.common.filters.GetAllBrandsFilters;

public class GetAllBrandsFiltersTest {

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(GetAllBrandsFilters.class).usingGetClass().suppress(Warning.NONFINAL_FIELDS).verify();
    }
}
