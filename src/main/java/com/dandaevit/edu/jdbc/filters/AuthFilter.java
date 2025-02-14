package com.dandaevit.edu.jdbc.filters;

import java.io.IOException;
import java.util.Set;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/flights-jsp")
public class AuthFilter implements Filter {
	private static final Set<String> PUBLIC_PATH = Set.of("/login", "/registration");

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		var uri = ((HttpServletRequest) servletRequest).getRequestURI();
		var req = ((HttpServletRequest) servletRequest);

		if (isPublicPath(uri) || isUserLoggedIn(servletRequest)) {
			System.out.println("is logged");
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			System.out.println("not logged");
			((HttpServletResponse) servletResponse).sendRedirect(req.getContextPath() + "/login-jsp");
		}
	}

	private boolean isUserLoggedIn(ServletRequest servletRequest) {
		var user = ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
		return user != null;
	}

	private boolean isPublicPath(String uri) {
		return PUBLIC_PATH.stream().anyMatch(e -> uri.startsWith(e));
	}
}
