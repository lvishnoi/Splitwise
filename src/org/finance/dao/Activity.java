package org.finance.dao;

import java.sql.*;
import org.finance.model.User;

public class Activity implements DatabaseCredentials {

	Connection conn = null;
	Statement stmt = null;

	public int createUser(User user) {
		int newId = 0;

		try {
			System.out.println();
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "insert into user (name, passcode) values ('" + user.getName() + "', '" + user.getPasscode() + "')";
			stmt.executeUpdate(sql);
			ResultSet rs = stmt.executeQuery("select last_insert_id() as last_id");
			if (rs.next())
				newId = Integer.parseInt(rs.getString(1));
			rs.close();
			sql = "insert into finance (user, friend, group_id, amount) values (" + newId + ", " + newId + ", 0, 0)";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newId;
	}
	
	public String getUserName(User user) {
		String userName = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			String sql = "select name from user where id = " + user.getId() + " and passcode = '" + user.getPasscode() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) userName = rs.getString(1);
			rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userName;
	}
}