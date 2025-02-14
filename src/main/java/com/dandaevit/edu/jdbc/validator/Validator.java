package com.dandaevit.edu.jdbc.validator;

public interface Validator<T> {
	ValidationResult isValid(T obj);
}
