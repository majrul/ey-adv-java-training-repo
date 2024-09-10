package com.ey.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ey.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginCheck")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		LoginService loginService = new LoginService();
		boolean isValid = loginService.isValidUser(username, password);
		
		if(isValid)
			response.sendRedirect("welcome.html");
		else
			response.sendRedirect("login.html");
	}

}
