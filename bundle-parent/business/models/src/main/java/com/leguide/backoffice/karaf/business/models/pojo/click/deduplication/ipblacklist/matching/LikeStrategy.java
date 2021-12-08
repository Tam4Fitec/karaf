package com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist.matching;

import java.util.regex.Pattern;

public class LikeStrategy implements MatchingStrategy {
	private Pattern pattern;
	
	public LikeStrategy(String template) {
		this.pattern = Pattern.compile("[0-9]*"+template+"[0-9]*");
	}
	
	@Override
	public boolean matches(String value) {
		return pattern.matcher(value).matches();
	}

}
