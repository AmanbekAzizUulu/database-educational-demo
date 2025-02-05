package com.dandaevit.edu.jdbc.controllers;

import java.io.IOException;

import com.dandaevit.edu.jdbc.jsp_utils.JSPUtils;
import com.dandaevit.edu.jdbc.service.FlightService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContentServlet extends HttpServlet {
	private final FlightService flightService = FlightService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var flights = flightService.findAll();

		req.setAttribute("flights", flights);

		req.getRequestDispatcher(JSPUtils.getPath("content")).forward(req, resp);
	}

}
