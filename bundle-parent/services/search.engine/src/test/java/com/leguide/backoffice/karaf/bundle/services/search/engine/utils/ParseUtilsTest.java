package com.leguide.backoffice.karaf.bundle.services.search.engine.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParseUtilsTest {

    @Test
    public void testParseFrench() {
        Double d1 = new Double("100.45");
        Double d2 = new Double("100.50");
        Double d3 = new Double("100.00");
        assertEquals("100", ParseUtils.parsePriceFrenchLocale(d3));
        assertEquals("100,50", ParseUtils.parsePriceFrenchLocale(d2));
        assertEquals("100,45", ParseUtils.parsePriceFrenchLocale(d1));
    }

    @Test
    public void testDiscount() {
        assertEquals(0, ParseUtils.discount(0.0, null));
        assertEquals(0, ParseUtils.discount(null, null));
        assertEquals(0, ParseUtils.discount(null, 0.0));
        assertEquals(0, ParseUtils.discount(0.0, 0.0));
        assertEquals(0, ParseUtils.discount(100.0, 100.0));
        assertEquals(50, ParseUtils.discount(50.0, 100.0));
        assertEquals(50, ParseUtils.discount(50.0, 100.5));
        assertEquals(50, ParseUtils.discount(50.5, 100.0));
    }

    @Test
    public void testDiscountError() {
        assertEquals(0, ParseUtils.discount(100.0, 50.0));
    }

    @Test
    public void testDiscountDivideZero() {
        assertEquals(0, ParseUtils.discount(100.0, 0.0));
    }
}
