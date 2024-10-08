package com.ey.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ey.entity.Product;
import com.ey.excepion.ProductException;

//Data Access Object
//Any java class talking to the db is commonly referred to as Dao class
//TODO:
//create table product(id int primary key auto_increment, name varchar(25), price double, quantity int);
//insert into product(name, price, quantity) values('iPhone 15', 69000, 25);
public class ProductDao {

	public void add(Product product) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			String sql = "insert into product(name, price, quantity) values(?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setInt(3, product.getQuantity());
			st.executeUpdate();			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	public void update(Product product) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			String sql = "update product set name = ?, price = ?, quantity = ? where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setInt(3, product.getQuantity());
			st.setInt(4, product.getId());
			st.executeUpdate();			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	public Product fetchOne(int id) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			String sql = "select * from product where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));
				return product;
			}
			//return null; //bad, rather we should throw an user defined exception
			throw new ProductException("No product with id " + id);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			//return null; //bad, rather we should throw an user defined exception
			throw new ProductException("Error while fetching product by id", e);
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	public List<Product> fetchAll() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			String sql = "select * from product";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			List<Product> list = new ArrayList<Product>();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setQuantity(rs.getInt("quantity"));
				list.add(product);
			}
			return list;
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null; //bad, rather we should throw an user defined exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
	
	public void delete(int id) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root");
			String sql = "delete from product where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
