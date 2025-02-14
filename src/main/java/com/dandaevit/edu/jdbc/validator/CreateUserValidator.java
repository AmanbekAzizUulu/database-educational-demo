package com.dandaevit.edu.jdbc.validator;

import com.dandaevit.edu.jdbc.dto.CreateUserDTO;
import com.dandaevit.edu.jdbc.mappers.utils.LocalDateFormatter;
import com.dandaevit.edu.jdbc.model.user.Gender;

public class CreateUserValidator implements Validator<CreateUserDTO> {
	private final static CreateUserValidator INSTANCE = new CreateUserValidator();

	private CreateUserValidator() {
	}

	public static CreateUserValidator getInstance() {
		return INSTANCE;
	}

	public ValidationResult isValid(CreateUserDTO userDTO) {
		var validationResult = new ValidationResult();
		if (!LocalDateFormatter.isValid(userDTO.getBirthDate())) {
			validationResult.add(Error.of("invalid.birth_date", "Birth date is invalid"));
		}
		if (Gender.getGender(userDTO.getGender()).isEmpty()) {
			validationResult.add(Error.of("invalid.gender", "Gender is invalid"));
		}

		// TODO add other validation

		return validationResult;
	}
}
