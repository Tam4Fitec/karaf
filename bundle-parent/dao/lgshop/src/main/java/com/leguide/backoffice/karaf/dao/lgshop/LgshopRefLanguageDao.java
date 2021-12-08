package com.leguide.backoffice.karaf.dao.lgshop;


import java.util.Optional;

public interface LgshopRefLanguageDao {


	String findLocaleByLanguageIdAndCountryId(Integer languageId, Integer countryId);

	Integer findIdLanguageByCountry(Integer countryId);

    Optional<Integer> findIdLanguageByCode(String language);

    Optional<String> findLanguageByLanguageIdAndCountryId(Integer languageId,	Integer countryId);

    Optional<String> findLocaleByLanguageIdAndCountryAlpha2(Integer languageId, String countryId);

}
