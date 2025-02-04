package com.dandaevit.edu.jdbc.controllers;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookiesServlet extends HttpServlet {
	private static final String USER_ID_COOKIE = "userId";
	private static final String USER_FIRST_NAME_COOKIE = "userFirstName";
	private static final String USER_LAST_NAME_COOKIE = "userLastName";
	private static final String USER_AGE_COOKIE = "userAge";
	private static final String USER_PREFERRED_LANGUAGE_COOKIE = "preferredLanguage";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();

		// Проверяем, есть ли куки с именем USER_FIRST_NAME_COOKIE
		boolean hasAnyUserCookie  = cookies != null &&
				Arrays.stream(cookies)
						.anyMatch(cookie -> USER_ID_COOKIE.equals(cookie.getName()) ||
								USER_FIRST_NAME_COOKIE.equals(cookie.getName()) ||
								USER_LAST_NAME_COOKIE.equals(cookie.getName()) ||
								USER_AGE_COOKIE.equals(cookie.getName()) ||
								USER_PREFERRED_LANGUAGE_COOKIE.equals(cookie.getName()));

		// Если куки нет, создаем и добавляем все необходимые куки
		if (!hasAnyUserCookie ) {
			// Создаем куки для каждого атрибута
			Cookie userIdCookie = new Cookie(USER_ID_COOKIE, "10001");
			Cookie userFirstNameCookie = new Cookie(USER_FIRST_NAME_COOKIE, "Aibek");
			Cookie userLastNameCookie = new Cookie(USER_LAST_NAME_COOKIE, "Dandaev");
			Cookie userAgeCookie = new Cookie(USER_AGE_COOKIE, "25");
			Cookie userPreferredLanguageCookie = new Cookie(USER_PREFERRED_LANGUAGE_COOKIE, "en");

			// Устанавливаем время жизни куки (1 час)
			int maxAge = 60 * 60;
			userIdCookie.setMaxAge(maxAge);
			userFirstNameCookie.setMaxAge(maxAge);
			userLastNameCookie.setMaxAge(maxAge);
			userAgeCookie.setMaxAge(maxAge);
			userPreferredLanguageCookie.setMaxAge(maxAge);

			// Устанавливаем путь для куки
			String cookiePath = "/flights-management/cookies";
			userIdCookie.setPath(cookiePath);
			userFirstNameCookie.setPath(cookiePath);
			userLastNameCookie.setPath(cookiePath);
			userAgeCookie.setPath(cookiePath);
			userPreferredLanguageCookie.setPath(cookiePath);

			// Добавляем куки в ответ
			resp.addCookie(userIdCookie);
			resp.addCookie(userFirstNameCookie);
			resp.addCookie(userLastNameCookie);
			resp.addCookie(userAgeCookie);
			resp.addCookie(userPreferredLanguageCookie);

			// Отправляем сообщение об успешном создании куки
			resp.getWriter().write("Cookies have been set successfully!");
			resp.getWriter().write("\nuserId:\t" + userAgeCookie.getValue());
			resp.getWriter().write("\nuserFirstName:\t" + userFirstNameCookie.getValue());
			resp.getWriter().write("\nuserLastName:\t" + userLastNameCookie.getValue());
			resp.getWriter().write("\nuserAge:\t" + userAgeCookie.getValue());
			resp.getWriter().write("\nuserPreferredLanguage:\t" + userPreferredLanguageCookie.getValue());
		} else {
			// Если куки уже существуют, отправляем сообщение
			resp.getWriter().write("Cookies already exist!");
		}
	}
}
