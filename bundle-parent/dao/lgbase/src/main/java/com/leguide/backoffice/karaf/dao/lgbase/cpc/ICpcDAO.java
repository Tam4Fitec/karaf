package com.leguide.backoffice.karaf.dao.lgbase.cpc;

public interface ICpcDAO {

    Float[] getCPC(Long lgCat, Long mappingCat, String country);
}
