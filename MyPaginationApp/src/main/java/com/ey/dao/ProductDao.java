package com.ey.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ey.entity.Product;

public class ProductDao {

	public List<Product> fetchPartially(int offset, int rows) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			String sql = "select * from product limit ? offset ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, rows);
			st.setInt(2, offset);
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

	public int count() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			String sql = "select count(*) from product";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return 0;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

}
