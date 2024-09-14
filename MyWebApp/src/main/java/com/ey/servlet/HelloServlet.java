package com.ey.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet(urlPatterns = "/hello", loadOnStartup = 100) //url pattern
//TODO: Check how to override lifecycle methods in a JSP
public class HelloServlet extends HttpServlet {

	public void init() {
		System.out.println("init called..");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet called..");
		
		ServletConfig cfg = getServletConfig();
		System.out.println(cfg.getServletName());
		
		PrintWriter out = response.getWriter();
		out.write("<html><body>");

		int accessHour = Integer.parseInt(cfg.getInitParameter("accessHour"));
		int currentHour = LocalTime.now().getHour();
		
		if(currentHour >= accessHour) {
			out.write("<h1>Welcome to Servlet</h1>");
			out.write("<h2>Today's Date " + LocalDate.now() + "</h2>");
		}
		else
			out.write("<h1>Sorry, you cannot access our services right now</h1>");

		out.write("</body></html>");
	}

	public void destroy() {
		System.out.println("destroy called..");
	}
}
