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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao dao = new ProductDao();
		List<Product> list = dao.fetchAll();
		
		HttpSession session = request.getSession();
		session.setAttribute("listOfProducts", list);
		
		response.sendRedirect("viewProducts.jsp");
	}

}
