package com.dandaevit.edu.jdbc.filters;

import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class LoginFilter implements Filter{
	private final static Logger LOGGER = LoggerFactory.getLogger(CharsetFilter.class);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		LOGGER.info("Request parameters");
		servletRequest.getParameterMap().forEach((key, value) -> LOGGER.info("key: " + key + "\t\tvalue: " + Arrays.toString(value)));

		filterChain.doFilter(servletRequest, servletResponse);
	}

}
