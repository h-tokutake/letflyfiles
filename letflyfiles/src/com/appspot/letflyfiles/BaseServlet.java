package com.appspot.letflyfiles;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	protected String AUTHORIZED_USER = "hiroyuki.tokutake@gmail.com";

	protected void dispatchScreen(final HttpServletRequest req, final HttpServletResponse resp, String dist)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher(dist).forward(req, resp);
	}
}
