package com.leguide.backoffice.karaf.bundle.services.search.engine.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class ParseUtils {

    private static final DecimalFormat dFrench = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.FRENCH));

    private ParseUtils(){};

    public static String parsePriceFrenchLocale(Double d) {
        if (d == null) {
            return "";
        } else {
            return d % 1 == 0.0 ? String.valueOf(d.intValue()) : dFrench.format(d);
        }
    }

    public static int discount(Double price, Double oldPrice) {
        if (oldPrice == null) {
            return 0;
        }
        if (price == null) {
            return 0;
        }
        if (oldPrice.equals(price)) {
            return 0;
        }
        if (price > oldPrice) {
            //throw new IllegalArgumentException("price " + price + " is greater than old price " + oldPrice + " , error !");
            //as values come fro mthe searchengine, need to handle 0 silently 
            return 0;
        }

        return (int)Math.rint((price / oldPrice) * 100.0);
    }
}
