package com.dandaevit.edu.jdbc.controllers;

import java.io.IOException;

import com.dandaevit.edu.jdbc.dto.UserDTO;
import com.dandaevit.edu.jdbc.jsp_utils.JSPUtils;
import com.dandaevit.edu.jdbc.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

public class LoginServlet extends HttpServlet {
	private UserService userService = UserService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JSPUtils.getPath("login")).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userService.login(req.getParameter("email"), req.getParameter("password"))
				   .ifPresentOrElse(userDTO -> onLoginSuccess(userDTO, req, resp),
						() -> onLoginFail(req, resp));
	}

	@SneakyThrows
	private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
		resp.sendRedirect(req.getContextPath() + "/login?error&email=" + req.getParameter("email"));
	}

	@SneakyThrows
	private void onLoginSuccess(UserDTO userDTO, HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("user", userDTO);
		resp.sendRedirect(req.getContextPath() + "/flights-jsp");
	}

}
