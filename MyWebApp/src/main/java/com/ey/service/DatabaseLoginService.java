package com.ey.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * TODO:
 * create table tbl_user(username varchar(20), password varchar(12), locked boolean, last_logged_in timestamp);
 * insert into tbl_user(username, password, locked) values('majrul', '123', true);
 * insert into tbl_user(username, password, locked) values('pranav', '456', false);
 */
public class DatabaseLoginService extends LoginService {

	public boolean isValidUser(String username, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			String sql = "select * from tbl_user where username = ? and password = ?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return !rs.getBoolean("locked");
			}
			return false;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
