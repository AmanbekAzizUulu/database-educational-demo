package com.dandaevit.edu.jdbc.filters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class CharsetFilter implements Filter {
	private final static Logger LOGGER = LoggerFactory.getLogger(CharsetFilter.class);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		servletRequest.setCharacterEncoding(StandardCharsets.UTF_8.name());
		servletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());

		LOGGER.debug("Filter's doFilter() method is invoked");

		filterChain.doFilter(servletRequest, servletResponse);
	}

}
