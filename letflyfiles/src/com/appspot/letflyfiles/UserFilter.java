package com.appspot.letflyfiles;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class UserFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String AUTHORIZED_USER1 = "hiroyuki.tokutake@gmail.com";
		String AUTHORIZED_USER2 = "sequoia.court@gmail.com";
		UserService userService = UserServiceFactory.getUserService();
		if (userService == null || !userService.isUserLoggedIn()){
			HttpServletResponse response = (HttpServletResponse) resp;
			response.sendRedirect("/login");
		} else {
			if(!AUTHORIZED_USER1.equalsIgnoreCase(userService.getCurrentUser().getEmail()) &&
					!AUTHORIZED_USER2.equalsIgnoreCase(userService.getCurrentUser().getEmail())){
				HttpServletResponse response = (HttpServletResponse) resp;
				response.sendRedirect("/login");
			}
		}
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}
