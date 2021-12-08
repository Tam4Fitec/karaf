package com.leguide.backoffice.karaf.dao.brands.entity;

import java.util.Date;

import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(value = BrandDTO.class)
public class BrandDTO_ {

    public static volatile SingularAttribute<BrandDTO, Long> id;
    public static volatile SingularAttribute<BrandDTO, String> name;
    public static volatile SingularAttribute<BrandDTO, String> normalizedName;
    public static volatile SingularAttribute<BrandDTO, String> seoName;
    public static volatile SingularAttribute<BrandDTO, Boolean> blacklistedSeo;
    public static volatile SingularAttribute<BrandDTO, Boolean> blacklistedSem;
    public static volatile SingularAttribute<BrandDTO, Date> activationDate;
    public static volatile SetAttribute<BrandDTO, BrandAliasDTO> brandAliases;
}
