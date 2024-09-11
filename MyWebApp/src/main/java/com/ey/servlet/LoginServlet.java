package com.ey.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ey.service.DatabaseLoginService;
import com.ey.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginCheck")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		LoginService loginService = new DatabaseLoginService();
		boolean isValid = loginService.isValidUser(username, password);
		
		/*PrintWriter out = response.getWriter();
		if(isValid)
			out.write("<h2>Okay</h2>");
		else*/
		
		if(isValid)
			response.sendRedirect("welcome.html?uname="+username);
		else
			response.sendRedirect("login.html?error=1");
	}

}
