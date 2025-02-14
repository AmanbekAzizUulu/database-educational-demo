package com.dandaevit.edu.jdbc.controllers;

import java.io.IOException;
import java.util.stream.Collectors;

import com.dandaevit.edu.jdbc.service.FlightService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FlightServlet extends HttpServlet {
	private final FlightService flightService = FlightService.getInstance();
	private static final String FLIGHT_INFORMATION_HTML = """
			<!DOCTYPE html>
			<html lang="en">

			<head>
				<meta charset="UTF-8">
				<meta name="viewport" content="width=device-width, initial-scale=1.0">
				<title>Flight Information</title>
			</head>

			<body>
				<h1>Flight Information</h1>
				%s
			</body>

			</html>
			""";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// resp.setCharacterEncoding(StandardCharsets.UTF_8);

		var flightsList = flightService.findAll().stream()
				.map(
						flightDTO -> "<li><a href=\"/flights-management/tickets?flightId=%d\">%s</a></li>"
								.formatted(flightDTO.id(), flightDTO.description()))
				.collect(Collectors.joining());

		var flightsListHtml = FLIGHT_INFORMATION_HTML.formatted("<ul>" + flightsList + "</ul>");


		try (var writer = resp.getWriter()) {
			writer.write(flightsListHtml);

			// код ниже будет работать только если был forward из DispatcherServlet`а
			var userInfo = req.getAttribute("userInfo");								// → Returns the value of the named attribute as an Object, or null if no attribute of the given name exists.
			if (userInfo != null) {
				writer.write("<br>");
				writer.write("<br>");
				writer.write("<p>" + userInfo.toString() + "</p>");
			}

			// код ниже будет работать только если был includes из DispatcherServlet`а
			var fromIncludes = (boolean) req.getAttribute("fromIncludes");
			if (fromIncludes) {
				writer.write("<br>");
				writer.write("<br>");
				writer.write("<p>Includes: "  + fromIncludes + "</p>");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("<h1>TEST</h1>");
	}

}
