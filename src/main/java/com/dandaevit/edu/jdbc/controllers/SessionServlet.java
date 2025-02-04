package com.dandaevit.edu.jdbc.controllers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dandaevit.edu.jdbc.data_base_connection_manager.DatabaseConnectionManager;
import com.dandaevit.edu.jdbc.dto.UserDTO;
import com.dandaevit.edu.jdbc.dto.UserDTO.Role;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SessionServlet extends HttpServlet {
	private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionManager.class.getName());

	private final static String USER = "user";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var session = req.getSession();
		var user = session.getAttribute(USER);

		if (user == null) {
			user = UserDTO.builder()
					.id(1001)
					.email("aibekdandaev@gmail.com")
					.userName("Aibek")
					.contactNumber("+996554445555")
					.login("__aibek007")
					.password("123password456")
					.role(Role.USER)
					.build();
		}

		resp.getWriter().write("Session is new:\t" + String.valueOf(session.isNew()) + "\n");
		resp.getWriter().write("Session data:\t" + user.toString() + "\n");
	}
}
