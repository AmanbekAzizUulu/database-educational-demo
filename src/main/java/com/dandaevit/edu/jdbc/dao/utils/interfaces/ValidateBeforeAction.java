package com.dandaevit.edu.jdbc.dao.utils.interfaces;

public interface ValidateBeforeAction<T> {
	boolean validate(T entity);
}
