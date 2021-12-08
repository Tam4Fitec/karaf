package com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist.matching;


public interface MatchingStrategy {
	boolean matches(String value);
}
