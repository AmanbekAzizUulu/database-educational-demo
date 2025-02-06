package com.dandaevit.edu.jdbc.dao.utils.implementations;

import com.dandaevit.edu.jdbc.dao.utils.interfaces.ValidateBeforeAction;
import com.dandaevit.edu.jdbc.model.user.Gender;
import com.dandaevit.edu.jdbc.model.user.User;

public class ValidateBeforeInsertUtil implements ValidateBeforeAction<User> {
	
	@Override
	public boolean validate(User user) {
		if (user == null) {
			return false;
		}

		return isNotEmpty(user.getFirstName()) &&
				isNotEmpty(user.getLogin()) &&
				isValidEmail(user.getEmail()) &&
				isValidBirthDate(user.getBirthDate().toString()) &&
				isValidGender(user.getGender().name(), Gender.class) &&
				isValidPassword(user.getPassword(), user.getConfirmPassword());
	}

	private boolean isNotEmpty(String value) {
		return value != null && !value.trim().isEmpty();
	}

	private boolean isValidEmail(String email) {
		return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	}

	private boolean isValidBirthDate(String birthDate) {
		return birthDate.matches("\\d{4}-\\d{2}-\\d{2}");
	}

	private boolean isValidGender(String genderStr, Class<? extends Enum<?>> enumClass) {
		for (Enum<?> gender : enumClass.getEnumConstants()) {
			if (gender.name().equalsIgnoreCase(genderStr)) {
				return true;
			}
		}
		return false;
	}

	private boolean isValidPassword(String password, String confirmPassword) {
		return password != null && password.length() >= 8 && password.equals(confirmPassword);
	}
}
