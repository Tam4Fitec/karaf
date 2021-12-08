package com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist.matching;

import java.util.regex.Pattern;

public class RegexStrategy implements MatchingStrategy {
	private Pattern pattern;
	
	public RegexStrategy(String regex) {
		String javaRegexp = regex;
		if(!regex.endsWith("$"))
			javaRegexp = javaRegexp+"[0-9]*";
		if(!regex.startsWith("^"))
			javaRegexp = "[0-9]*"+javaRegexp;
		this.pattern = Pattern.compile(javaRegexp);
	}
	
	@Override
	public boolean matches(String value) {
		return pattern.matcher(value).matches();
	}

}
