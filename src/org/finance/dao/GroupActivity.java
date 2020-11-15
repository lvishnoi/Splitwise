package org.finance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GroupActivity implements DatabaseCredentials {

	Connection conn = null;
	Statement stmt = null;

	public ArrayList<Integer> getPossibleGroups(int user) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			String sql = "select group_id from group_friend where friend = " + user;
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				rs.beforeFirst();
				while (rs.next())
					list.add(rs.getInt("group_id"));
			}
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
		return list;
	}
	
	public ArrayList<Integer> getGroupMembers(int grpId) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			String sql = "select friend from group_friend where group_id = " + grpId;
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				rs.beforeFirst();
				while (rs.next())
					list.add(rs.getInt("friend"));
			}
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
		return list;
	}

}
