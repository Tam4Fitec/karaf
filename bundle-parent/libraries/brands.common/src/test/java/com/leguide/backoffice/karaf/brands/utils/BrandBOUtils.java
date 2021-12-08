package com.leguide.backoffice.karaf.brands.utils;

import java.util.Set;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;
import com.leguide.backoffice.karaf.brands.common.business.model.BrandBO;

public final class BrandBOUtils {

    private static final String BRAND_TEST_DEFAULT_NAME = "brand";

    private BrandBOUtils() {
    }

    public static BrandBO createBrandBO(Long id, String name, String normalizedName, Long temporaryId,
            Boolean blacklistedSeo, Boolean blacklistedSem, Set<BrandAliasBO> aliases) {
        BrandBO brandBo = new BrandBO();
        brandBo.setBrandsId(id);
        brandBo.setName(name);
        brandBo.setNormalizedName(normalizedName);
        brandBo.setTemporaryId(temporaryId);
        brandBo.setBlacklistedSeo(blacklistedSeo);
        brandBo.setBlacklistedSem(blacklistedSem);
        brandBo.setBrandAliases(aliases);

        return brandBo;
    }

    public static BrandBO createBrandBO(Long id) {
        return BrandBOUtils.createBrandBO(id, BRAND_TEST_DEFAULT_NAME, BRAND_TEST_DEFAULT_NAME, null, false, false,
                null);
    }

    public static BrandBO createBrandBO(Long id, String name, String nameNormalized, Long temporaryId) {
        return BrandBOUtils.createBrandBO(id, name, nameNormalized, temporaryId, false, false, null);
    }

    public static BrandBO createBrandBO(Long id, String name, String nameNormalized, Long temporaryId,
            Set<BrandAliasBO> aliases) {
        return BrandBOUtils.createBrandBO(id, name, nameNormalized, temporaryId, false, false, aliases);
    }

    public static BrandBO createBrandBO(Long id, Long temporaryId, Boolean blacklistedSeo, Boolean blacklistedSem) {
        return BrandBOUtils.createBrandBO(id, BRAND_TEST_DEFAULT_NAME, BRAND_TEST_DEFAULT_NAME, temporaryId,
                blacklistedSeo, blacklistedSem, null);
    }
}
