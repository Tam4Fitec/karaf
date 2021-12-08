package com.leguide.backoffice.karaf.dao.lgbase.utils;

import org.joda.time.DateTimeUtils.MillisProvider;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateMock implements MillisProvider {

	private String testingDate;

	private static final DateTimeFormatter FORMATTER = DateTimeFormat
			.forPattern("dd/MM/yyyy hh:mm:ss");

	public DateMock(String testingDate) {
		this.testingDate = testingDate;
	}

	@Override
	public long getMillis() {
		return FORMATTER.parseDateTime(testingDate).getMillis();

	}

}
