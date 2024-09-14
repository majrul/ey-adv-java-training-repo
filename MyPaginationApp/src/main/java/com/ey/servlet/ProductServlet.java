package com.ey.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ey.dao.ProductDao;
import com.ey.entity.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

	private int pageSize;
	private int rows;
	private int cursor;
	private ProductDao dao = new ProductDao();
	
	public void init() {
		pageSize = 3;
		cursor = 0;
		rows = dao.count();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		if(page != null) {
			if(page.equals("next")) {
				cursor += pageSize;
			}
			else if(page.equals("prev")) {
				cursor -= pageSize;
			}
		}
		else
			cursor = 0;
		
		List<Product> list = dao.fetchPartially(cursor, pageSize);
		
		HttpSession session = request.getSession();
		session.setAttribute("listOfProducts", list);
		
		response.sendRedirect("viewProducts.jsp");
	}

}
