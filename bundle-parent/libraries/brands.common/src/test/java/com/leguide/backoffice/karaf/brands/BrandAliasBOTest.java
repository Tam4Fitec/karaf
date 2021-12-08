package com.leguide.backoffice.karaf.brands;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.Test;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;

public class BrandAliasBOTest {

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(BrandAliasBO.class).usingGetClass().suppress(Warning.NONFINAL_FIELDS).verify();
    }
}
