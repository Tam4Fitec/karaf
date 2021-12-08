package com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist;

import com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist.matching.MatchingStrategy;
import com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist.matching.StrategyFactory;


public class BlackIP {
	private String ip;
	private MatchingStrategy strategy;
	
	public BlackIP(String ip, String strategy) {
		this.ip = ip;
		this.strategy = StrategyFactory.valueOf(strategy).createMatchingStrategy(ip);
	}
	
	public boolean matches(String value) {
		return strategy.matches(value);
	}
	
	public String getIp() {
		return ip;
	}
}
