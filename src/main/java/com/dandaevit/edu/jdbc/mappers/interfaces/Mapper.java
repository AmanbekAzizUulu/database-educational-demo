package com.dandaevit.edu.jdbc.mappers.interfaces;

public interface Mapper<T, F> {
	T mapFrom(F f);
}
