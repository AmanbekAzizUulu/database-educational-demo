package com.dandaevit.edu.jdbc.controllers;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.jdbc.dto.CreateUserDTO;
import com.dandaevit.edu.jdbc.jsp_utils.JSPUtils;
import com.dandaevit.edu.jdbc.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionManager.class.getName());

	private final static UserService userService = UserService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("userRoles", List.of("Administrator", "User"));
		req.setAttribute("userGenders", List.of("Male", "Female"));

		req.getRequestDispatcher(JSPUtils.getPath("registration")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("User name: " + req.getParameter("userName"));
		LOGGER.info("User login: " + req.getParameter("userLogin"));
		LOGGER.info("User role: " + req.getParameter("userRole"));
		LOGGER.info("User email: " + req.getParameter("userEmail"));
		LOGGER.info("User birth date: " + req.getParameter("userBirthdate"));
		LOGGER.info("User gender: " + req.getParameter("userGender"));
		LOGGER.info("User password: " + req.getParameter("userPassword"));
		LOGGER.info("User confirm password: " + req.getParameter("userConfirmPassword"));

		CreateUserDTO createUserDTO = CreateUserDTO.builder()
				.firstName(req.getParameter("userFirstName"))
				.lastName(req.getParameter("userLastName"))
				.login(req.getParameter("userLogin"))
				.email(req.getParameter("userEmail"))
				.role(req.getParameter("userRole"))
				.birthDate(req.getParameter("userBirthDate"))
				.gender(req.getParameter("userGender"))
				.password(req.getParameter("userPassword"))
				.confirmPassword(req.getParameter("userConfirmPassword"))
				.build();

		var user = userService.createUser(createUserDTO);
		req.getRequestDispatcher(JSPUtils.getPath("content")).forward(req, resp);
		resp.getWriter().println(user);
	}
}
