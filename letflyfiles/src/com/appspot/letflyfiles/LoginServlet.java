package com.appspot.letflyfiles;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LoginServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		Set<String> attributes = new HashSet<String>();

		if (user != null) {
			req.setAttribute("logoutUrl", userService.createLogoutURL(req.getRequestURI()));
		}
		String providerUrl = "https://www.google.com/accounts/o8/id";
		String loginUrl = userService.createLoginURL(req.getRequestURI(), null, providerUrl, attributes);
		req.setAttribute("loginUrl", loginUrl);
		dispatchScreen(req, resp, "/WEB-INF/login.jsp");
	}
}
