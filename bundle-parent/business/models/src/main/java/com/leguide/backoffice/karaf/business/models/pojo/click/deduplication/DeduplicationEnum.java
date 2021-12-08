package com.leguide.backoffice.karaf.business.models.pojo.click.deduplication;

public enum DeduplicationEnum {
	NONE(0),
	USER_AGENT(15),
	IP(11),
	PROMO(2),
	ID_RECH(6),
	TIME(1),
	EMPTY_PATH(5),
	EMPTY_STORE_ID(16),
	EMPTY_COUNTRY(17);
	
	private long id;

	private DeduplicationEnum(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
}
