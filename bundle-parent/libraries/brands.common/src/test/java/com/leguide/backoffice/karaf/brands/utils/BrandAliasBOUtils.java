package com.leguide.backoffice.karaf.brands.utils;

import java.util.LinkedHashSet;
import java.util.Set;

import com.leguide.backoffice.karaf.brands.common.business.model.BrandAliasBO;

public final class BrandAliasBOUtils {

    private static final String ALIAS_TEST_DEFAULT_NAME = "alias";

    private BrandAliasBOUtils() {
    }

    public static Set<BrandAliasBO> createBrandAliasBOList(String[] names) {

        Set<BrandAliasBO> set = new LinkedHashSet<BrandAliasBO>();

        for (int i = 0; i < names.length; i++) {
            set.add(BrandAliasBOUtils.createBrandAliasBO(Long.valueOf(i), names[i]));
        }

        return set;
    }

    public static BrandAliasBO createBrandAliasBO(Long id, String name, Long temporaryId) {
        BrandAliasBO brandAliasBo = new BrandAliasBO();
        brandAliasBo.setId(id);
        brandAliasBo.setName(name);
        brandAliasBo.setTemporaryId(temporaryId);

        return brandAliasBo;
    }

    public static BrandAliasBO createBrandAliasBO(Long id) {
        return BrandAliasBOUtils.createBrandAliasBO(id, BrandAliasBOUtils.ALIAS_TEST_DEFAULT_NAME, null);
    }

    public static BrandAliasBO createBrandAliasBO(Long id, String name) {
        return BrandAliasBOUtils.createBrandAliasBO(id, name, null);
    }
}
