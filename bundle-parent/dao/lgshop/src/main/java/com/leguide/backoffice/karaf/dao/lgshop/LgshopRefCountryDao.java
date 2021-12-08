package com.leguide.backoffice.karaf.dao.lgshop;


public interface LgshopRefCountryDao {

	Integer findInternalCountryByAlpha2Code(String alpha2Code);

	String findAlpha2CodeByInternalId(Integer id);

}
