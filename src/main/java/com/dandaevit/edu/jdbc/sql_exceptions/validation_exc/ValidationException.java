package com.dandaevit.edu.jdbc.sql_exceptions.validation_exc;

import java.util.List;

import com.dandaevit.edu.jdbc.validator.Error;

import lombok.Getter;

public class ValidationException extends RuntimeException{
	@Getter
	private final List<Error> errors;

	public ValidationException(List<Error> errors){
		this.errors = errors;
	}

}
