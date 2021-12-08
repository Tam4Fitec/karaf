package com.leguide.backoffice.karaf.webservices.wsbrands.utils;

import java.util.LinkedHashSet;
import java.util.Set;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;

public final class BrandAliasBOUtils {

    private static final String ALIAS_TEST_DEFAULT_NAME = "alias";
    private static final String ALIAS_TEST_DEFAULT_NAME_NORMALIZED = "normalized_alias";

    private BrandAliasBOUtils() {
    }

    public static Set<BrandAliasBO> createBrandAliasBOList(String[] names, String[] namesNormalized) {

        Set<BrandAliasBO> set = new LinkedHashSet<BrandAliasBO>();

        for (int i = 0; i < names.length; i++) {
            set.add(BrandAliasBOUtils.createBrandAliasBO(Long.valueOf(i), names[i], namesNormalized[i]));
        }

        return set;
    }

    public static BrandAliasBO createBrandAliasBO(Long id, String name, String nameNormalized, Long temporaryId) {
        BrandAliasBO brandAliasBo = new BrandAliasBO();
        brandAliasBo.setId(id);
        brandAliasBo.setName(name);
        brandAliasBo.setNameNormalized(nameNormalized);
        brandAliasBo.setTemporaryId(temporaryId);

        return brandAliasBo;
    }

    public static BrandAliasBO createBrandAliasBO(Long id) {
        return BrandAliasBOUtils.createBrandAliasBO(id, BrandAliasBOUtils.ALIAS_TEST_DEFAULT_NAME,
                BrandAliasBOUtils.ALIAS_TEST_DEFAULT_NAME_NORMALIZED, null);
    }

    public static BrandAliasBO createBrandAliasBO(Long id, String name, String nameNormalized) {
        return BrandAliasBOUtils.createBrandAliasBO(id, name, nameNormalized, null);
    }
}
