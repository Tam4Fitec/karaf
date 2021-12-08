package com.leguide.backoffice.karaf.normalizer.simple.impl;

import java.net.URLDecoder;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.normalizer.simple.Normalizer;

public class SimpleNormalizer implements Normalizer {

    private static Logger logger = LoggerFactory.getLogger(SimpleNormalizer.class);
    
    /**
     * {@inheritDoc} 
     */
    public String searchEngineNormalizeString(String strToNormalize) {

        // Replace strokes and other special characters modifications
        String finalStr = strToNormalize.toLowerCase();
        finalStr = finalStr.replaceAll("[\u00E4]", "ae"); // ä
        finalStr = finalStr.replaceAll("[\u00E6]", "ae"); // æ
        finalStr = finalStr.replaceAll("[\u00F8]", "o"); // ø
        finalStr = finalStr.replaceAll("[\u00F6]", "oe"); // ö
        finalStr = finalStr.replaceAll("[\u0153]", "oe"); // œ
        finalStr = finalStr.replaceAll("[\u00FC]", "ue"); // ü
        finalStr = finalStr.replaceAll("[\u00DF]", "ss"); // ß
        finalStr = finalStr.replaceAll("[\u0142]", "l"); // ł

        String strWithSeparatedDiacritics = java.text.Normalizer.normalize(finalStr, java.text.Normalizer.Form.NFD);
        // Remove diacritics
        String strWithoutDiacritics = strWithSeparatedDiacritics.replaceAll("[\\p{InCombiningDiacriticalMarks}]+", "");
        logger.debug("String without diacritics : " + strWithoutDiacritics);

        // Replace all known versions of quotes by space
        finalStr = strWithoutDiacritics.replaceAll("[\\p{Pi}\\p{Pf}\']", " ");

        // Replace + signs, ampersands, slashes, commas, hyphens/minuses by
        // space
        finalStr = finalStr.replaceAll("[\u002B\u0026\u002F\u002C\u002D]", " ");

        // Replace blocks of spaces by one space
        finalStr = finalStr.replaceAll("([\u0020])+", " ");

        // Trim string
        finalStr = finalStr.trim();

        return finalStr;
    }
    
    /**
     * {@inheritDoc} 
     */
    public String userViewNormalizeString(String strToNormalize, String locale) /*throws UrlDecodingException */ {

        String lang = null;
        if (locale != null && locale.split("_").length == 2) { 
            lang = locale.split("_")[0];
        }
        String finalStr = strToNormalize;
        // Decode URL (%XX)
        logger.debug("userViewNormalizeString {}", strToNormalize);
        try {
            finalStr = URLDecoder.decode(finalStr, "ISO-8859-1");
        } catch (Exception e) {
            logger.error(e.getMessage());
            //throw new UrlDecodingException(e);
            throw new RuntimeException();
        }

        logger.debug("Test decoded URL : " + finalStr);

        // Decode HTML Entities
        finalStr = StringEscapeUtils.unescapeHtml(finalStr);

        logger.debug("Test decoded HTML : " + finalStr);

        // Switch to lowercase
        finalStr = finalStr.toLowerCase();

        if (lang != null) {
            finalStr = finalStr.replaceAll("[\u0153]", ("de".equalsIgnoreCase(lang)) ? "ö" : "oe");
            if (("de".equalsIgnoreCase(lang))) {
                finalStr = finalStr.replaceAll("oe", "ö");
                finalStr = finalStr.replaceAll("[\u00E6]", "ä");
            }
        } else {
            finalStr = finalStr.replaceAll("[\u0153]", "oe");
        }
        logger.debug("Test after language : " + finalStr);

        // Replace everything that is not alphanuméric, quotes, plus signs by
        // spaces
        finalStr = finalStr.replaceAll("[^\\p{L}\\p{N}\\p{Pi}\\p{Pf}\u002B&&[^']]", " ");

        //replace ² by space
        finalStr = finalStr.replaceAll("[\u00B2]", " "); // ²
        logger.debug("Test Nothing else than alphanums, quotes and plus signs : " + finalStr);

        /*
         * Replace All Spaces characters by white-spaces Tab (\t), NewLine (\n),
         * VerticalTab (\v), FormFeed (\f), CarriageReturn (\r), Space, No-break
         * space, Ogham space mark, Mongolian vowel separator, [En quad, Em
         * quad, En space, Em space, Three-per-em space, Four-per-em space,
         * Six-per-em space, Figure space, Punctuation space, Thin space, Hair
         * space], Line separator (newline character), Paragraph separator
         * (newline character), Narrow no-break space, Medium mathematical
         * space, Ideographic space
         */
        finalStr = finalStr.replaceAll("[\\u0009\\u000a\\u000b\\u000c\\u000d\u0020\u00a0\u1680\u180e"
                + "\u2000-\u200A\u2028\u2029\u202f\u205f\u3000]", " ");

        // Replace blocks of spaces by one space
        finalStr = finalStr.replaceAll("([\u0020])+", " ");

        // Trim string
        finalStr = finalStr.trim();
        logger.debug("exit userViewNormalizeString with {} ", finalStr);
        return finalStr;
    }
    
    /**
     * {@inheritDoc} 
     */
    public String fullNormalizeString(String strToNormalize, String locale) {
        return searchEngineNormalizeString(userViewNormalizeString(strToNormalize, locale));
    }
 
}
