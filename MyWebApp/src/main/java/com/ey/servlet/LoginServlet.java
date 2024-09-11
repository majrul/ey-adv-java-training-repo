package com.ey.servlet;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
		if(isValid) {
			String remember = request.getParameter("remember");
			if(remember != null && remember.equals("y")) {
				//TODO: Try using some encryption alg. like bcrypt or sha-1
				String loginData = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
				Cookie c = new Cookie("loginData", loginData);
				c.setMaxAge(60 * 60 * 24);
				response.addCookie(c);
				/*Cookie c1 = new Cookie("uname", username);
				c1.setMaxAge(60 * 60 * 24);
				Cookie c2 = new Cookie("pwd", password);
				c2.setMaxAge(60 * 60 * 24);
				response.addCookie(c1);
				response.addCookie(c2);*/
			}
			response.sendRedirect("welcome.html?uname="+username);
		}
		else
			response.sendRedirect("login.html?error=1");
	}

}
