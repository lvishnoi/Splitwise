package org.finance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BillActivity implements DatabaseCredentials {

	Connection conn = null;
	Statement stmt = null;

	public void updateBillInDatabase(String[] friends, int amount, int user) {
		int totalFriends = friends.length;
		int balance = 0;
		int updatedBalance = 0;
		String sql = "";
		int temp = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			sql = "select amount from finance where user = " + user + " AND friend = " + user + " AND group_id = 0";
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				balance = Integer.parseInt(rs.getString(1));
			}
			rs.close();
			temp = amount * totalFriends / (totalFriends + 1);
			updatedBalance = balance + temp;
			sql = "UPDATE finance SET amount = " + updatedBalance + " where user = " + user + " AND friend = " + user
					+ " AND group_id = 0";
			stmt.executeUpdate(sql);

			for (int i = 0; i < totalFriends; i++) {
				sql = "select amount from finance where user = " + user + " AND friend = " + friends[i]
						+ " AND group_id = 0";
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					balance = Integer.parseInt(rs.getString(1));
				}
				rs.close();
				updatedBalance = balance - (amount / (totalFriends + 1));
				sql = "UPDATE finance SET amount = " + updatedBalance + " where user = " + user + " AND friend = "
						+ friends[i] + " AND group_id = 0";
				stmt.executeUpdate(sql);
			}
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
	}

}
