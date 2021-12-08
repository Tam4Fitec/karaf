package com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist.matching;

public class EqualStrategy implements MatchingStrategy {
	private String reference;
	
	public EqualStrategy(String reference) {
		this.reference = reference;
	}
	
	@Override
	public boolean matches(String value) {
		return reference.equals(value);
	}

}
