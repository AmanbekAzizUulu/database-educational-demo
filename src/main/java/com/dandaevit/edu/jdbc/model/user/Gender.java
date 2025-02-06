package com.dandaevit.edu.jdbc.model.user;

import java.util.Arrays;
import java.util.Optional;

public enum Gender {
	MALE,
	FEMALE;

	public static Optional<Gender> getGender(String gender) {
		return Arrays.stream(values())
				.filter(it -> it.name().equals(gender))
				.findFirst();
	}
}
