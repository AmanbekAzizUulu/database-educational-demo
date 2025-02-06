package com.dandaevit.edu.jdbc.mappers.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class LocalDateFormatter {
	private static final String PATTERN = "yyyy-MM-dd";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

	public LocalDate format(String date){
		return LocalDate.parse(date, FORMATTER);
	}

	public boolean isValid (String date){

		return Optional.ofNullable(date)
					   .map(LocalDateFormatter::format)
					   .isPresent();
	}



}
