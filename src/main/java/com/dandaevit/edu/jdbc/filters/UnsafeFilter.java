package com.dandaevit.edu.jdbc.filters;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dandaevit.edu.jdbc.dto.UserDTO;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UnsafeFilter implements Filter{
	private final static Logger LOGGER = LoggerFactory.getLogger(CharsetFilter.class);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
		var user = (UserDTO) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
		if(user != null){
			LOGGER.info("user is logged");
			filterChain.doFilter(servletRequest, servletResponse);
		} else{
			LOGGER.info("user is not logged");
			((HttpServletResponse)servletResponse).sendRedirect(servletRequest.getServletContext().getContextPath() + "/registration");
		}
	}
}
