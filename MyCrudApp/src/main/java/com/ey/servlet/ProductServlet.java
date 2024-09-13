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
		HttpSession session = request.getSession();

		String op = request.getParameter("op");
		
		if(op.equals("fetchAll")) {
			List<Product> list = dao.fetchAll();
		
			session.setAttribute("listOfProducts", list);
		
			response.sendRedirect("viewProducts.jsp");
		}
		else if(op.equals("add")) {
			String name = request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setQuantity(quantity);
			
			dao.add(product);
			
			response.sendRedirect("ProductServlet?op=fetchAll");
		}
		else if(op.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product product = dao.fetchOne(id);
			session.setAttribute("product", product);
			response.sendRedirect("editProduct.jsp");
		}
		else if(op.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			double price = Double.parseDouble(request.getParameter("price"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setPrice(price);
			product.setQuantity(quantity);
			
			dao.update(product);
			
			response.sendRedirect("ProductServlet?op=fetchAll");
		}
		else if(op.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			dao.delete(id);
			//response.sendRedirect("viewProducts.jsp");
			response.sendRedirect("ProductServlet?op=fetchAll");
		}
	}

}
