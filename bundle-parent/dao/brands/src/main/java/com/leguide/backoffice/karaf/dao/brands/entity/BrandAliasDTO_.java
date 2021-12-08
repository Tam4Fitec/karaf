package com.leguide.backoffice.karaf.dao.brands.entity;

import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(value = BrandAliasDTO.class)
public class BrandAliasDTO_ {

    public static volatile SingularAttribute<BrandAliasDTO, Long> id;
    public static volatile SingularAttribute<BrandAliasDTO, String> name;
    public static volatile SingularAttribute<BrandAliasDTO, String> nameNormalized;
    public static volatile SingularAttribute<BrandAliasDTO, Date> activationDate;
    public static volatile SingularAttribute<BrandAliasDTO, BrandDTO> brand;
}
