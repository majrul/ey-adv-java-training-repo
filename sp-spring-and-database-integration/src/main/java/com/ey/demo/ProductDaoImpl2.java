package com.ey.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("daoImpl2")
public class ProductDaoImpl2 implements ProductDao {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public int add(Product product) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into product(name, price, quantity) values(?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setInt(3, product.getQuantity());
			st.executeUpdate();			
			
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		}
		catch(SQLException e) {
			e.printStackTrace(); //throw an exception instead
			return -1;
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	@Override
	public void update(Product product) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "update product set name = ?, price = ?, quantity = ? where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setInt(3, product.getQuantity());
			st.setInt(4, product.getId());
			st.executeUpdate();			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	@Override
	public Product fetchOne(int id) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
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
			return null; //bad, rather we should throw an user defined exception
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null; //bad, rather we should throw an user defined exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	@Override
	public List<Product> fetchAll() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
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
		catch(SQLException e) {
			e.printStackTrace();
			return null; //bad, rather we should throw an user defined exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
	
	@Override
	public void delete(int id) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from product where id = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
