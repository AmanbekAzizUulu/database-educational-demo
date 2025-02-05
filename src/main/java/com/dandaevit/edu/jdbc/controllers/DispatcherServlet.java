package com.dandaevit.edu.jdbc.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionManager.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req.setAttribute("userInfo", UserDTO.builder().email("test_email").id(1).contactNumber("+0").login("test_login").role(Role.USER).password("test_password").userName("test_userName").build());
		// LOGGER.info("redirecting done");

		// req.setAttribute("fromIncludes", true);
		// LOGGER.info("includes done");

		// req.getRequestDispatcher("/flights").forward(req, resp);						// → forward

		// req.getRequestDispatcher("/flights").include(req, resp);						// → includes

		// resp.sendRedirect("https://www.youtube.com/watch?v=dQw4w9WgXcQ&pp=ygUJcmljayByb2xs");			// → redirect
		// LOGGER.info("redirecting done");

		LOGGER.info("redirecting to tickets.jsp");
		req.getRequestDispatcher("/WEB-INF/pages/tickets.jsp").forward(req, resp);
	}

}
