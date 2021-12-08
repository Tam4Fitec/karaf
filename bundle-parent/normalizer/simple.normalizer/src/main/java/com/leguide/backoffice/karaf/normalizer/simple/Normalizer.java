package com.leguide.backoffice.karaf.normalizer.simple;

public interface Normalizer {

    /**
     * Replaces strokes and other special characters modifications; quotes and diacriticals marks. Does NOT
     * remove stop words !
     * @param strToNormalize
     * @return a string
     */
    String searchEngineNormalizeString(String strToNormalize);

    /**
     * Encode the string in ISO-8859-1 and replace all non alphanum char by a
     * space. Remove all spaces group, and, depending on the locale: <li>de:
     * replace all \u0153 and oe by ö, all u00E6 by ä <li>other (including null
     * locale): replace all \u0153 by oe <br>
     * Then, Replace All Spaces characters by white-spaces Tab (\t), NewLine
     * (\n), VerticalTab (\v), FormFeed (\f), CarriageReturn (\r), Space,
     * No-break space, Ogham space mark, Mongolian vowel separator, [En quad, Em
     * quad, En space, Em space, Three-per-em space, Four-per-em space,
     * Six-per-em space, Figure space, Punctuation space, Thin space, Hair
     * space], Line separator (newline character), Paragraph separator (newline
     * character), Narrow no-break space, Medium mathematical space, Ideographic
     * space by one space
     * 
     * @param strToNormalize
     * @param locale can be null
     * @return
     */
    String userViewNormalizeString(String strToNormalize, String locale);
    
    /**
     * calls userViewNormalizeString on strToNormalize, and searchEngineNormalizeString on the result
     * @param strToNormalize
     * @param locale can be null
     * @return
     */
    String fullNormalizeString(String strToNormalize, String locale);
}
