package com.leguide.backoffice.karaf.brands;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

import com.leguide.backoffice.karaf.brands.common.filters.GetBrandsByNameFilters;

public class GetBrandsByNameFiltersTest {

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(GetBrandsByNameFilters.class).usingGetClass().suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }
}
