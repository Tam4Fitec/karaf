package com.leguide.backoffice.karaf.normalizer.simple.normalizer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.leguide.backoffice.karaf.normalizer.simple.Normalizer;
import com.leguide.backoffice.karaf.normalizer.simple.impl.SimpleNormalizer;

/**
 * see http://confluence.leguide.com:8080/display/LGINFO/12_Testing
 * @author jlboulanger
 *
 */
public class NormalizeTest {

    private Normalizer normalizer;

    @Before
    public void setUp() {
        normalizer = new SimpleNormalizer();
    }

    @After
    public void teardown() {
        normalizer = null;
    }

    /*
     * TEST 01.1 : Accentuate characters input: télévision lcd output:
     * télévision lcd
     */
    @Test
    public void test011() {
        assertTrue("télévision lcd".equals(normalizer.userViewNormalizeString("télévision lcd", "fr_FR")));
    }

    /*
     * TEST 01.2 : Accentuate characters input: handy zubehör output: handy
     * zubehör
     */
    @Test
    public void test012() {
        assertTrue("handy zubehör".equals(normalizer.userViewNormalizeString("handy zubehör", "de_DE")));
        assertTrue("handy zubehör".equals(normalizer.userViewNormalizeString("handy zubehör", "fr_FR")));
        assertTrue("handy zubehör".equals(normalizer.userViewNormalizeString("handy zubehör", "null")));
    }

    /*
     * TEST 01.3 : German Accentuate characters input: handy zubehœr output:
     * handy zubehör
     */
    @Test
    public void test013() {
        assertTrue("handy zubehör".equals(normalizer.userViewNormalizeString("handy zubehœr", "de_DE")));
        assertTrue("handy zubehör".equals(normalizer.userViewNormalizeString("handy zubehoer", "de_DE")));
        assertTrue("handy zubehoer".equals(normalizer.userViewNormalizeString("handy zubehœr", "sv_SE")));
        assertFalse("handy zubehör".equals(normalizer.userViewNormalizeString("handy zubehœr", "fr_FR")));
        assertTrue("handy zubehoer".equals(normalizer.userViewNormalizeString("handy zubehœr", "fr_FR")));
        assertTrue("handy zubehoer".equals(normalizer.userViewNormalizeString("handy zubehœr", null)));
    }

    /*
     * TEST 02 : Non Alpha Numeric & accentuate characters input: accessoires
     * photos :(video) output: accessoires photos video
     */
    @Test
    public void test021() {
        assertTrue("accessoires photos video".equals(normalizer.userViewNormalizeString("accessoires photos :(video)",
                "fr_FR")));
    }

    /*
     * TEST 03 : Use of Spaces TEST 03.1 : Use of Spaces Between input:
     * "accessoires    photos" output: "accessoires photos"
     */
    @Test
    public void test031() {
        assertTrue("accessoires photos".equals(normalizer.userViewNormalizeString("accessoires    photos", "fr_FR")));
    }

    /*
     * TEST 03.2 : Use of Spaces Begin by input: " accessoires photos" output:
     * "accessoires photos"
     */
    @Test
    public void test032() {
        assertTrue("accessoires photos".equals(normalizer.userViewNormalizeString(" accessoires photos", "fr_FR")));
    }

    /*
     * TEST 03.3 : Use of Spaces Finnish by input: "accessoires photos " output:
     * "accessoires photos"
     */
    @Test
    public void test033() {
        assertTrue("accessoires photos".equals(normalizer.userViewNormalizeString("accessoires photos ", "fr_FR")));
    }

    /*
     * TEST 04 : Lower-case Uses input: "ACCESSOIRES photos" output:
     * "accessoires photos"
     */
    @Test
    public void test041() {
        assertTrue("accessoires photos".equals(normalizer.userViewNormalizeString("ACCESSOIRES photos", "fr_FR")));
    }

    /*
     * TEST 05 : Keep the stop words input: "accessoires pour photos" output:
     * "accessoires pour photos"
     */
    @Test
    public void test051() {
        assertTrue("accessoires pour photos".equals(normalizer.userViewNormalizeString("accessoires pour photos",
                "fr_FR")));
    }

    /*
     * TEST 06 : accentuate characters TEST 06.1 : Accentuate characters input:
     * télévision lcd output: television lcd
     */
    @Test
    public void test061() {
        String userNorm = normalizer.userViewNormalizeString("télévision lcd", "fr_FR");
        assertTrue("television lcd".equals(normalizer.searchEngineNormalizeString(userNorm)));
    }

    /*
     * TEST 06.2 : Accentuate characters input: handy zubehör output: handy
     * zubehoer
     */
    @Test
    public void test062() {
        String userNorm = normalizer.userViewNormalizeString("handy zubehör", "de_DE");
        assertTrue("handy zubehoer".equals(normalizer.searchEngineNormalizeString(userNorm)));
    }

    /*
     * TEST 07 : Non Alpha Numeric & accentuate characters input:
     * "accessoires photos :(video)" output: "accessoires photos video"
     */
    @Test
    public void test071() {
        String userNorm = normalizer.userViewNormalizeString("accessoires photos :(video)", "fr_FR");
        assertTrue("accessoires photos video".equals(normalizer.searchEngineNormalizeString(userNorm)));
    }

    /*
     * TEST 08.1 : Use of Spaces Between input: "accessoires    photos" output:
     * "accessoires photos"
     */
    @Test
    public void test081() {
        String userNorm = normalizer.userViewNormalizeString("accessoires    photos", "fr_FR");
        assertTrue("accessoires photos".equals(normalizer.searchEngineNormalizeString(userNorm)));
    }

    /*
     * TEST 08.2 : Use of Spaces Begin by input: " accessoires photos" output:
     * "accessoires photos"
     */
    @Test
    public void test082() {
        String userNorm = normalizer.userViewNormalizeString(" accessoires photos", "fr_FR");
        assertTrue("accessoires photos".equals(normalizer.searchEngineNormalizeString(userNorm)));
    }

    /*
     * TEST 08.3 : Use of Spaces Finnish by input: "accessoires photos " output:
     * "accessoires photos"
     */
    @Test
    public void test083() {
        String userNorm = normalizer.userViewNormalizeString("accessoires photos ", "fr_FR");
        assertTrue("accessoires photos".equals(normalizer.searchEngineNormalizeString(userNorm)));
    }

    /*
     * TEST 09 : Lower-case Uses input: "ACCESSOIRES photos" output:
     * "accessoires photos"
     */
    @Test
    public void test091() {
        String userNorm = normalizer.userViewNormalizeString("ACCESSOIRES photos ", "fr_FR");
        assertTrue("accessoires photos".equals(normalizer.searchEngineNormalizeString(userNorm)));
    }

    /*
     * TEST remove ²
     */
    @Test
    public void testSUPERSCRIPT_TWO() {
        assertTrue("test".equals(normalizer.userViewNormalizeString("² test ²", null)));
    }

    /*
     * TEST do not remove quotes
     */
    @Test
    public void testQuotes() {
        assertTrue("canapé d'angle".equals(normalizer.userViewNormalizeString("canapé d'angle", null)));
    }

    @Test
    public void testQuotes2() {
        String userNorm = normalizer.userViewNormalizeString("canapé d'angle", null);
        assertTrue("canape d angle".equals(normalizer.searchEngineNormalizeString(userNorm)));
    }

    @Test
    public void testNumbers() {
        assertTrue("canapé 123 angle".equals(normalizer.userViewNormalizeString("canapé 123 angle", null)));
    }
}
