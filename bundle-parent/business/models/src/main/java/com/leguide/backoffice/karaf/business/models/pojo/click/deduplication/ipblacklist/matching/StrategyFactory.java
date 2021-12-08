package com.leguide.backoffice.karaf.business.models.pojo.click.deduplication.ipblacklist.matching;

public enum StrategyFactory {
	EQUAL {
		@Override
		public MatchingStrategy createMatchingStrategy(String parameter) {
			return new EqualStrategy(parameter);
		}
	}, REGEXP {
		@Override
		public MatchingStrategy createMatchingStrategy(String parameter) {
			return new RegexStrategy(parameter);
		}
	}, LIKE {
		@Override
		public MatchingStrategy createMatchingStrategy(String parameter) {
			return new LikeStrategy(parameter);
		}
	};
	
	public abstract MatchingStrategy createMatchingStrategy(String parameter);
}
